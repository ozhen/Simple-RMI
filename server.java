package cmpt213_hw6;

import java.rmi.*;

public class server {

	public static void main(String args[]) throws Exception {
		java.rmi.registry.LocateRegistry.createRegistry(1101);
		incimpl inc = new incimpl();
		//Naming.rebind("//localhost/inc", inc);
		Naming.rebind("server", inc);
	}
}
