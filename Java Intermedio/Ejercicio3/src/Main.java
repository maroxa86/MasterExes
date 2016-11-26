import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		File origen = new File("origen.txt");
		
		try {
			System.out.println("Realizando la copia de ficheros");
			copiaFichero(origen);
			System.out.println("Realizando la copia en mayuscula del fichero");
			copiaMayusculasFichero(origen);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void copiaMayusculasFichero(File origen) throws IOException {
		 File destino = new File("copiaMayusculas.txt");
		 char[] bufferOrigen;
		 char[] bufferDestino;
		 
		 FileReader fr = new FileReader(origen);
		 bufferOrigen = new char[(int) origen.length()];
		 bufferDestino = new char[(int) origen.length()];
		 
		 fr.read(bufferOrigen);
		 
		 FileWriter fw = new FileWriter(destino);
		
		 for(int i = 0; i < bufferOrigen.length; i++){
			 bufferDestino[i] = Character.toUpperCase(bufferOrigen[i]);
		 }
		 
		 fw.write(bufferDestino);
		 
		 fr.close();
		 fw.close();
	}

	private static void copiaFichero(File origen) throws IOException {
		 File destino = new File("copia.txt");
		 char[] bufferOrigen;
		 
		 FileReader fr = new FileReader(origen);
		 bufferOrigen = new char[(int) origen.length()];
		 fr.read(bufferOrigen);
		 
		 FileWriter fw = new FileWriter(destino);
		 
		 fw.write(bufferOrigen);
		 
		 fw.close();
		 fr.close();
		 
	}

}
