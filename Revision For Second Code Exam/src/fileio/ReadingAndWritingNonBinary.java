package fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadingAndWritingNonBinary {

	public static void main(String[] args) throws IOException{
		String srcFile = "CopyRight.txt";
		String dstFile = "CopyRight2.txt";
		
		try(BufferedReader inputFile = new BufferedReader(new FileReader(srcFile));
				BufferedWriter outputFile = new BufferedWriter(new FileWriter(dstFile))){
			int ch = 0;
			while((ch = inputFile.read()) != -1){
				outputFile.write(ch);
			}
		}catch(FileNotFoundException fnfe){
			System.err.println("Cannot open the file " + fnfe.getMessage());
		}
		catch(IOException ioe){
			System.err.printf("Error when processing file; exiting...");
		}
	}
	
}
