package Services;

import java.io.IOException;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class ServiceRegister {
    public static void main(String[] args) throws IOException {
        // Crie uma instância jmDNS
        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

        // Registre um serviço
        ServiceInfo serviceInfo = ServiceInfo.create("_grpc._tcp.local.", "InventoryService", 50051, "path=index.html");
        jmdns.registerService(serviceInfo);

        System.out.println("Service registered: " + serviceInfo);

        // Mantém o serviço registrado
        try {
            Thread.sleep(60000); // Mantém o serviço registrado por 1 minuto
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Fechar jmDNS
        jmdns.close();
    }
}