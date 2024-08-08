package Services;

import java.io.IOException;

import com.smartmarket.SmartCheckoutGrpc;
import com.smartmarket.SmartCheckoutOuterClass.PaymentRequest;
import com.smartmarket.SmartCheckoutOuterClass.PaymentResponse;
import com.smartmarket.SmartCheckoutOuterClass.ScanRequest;
import com.smartmarket.SmartCheckoutOuterClass.ScannedItem;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class SmartCheckoutService extends SmartCheckoutGrpc.SmartCheckoutImplBase {

    @Override
    public void processPayment(PaymentRequest request, StreamObserver<PaymentResponse> responseObserver) {
        // Logic to process payment
        String customerId = request.getCustomerId();
        float amount = request.getAmount();
        
        // For demonstration, let's assume all payments are successful
        PaymentResponse response = PaymentResponse.newBuilder()
                .setSuccess(true)
                .setMessage("Payment processed successfully for customer " + customerId + " of amount " + amount)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void streamScannedItems(ScanRequest request, StreamObserver<ScannedItem> responseObserver) {
        // Logic to stream scanned items
        String counterId = request.getCounterId();

        // For demonstration, let's send a few scanned items
        ScannedItem item1 = ScannedItem.newBuilder()
                .setProductId("001")
                .setName("Apple")
                .setPrice(0.99f)
                .build();

        ScannedItem item2 = ScannedItem.newBuilder()
                .setProductId("002")
                .setName("Banana")
                .setPrice(0.59f)
                .build();

        responseObserver.onNext(item1);
        responseObserver.onNext(item2);
        
        // Complete the stream
        responseObserver.onCompleted();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(9091)
                .addService(new SmartCheckoutService())
                .build();

        server.start();
        System.out.println("Server started at " + server.getPort());
        server.awaitTermination();
    }
}
