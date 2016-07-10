package nio2;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FindingPathInformation {

	public static void main(String[] args){
		Path testFilePath = Paths.get("/someDir/test/testfile.txt");
		
		System.out.println("Printing file information: ");
		System.out.println("File.seperator: " + File.separator);
		System.out.println("\t file name: " + testFilePath.getFileName());
		System.out.println("\t root of the path: " + testFilePath.getRoot());
		
		System.out.println("\t parent of the target: " + testFilePath.getParent());
		
		System.out.println("Printing elements of the path: ");
		
		/*
		 * Prints each section of the path divided by the separator '\'
		 */
		for(Path element : testFilePath){
			System.out.println("\t path element: " + element);
		}
	}
}
