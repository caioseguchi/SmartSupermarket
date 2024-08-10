package Client;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.smartmarket.InventoryManagementGrpc;
import com.smartmarket.InventoryManagementSystem.RestockRequest;
import com.smartmarket.InventoryManagementSystem.RestockResponse;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

//Communication
public class InventoryManagementClient {
    private static final Logger logger = Logger.getLogger(InventoryManagementClient.class.getName());
    private final ManagedChannel channel;
    private final InventoryManagementGrpc.InventoryManagementStub asyncStub;

    //Constructor
    public InventoryManagementClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        asyncStub = InventoryManagementGrpc.newStub(channel);
    }

    //Turn of the stream
    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    //method
    public void sendRestockRequests() throws InterruptedException {
    	
    	//Wait until the stream finish
        final CountDownLatch finishLatch = new CountDownLatch(1);

        StreamObserver<RestockResponse> responseObserver = new StreamObserver<RestockResponse>() {
        	//output
            @Override
            public void onNext(RestockResponse restockResponse) {
                logger.info("Received response: " + restockResponse.getMessage());
            }

            //deal error
            @Override
            public void onError(Throwable t) {
                logger.log(Level.SEVERE, "Request failed: ", t);
                finishLatch.countDown();
            }
            

            //the end of method
            @Override
            public void onCompleted() {
                logger.info("All requests completed");
                finishLatch.countDown();
            }
        };

        StreamObserver<RestockRequest> requestObserver = asyncStub.receiveRestockRequests(responseObserver);
        try {
            for (int i = 0; i < 5; i++) {
                RestockRequest request = RestockRequest.newBuilder()//build the message 
                        .setProductId("Product-" + i)
                        .setQuantityNeeded(10 + i)
                        .build();
                requestObserver.onNext(request);
                Thread.sleep(1000);
            }
        } catch (RuntimeException e) {
            requestObserver.onError(e);
            throw e;
        }
        requestObserver.onCompleted();
        finishLatch.await(1, TimeUnit.MINUTES);
    }

    //make the call
    public static void main(String[] args) throws InterruptedException {
        InventoryManagementClient client = new InventoryManagementClient("localhost", 50051);
        try {
            client.sendRestockRequests();
        } finally {
            client.shutdown();
        }
    }
}
