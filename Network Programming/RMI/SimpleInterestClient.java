import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.util.Scanner;

public class SimpleInterestClient {

  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the principal amount: ");
    double principal = scanner.nextDouble();

    System.out.println("Enter the interest rate: ");
    double rate = scanner.nextDouble();

    System.out.println("Enter the time in years: ");
    double time = scanner.nextDouble();

    // Locate the registry
    Registry registry = LocateRegistry.getRegistry("localhost",8085);

    // Look up the remote object
    SimpleInterest stub = (SimpleInterest) registry.lookup("SimpleInterest");

    // Calculate the simple interest
    double interest = stub.calculateSimpleInterest(principal, rate, time);

    // Display the simple interest
    System.out.println("The simple interest is " + interest);
  }
}
