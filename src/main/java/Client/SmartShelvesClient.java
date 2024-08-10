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

	//Communication Client and Server
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

    //Turn of the communication after 5 seconds
    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    //Method
    public void getProductInfo(String productId) {
    	//make request
        ProductRequest request = ProductRequest.newBuilder()
                .setProductId(productId)
                .build();
        
        //Get Answer
        ProductInfo response = blockingStub.getProductInfo(request);
        System.out.println("Product Info: " + response);
    }

    public void streamLowStockAlerts(String productId) {
    	//Make request
        StockRequest request = StockRequest.newBuilder()//create a comment
                .setProductId(productId)
                .build();
        
        //Wait the stream finish
        CountDownLatch finishLatch = new CountDownLatch(1);

        StreamObserver<StockAlert> responseObserver = new StreamObserver<StockAlert>() {
        	//Get alert
            @Override
            public void onNext(StockAlert alert) {
                System.out.println("Stock Alert: " + alert);
            }

            //Deal error
            @Override
            public void onError(Throwable t) {
                System.err.println("Error: " + t);
                finishLatch.countDown();
            }

            //The end of method
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

    //get the response
    public static void main(String[] args) throws InterruptedException {
        SmartShelvesClient client = new SmartShelvesClient("localhost", 9090);
        
        try {
            // Unary call example
            client.getProductInfo("123");
            
            // Server streaming call example
            client.streamLowStockAlerts("124");
        } finally {
            client.shutdown();
        }
    }
}