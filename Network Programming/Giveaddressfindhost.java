import java.net.*;

public class Giveaddressfindhost {
    public static void main(String args[]) {
        System.out.println("Running Giveaddressfindhost...");
        try {
            InetAddress ia = InetAddress.getByName("208.201.239.100");
            System.out.println(ia.getCanonicalHostName());
        } catch(UnknownHostException ex) {
            System.out.println("error");
        }
    }
}
