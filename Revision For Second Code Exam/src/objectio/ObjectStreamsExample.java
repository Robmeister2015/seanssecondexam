package objectio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class ObjectStreamsExample {

	public static void main(String[] args){
		Map<String, String> presidentsOfUS = new HashMap<>();
		presidentsOfUS.put("Barack Obama", "2009 to 2017, Democratic Party, 56th and 57th terms");
		presidentsOfUS.put("George W. Bush", "2001 to 2009, Republican Party, 54th and 55th terms");
		presidentsOfUS.put("Bill Clinton", "1993 to 2001, Democratic Party, 52nd and 53rd terms");
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.data"))) {
			oos.writeObject(presidentsOfUS);
		}catch(Exception e) {
			System.err.println("Exception...");
		}
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.data"))) {
			Object obj = ois.readObject();
			
			if(obj != null && obj instanceof Map) {
				Map<String, String> presidents = (Map<String, String>) obj;
				System.out.println("Presidents name \t Description \n");
				
				for(Map.Entry<String, String> president : presidents.entrySet()) {
					System.out.printf("%s \t %s %n", president.getKey(), president.getValue());
				}
			}
			
		}catch(Exception e) {
			System.err.println("Exception...");
		}
	}
}
