import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Rem extends Remote{
    public int addNumber(int a, int b)throws RemoteException;
    public int subNumber(int a, int b)throws RemoteException;
    
}