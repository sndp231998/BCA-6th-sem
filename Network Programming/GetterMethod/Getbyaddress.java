
import java.net.*;
class Getbyaddress{
    public static void main(String[] args) {
        try {
            byte[] ipAddr = new byte[] { (byte) 192, (byte) 168, 0, 1 };
            InetAddress addr = InetAddress.getByAddress(ipAddr);
            System.out.println("IP address: " + addr.getHostAddress());
            System.out.println("Host name: " + addr.getHostName());
        } catch (UnknownHostException ex) {
            System.err.println("Unknown host or IP address");
        }
        
    }
}