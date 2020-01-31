// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PCSBasedComponentParameter.proto

package ai.libs.hasco.pcsbasedoptimization.proto;

/**
 * Protobuf type {@code pcsbasedoptimization.PCSBasedComponentProto}
 */
public final class PCSBasedComponentProto extends com.google.protobuf.GeneratedMessageV3 implements
// @@protoc_insertion_point(message_implements:pcsbasedoptimization.PCSBasedComponentProto)
PCSBasedComponentProtoOrBuilder {
	private static final long serialVersionUID = 0L;

	// Use PCSBasedComponentProto.newBuilder() to construct.
	private PCSBasedComponentProto(final com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
		super(builder);
	}

	private PCSBasedComponentProto() {
		this.name_ = "";
		this.parameters_ = java.util.Collections.emptyList();
	}

	@java.lang.Override
	@SuppressWarnings({ "unused" })
	protected java.lang.Object newInstance(final UnusedPrivateParameter unused) {
		return new PCSBasedComponentProto();
	}

	@java.lang.Override
	public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
		return this.unknownFields;
	}

	private PCSBasedComponentProto(final com.google.protobuf.CodedInputStream input, final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws com.google.protobuf.InvalidProtocolBufferException {
		this();
		if (extensionRegistry == null) {
			throw new java.lang.NullPointerException();
		}
		int mutable_bitField0_ = 0;
		com.google.protobuf.UnknownFieldSet.Builder unknownFields = com.google.protobuf.UnknownFieldSet.newBuilder();
		try {
			boolean done = false;
			while (!done) {
				int tag = input.readTag();
				switch (tag) {
				case 0:
					done = true;
					break;
				case 10: {
					java.lang.String s = input.readStringRequireUtf8();

					this.name_ = s;
					break;
				}
				case 18: {
					if (!((mutable_bitField0_ & 0x00000001) != 0)) {
						this.parameters_ = new java.util.ArrayList<ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProto>();
						mutable_bitField0_ |= 0x00000001;
					}
					this.parameters_.add(input.readMessage(ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProto.parser(), extensionRegistry));
					break;
				}
				default: {
					if (!this.parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
						done = true;
					}
					break;
				}
				}
			}
		} catch (com.google.protobuf.InvalidProtocolBufferException e) {
			throw e.setUnfinishedMessage(this);
		} catch (java.io.IOException e) {
			throw new com.google.protobuf.InvalidProtocolBufferException(e).setUnfinishedMessage(this);
		} finally {
			if (((mutable_bitField0_ & 0x00000001) != 0)) {
				this.parameters_ = java.util.Collections.unmodifiableList(this.parameters_);
			}
			this.unknownFields = unknownFields.build();
			this.makeExtensionsImmutable();
		}
	}

	public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
		return ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentParameter.internal_static_pcsbasedoptimization_PCSBasedComponentProto_descriptor;
	}

	@java.lang.Override
	protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
		return ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentParameter.internal_static_pcsbasedoptimization_PCSBasedComponentProto_fieldAccessorTable
				.ensureFieldAccessorsInitialized(ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto.class, ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto.Builder.class);
	}

	public static final int NAME_FIELD_NUMBER = 1;
	private volatile java.lang.Object name_;

	/**
	 * <code>string name = 1;</code>
	 */
	@Override
	public java.lang.String getName() {
		java.lang.Object ref = this.name_;
		if (ref instanceof java.lang.String) {
			return (java.lang.String) ref;
		} else {
			com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
			java.lang.String s = bs.toStringUtf8();
			this.name_ = s;
			return s;
		}
	}

	/**
	 * <code>string name = 1;</code>
	 */
	@Override
	public com.google.protobuf.ByteString getNameBytes() {
		java.lang.Object ref = this.name_;
		if (ref instanceof java.lang.String) {
			com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
			this.name_ = b;
			return b;
		} else {
			return (com.google.protobuf.ByteString) ref;
		}
	}

	public static final int PARAMETERS_FIELD_NUMBER = 2;
	private java.util.List<ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProto> parameters_;

	/**
	 * <code>repeated .pcsbasedoptimization.PCSBasedParameterProto parameters = 2;</code>
	 */
	@Override
	public java.util.List<ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProto> getParametersList() {
		return this.parameters_;
	}

	/**
	 * <code>repeated .pcsbasedoptimization.PCSBasedParameterProto parameters = 2;</code>
	 */
	@Override
	public java.util.List<? extends ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProtoOrBuilder> getParametersOrBuilderList() {
		return this.parameters_;
	}

	/**
	 * <code>repeated .pcsbasedoptimization.PCSBasedParameterProto parameters = 2;</code>
	 */
	@Override
	public int getParametersCount() {
		return this.parameters_.size();
	}

	/**
	 * <code>repeated .pcsbasedoptimization.PCSBasedParameterProto parameters = 2;</code>
	 */
	@Override
	public ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProto getParameters(final int index) {
		return this.parameters_.get(index);
	}

	/**
	 * <code>repeated .pcsbasedoptimization.PCSBasedParameterProto parameters = 2;</code>
	 */
	@Override
	public ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProtoOrBuilder getParametersOrBuilder(final int index) {
		return this.parameters_.get(index);
	}

	private byte memoizedIsInitialized = -1;

	@java.lang.Override
	public final boolean isInitialized() {
		byte isInitialized = this.memoizedIsInitialized;
		if (isInitialized == 1) {
			return true;
		}
		if (isInitialized == 0) {
			return false;
		}

		this.memoizedIsInitialized = 1;
		return true;
	}

	@java.lang.Override
	public void writeTo(final com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
		if (!this.getNameBytes().isEmpty()) {
			com.google.protobuf.GeneratedMessageV3.writeString(output, 1, this.name_);
		}
		for (int i = 0; i < this.parameters_.size(); i++) {
			output.writeMessage(2, this.parameters_.get(i));
		}
		this.unknownFields.writeTo(output);
	}

	@java.lang.Override
	public int getSerializedSize() {
		int size = this.memoizedSize;
		if (size != -1) {
			return size;
		}

		size = 0;
		if (!this.getNameBytes().isEmpty()) {
			size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, this.name_);
		}
		for (int i = 0; i < this.parameters_.size(); i++) {
			size += com.google.protobuf.CodedOutputStream.computeMessageSize(2, this.parameters_.get(i));
		}
		size += this.unknownFields.getSerializedSize();
		this.memoizedSize = size;
		return size;
	}

	@java.lang.Override
	public boolean equals(final java.lang.Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto)) {
			return super.equals(obj);
		}
		ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto other = (ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto) obj;

		if (!this.getName().equals(other.getName())) {
			return false;
		}
		if (!this.getParametersList().equals(other.getParametersList())) {
			return false;
		}
		if (!this.unknownFields.equals(other.unknownFields)) {
			return false;
		}
		return true;
	}

	@java.lang.Override
	public int hashCode() {
		if (this.memoizedHashCode != 0) {
			return this.memoizedHashCode;
		}
		int hash = 41;
		hash = (19 * hash) + getDescriptor().hashCode();
		hash = (37 * hash) + NAME_FIELD_NUMBER;
		hash = (53 * hash) + this.getName().hashCode();
		if (this.getParametersCount() > 0) {
			hash = (37 * hash) + PARAMETERS_FIELD_NUMBER;
			hash = (53 * hash) + this.getParametersList().hashCode();
		}
		hash = (29 * hash) + this.unknownFields.hashCode();
		this.memoizedHashCode = hash;
		return hash;
	}

	public static ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto parseFrom(final java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
		return PARSER.parseFrom(data);
	}

	public static ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto parseFrom(final java.nio.ByteBuffer data, final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
			throws com.google.protobuf.InvalidProtocolBufferException {
		return PARSER.parseFrom(data, extensionRegistry);
	}

	public static ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto parseFrom(final com.google.protobuf.ByteString data) throws com.google.protobuf.InvalidProtocolBufferException {
		return PARSER.parseFrom(data);
	}

	public static ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto parseFrom(final com.google.protobuf.ByteString data, final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
			throws com.google.protobuf.InvalidProtocolBufferException {
		return PARSER.parseFrom(data, extensionRegistry);
	}

	public static ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto parseFrom(final byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
		return PARSER.parseFrom(data);
	}

	public static ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto parseFrom(final byte[] data, final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws com.google.protobuf.InvalidProtocolBufferException {
		return PARSER.parseFrom(data, extensionRegistry);
	}

	public static ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto parseFrom(final java.io.InputStream input) throws java.io.IOException {
		return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
	}

	public static ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto parseFrom(final java.io.InputStream input, final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
		return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
	}

	public static ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto parseDelimitedFrom(final java.io.InputStream input) throws java.io.IOException {
		return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
	}

	public static ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto parseDelimitedFrom(final java.io.InputStream input, final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
		return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
	}

	public static ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto parseFrom(final com.google.protobuf.CodedInputStream input) throws java.io.IOException {
		return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
	}

	public static ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto parseFrom(final com.google.protobuf.CodedInputStream input, final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
		return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
	}

	@java.lang.Override
	public Builder newBuilderForType() {
		return newBuilder();
	}

	public static Builder newBuilder() {
		return DEFAULT_INSTANCE.toBuilder();
	}

	public static Builder newBuilder(final ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto prototype) {
		return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
	}

	@java.lang.Override
	public Builder toBuilder() {
		return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
	}

	@java.lang.Override
	protected Builder newBuilderForType(final com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
		Builder builder = new Builder(parent);
		return builder;
	}

	/**
	 * Protobuf type {@code pcsbasedoptimization.PCSBasedComponentProto}
	 */
	public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
	// @@protoc_insertion_point(builder_implements:pcsbasedoptimization.PCSBasedComponentProto)
	ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProtoOrBuilder {
		public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
			return ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentParameter.internal_static_pcsbasedoptimization_PCSBasedComponentProto_descriptor;
		}

		@java.lang.Override
		protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
			return ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentParameter.internal_static_pcsbasedoptimization_PCSBasedComponentProto_fieldAccessorTable
					.ensureFieldAccessorsInitialized(ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto.class, ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto.Builder.class);
		}

		// Construct using ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto.newBuilder()
		private Builder() {
			this.maybeForceBuilderInitialization();
		}

		private Builder(final com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
			super(parent);
			this.maybeForceBuilderInitialization();
		}

		private void maybeForceBuilderInitialization() {
			if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
				this.getParametersFieldBuilder();
			}
		}

		@java.lang.Override
		public Builder clear() {
			super.clear();
			this.name_ = "";

			if (this.parametersBuilder_ == null) {
				this.parameters_ = java.util.Collections.emptyList();
				this.bitField0_ = (this.bitField0_ & ~0x00000001);
			} else {
				this.parametersBuilder_.clear();
			}
			return this;
		}

		@java.lang.Override
		public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
			return ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentParameter.internal_static_pcsbasedoptimization_PCSBasedComponentProto_descriptor;
		}

		@java.lang.Override
		public ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto getDefaultInstanceForType() {
			return ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto.getDefaultInstance();
		}

		@java.lang.Override
		public ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto build() {
			ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto result = this.buildPartial();
			if (!result.isInitialized()) {
				throw newUninitializedMessageException(result);
			}
			return result;
		}

		@java.lang.Override
		public ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto buildPartial() {
			ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto result = new ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto(this);
			int from_bitField0_ = this.bitField0_;
			result.name_ = this.name_;
			if (this.parametersBuilder_ == null) {
				if (((this.bitField0_ & 0x00000001) != 0)) {
					this.parameters_ = java.util.Collections.unmodifiableList(this.parameters_);
					this.bitField0_ = (this.bitField0_ & ~0x00000001);
				}
				result.parameters_ = this.parameters_;
			} else {
				result.parameters_ = this.parametersBuilder_.build();
			}
			this.onBuilt();
			return result;
		}

		@java.lang.Override
		public Builder clone() {
			return super.clone();
		}

		@java.lang.Override
		public Builder setField(final com.google.protobuf.Descriptors.FieldDescriptor field, final java.lang.Object value) {
			return super.setField(field, value);
		}

		@java.lang.Override
		public Builder clearField(final com.google.protobuf.Descriptors.FieldDescriptor field) {
			return super.clearField(field);
		}

		@java.lang.Override
		public Builder clearOneof(final com.google.protobuf.Descriptors.OneofDescriptor oneof) {
			return super.clearOneof(oneof);
		}

		@java.lang.Override
		public Builder setRepeatedField(final com.google.protobuf.Descriptors.FieldDescriptor field, final int index, final java.lang.Object value) {
			return super.setRepeatedField(field, index, value);
		}

		@java.lang.Override
		public Builder addRepeatedField(final com.google.protobuf.Descriptors.FieldDescriptor field, final java.lang.Object value) {
			return super.addRepeatedField(field, value);
		}

		@java.lang.Override
		public Builder mergeFrom(final com.google.protobuf.Message other) {
			if (other instanceof ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto) {
				return this.mergeFrom((ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto) other);
			} else {
				super.mergeFrom(other);
				return this;
			}
		}

		public Builder mergeFrom(final ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto other) {
			if (other == ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto.getDefaultInstance()) {
				return this;
			}
			if (!other.getName().isEmpty()) {
				this.name_ = other.name_;
				this.onChanged();
			}
			if (this.parametersBuilder_ == null) {
				if (!other.parameters_.isEmpty()) {
					if (this.parameters_.isEmpty()) {
						this.parameters_ = other.parameters_;
						this.bitField0_ = (this.bitField0_ & ~0x00000001);
					} else {
						this.ensureParametersIsMutable();
						this.parameters_.addAll(other.parameters_);
					}
					this.onChanged();
				}
			} else {
				if (!other.parameters_.isEmpty()) {
					if (this.parametersBuilder_.isEmpty()) {
						this.parametersBuilder_.dispose();
						this.parametersBuilder_ = null;
						this.parameters_ = other.parameters_;
						this.bitField0_ = (this.bitField0_ & ~0x00000001);
						this.parametersBuilder_ = com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ? this.getParametersFieldBuilder() : null;
					} else {
						this.parametersBuilder_.addAllMessages(other.parameters_);
					}
				}
			}
			this.mergeUnknownFields(other.unknownFields);
			this.onChanged();
			return this;
		}

		@java.lang.Override
		public final boolean isInitialized() {
			return true;
		}

		@java.lang.Override
		public Builder mergeFrom(final com.google.protobuf.CodedInputStream input, final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto parsedMessage = null;
			try {
				parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
			} catch (com.google.protobuf.InvalidProtocolBufferException e) {
				parsedMessage = (ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto) e.getUnfinishedMessage();
				throw e.unwrapIOException();
			} finally {
				if (parsedMessage != null) {
					this.mergeFrom(parsedMessage);
				}
			}
			return this;
		}

		private int bitField0_;

		private java.lang.Object name_ = "";

		/**
		 * <code>string name = 1;</code>
		 */
		@Override
		public java.lang.String getName() {
			java.lang.Object ref = this.name_;
			if (!(ref instanceof java.lang.String)) {
				com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
				java.lang.String s = bs.toStringUtf8();
				this.name_ = s;
				return s;
			} else {
				return (java.lang.String) ref;
			}
		}

		/**
		 * <code>string name = 1;</code>
		 */
		@Override
		public com.google.protobuf.ByteString getNameBytes() {
			java.lang.Object ref = this.name_;
			if (ref instanceof String) {
				com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
				this.name_ = b;
				return b;
			} else {
				return (com.google.protobuf.ByteString) ref;
			}
		}

		/**
		 * <code>string name = 1;</code>
		 */
		public Builder setName(final java.lang.String value) {
			if (value == null) {
				throw new NullPointerException();
			}

			this.name_ = value;
			this.onChanged();
			return this;
		}

		/**
		 * <code>string name = 1;</code>
		 */
		public Builder clearName() {

			this.name_ = getDefaultInstance().getName();
			this.onChanged();
			return this;
		}

		/**
		 * <code>string name = 1;</code>
		 */
		public Builder setNameBytes(final com.google.protobuf.ByteString value) {
			if (value == null) {
				throw new NullPointerException();
			}
			checkByteStringIsUtf8(value);

			this.name_ = value;
			this.onChanged();
			return this;
		}

		private java.util.List<ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProto> parameters_ = java.util.Collections.emptyList();

		private void ensureParametersIsMutable() {
			if (!((this.bitField0_ & 0x00000001) != 0)) {
				this.parameters_ = new java.util.ArrayList<ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProto>(this.parameters_);
				this.bitField0_ |= 0x00000001;
			}
		}

		private com.google.protobuf.RepeatedFieldBuilderV3<ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProto, ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProto.Builder, ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProtoOrBuilder> parametersBuilder_;

		/**
		 * <code>repeated .pcsbasedoptimization.PCSBasedParameterProto parameters = 2;</code>
		 */
		@Override
		public java.util.List<ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProto> getParametersList() {
			if (this.parametersBuilder_ == null) {
				return java.util.Collections.unmodifiableList(this.parameters_);
			} else {
				return this.parametersBuilder_.getMessageList();
			}
		}

		/**
		 * <code>repeated .pcsbasedoptimization.PCSBasedParameterProto parameters = 2;</code>
		 */
		@Override
		public int getParametersCount() {
			if (this.parametersBuilder_ == null) {
				return this.parameters_.size();
			} else {
				return this.parametersBuilder_.getCount();
			}
		}

		/**
		 * <code>repeated .pcsbasedoptimization.PCSBasedParameterProto parameters = 2;</code>
		 */
		@Override
		public ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProto getParameters(final int index) {
			if (this.parametersBuilder_ == null) {
				return this.parameters_.get(index);
			} else {
				return this.parametersBuilder_.getMessage(index);
			}
		}

		/**
		 * <code>repeated .pcsbasedoptimization.PCSBasedParameterProto parameters = 2;</code>
		 */
		public Builder setParameters(final int index, final ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProto value) {
			if (this.parametersBuilder_ == null) {
				if (value == null) {
					throw new NullPointerException();
				}
				this.ensureParametersIsMutable();
				this.parameters_.set(index, value);
				this.onChanged();
			} else {
				this.parametersBuilder_.setMessage(index, value);
			}
			return this;
		}

		/**
		 * <code>repeated .pcsbasedoptimization.PCSBasedParameterProto parameters = 2;</code>
		 */
		public Builder setParameters(final int index, final ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProto.Builder builderForValue) {
			if (this.parametersBuilder_ == null) {
				this.ensureParametersIsMutable();
				this.parameters_.set(index, builderForValue.build());
				this.onChanged();
			} else {
				this.parametersBuilder_.setMessage(index, builderForValue.build());
			}
			return this;
		}

		/**
		 * <code>repeated .pcsbasedoptimization.PCSBasedParameterProto parameters = 2;</code>
		 */
		public Builder addParameters(final ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProto value) {
			if (this.parametersBuilder_ == null) {
				if (value == null) {
					throw new NullPointerException();
				}
				this.ensureParametersIsMutable();
				this.parameters_.add(value);
				this.onChanged();
			} else {
				this.parametersBuilder_.addMessage(value);
			}
			return this;
		}

		/**
		 * <code>repeated .pcsbasedoptimization.PCSBasedParameterProto parameters = 2;</code>
		 */
		public Builder addParameters(final int index, final ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProto value) {
			if (this.parametersBuilder_ == null) {
				if (value == null) {
					throw new NullPointerException();
				}
				this.ensureParametersIsMutable();
				this.parameters_.add(index, value);
				this.onChanged();
			} else {
				this.parametersBuilder_.addMessage(index, value);
			}
			return this;
		}

		/**
		 * <code>repeated .pcsbasedoptimization.PCSBasedParameterProto parameters = 2;</code>
		 */
		public Builder addParameters(final ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProto.Builder builderForValue) {
			if (this.parametersBuilder_ == null) {
				this.ensureParametersIsMutable();
				this.parameters_.add(builderForValue.build());
				this.onChanged();
			} else {
				this.parametersBuilder_.addMessage(builderForValue.build());
			}
			return this;
		}

		/**
		 * <code>repeated .pcsbasedoptimization.PCSBasedParameterProto parameters = 2;</code>
		 */
		public Builder addParameters(final int index, final ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProto.Builder builderForValue) {
			if (this.parametersBuilder_ == null) {
				this.ensureParametersIsMutable();
				this.parameters_.add(index, builderForValue.build());
				this.onChanged();
			} else {
				this.parametersBuilder_.addMessage(index, builderForValue.build());
			}
			return this;
		}

		/**
		 * <code>repeated .pcsbasedoptimization.PCSBasedParameterProto parameters = 2;</code>
		 */
		public Builder addAllParameters(final java.lang.Iterable<? extends ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProto> values) {
			if (this.parametersBuilder_ == null) {
				this.ensureParametersIsMutable();
				com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.parameters_);
				this.onChanged();
			} else {
				this.parametersBuilder_.addAllMessages(values);
			}
			return this;
		}

		/**
		 * <code>repeated .pcsbasedoptimization.PCSBasedParameterProto parameters = 2;</code>
		 */
		public Builder clearParameters() {
			if (this.parametersBuilder_ == null) {
				this.parameters_ = java.util.Collections.emptyList();
				this.bitField0_ = (this.bitField0_ & ~0x00000001);
				this.onChanged();
			} else {
				this.parametersBuilder_.clear();
			}
			return this;
		}

		/**
		 * <code>repeated .pcsbasedoptimization.PCSBasedParameterProto parameters = 2;</code>
		 */
		public Builder removeParameters(final int index) {
			if (this.parametersBuilder_ == null) {
				this.ensureParametersIsMutable();
				this.parameters_.remove(index);
				this.onChanged();
			} else {
				this.parametersBuilder_.remove(index);
			}
			return this;
		}

		/**
		 * <code>repeated .pcsbasedoptimization.PCSBasedParameterProto parameters = 2;</code>
		 */
		public ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProto.Builder getParametersBuilder(final int index) {
			return this.getParametersFieldBuilder().getBuilder(index);
		}

		/**
		 * <code>repeated .pcsbasedoptimization.PCSBasedParameterProto parameters = 2;</code>
		 */
		@Override
		public ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProtoOrBuilder getParametersOrBuilder(final int index) {
			if (this.parametersBuilder_ == null) {
				return this.parameters_.get(index);
			} else {
				return this.parametersBuilder_.getMessageOrBuilder(index);
			}
		}

		/**
		 * <code>repeated .pcsbasedoptimization.PCSBasedParameterProto parameters = 2;</code>
		 */
		@Override
		public java.util.List<? extends ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProtoOrBuilder> getParametersOrBuilderList() {
			if (this.parametersBuilder_ != null) {
				return this.parametersBuilder_.getMessageOrBuilderList();
			} else {
				return java.util.Collections.unmodifiableList(this.parameters_);
			}
		}

		/**
		 * <code>repeated .pcsbasedoptimization.PCSBasedParameterProto parameters = 2;</code>
		 */
		public ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProto.Builder addParametersBuilder() {
			return this.getParametersFieldBuilder().addBuilder(ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProto.getDefaultInstance());
		}

		/**
		 * <code>repeated .pcsbasedoptimization.PCSBasedParameterProto parameters = 2;</code>
		 */
		public ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProto.Builder addParametersBuilder(final int index) {
			return this.getParametersFieldBuilder().addBuilder(index, ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProto.getDefaultInstance());
		}

		/**
		 * <code>repeated .pcsbasedoptimization.PCSBasedParameterProto parameters = 2;</code>
		 */
		public java.util.List<ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProto.Builder> getParametersBuilderList() {
			return this.getParametersFieldBuilder().getBuilderList();
		}

		private com.google.protobuf.RepeatedFieldBuilderV3<ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProto, ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProto.Builder, ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProtoOrBuilder> getParametersFieldBuilder() {
			if (this.parametersBuilder_ == null) {
				this.parametersBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProto, ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProto.Builder, ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedParameterProtoOrBuilder>(
						this.parameters_, ((this.bitField0_ & 0x00000001) != 0), this.getParentForChildren(), this.isClean());
				this.parameters_ = null;
			}
			return this.parametersBuilder_;
		}

		@java.lang.Override
		public final Builder setUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
			return super.setUnknownFields(unknownFields);
		}

		@java.lang.Override
		public final Builder mergeUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
			return super.mergeUnknownFields(unknownFields);
		}

		// @@protoc_insertion_point(builder_scope:pcsbasedoptimization.PCSBasedComponentProto)
	}

	// @@protoc_insertion_point(class_scope:pcsbasedoptimization.PCSBasedComponentProto)
	private static final ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto DEFAULT_INSTANCE;
	static {
		DEFAULT_INSTANCE = new ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto();
	}

	public static ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto getDefaultInstance() {
		return DEFAULT_INSTANCE;
	}

	private static final com.google.protobuf.Parser<PCSBasedComponentProto> PARSER = new com.google.protobuf.AbstractParser<PCSBasedComponentProto>() {
		@java.lang.Override
		public PCSBasedComponentProto parsePartialFrom(final com.google.protobuf.CodedInputStream input, final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws com.google.protobuf.InvalidProtocolBufferException {
			return new PCSBasedComponentProto(input, extensionRegistry);
		}
	};

	public static com.google.protobuf.Parser<PCSBasedComponentProto> parser() {
		return PARSER;
	}

	@java.lang.Override
	public com.google.protobuf.Parser<PCSBasedComponentProto> getParserForType() {
		return PARSER;
	}

	@java.lang.Override
	public ai.libs.hasco.pcsbasedoptimization.proto.PCSBasedComponentProto getDefaultInstanceForType() {
		return DEFAULT_INSTANCE;
	}

}