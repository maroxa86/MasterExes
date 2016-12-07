package servidorWeb;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorWeb{
	
	private int puerto = 8080;

	private final int DEBUG = 2;

	public ServidorWeb(String[] param){
		procesaParametros();
	}

    public static void main(String [] array){
		ServidorWeb instancia = new ServidorWeb(array);
		instancia.arranca();
	}
    
    public boolean procesaParametros(){
		return true;
	}

    public boolean arranca(){
    	ServerSocket servidor = null;
		try {
			servidor = new ServerSocket(puerto);
			
			while(true){
				Socket cliente = servidor.accept();
				PeticionWeb peticionWeb = new PeticionWeb(cliente);
				peticionWeb.start();
			}
		} catch (IOException e) {
			System.err.println("Error al iniciar el sevidor.\n" + e);
		}
		finally{
			try {
				servidor.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}
}
