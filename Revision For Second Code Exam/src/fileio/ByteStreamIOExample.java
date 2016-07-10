package fileio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class ByteStreamIOExample {

	public static void main(String[] args){
		String fileName = "Copy.class";
		
		byte[] magicNumber = {(byte) 0xCA, (byte) 0xFE, (byte) 0xBA, (byte) 0xBE };
		
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName))) {
			
			byte[] u4buffer = new byte[4];
			
			if(bis.read(u4buffer) != -1) {
				if(Arrays.equals(magicNumber, u4buffer)){
					System.out.printf("The magic number for %s matches a .class file format %n", fileName);
				}else{
					System.out.printf("The magic number for %s does not match a .class file format %n", fileName);
				}
			}
			
		}catch(FileNotFoundException fnfe) {
			System.err.println("File not found");
		}catch(IOException ioe){
			System.err.println("an I/O error occurred while processing the file");
		}
		}
	
}
