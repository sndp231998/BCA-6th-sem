import java.net.InetAddress;
import java.net.UnknownHostException;

class Checkip {

    static String remoteServer = "www.facebook.com";

    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName(remoteServer);
            String ipAddress = address.getHostAddress();
            
            if (address instanceof java.net.Inet4Address) {
                System.out.println("IPv4 Address: " + ipAddress);
                int digitCount = countDigits(ipAddress);
                System.out.println("Number of digits in IPv4 address: " + digitCount);
            } else if (address instanceof java.net.Inet6Address) {
                System.out.println("IPv6 Address: " + ipAddress);
                int digitCount = countDigits(ipAddress.replaceAll(":", ""));
                System.out.println("Number of digits in IPv6 address: " + digitCount);
            } else {
                System.out.println("Unknown address type");
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static int countDigits(String str) {
        int digitCount = 0;
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
            }
        }
        return digitCount;
    }
}
