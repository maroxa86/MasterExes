import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args){
		
		try {
			File fichero = new File("texto.txt");
			FileOutputStream fos = new FileOutputStream(fichero);
			DataOutputStream dos = new DataOutputStream(fos);

			dos.writeByte(120);
			dos.writeShort(32767);
			dos.writeInt(5555555);
			dos.writeLong(999999999);
			dos.writeFloat(125.52f);
			dos.writeDouble(856.34522);
			dos.writeChar('a');
			dos.writeBoolean(true);
			
			dos.close();
			fos.close();
			
			FileInputStream fis = new FileInputStream(fichero);
			DataInputStream dis = new DataInputStream(fis);
			
			System.out.println("Valor Byte: " + dis.readByte());
			System.out.println("Valor Short: " + dis.readShort());
			System.out.println("Valor Int: " + dis.readInt());
			System.out.println("Valor Long: " + dis.readLong());
			System.out.println("Valor Float: " + dis.readFloat());
			System.out.println("Valor Double: " + dis.readDouble());
			System.out.println("Valor char: " + dis.readChar());
			System.out.println("Valor boolean: " + dis.readBoolean());
			
			dis.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
}
