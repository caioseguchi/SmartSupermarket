package Client;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.smartmarket.InventoryManagement2Grpc;
import com.smartmarket.InventoryManagementSystem2.InventoryUpdate;
import com.smartmarket.InventoryManagementSystem2.RestockSuggestion;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class InventoryManagementClient2 {
    private static final Logger logger = Logger.getLogger(InventoryManagementClient2.class.getName());
    private final ManagedChannel channel;
    private final InventoryManagement2Grpc.InventoryManagement2Stub asyncStub;

    public InventoryManagementClient2(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        asyncStub = InventoryManagement2Grpc.newStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void biDirectionalInventoryUpdates() throws InterruptedException {
        final CountDownLatch finishLatch = new CountDownLatch(1);

        StreamObserver<RestockSuggestion> responseObserver = new StreamObserver<RestockSuggestion>() {
            @Override
            public void onNext(RestockSuggestion restockSuggestion) {
                logger.info("Received restock suggestion: Product ID: " + restockSuggestion.getProductId() +
                        ", Suggested Quantity: " + restockSuggestion.getSuggestedQuantity());
            }

            @Override
            public void onError(Throwable t) {
                logger.log(Level.SEVERE, "Request failed: ", t);
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                logger.info("All requests completed");
                finishLatch.countDown();
            }
        };

        StreamObserver<InventoryUpdate> requestObserver = asyncStub.biDirectionalInventoryUpdates(responseObserver);
        try {
            for (int i = 0; i < 5; i++) {
                InventoryUpdate update = InventoryUpdate.newBuilder()
                        .setProductId("Product-" + i)
                        .setCurrentQuantity(10 + i)
                        .build();
                requestObserver.onNext(update);
                Thread.sleep(1000);
            }
        } catch (RuntimeException e) {
            requestObserver.onError(e);
            throw e;
        }
        requestObserver.onCompleted();
        finishLatch.await(1, TimeUnit.MINUTES);
    }

    public static void main(String[] args) throws InterruptedException {
        InventoryManagementClient2 client = new InventoryManagementClient2("localhost", 50051);
        try {
            client.biDirectionalInventoryUpdates();
        } finally {
            client.shutdown();
        }
    }
}

