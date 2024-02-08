package lambda;

import avroGeneratedClasses.Sample;
import com.amazonaws.services.kinesis.AmazonKinesis;
import com.amazonaws.services.kinesis.AmazonKinesisClientBuilder;
import com.amazonaws.services.kinesis.model.PutRecordRequest;
import com.amazonaws.services.kinesis.model.PutRecordResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.lambda.runtime.events.models.s3.S3EventNotification;
import com.amazonaws.services.lambda.runtime.logging.LogLevel;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.schemaregistry.common.GlueSchemaRegistryDataFormatSerializer;
import com.amazonaws.services.schemaregistry.common.Schema;
import com.amazonaws.services.schemaregistry.common.configs.GlueSchemaRegistryConfiguration;
import com.amazonaws.services.schemaregistry.serializers.GlueSchemaRegistrySerializer;
import com.amazonaws.services.schemaregistry.serializers.GlueSchemaRegistrySerializerFactory;
import com.amazonaws.services.schemaregistry.serializers.GlueSchemaRegistrySerializerImpl;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.services.glue.model.DataFormat;
import utils.MapperUtil;
import xml.Inventory;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;

public class InventoryUpdate implements RequestHandler<S3Event, String> {

    @Override
    public String handleRequest(S3Event s3Event, Context context) {
        LambdaLogger logger = context.getLogger();
        try {
            // Below piece of code is to get the object from the S3 bucket and read the contents
            List<S3EventNotification.S3EventNotificationRecord> s3EventRecords = s3Event.getRecords();
            S3EventNotification.S3EventNotificationRecord s3EventNotificationRecord = s3EventRecords.get(0);
            String bucketName = s3EventNotificationRecord.getS3().getBucket().getName();
            String key = s3EventNotificationRecord.getS3().getObject().getKey();

            AmazonS3 amazonS3Client = AmazonS3ClientBuilder.defaultClient();
            String objectAsString = amazonS3Client.getObjectAsString(bucketName, key);
            Inventory inventory = MapperUtil.mapXmlToInventoryObject(objectAsString);
            String payload = MapperUtil.writeAsString(inventory);
            logger.log("Payload " + payload, LogLevel.DEBUG);


            // Below piece of code is to serialize the data into AVRO format
            AwsCredentialsProvider awsCredentialsProvider = DefaultCredentialsProvider.builder().build();
            GlueSchemaRegistryConfiguration gsrConfig = new GlueSchemaRegistryConfiguration("ap-south-1");
            gsrConfig.setRegistryName("InventoryEventSchemas");
            software.amazon.awssdk.services.glue.model.DataFormat dataFormat = DataFormat.AVRO;
            GlueSchemaRegistrySerializer glueSchemaRegistrySerializer = new GlueSchemaRegistrySerializerImpl(
                    awsCredentialsProvider, gsrConfig);
            GlueSchemaRegistryDataFormatSerializer dataFormatSerializer = new GlueSchemaRegistrySerializerFactory()
                    .getInstance(dataFormat, gsrConfig);
            Sample s = new Sample(1L);
            byte[] serializedPayload = dataFormatSerializer.serialize(s);
            logger.log("AVRO Serialized message is " + Arrays.toString(serializedPayload), LogLevel.DEBUG);
            Schema gsrSchema =
                    new Schema(dataFormatSerializer.getSchemaDefinition(s), dataFormat.name(), "SampleEvent");
            byte[] gsrEncodedBytes = glueSchemaRegistrySerializer.encode("inventory-update-kinesis-spike", gsrSchema, serializedPayload);


            // Below piece of code is to put the serialized message into the kinesis stream
            AmazonKinesis kinesisClient = AmazonKinesisClientBuilder.defaultClient();
            PutRecordRequest putRecordRequest = new PutRecordRequest();
            putRecordRequest.setStreamARN("arn:aws:kinesis:ap-south-1:417610864161:stream/inventory-update-kinesis-spike");
            putRecordRequest.setStreamName("inventory-update-kinesis-spike");
            putRecordRequest.setData(ByteBuffer.wrap(gsrEncodedBytes));
            putRecordRequest.setPartitionKey("partitionKey-1");
            PutRecordResult result = kinesisClient.putRecord(putRecordRequest);
            logger.log("Successfully inserted record into shard " + result.getShardId(), LogLevel.DEBUG);
            return "success";
        } catch (Exception e) {
            logger.log("Request failed with error " + e);
            return "failure";
        }
    }


}