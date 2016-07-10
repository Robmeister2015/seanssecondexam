package implementingserializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TransientSerialization {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
		USPresident usPresident = new USPresident("Barack Obama", "2009 to 2017", "56th and 57th terms");
		System.out.println(usPresident);
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("USPresident.data"))){
			oos.writeObject(usPresident);
		}catch(Exception ioe) {
			System.err.println("Exception occurred...");
		}
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("USPresident.data"))){
			Object obj = ois.readObject();
			
			if(obj != null && obj instanceof USPresident){
				USPresident presidentOfUS = (USPresident)obj;
				System.out.println(presidentOfUS);
			}
		}catch(Exception fnfe) {
			System.err.println("Exception occurred...");
		}
	}
	
}
