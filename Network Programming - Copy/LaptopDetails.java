import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class LaptopDetails {

    public static void main(String[] args) {
        
        try {
            InetAddress myIP=InetAddress.getLocalHost();
            System.out.println("IP Address: "+myIP.getHostAddress());
            
            NetworkInterface network = NetworkInterface.getByInetAddress(myIP);
            byte[] mac = network.getHardwareAddress();
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            System.out.println("MAC Address: "+sb.toString());
            
            String ispName = network.getDisplayName();
            System.out.println("ISP Name: "+ispName);
            
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e){
            e.printStackTrace();
        }
        
    }

}
