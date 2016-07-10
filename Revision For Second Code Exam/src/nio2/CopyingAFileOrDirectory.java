package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyingAFileOrDirectory {

	public static void main(String[] args){
		Path pathSource = Paths.get("CopyRight.txt");
		Path pathDestination = Paths.get("nbproject2");
		try{
			Files.copy(pathSource, pathDestination, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Source file copied successfully");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
