
package Services;

import java.io.IOException;

import com.smartmarket.SmartShelvesGrpc;
import com.smartmarket.SmartShelvesOuterClass.ProductInfo;
import com.smartmarket.SmartShelvesOuterClass.ProductRequest;
import com.smartmarket.SmartShelvesOuterClass.StockAlert;
import com.smartmarket.SmartShelvesOuterClass.StockRequest;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class SmartShelvesService<setRemainingQuantity> extends SmartShelvesGrpc.SmartShelvesImplBase {

    @Override
    public void getProductInfo(ProductRequest request, StreamObserver<ProductInfo> responseObserver) {
        // Set the answer 
        ProductInfo productInfo = ProductInfo.newBuilder()
        		.setProductId(request.getProductId())//get from customer
        		.setName("Straberry")
        		.setPrice(9.99f).setQuantity(50)
                .build();
        
        responseObserver.onNext(productInfo);
        //The end of method
        responseObserver.onCompleted();
    }

    @Override
    public void streamLowStockAlerts(StockRequest request, StreamObserver<StockAlert> responseObserver) {
    	// Set the answer - item that has a low level in the shelf
        StockAlert alert = StockAlert.newBuilder()
        		.setProductId("124")
        		.setName("Mango")
        		.setRemainingQuantity(5)
        		.build();
        
        responseObserver.onNext(alert);
      //The end of method
        responseObserver.onCompleted();
    }

    //Run the server
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(9090)
                .addService((BindableService) new SmartShelvesService())
                .build();

        server.start();
        System.out.println("Server started at " + server.getPort());
        server.awaitTermination();
    }
}
