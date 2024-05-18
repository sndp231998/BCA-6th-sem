import java.net.InetAddress;

public class LoopbackExample {
  public static void main(String[] args) {
    InetAddress loopback = InetAddress.getLoopbackAddress();
    System.out.println("Loopback address: " + loopback.getHostAddress());
  }
}
