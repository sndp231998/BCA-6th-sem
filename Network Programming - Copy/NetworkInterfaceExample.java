import java.net.*;
import java.util.*;

public class NetworkInterfaceExample {

   public static void main(String[] args) {

      try {
         Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

         while (interfaces.hasMoreElements()) {
            NetworkInterface iface = interfaces.nextElement();
            System.out.println("Interface: " + iface.getName());

            Enumeration<InetAddress> addresses = iface.getInetAddresses();
            while (addresses.hasMoreElements()) {
               InetAddress addr = addresses.nextElement();
               System.out.println("  " + addr.getHostAddress());
            }
         }
      } catch (SocketException e) {
         System.err.println("Error retrieving network interfaces: " + e.getMessage());
      }
   }
}
