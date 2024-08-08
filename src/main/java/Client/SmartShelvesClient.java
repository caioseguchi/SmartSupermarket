package Client;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.smartmarket.SmartShelvesGrpc;
import com.smartmarket.SmartShelvesOuterClass.ProductInfo;
import com.smartmarket.SmartShelvesOuterClass.ProductRequest;
import com.smartmarket.SmartShelvesOuterClass.StockAlert;
import com.smartmarket.SmartShelvesOuterClass.StockRequest;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class SmartShelvesClient {

    private final ManagedChannel channel;
    private final SmartShelvesGrpc.SmartShelvesBlockingStub blockingStub;
    private final SmartShelvesGrpc.SmartShelvesStub asyncStub;

    public SmartShelvesClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        blockingStub = SmartShelvesGrpc.newBlockingStub(channel);
        asyncStub = SmartShelvesGrpc.newStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void getProductInfo(String productId) {
        ProductRequest request = ProductRequest.newBuilder()
                .setProductId(productId)
                .build();
        ProductInfo response = blockingStub.getProductInfo(request);
        System.out.println("Product Info: " + response);
    }

    public void streamLowStockAlerts(String productId) {
        StockRequest request = StockRequest.newBuilder()
                .setProductId(productId)
                .build();
        
        CountDownLatch finishLatch = new CountDownLatch(1);

        StreamObserver<StockAlert> responseObserver = new StreamObserver<StockAlert>() {
            @Override
            public void onNext(StockAlert alert) {
                System.out.println("Stock Alert: " + alert);
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error: " + t);
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Stream completed");
                finishLatch.countDown();
            }
        };

        asyncStub.streamLowStockAlerts(request, responseObserver);

        try {
            finishLatch.await(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.err.println("Stream interrupted");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SmartShelvesClient client = new SmartShelvesClient("localhost", 9090);
        
        try {
            // Unary call example
            client.getProductInfo("123");
            
            // Server streaming call example
            client.streamLowStockAlerts("123");
        } finally {
            client.shutdown();
        }
    }
}
