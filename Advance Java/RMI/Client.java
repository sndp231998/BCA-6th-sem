import java.net.*;
import java.rmi.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter First number:");
       int a=sc.nextInt();
          System.out.print("Enter Second number:");
       int b=sc.nextInt();
       try{
        Rem remobj=(Rem)Naming.lookup("rmi://localhost/Rem");
        System.out.println("Sum="+remobj.addNumber(a,b));
        System.out.println(("Difference="+remobj.subNumber(a, b)));
       }catch(RemoteException re){
        System.out.println(re);
       }catch(NotBoundException nbe){
        System.out.println(nbe);
       }catch(MalformedURLException mfe){
        System.out.println(mfe);
       }
    }
}
