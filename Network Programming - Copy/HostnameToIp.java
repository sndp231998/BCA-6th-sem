import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostnameToIp {

    public static void main(String[] args) {
        String hostname = "google.com"; // Replace with your desired hostname
        try {
            InetAddress address = InetAddress.getByName(hostname);
            System.out.println("IP Address of " + hostname + ": " + address.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Unknown host: " + hostname);
        }
    }
}
