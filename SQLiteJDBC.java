package cmpt213_hw6;
import java.sql.*;

public class SQLiteJDBC {
	
	Connection c = null;
	Statement stmt = null;
	int cnt = 1;
	
	public void openTable(){
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			System.out.println("Opened database successfully");
			c.close();
	         
		} catch ( Exception e ) {
	    		System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    		System.exit(0);
	    }
	}
	
	public void createTable(){
	
			try {
				Class.forName("org.sqlite.JDBC");
				c = DriverManager.getConnection("jdbc:sqlite:test.db");
				
				stmt = c.createStatement();
				String sql = "CREATE TABLE DATA " +
		                   "(NUM			INT		NOT NULL)"; 
				stmt.executeUpdate(sql);
//				stmt.close();
//				c.close();
		      
		      
			} catch ( Exception e ) {
		    		System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    		System.exit(0);
		    }
		
		System.out.println("Table created successfully"); 
	}
	
	public void insertValue(int val){
		
		 try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:test.db");
		      c.setAutoCommit(false);
		      System.out.println("Opened database using insertValue");

		      stmt = c.createStatement();
		      String sql = "INSERT INTO DATA (ID,NUM) " +
		                   "VALUES (1,0);"; 
		      stmt.executeUpdate(sql);
		      
		      //increase the ID by one
		      cnt++;
		   
		      stmt.close();
		      c.commit();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("Records created successfully");
		  }
	
	public void updateValue(int val){
		
		try {
		      Class.forName("org.sqlite.JDBC");
		      //c = DriverManager.getConnection("jdbc:sqlite:test.db");
		      c = DriverManager.getConnection("jdbc:sqlite:test1");
		      c.setAutoCommit(false);
		      System.out.println("Opened database successfully from updateValue");

		      stmt = c.createStatement();
		      String sql = "UPDATE NUM_VAL set NUM = " + val +" WHERE rowid= 1;";
		      stmt.executeUpdate(sql);
		      c.commit();

		      stmt.close();
		      c.close();
		      
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("Operation done successfully from updateValue");
	}
	
	public void selectVal(){
		Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully from selectVal method");

	      stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT * FROM DATA;" );
	      
	         int value = rs.getInt("num");
	        
	         System.out.println( "Num = " + value );
	         
	         System.out.println();
	      
	      rs.close();
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Operation done successfully from selectVal method");
	}
}

