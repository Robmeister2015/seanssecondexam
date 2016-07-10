package nio2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadingFilePermissions {

	public static void main(String[] args){
		Path path = Paths.get("CopyRight.txt");
		System.out.printf("Readable: %b, Writable: %b, Executable: %b",
				Files.isReadable(path),
				Files.isWritable(path),
				Files.isExecutable(path));
	}
	
}
