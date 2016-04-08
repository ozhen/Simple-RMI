package cmpt213_hw6;

import java.rmi.server.*;
import java.rmi.*;

public class incimpl extends UnicastRemoteObject implements inc {

	int current;
	incimpl( ) throws RemoteException{
		super();
		current = 0;
	}
	
	
	public void add_one(){

		current = current + 1;
	}

	
	public int get_number(){

		return current;
	}

}
