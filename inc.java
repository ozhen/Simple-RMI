package cmpt213_hw6;

import java.rmi.*;


public interface inc extends Remote {
	public void add_one() throws RemoteException;
	public int get_number() throws RemoteException;
}
