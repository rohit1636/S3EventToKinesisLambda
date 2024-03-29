package avroGeneratedClasses; /**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */

import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.SchemaStore;
import org.apache.avro.specific.SpecificData;

@org.apache.avro.specific.AvroGenerated
public class Header extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 1524885259333979515L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Header\",\"fields\":[{\"name\":\"defaultInstock\",\"type\":\"boolean\"},{\"name\":\"listId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"onOrder\",\"type\":\"boolean\"},{\"name\":\"useBundleInventoryOnly\",\"type\":\"boolean\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Header> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Header> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Header> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Header> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Header> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Header to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Header from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Header instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Header fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private boolean defaultInstock;
  private String listId;
  private boolean onOrder;
  private boolean useBundleInventoryOnly;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Header() {}

  /**
   * All-args constructor.
   * @param defaultInstock The new value for defaultInstock
   * @param listId The new value for listId
   * @param onOrder The new value for onOrder
   * @param useBundleInventoryOnly The new value for useBundleInventoryOnly
   */
  public Header(Boolean defaultInstock, String listId, Boolean onOrder, Boolean useBundleInventoryOnly) {
    this.defaultInstock = defaultInstock;
    this.listId = listId;
    this.onOrder = onOrder;
    this.useBundleInventoryOnly = useBundleInventoryOnly;
  }

  @Override
  public SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public Object get(int field$) {
    switch (field$) {
    case 0: return defaultInstock;
    case 1: return listId;
    case 2: return onOrder;
    case 3: return useBundleInventoryOnly;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: defaultInstock = (Boolean)value$; break;
    case 1: listId = value$ != null ? value$.toString() : null; break;
    case 2: onOrder = (Boolean)value$; break;
    case 3: useBundleInventoryOnly = (Boolean)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'defaultInstock' field.
   * @return The value of the 'defaultInstock' field.
   */
  public boolean getDefaultInstock() {
    return defaultInstock;
  }


  /**
   * Sets the value of the 'defaultInstock' field.
   * @param value the value to set.
   */
  public void setDefaultInstock(boolean value) {
    this.defaultInstock = value;
  }

  /**
   * Gets the value of the 'listId' field.
   * @return The value of the 'listId' field.
   */
  public String getListId() {
    return listId;
  }


  /**
   * Sets the value of the 'listId' field.
   * @param value the value to set.
   */
  public void setListId(String value) {
    this.listId = value;
  }

  /**
   * Gets the value of the 'onOrder' field.
   * @return The value of the 'onOrder' field.
   */
  public boolean getOnOrder() {
    return onOrder;
  }


  /**
   * Sets the value of the 'onOrder' field.
   * @param value the value to set.
   */
  public void setOnOrder(boolean value) {
    this.onOrder = value;
  }

  /**
   * Gets the value of the 'useBundleInventoryOnly' field.
   * @return The value of the 'useBundleInventoryOnly' field.
   */
  public boolean getUseBundleInventoryOnly() {
    return useBundleInventoryOnly;
  }


  /**
   * Sets the value of the 'useBundleInventoryOnly' field.
   * @param value the value to set.
   */
  public void setUseBundleInventoryOnly(boolean value) {
    this.useBundleInventoryOnly = value;
  }

  /**
   * Creates a new Header RecordBuilder.
   * @return A new Header RecordBuilder
   */
  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Creates a new Header RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Header RecordBuilder
   */
  public static Builder newBuilder(Builder other) {
    if (other == null) {
      return new Builder();
    } else {
      return new Builder(other);
    }
  }

  /**
   * Creates a new Header RecordBuilder by copying an existing Header instance.
   * @param other The existing instance to copy.
   * @return A new Header RecordBuilder
   */
  public static Builder newBuilder(Header other) {
    if (other == null) {
      return new Builder();
    } else {
      return new Builder(other);
    }
  }

  /**
   * RecordBuilder for Header instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Header>
    implements org.apache.avro.data.RecordBuilder<Header> {

    private boolean defaultInstock;
    private String listId;
    private boolean onOrder;
    private boolean useBundleInventoryOnly;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.defaultInstock)) {
        this.defaultInstock = data().deepCopy(fields()[0].schema(), other.defaultInstock);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.listId)) {
        this.listId = data().deepCopy(fields()[1].schema(), other.listId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.onOrder)) {
        this.onOrder = data().deepCopy(fields()[2].schema(), other.onOrder);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.useBundleInventoryOnly)) {
        this.useBundleInventoryOnly = data().deepCopy(fields()[3].schema(), other.useBundleInventoryOnly);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
    }

    /**
     * Creates a Builder by copying an existing Header instance
     * @param other The existing instance to copy.
     */
    private Builder(Header other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.defaultInstock)) {
        this.defaultInstock = data().deepCopy(fields()[0].schema(), other.defaultInstock);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.listId)) {
        this.listId = data().deepCopy(fields()[1].schema(), other.listId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.onOrder)) {
        this.onOrder = data().deepCopy(fields()[2].schema(), other.onOrder);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.useBundleInventoryOnly)) {
        this.useBundleInventoryOnly = data().deepCopy(fields()[3].schema(), other.useBundleInventoryOnly);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'defaultInstock' field.
      * @return The value.
      */
    public boolean getDefaultInstock() {
      return defaultInstock;
    }


    /**
      * Sets the value of the 'defaultInstock' field.
      * @param value The value of 'defaultInstock'.
      * @return This builder.
      */
    public Builder setDefaultInstock(boolean value) {
      validate(fields()[0], value);
      this.defaultInstock = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'defaultInstock' field has been set.
      * @return True if the 'defaultInstock' field has been set, false otherwise.
      */
    public boolean hasDefaultInstock() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'defaultInstock' field.
      * @return This builder.
      */
    public Builder clearDefaultInstock() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'listId' field.
      * @return The value.
      */
    public String getListId() {
      return listId;
    }


    /**
      * Sets the value of the 'listId' field.
      * @param value The value of 'listId'.
      * @return This builder.
      */
    public Builder setListId(String value) {
      validate(fields()[1], value);
      this.listId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'listId' field has been set.
      * @return True if the 'listId' field has been set, false otherwise.
      */
    public boolean hasListId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'listId' field.
      * @return This builder.
      */
    public Builder clearListId() {
      listId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'onOrder' field.
      * @return The value.
      */
    public boolean getOnOrder() {
      return onOrder;
    }


    /**
      * Sets the value of the 'onOrder' field.
      * @param value The value of 'onOrder'.
      * @return This builder.
      */
    public Builder setOnOrder(boolean value) {
      validate(fields()[2], value);
      this.onOrder = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'onOrder' field has been set.
      * @return True if the 'onOrder' field has been set, false otherwise.
      */
    public boolean hasOnOrder() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'onOrder' field.
      * @return This builder.
      */
    public Builder clearOnOrder() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'useBundleInventoryOnly' field.
      * @return The value.
      */
    public boolean getUseBundleInventoryOnly() {
      return useBundleInventoryOnly;
    }


    /**
      * Sets the value of the 'useBundleInventoryOnly' field.
      * @param value The value of 'useBundleInventoryOnly'.
      * @return This builder.
      */
    public Builder setUseBundleInventoryOnly(boolean value) {
      validate(fields()[3], value);
      this.useBundleInventoryOnly = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'useBundleInventoryOnly' field has been set.
      * @return True if the 'useBundleInventoryOnly' field has been set, false otherwise.
      */
    public boolean hasUseBundleInventoryOnly() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'useBundleInventoryOnly' field.
      * @return This builder.
      */
    public Builder clearUseBundleInventoryOnly() {
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Header build() {
      try {
        Header record = new Header();
        record.defaultInstock = fieldSetFlags()[0] ? this.defaultInstock : (Boolean) defaultValue(fields()[0]);
        record.listId = fieldSetFlags()[1] ? this.listId : (String) defaultValue(fields()[1]);
        record.onOrder = fieldSetFlags()[2] ? this.onOrder : (Boolean) defaultValue(fields()[2]);
        record.useBundleInventoryOnly = fieldSetFlags()[3] ? this.useBundleInventoryOnly : (Boolean) defaultValue(fields()[3]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Header>
    WRITER$ = (org.apache.avro.io.DatumWriter<Header>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Header>
    READER$ = (org.apache.avro.io.DatumReader<Header>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeBoolean(this.defaultInstock);

    out.writeString(this.listId);

    out.writeBoolean(this.onOrder);

    out.writeBoolean(this.useBundleInventoryOnly);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.defaultInstock = in.readBoolean();

      this.listId = in.readString();

      this.onOrder = in.readBoolean();

      this.useBundleInventoryOnly = in.readBoolean();

    } else {
      for (int i = 0; i < 4; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.defaultInstock = in.readBoolean();
          break;

        case 1:
          this.listId = in.readString();
          break;

        case 2:
          this.onOrder = in.readBoolean();
          break;

        case 3:
          this.useBundleInventoryOnly = in.readBoolean();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










