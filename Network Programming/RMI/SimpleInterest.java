import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SimpleInterest extends Remote {
  double calculateSimpleInterest(double principal, double rate, double time) throws RemoteException;
  void displaySimpleInterest(double principal, double rate, double time) throws RemoteException;
}
