import java.net.*;

public class IPAddresses {
    public static void main(String[] args) {
        try {
            // Get the InetAddress object for a hostname
            InetAddress address = InetAddress.getByName("www.google.com");
            InetAddress sandip = InetAddress.getByName("sandipchapagain.com.np");
            System.out.println("Hostname: " + address.getHostName());
            System.out.println("IP address: " + sandip.getHostAddress());

            // // Get an array of InetAddress objects for a hostname
            // InetAddress[] addresses = InetAddress.getAllByName("www.google.com");
            // System.out.println("Number of IP addresses: " + addresses.length);
            // for (int i = 0; i < addresses.length; i++) {
            //     System.out.println("IP address #" + (i+1) + ": " + addresses[i].getHostAddress());
            // }

            // // Get the InetAddress object for the local host
            // InetAddress localhost = InetAddress.getLocalHost();
            // System.out.println("Local hostname: " + localhost.getHostName());
            // System.out.println("Local IP address: " + localhost.getHostAddress());

            // // Get the InetAddress object for an IP address
            // byte[] ip = { (byte)192, (byte)168, (byte)1, (byte)1 };
            // InetAddress address2 = InetAddress.getByAddress(ip);
            // System.out.println("Hostname: " + address2.getHostName());
            // System.out.println("IP address: " + address2.getHostAddress());


        } catch (UnknownHostException ex) {
            System.err.println("Unable to get IP address information: " + ex.getMessage());
        }
    }
}
