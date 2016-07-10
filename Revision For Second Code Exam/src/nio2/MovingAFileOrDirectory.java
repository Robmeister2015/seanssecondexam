package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MovingAFileOrDirectory {

	public static void main(String[] args){
		
		Path pathSource = Paths.get("CopyRight2.txt");
		Path pathDestination = Paths.get("nbproject2/CopyRight2.txt");
		try {
			Files.move( pathSource, pathDestination, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Source file moved successfully");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
