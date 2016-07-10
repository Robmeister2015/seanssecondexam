package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeletingAFile {

	public static void main(String[] args){
		
		Path pathSource = Paths.get("nbproject2/CopyRight2.txt");
		
		try {
			Files.delete(pathSource);
			System.out.println("File deleted successfully");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
