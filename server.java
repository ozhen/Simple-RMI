package cmpt213_hw6;

import java.rmi.*;
import java.sql.*;

public class server {

	public static void main(String args[]) throws Exception {
		
		java.rmi.registry.LocateRegistry.createRegistry(1099);
		incimpl inc = new incimpl();
		Naming.rebind("server", inc);
		System.out.println("server is up!");
	}
}
