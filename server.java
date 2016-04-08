package cmpt213_hw6;

import java.rmi.*;
import java.sql.*;

public class server {

	public static void main(String args[]) throws Exception {
		
		Connection c = null;
		Statement stmt = null;
			try {
				Class.forName("org.sqlite.JDBC");
				c = DriverManager.getConnection("jdbc:sqlite:test.db");
				System.out.println("Opened database successfully");
				
				stmt = c.createStatement();
				String sql = "CREATE TABLE DATA " +
		                   "(ID INT PRIMARY KEY     NOT NULL," + " SALARY         REAL)"; 
				stmt.executeUpdate(sql);
				stmt.close();
				c.close();
		      
		      
			} catch ( Exception e ) {
		    		System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    		System.exit(0);
		    }
		
		System.out.println("Table created successfully"); 
		
		java.rmi.registry.LocateRegistry.createRegistry(1002);
		incimpl inc = new incimpl();
		//Naming.rebind("//localhost/inc", inc);
		Naming.rebind("server", inc);
		System.out.println("server is up!");
	}
}
