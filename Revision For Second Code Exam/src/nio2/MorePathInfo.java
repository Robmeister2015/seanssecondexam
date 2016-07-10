package nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class MorePathInfo {

	public static void main(String[] args){
		Path testFilePath = Paths.get("./Test");
		System.out.println("The file name is: " + testFilePath.getFileName());
		
		/*
		 * Prints usable URI in web-compatible format (no spaces, spaces replaced by %20)
		 */
		System.out.println("It's URI is: " + testFilePath.toUri());
		
		/*
		 * Prints the absolute path (windows compatible)
		 */
		System.out.println("It's absolute path is: " + testFilePath.toAbsolutePath());
		
		/*
		 * Normalized path (how to access it from here)
		 */
		System.out.println("It's normalized path is: " + testFilePath.normalize());
	}
	
}
