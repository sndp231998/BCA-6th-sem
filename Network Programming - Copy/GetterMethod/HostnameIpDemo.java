import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostnameIpDemo {

    public static void main(String[] args) {
        String hostname = "www.microsoft.com"; // Replace with your desired hostname

        try {
            InetAddress[] addresses = InetAddress.getAllByName(hostname);
            System.out.println("IP Addresses for " + hostname + ":");
            for (InetAddress address : addresses) {
                System.out.println(address.getHostAddress());
            }
        } catch (UnknownHostException e) {
            System.out.println("Unknown host: " + e.getMessage());
        }
    }
}
