// import java.net.InetAddress;
// import java.net.UnknownHostException;
import java.net.*;
public class IpHostnameDemo {

    public static void main(String[] args) {
       // String ipAddress = "8.8.8.8"; // Replace with your desired IP address

        try {
            InetAddress[] addresses = InetAddress.getAllByName("2400:1a00:8000:a93:0:0:0:356e");
            System.out.println("Hostnames for  2400:1a00:8000:a93:0:0:0:356e:");
            for (InetAddress address : addresses) {
                System.out.println(address.getHostName());
            }
        } catch (UnknownHostException e) {
            System.out.println("Unknown host: " + e.getMessage());
        }
    }
}
