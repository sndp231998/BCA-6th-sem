import java.rmi.Remote;
import java.rmi.RemoteException;
public class SimpleInterestImpl implements SimpleInterest {

  @Override
  public double calculateSimpleInterest(double principal, double rate, double time) throws RemoteException {
    return principal * rate * time;
  }

  @Override
  public void displaySimpleInterest(double principal, double rate, double time) throws RemoteException {
    double interest = calculateSimpleInterest(principal, rate, time);
    System.out.println("The simple interest is " + interest);
  }
}