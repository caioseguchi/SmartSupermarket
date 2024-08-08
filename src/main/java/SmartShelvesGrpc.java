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
    comments = "Source: SmartShelves.proto")
public final class SmartShelvesGrpc {

  private SmartShelvesGrpc() {}

  public static final String SERVICE_NAME = "SmartShelves";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<SmartShelvesOuterClass.ProductRequest,
      SmartShelvesOuterClass.ProductInfo> getGetProductInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProductInfo",
      requestType = SmartShelvesOuterClass.ProductRequest.class,
      responseType = SmartShelvesOuterClass.ProductInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<SmartShelvesOuterClass.ProductRequest,
      SmartShelvesOuterClass.ProductInfo> getGetProductInfoMethod() {
    io.grpc.MethodDescriptor<SmartShelvesOuterClass.ProductRequest, SmartShelvesOuterClass.ProductInfo> getGetProductInfoMethod;
    if ((getGetProductInfoMethod = SmartShelvesGrpc.getGetProductInfoMethod) == null) {
      synchronized (SmartShelvesGrpc.class) {
        if ((getGetProductInfoMethod = SmartShelvesGrpc.getGetProductInfoMethod) == null) {
          SmartShelvesGrpc.getGetProductInfoMethod = getGetProductInfoMethod = 
              io.grpc.MethodDescriptor.<SmartShelvesOuterClass.ProductRequest, SmartShelvesOuterClass.ProductInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "SmartShelves", "GetProductInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SmartShelvesOuterClass.ProductRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SmartShelvesOuterClass.ProductInfo.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartShelvesMethodDescriptorSupplier("GetProductInfo"))
                  .build();
          }
        }
     }
     return getGetProductInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<SmartShelvesOuterClass.StockRequest,
      SmartShelvesOuterClass.StockAlert> getStreamLowStockAlertsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamLowStockAlerts",
      requestType = SmartShelvesOuterClass.StockRequest.class,
      responseType = SmartShelvesOuterClass.StockAlert.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<SmartShelvesOuterClass.StockRequest,
      SmartShelvesOuterClass.StockAlert> getStreamLowStockAlertsMethod() {
    io.grpc.MethodDescriptor<SmartShelvesOuterClass.StockRequest, SmartShelvesOuterClass.StockAlert> getStreamLowStockAlertsMethod;
    if ((getStreamLowStockAlertsMethod = SmartShelvesGrpc.getStreamLowStockAlertsMethod) == null) {
      synchronized (SmartShelvesGrpc.class) {
        if ((getStreamLowStockAlertsMethod = SmartShelvesGrpc.getStreamLowStockAlertsMethod) == null) {
          SmartShelvesGrpc.getStreamLowStockAlertsMethod = getStreamLowStockAlertsMethod = 
              io.grpc.MethodDescriptor.<SmartShelvesOuterClass.StockRequest, SmartShelvesOuterClass.StockAlert>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "SmartShelves", "StreamLowStockAlerts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SmartShelvesOuterClass.StockRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SmartShelvesOuterClass.StockAlert.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartShelvesMethodDescriptorSupplier("StreamLowStockAlerts"))
                  .build();
          }
        }
     }
     return getStreamLowStockAlertsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SmartShelvesStub newStub(io.grpc.Channel channel) {
    return new SmartShelvesStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SmartShelvesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SmartShelvesBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SmartShelvesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SmartShelvesFutureStub(channel);
  }

  /**
   */
  public static abstract class SmartShelvesImplBase implements io.grpc.BindableService {

    /**
     */
    public void getProductInfo(SmartShelvesOuterClass.ProductRequest request,
        io.grpc.stub.StreamObserver<SmartShelvesOuterClass.ProductInfo> responseObserver) {
      asyncUnimplementedUnaryCall(getGetProductInfoMethod(), responseObserver);
    }

    /**
     */
    public void streamLowStockAlerts(SmartShelvesOuterClass.StockRequest request,
        io.grpc.stub.StreamObserver<SmartShelvesOuterClass.StockAlert> responseObserver) {
      asyncUnimplementedUnaryCall(getStreamLowStockAlertsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetProductInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                SmartShelvesOuterClass.ProductRequest,
                SmartShelvesOuterClass.ProductInfo>(
                  this, METHODID_GET_PRODUCT_INFO)))
          .addMethod(
            getStreamLowStockAlertsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                SmartShelvesOuterClass.StockRequest,
                SmartShelvesOuterClass.StockAlert>(
                  this, METHODID_STREAM_LOW_STOCK_ALERTS)))
          .build();
    }
  }

  /**
   */
  public static final class SmartShelvesStub extends io.grpc.stub.AbstractStub<SmartShelvesStub> {
    private SmartShelvesStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartShelvesStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartShelvesStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartShelvesStub(channel, callOptions);
    }

    /**
     */
    public void getProductInfo(SmartShelvesOuterClass.ProductRequest request,
        io.grpc.stub.StreamObserver<SmartShelvesOuterClass.ProductInfo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetProductInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void streamLowStockAlerts(SmartShelvesOuterClass.StockRequest request,
        io.grpc.stub.StreamObserver<SmartShelvesOuterClass.StockAlert> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStreamLowStockAlertsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SmartShelvesBlockingStub extends io.grpc.stub.AbstractStub<SmartShelvesBlockingStub> {
    private SmartShelvesBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartShelvesBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartShelvesBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartShelvesBlockingStub(channel, callOptions);
    }

    /**
     */
    public SmartShelvesOuterClass.ProductInfo getProductInfo(SmartShelvesOuterClass.ProductRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetProductInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<SmartShelvesOuterClass.StockAlert> streamLowStockAlerts(
        SmartShelvesOuterClass.StockRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getStreamLowStockAlertsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SmartShelvesFutureStub extends io.grpc.stub.AbstractStub<SmartShelvesFutureStub> {
    private SmartShelvesFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartShelvesFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartShelvesFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartShelvesFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<SmartShelvesOuterClass.ProductInfo> getProductInfo(
        SmartShelvesOuterClass.ProductRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetProductInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PRODUCT_INFO = 0;
  private static final int METHODID_STREAM_LOW_STOCK_ALERTS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SmartShelvesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SmartShelvesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PRODUCT_INFO:
          serviceImpl.getProductInfo((SmartShelvesOuterClass.ProductRequest) request,
              (io.grpc.stub.StreamObserver<SmartShelvesOuterClass.ProductInfo>) responseObserver);
          break;
        case METHODID_STREAM_LOW_STOCK_ALERTS:
          serviceImpl.streamLowStockAlerts((SmartShelvesOuterClass.StockRequest) request,
              (io.grpc.stub.StreamObserver<SmartShelvesOuterClass.StockAlert>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SmartShelvesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SmartShelvesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return SmartShelvesOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SmartShelves");
    }
  }

  private static final class SmartShelvesFileDescriptorSupplier
      extends SmartShelvesBaseDescriptorSupplier {
    SmartShelvesFileDescriptorSupplier() {}
  }

  private static final class SmartShelvesMethodDescriptorSupplier
      extends SmartShelvesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SmartShelvesMethodDescriptorSupplier(String methodName) {
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
      synchronized (SmartShelvesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SmartShelvesFileDescriptorSupplier())
              .addMethod(getGetProductInfoMethod())
              .addMethod(getStreamLowStockAlertsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
