package cmpt213_hw6;
import java.rmi.*;

public class client {

	public static void main(String args[]) throws Exception {
		//inc i = (inc) Naming.lookup("//localhost/inc");
		
		inc i = (inc) Naming.lookup("server");
		System.out.println(i.get_number());
		i.add_one();
		System.out.println(i.get_number());
	}
}

