import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Server{
    public static void main(String[] args) {
        try{
            Rem_imp locobj=new Rem_imp();
            Naming.rebind("rmi:///Rem", locobj);
        }catch(RemoteException re){
            System.out.println(re);
        }catch(MalformedURLException mfe){
            System.out.println(mfe);
        }
    }
}