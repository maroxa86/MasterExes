import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			char[] buffer;
			File fichero = new File("texto.txt");
			buffer = new char[(int)fichero.length()];
			FileReader re = new FileReader(fichero);
			re.read(buffer);
			System.out.println(buffer);
			re.close();
		} catch (FileNotFoundException e) {
			System.err.println("Error al leer el fichero.\n" + e);
		} catch (IOException e) {
			System.err.println("Error al leer el fichero.\n" + e);
		}
		
		
	}

}
