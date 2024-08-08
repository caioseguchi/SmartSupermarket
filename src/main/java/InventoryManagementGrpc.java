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
    comments = "Source: InventoryManagement.proto")
public final class InventoryManagementGrpc {

  private InventoryManagementGrpc() {}

  public static final String SERVICE_NAME = "InventoryManagement";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<InventoryManagementOuterClass.RestockRequest,
      InventoryManagementOuterClass.RestockResponse> getReceiveRestockRequestsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReceiveRestockRequests",
      requestType = InventoryManagementOuterClass.RestockRequest.class,
      responseType = InventoryManagementOuterClass.RestockResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<InventoryManagementOuterClass.RestockRequest,
      InventoryManagementOuterClass.RestockResponse> getReceiveRestockRequestsMethod() {
    io.grpc.MethodDescriptor<InventoryManagementOuterClass.RestockRequest, InventoryManagementOuterClass.RestockResponse> getReceiveRestockRequestsMethod;
    if ((getReceiveRestockRequestsMethod = InventoryManagementGrpc.getReceiveRestockRequestsMethod) == null) {
      synchronized (InventoryManagementGrpc.class) {
        if ((getReceiveRestockRequestsMethod = InventoryManagementGrpc.getReceiveRestockRequestsMethod) == null) {
          InventoryManagementGrpc.getReceiveRestockRequestsMethod = getReceiveRestockRequestsMethod = 
              io.grpc.MethodDescriptor.<InventoryManagementOuterClass.RestockRequest, InventoryManagementOuterClass.RestockResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "InventoryManagement", "ReceiveRestockRequests"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  InventoryManagementOuterClass.RestockRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  InventoryManagementOuterClass.RestockResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new InventoryManagementMethodDescriptorSupplier("ReceiveRestockRequests"))
                  .build();
          }
        }
     }
     return getReceiveRestockRequestsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<InventoryManagementOuterClass.InventoryUpdate,
      InventoryManagementOuterClass.RestockSuggestion> getBiDirectionalInventoryUpdatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BiDirectionalInventoryUpdates",
      requestType = InventoryManagementOuterClass.InventoryUpdate.class,
      responseType = InventoryManagementOuterClass.RestockSuggestion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<InventoryManagementOuterClass.InventoryUpdate,
      InventoryManagementOuterClass.RestockSuggestion> getBiDirectionalInventoryUpdatesMethod() {
    io.grpc.MethodDescriptor<InventoryManagementOuterClass.InventoryUpdate, InventoryManagementOuterClass.RestockSuggestion> getBiDirectionalInventoryUpdatesMethod;
    if ((getBiDirectionalInventoryUpdatesMethod = InventoryManagementGrpc.getBiDirectionalInventoryUpdatesMethod) == null) {
      synchronized (InventoryManagementGrpc.class) {
        if ((getBiDirectionalInventoryUpdatesMethod = InventoryManagementGrpc.getBiDirectionalInventoryUpdatesMethod) == null) {
          InventoryManagementGrpc.getBiDirectionalInventoryUpdatesMethod = getBiDirectionalInventoryUpdatesMethod = 
              io.grpc.MethodDescriptor.<InventoryManagementOuterClass.InventoryUpdate, InventoryManagementOuterClass.RestockSuggestion>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "InventoryManagement", "BiDirectionalInventoryUpdates"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  InventoryManagementOuterClass.InventoryUpdate.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  InventoryManagementOuterClass.RestockSuggestion.getDefaultInstance()))
                  .setSchemaDescriptor(new InventoryManagementMethodDescriptorSupplier("BiDirectionalInventoryUpdates"))
                  .build();
          }
        }
     }
     return getBiDirectionalInventoryUpdatesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static InventoryManagementStub newStub(io.grpc.Channel channel) {
    return new InventoryManagementStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static InventoryManagementBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new InventoryManagementBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static InventoryManagementFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new InventoryManagementFutureStub(channel);
  }

  /**
   */
  public static abstract class InventoryManagementImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<InventoryManagementOuterClass.RestockRequest> receiveRestockRequests(
        io.grpc.stub.StreamObserver<InventoryManagementOuterClass.RestockResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getReceiveRestockRequestsMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<InventoryManagementOuterClass.InventoryUpdate> biDirectionalInventoryUpdates(
        io.grpc.stub.StreamObserver<InventoryManagementOuterClass.RestockSuggestion> responseObserver) {
      return asyncUnimplementedStreamingCall(getBiDirectionalInventoryUpdatesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getReceiveRestockRequestsMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                InventoryManagementOuterClass.RestockRequest,
                InventoryManagementOuterClass.RestockResponse>(
                  this, METHODID_RECEIVE_RESTOCK_REQUESTS)))
          .addMethod(
            getBiDirectionalInventoryUpdatesMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                InventoryManagementOuterClass.InventoryUpdate,
                InventoryManagementOuterClass.RestockSuggestion>(
                  this, METHODID_BI_DIRECTIONAL_INVENTORY_UPDATES)))
          .build();
    }
  }

  /**
   */
  public static final class InventoryManagementStub extends io.grpc.stub.AbstractStub<InventoryManagementStub> {
    private InventoryManagementStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InventoryManagementStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryManagementStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InventoryManagementStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<InventoryManagementOuterClass.RestockRequest> receiveRestockRequests(
        io.grpc.stub.StreamObserver<InventoryManagementOuterClass.RestockResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getReceiveRestockRequestsMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<InventoryManagementOuterClass.InventoryUpdate> biDirectionalInventoryUpdates(
        io.grpc.stub.StreamObserver<InventoryManagementOuterClass.RestockSuggestion> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getBiDirectionalInventoryUpdatesMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class InventoryManagementBlockingStub extends io.grpc.stub.AbstractStub<InventoryManagementBlockingStub> {
    private InventoryManagementBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InventoryManagementBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryManagementBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InventoryManagementBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class InventoryManagementFutureStub extends io.grpc.stub.AbstractStub<InventoryManagementFutureStub> {
    private InventoryManagementFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InventoryManagementFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryManagementFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InventoryManagementFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_RECEIVE_RESTOCK_REQUESTS = 0;
  private static final int METHODID_BI_DIRECTIONAL_INVENTORY_UPDATES = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final InventoryManagementImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(InventoryManagementImplBase serviceImpl, int methodId) {
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
        case METHODID_RECEIVE_RESTOCK_REQUESTS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.receiveRestockRequests(
              (io.grpc.stub.StreamObserver<InventoryManagementOuterClass.RestockResponse>) responseObserver);
        case METHODID_BI_DIRECTIONAL_INVENTORY_UPDATES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.biDirectionalInventoryUpdates(
              (io.grpc.stub.StreamObserver<InventoryManagementOuterClass.RestockSuggestion>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class InventoryManagementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    InventoryManagementBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return InventoryManagementOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("InventoryManagement");
    }
  }

  private static final class InventoryManagementFileDescriptorSupplier
      extends InventoryManagementBaseDescriptorSupplier {
    InventoryManagementFileDescriptorSupplier() {}
  }

  private static final class InventoryManagementMethodDescriptorSupplier
      extends InventoryManagementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    InventoryManagementMethodDescriptorSupplier(String methodName) {
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
      synchronized (InventoryManagementGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new InventoryManagementFileDescriptorSupplier())
              .addMethod(getReceiveRestockRequestsMethod())
              .addMethod(getBiDirectionalInventoryUpdatesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
