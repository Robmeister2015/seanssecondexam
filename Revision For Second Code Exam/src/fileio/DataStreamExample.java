package fileio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamExample {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("temp.data"))) {
			for(int i = 0; i < 10; i ++){
				dos.writeByte(1);
				dos.writeByte(1);
				dos.writeInt(1);
				dos.writeLong(1);
				dos.writeFloat(1);
				dos.writeDouble(1);
			}
		}catch(IOException ioe) {
			System.err.println("an I/O error occurred while processing the file");
			System.exit(-1);
		}
		try(DataInputStream dis = new DataInputStream(new FileInputStream("temp.data"))) {
			for(int i = 0; i < 10; i ++){
				System.out.printf("%d %d %d %d %g %g %n", dis.readByte(), dis.readShort(), dis.readInt(), dis.readLong(),
						dis.readFloat(), dis.readDouble());
			}
		}catch(FileNotFoundException fnfe) {
			System.err.println("cannot read a file with the given file name");
		}catch(IOException ioe) {
			System.err.println("an I/O error occurred while processing the file");
		}
	}
}
