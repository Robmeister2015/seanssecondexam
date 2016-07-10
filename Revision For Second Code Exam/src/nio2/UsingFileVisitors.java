package nio2;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class UsingFileVisitors extends SimpleFileVisitor<Path> {

	private Path source, destination;
	
	public UsingFileVisitors(Path s,  Path d){
		source = s;
		destination = d;
	}
	
	@Override
	public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes){
		System.out.println("\tvisitFile:path == " + path);
		
		System.out.println("\t\tsource.relativize(path) == " + source.relativize(path));
		Path newd = destination.resolve(source.relativize(path));
		System.out.println("\t\tnewd == " + newd);
		try{
			Files.copy(path, newd, StandardCopyOption.REPLACE_EXISTING);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes fileAttributes){
		System.out.println("\tvisitDirectory:path == " + path);
		
		Path newd = destination.resolve(source.relativize(path));
		System.out.println("\t\tnewd == " + newd);
		try{
			Files.copy(path, newd, StandardCopyOption.REPLACE_EXISTING);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return FileVisitResult.CONTINUE;
	}
}

class FileTreeWalkCopy {
	public static void main(String[] args){
		//Directory you want to copy
		Path pathSource = Paths.get("src");
		//Directory you want to copy to
		Path pathDestination = Paths.get("nbproject2");
		try {
			Files.walkFileTree(pathSource, new UsingFileVisitors(pathSource, pathDestination));
			System.out.println("Files copied successfully!");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}	