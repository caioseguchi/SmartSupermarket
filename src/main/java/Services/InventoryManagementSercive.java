package Services;


import java.io.IOException;
import java.util.logging.Logger;

import com.smartmarket.InventoryManagementGrpc;
import com.smartmarket.InventoryManagementSystem.RestockRequest;
import com.smartmarket.InventoryManagementSystem.RestockResponse;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class InventoryManagementSercive {
    private static final Logger logger = Logger.getLogger(InventoryManagementSercive.class.getName());
    private Server server;

    //Start the method
    private void start() throws IOException {
        int port = 50051;
        server = ServerBuilder.forPort(port)
                .addService(new InventoryManagementImpl())
                .build()
                .start();
        logger.info("Server started, listening on " + port);
        
        //Turn of the method properly
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            InventoryManagementSercive.this.stop();
            System.err.println("*** server shut down");
        }));
    }

    //stop the server
    void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    //keep the server running while the thread is running
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    
    public static void main(String[] args) throws IOException, InterruptedException {
        final InventoryManagementSercive server = new InventoryManagementSercive();
        server.start();
        server.blockUntilShutdown();
    }

    static class InventoryManagementImpl extends InventoryManagementGrpc.InventoryManagementImplBase {
        @Override
        public StreamObserver<RestockRequest> receiveRestockRequests(StreamObserver<RestockResponse> responseObserver) {
            return new StreamObserver<RestockRequest>() {
                @Override
                public void onNext(RestockRequest restockRequest) {
                    // Process each restock request
                    System.out.println("Received restock request for product ID: " + restockRequest.getProductId() +
                            " with quantity needed: " + restockRequest.getQuantityNeeded());
                }

                //Deal with errors
                @Override
                public void onError(Throwable t) {
                    t.printStackTrace();
                }

                //The end
                @Override
                public void onCompleted() {
                    RestockResponse response = RestockResponse.newBuilder()
                            .setSuccess(true)
                            .setMessage("All restock requests processed")
                            .build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                }
            };
        }
    }
}
