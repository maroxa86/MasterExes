package servidor;

import java.io.IOException;

public class Principal {

	public static void main(String[] args) throws IOException{
		Servidor servidor = new Servidor();
		servidor.startServidor();
	}
}
