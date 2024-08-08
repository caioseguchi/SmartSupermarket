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
    comments = "Source: SmartCheckout.proto")
public final class SmartCheckoutGrpc {

  private SmartCheckoutGrpc() {}

  public static final String SERVICE_NAME = "com.smartmarket.SmartCheckout";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.smartmarket.SmartCheckoutOuterClass.PaymentRequest,
      com.smartmarket.SmartCheckoutOuterClass.PaymentResponse> getProcessPaymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProcessPayment",
      requestType = com.smartmarket.SmartCheckoutOuterClass.PaymentRequest.class,
      responseType = com.smartmarket.SmartCheckoutOuterClass.PaymentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.smartmarket.SmartCheckoutOuterClass.PaymentRequest,
      com.smartmarket.SmartCheckoutOuterClass.PaymentResponse> getProcessPaymentMethod() {
    io.grpc.MethodDescriptor<com.smartmarket.SmartCheckoutOuterClass.PaymentRequest, com.smartmarket.SmartCheckoutOuterClass.PaymentResponse> getProcessPaymentMethod;
    if ((getProcessPaymentMethod = SmartCheckoutGrpc.getProcessPaymentMethod) == null) {
      synchronized (SmartCheckoutGrpc.class) {
        if ((getProcessPaymentMethod = SmartCheckoutGrpc.getProcessPaymentMethod) == null) {
          SmartCheckoutGrpc.getProcessPaymentMethod = getProcessPaymentMethod = 
              io.grpc.MethodDescriptor.<com.smartmarket.SmartCheckoutOuterClass.PaymentRequest, com.smartmarket.SmartCheckoutOuterClass.PaymentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.smartmarket.SmartCheckout", "ProcessPayment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartmarket.SmartCheckoutOuterClass.PaymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartmarket.SmartCheckoutOuterClass.PaymentResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartCheckoutMethodDescriptorSupplier("ProcessPayment"))
                  .build();
          }
        }
     }
     return getProcessPaymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.smartmarket.SmartCheckoutOuterClass.ScanRequest,
      com.smartmarket.SmartCheckoutOuterClass.ScannedItem> getStreamScannedItemsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamScannedItems",
      requestType = com.smartmarket.SmartCheckoutOuterClass.ScanRequest.class,
      responseType = com.smartmarket.SmartCheckoutOuterClass.ScannedItem.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.smartmarket.SmartCheckoutOuterClass.ScanRequest,
      com.smartmarket.SmartCheckoutOuterClass.ScannedItem> getStreamScannedItemsMethod() {
    io.grpc.MethodDescriptor<com.smartmarket.SmartCheckoutOuterClass.ScanRequest, com.smartmarket.SmartCheckoutOuterClass.ScannedItem> getStreamScannedItemsMethod;
    if ((getStreamScannedItemsMethod = SmartCheckoutGrpc.getStreamScannedItemsMethod) == null) {
      synchronized (SmartCheckoutGrpc.class) {
        if ((getStreamScannedItemsMethod = SmartCheckoutGrpc.getStreamScannedItemsMethod) == null) {
          SmartCheckoutGrpc.getStreamScannedItemsMethod = getStreamScannedItemsMethod = 
              io.grpc.MethodDescriptor.<com.smartmarket.SmartCheckoutOuterClass.ScanRequest, com.smartmarket.SmartCheckoutOuterClass.ScannedItem>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.smartmarket.SmartCheckout", "StreamScannedItems"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartmarket.SmartCheckoutOuterClass.ScanRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartmarket.SmartCheckoutOuterClass.ScannedItem.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartCheckoutMethodDescriptorSupplier("StreamScannedItems"))
                  .build();
          }
        }
     }
     return getStreamScannedItemsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SmartCheckoutStub newStub(io.grpc.Channel channel) {
    return new SmartCheckoutStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SmartCheckoutBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SmartCheckoutBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SmartCheckoutFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SmartCheckoutFutureStub(channel);
  }

  /**
   */
  public static abstract class SmartCheckoutImplBase implements io.grpc.BindableService {

    /**
     */
    public void processPayment(com.smartmarket.SmartCheckoutOuterClass.PaymentRequest request,
        io.grpc.stub.StreamObserver<com.smartmarket.SmartCheckoutOuterClass.PaymentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getProcessPaymentMethod(), responseObserver);
    }

    /**
     */
    public void streamScannedItems(com.smartmarket.SmartCheckoutOuterClass.ScanRequest request,
        io.grpc.stub.StreamObserver<com.smartmarket.SmartCheckoutOuterClass.ScannedItem> responseObserver) {
      asyncUnimplementedUnaryCall(getStreamScannedItemsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getProcessPaymentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.smartmarket.SmartCheckoutOuterClass.PaymentRequest,
                com.smartmarket.SmartCheckoutOuterClass.PaymentResponse>(
                  this, METHODID_PROCESS_PAYMENT)))
          .addMethod(
            getStreamScannedItemsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.smartmarket.SmartCheckoutOuterClass.ScanRequest,
                com.smartmarket.SmartCheckoutOuterClass.ScannedItem>(
                  this, METHODID_STREAM_SCANNED_ITEMS)))
          .build();
    }
  }

  /**
   */
  public static final class SmartCheckoutStub extends io.grpc.stub.AbstractStub<SmartCheckoutStub> {
    private SmartCheckoutStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartCheckoutStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartCheckoutStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartCheckoutStub(channel, callOptions);
    }

    /**
     */
    public void processPayment(com.smartmarket.SmartCheckoutOuterClass.PaymentRequest request,
        io.grpc.stub.StreamObserver<com.smartmarket.SmartCheckoutOuterClass.PaymentResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getProcessPaymentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void streamScannedItems(com.smartmarket.SmartCheckoutOuterClass.ScanRequest request,
        io.grpc.stub.StreamObserver<com.smartmarket.SmartCheckoutOuterClass.ScannedItem> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStreamScannedItemsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SmartCheckoutBlockingStub extends io.grpc.stub.AbstractStub<SmartCheckoutBlockingStub> {
    private SmartCheckoutBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartCheckoutBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartCheckoutBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartCheckoutBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.smartmarket.SmartCheckoutOuterClass.PaymentResponse processPayment(com.smartmarket.SmartCheckoutOuterClass.PaymentRequest request) {
      return blockingUnaryCall(
          getChannel(), getProcessPaymentMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.smartmarket.SmartCheckoutOuterClass.ScannedItem> streamScannedItems(
        com.smartmarket.SmartCheckoutOuterClass.ScanRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getStreamScannedItemsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SmartCheckoutFutureStub extends io.grpc.stub.AbstractStub<SmartCheckoutFutureStub> {
    private SmartCheckoutFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartCheckoutFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartCheckoutFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartCheckoutFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.smartmarket.SmartCheckoutOuterClass.PaymentResponse> processPayment(
        com.smartmarket.SmartCheckoutOuterClass.PaymentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getProcessPaymentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PROCESS_PAYMENT = 0;
  private static final int METHODID_STREAM_SCANNED_ITEMS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SmartCheckoutImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SmartCheckoutImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PROCESS_PAYMENT:
          serviceImpl.processPayment((com.smartmarket.SmartCheckoutOuterClass.PaymentRequest) request,
              (io.grpc.stub.StreamObserver<com.smartmarket.SmartCheckoutOuterClass.PaymentResponse>) responseObserver);
          break;
        case METHODID_STREAM_SCANNED_ITEMS:
          serviceImpl.streamScannedItems((com.smartmarket.SmartCheckoutOuterClass.ScanRequest) request,
              (io.grpc.stub.StreamObserver<com.smartmarket.SmartCheckoutOuterClass.ScannedItem>) responseObserver);
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

  private static abstract class SmartCheckoutBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SmartCheckoutBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.smartmarket.SmartCheckoutOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SmartCheckout");
    }
  }

  private static final class SmartCheckoutFileDescriptorSupplier
      extends SmartCheckoutBaseDescriptorSupplier {
    SmartCheckoutFileDescriptorSupplier() {}
  }

  private static final class SmartCheckoutMethodDescriptorSupplier
      extends SmartCheckoutBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SmartCheckoutMethodDescriptorSupplier(String methodName) {
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
      synchronized (SmartCheckoutGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SmartCheckoutFileDescriptorSupplier())
              .addMethod(getProcessPaymentMethod())
              .addMethod(getStreamScannedItemsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
