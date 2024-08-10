package jmDNS;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;

public class ServerWithJmDNS {

    public static void main(String[] args) {
        try {
            // Create  JmDNS
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            // Register 
            ServiceInfo serviceInfo = ServiceInfo.create("_grpc._tcp.local.", "MyGRPCService", 50051, "gRPC Server");
            jmdns.registerService(serviceInfo);

            System.out.println("Service registereed: " + serviceInfo.getName());

            // Keep the service registered 
            System.out.println("Press Enters to stop the service...");
            System.in.read();

            // Unregister stops
            jmdns.unregisterAllServices();
            jmdns.close();
            System.out.println("Service unregistereded.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
