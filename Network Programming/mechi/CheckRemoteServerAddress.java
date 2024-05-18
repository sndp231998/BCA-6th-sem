package mechi;

import java.net.InetAddress;

public class CheckRemoteServerAddress {

    public static void main(String[] args) throws Exception {
        //Socket socket = new Socket("localhost", 80);
        InetAddress ip = InetAddress.getByName("www.google.com");

        byte[] ipAddress = ip.getAddress();

        if (ipAddress.length == 4) {
            System.out.println("IPv4 address: " + ip.getHostAddress());
        } else {
            System.out.println("IPv6 address: " + ip.getHostAddress());
        }
    }
}
