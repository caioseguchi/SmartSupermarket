package jmDNS;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import java.io.IOException;
import java.net.InetAddress;

public class ClientWithJmDNS {

    public static void main(String[] args) {
        try {
            // Create JmDNS
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            // Add a service
            jmdns.addServiceListener("_grpc._tcp.local.", new ServiceListener() {
                @Override
                public void serviceAdded(ServiceEvent event) {
                    System.out.println("Service addedd: " + event.getName());
                }

                @Override
                public void serviceRemoved(ServiceEvent event) {
                    System.out.println("Service removed: " + event.getName());
                }

                @Override
                public void serviceResolved(ServiceEvent event) {
                    ServiceInfo serviceInfo = event.getInfo();
                    System.out.println("Service resolved: " + serviceInfo.getQualifiedName());
                    System.out.println("Host: " + serviceInfo.getHostAddresses()[0]);
                    System.out.println("Ports: " + serviceInfo.getPort());
                    System.out.println("Type: " + serviceInfo.getType());
                    System.out.println("Descrition: " + serviceInfo.getNiceTextString());
                }
            });

            System.in.read();

            jmdns.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
