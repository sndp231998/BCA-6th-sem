import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Rem_imp extends UnicastRemoteObject implements Rem {

    protected Rem_imp() throws RemoteException {
        super();
        
    }

    @Override
    public int addNumber(int a, int b)  {
      return a+b;
    }

    @Override
    public int subNumber(int a, int b) {
    return a-b;    
        
    }
    
}
