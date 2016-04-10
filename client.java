package cmpt213_hw6;
import java.rmi.*;

public class client {

	public static void main(String args[]) throws Exception {
		
		
		SQLiteJDBC sql = new SQLiteJDBC();
		
		
		inc i = (inc) Naming.lookup("server");
		System.out.println(i.get_number());
		
		//update the number in the SQLite file
		sql.updateValue(i.get_number());
		
		//increase the number by one
		i.add_one();
		
		System.out.println(i.get_number());
		//update the number in the SQLite file
		sql.updateValue(i.get_number());
	}
}

