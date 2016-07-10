package fileio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CharacterStreams {

	public static void main(String[] args){
	
		String filename = "CopyRight.txt";
	
		Set<String> words = new TreeSet<>();
		
		try(Scanner tokenizingScanner = new Scanner(new FileReader(filename))) {
			
			tokenizingScanner.useDelimiter("\\W");
			
			while(tokenizingScanner.hasNext()) {
				String word = tokenizingScanner.next();
				
				if(!word.isEmpty()){
					words.add(word.toLowerCase());
				}
			}
			
			for(String word : words){
				System.out.println(word + "\t");
			}
			
		}catch(FileNotFoundException fnfe) {
			System.err.println("Cannot read the input file - pass a valid file name");
		}
	}
	
}
