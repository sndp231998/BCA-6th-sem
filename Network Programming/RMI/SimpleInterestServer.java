
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class SimpleInterestServer {

  public static void main(String[] args) throws Exception {
    SimpleInterestImpl skeleton = new SimpleInterestImpl();

    // Export the remote object
    Registry registry = LocateRegistry.getRegistry();
    registry.bind("SimpleInterest", skeleton);

    System.out.println("The server is ready");
  }
}
