package com.smartmarket;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: InventoryManagementSystem2.proto")
public final class InventoryManagement2Grpc {

  private InventoryManagement2Grpc() {}

  public static final String SERVICE_NAME = "com.smartmarket.InventoryManagement2";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.smartmarket.InventoryManagementSystem2.InventoryUpdate,
      com.smartmarket.InventoryManagementSystem2.RestockSuggestion> getBiDirectionalInventoryUpdatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BiDirectionalInventoryUpdates",
      requestType = com.smartmarket.InventoryManagementSystem2.InventoryUpdate.class,
      responseType = com.smartmarket.InventoryManagementSystem2.RestockSuggestion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.smartmarket.InventoryManagementSystem2.InventoryUpdate,
      com.smartmarket.InventoryManagementSystem2.RestockSuggestion> getBiDirectionalInventoryUpdatesMethod() {
    io.grpc.MethodDescriptor<com.smartmarket.InventoryManagementSystem2.InventoryUpdate, com.smartmarket.InventoryManagementSystem2.RestockSuggestion> getBiDirectionalInventoryUpdatesMethod;
    if ((getBiDirectionalInventoryUpdatesMethod = InventoryManagement2Grpc.getBiDirectionalInventoryUpdatesMethod) == null) {
      synchronized (InventoryManagement2Grpc.class) {
        if ((getBiDirectionalInventoryUpdatesMethod = InventoryManagement2Grpc.getBiDirectionalInventoryUpdatesMethod) == null) {
          InventoryManagement2Grpc.getBiDirectionalInventoryUpdatesMethod = getBiDirectionalInventoryUpdatesMethod = 
              io.grpc.MethodDescriptor.<com.smartmarket.InventoryManagementSystem2.InventoryUpdate, com.smartmarket.InventoryManagementSystem2.RestockSuggestion>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.smartmarket.InventoryManagement2", "BiDirectionalInventoryUpdates"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartmarket.InventoryManagementSystem2.InventoryUpdate.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartmarket.InventoryManagementSystem2.RestockSuggestion.getDefaultInstance()))
                  .setSchemaDescriptor(new InventoryManagement2MethodDescriptorSupplier("BiDirectionalInventoryUpdates"))
                  .build();
          }
        }
     }
     return getBiDirectionalInventoryUpdatesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static InventoryManagement2Stub newStub(io.grpc.Channel channel) {
    return new InventoryManagement2Stub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static InventoryManagement2BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new InventoryManagement2BlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static InventoryManagement2FutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new InventoryManagement2FutureStub(channel);
  }

  /**
   */
  public static abstract class InventoryManagement2ImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.smartmarket.InventoryManagementSystem2.InventoryUpdate> biDirectionalInventoryUpdates(
        io.grpc.stub.StreamObserver<com.smartmarket.InventoryManagementSystem2.RestockSuggestion> responseObserver) {
      return asyncUnimplementedStreamingCall(getBiDirectionalInventoryUpdatesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getBiDirectionalInventoryUpdatesMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.smartmarket.InventoryManagementSystem2.InventoryUpdate,
                com.smartmarket.InventoryManagementSystem2.RestockSuggestion>(
                  this, METHODID_BI_DIRECTIONAL_INVENTORY_UPDATES)))
          .build();
    }
  }

  /**
   */
  public static final class InventoryManagement2Stub extends io.grpc.stub.AbstractStub<InventoryManagement2Stub> {
    private InventoryManagement2Stub(io.grpc.Channel channel) {
      super(channel);
    }

    private InventoryManagement2Stub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryManagement2Stub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InventoryManagement2Stub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.smartmarket.InventoryManagementSystem2.InventoryUpdate> biDirectionalInventoryUpdates(
        io.grpc.stub.StreamObserver<com.smartmarket.InventoryManagementSystem2.RestockSuggestion> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getBiDirectionalInventoryUpdatesMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class InventoryManagement2BlockingStub extends io.grpc.stub.AbstractStub<InventoryManagement2BlockingStub> {
    private InventoryManagement2BlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InventoryManagement2BlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryManagement2BlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InventoryManagement2BlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class InventoryManagement2FutureStub extends io.grpc.stub.AbstractStub<InventoryManagement2FutureStub> {
    private InventoryManagement2FutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InventoryManagement2FutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryManagement2FutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InventoryManagement2FutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_BI_DIRECTIONAL_INVENTORY_UPDATES = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final InventoryManagement2ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(InventoryManagement2ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BI_DIRECTIONAL_INVENTORY_UPDATES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.biDirectionalInventoryUpdates(
              (io.grpc.stub.StreamObserver<com.smartmarket.InventoryManagementSystem2.RestockSuggestion>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class InventoryManagement2BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    InventoryManagement2BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.smartmarket.InventoryManagementSystem2.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("InventoryManagement2");
    }
  }

  private static final class InventoryManagement2FileDescriptorSupplier
      extends InventoryManagement2BaseDescriptorSupplier {
    InventoryManagement2FileDescriptorSupplier() {}
  }

  private static final class InventoryManagement2MethodDescriptorSupplier
      extends InventoryManagement2BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    InventoryManagement2MethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (InventoryManagement2Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new InventoryManagement2FileDescriptorSupplier())
              .addMethod(getBiDirectionalInventoryUpdatesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
