package Client;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.smartmarket.SmartCheckoutGrpc;
import com.smartmarket.SmartCheckoutOuterClass.PaymentRequest;
import com.smartmarket.SmartCheckoutOuterClass.PaymentResponse;
import com.smartmarket.SmartCheckoutOuterClass.ScanRequest;
import com.smartmarket.SmartCheckoutOuterClass.ScannedItem;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class SmartCheckoutClient {

    private final ManagedChannel channel;
    private final SmartCheckoutGrpc.SmartCheckoutBlockingStub blockingStub;
    private final SmartCheckoutGrpc.SmartCheckoutStub asyncStub;

    public SmartCheckoutClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        blockingStub = SmartCheckoutGrpc.newBlockingStub(channel);
        asyncStub = SmartCheckoutGrpc.newStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void processPayment(String customerId, float amount) {
        PaymentRequest request = PaymentRequest.newBuilder()
                .setCustomerId(customerId)
                .setAmount(amount)
                .build();
        PaymentResponse response = blockingStub.processPayment(request);
        System.out.println("Payment Response: " + response.getMessage());
    }

    public void streamScannedItems(String counterId) {
        ScanRequest request = ScanRequest.newBuilder()
                .setCounterId(counterId)
                .build();

        CountDownLatch finishLatch = new CountDownLatch(1);

        StreamObserver<ScannedItem> responseObserver = new StreamObserver<ScannedItem>() {
            @Override
            public void onNext(ScannedItem item) {
                System.out.println("Scanned Item: " + item.getName() + " - " + item.getPrice());
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

        asyncStub.streamScannedItems(request, responseObserver);

        try {
            finishLatch.await(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.err.println("Stream interrupted");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SmartCheckoutClient client = new SmartCheckoutClient("localhost", 9091);

        try {
            // Unary call example
            client.processPayment("cust123", 99.99f);

            // Server streaming call example
            client.streamScannedItems("counter1");
        } finally {
            client.shutdown();
        }
    }
}
