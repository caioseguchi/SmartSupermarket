package Services;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.smartmarket.InventoryManagement2Grpc;
import com.smartmarket.InventoryManagementSystem2.InventoryUpdate;
import com.smartmarket.InventoryManagementSystem2.RestockSuggestion;

import Services.InventoryManagementSercive.InventoryManagementImpl;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class InventaryManagmentServer2 {
    private static final Logger logger = Logger.getLogger(InventaryManagmentServer2.class.getName());
    private Server server;

    private void start() throws IOException {
        int port = 50052;
        
        server = ServerBuilder.forPort(port)
                .addService(new InventoryManagement2Impl())
                .build()
                .start();
        
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            InventaryManagmentServer2.this.stop();
            System.err.println("*** server shut down");
        }));
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final InventaryManagmentServer2 server = new InventaryManagmentServer2();
        server.start();
        server.blockUntilShutdown();
    }

    static class InventoryManagement2Impl extends InventoryManagement2Grpc.InventoryManagement2ImplBase {
        @Override
        public StreamObserver<InventoryUpdate> biDirectionalInventoryUpdates(StreamObserver<RestockSuggestion> responseObserver) {
            return new StreamObserver<InventoryUpdate>() {
                @Override
                public void onNext(InventoryUpdate inventoryUpdate) {
                    // Process each inventory update
                    System.out.println("Received inventory update for product ID: " + inventoryUpdate.getProductId() +
                            " with current quantity: " + inventoryUpdate.getCurrentQuantity());

                    // Generate a restock suggestion for the given inventory update
                    RestockSuggestion suggestion = RestockSuggestion.newBuilder()
                            .setProductId(inventoryUpdate.getProductId())
                            .setSuggestedQuantity(20 - inventoryUpdate.getCurrentQuantity())
                            .build();
                    responseObserver.onNext(suggestion);
                }

                //Dear with errors
                @Override
                public void onError(Throwable t) {
                    t.printStackTrace();
                }

                //The end of method
                @Override
                public void onCompleted() {
                    responseObserver.onCompleted();
                }
            };
        }
    }
}

