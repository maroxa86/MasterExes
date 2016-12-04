package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor{

	private Socket cliente;
	private ServerSocket servidor;
	
	public Servidor(){
		try {
			servidor = new ServerSocket(3000);
		} catch (IOException e) {
			System.err.println("Error al inicializar el servidor:\n" + e);
			System.exit(1);
		}
	}

	public void startServidor(){
		try {
			System.out.println("Esperando conexión.....");
			while(true){
				cliente = servidor.accept(); //Accept comienza el socket y espera una conexión desde un cliente
				System.out.println("Cliente conectado");
				addCliente(cliente);
			}
		} catch (IOException e) {
			System.err.println("Error en el servidor:\n" + e.getMessage());
		}
		
	}

	private void addCliente(Socket cliente) {
		EnviarMensaje enviarMensaje = new EnviarMensaje();
		enviarMensaje.addCliente(cliente);
		enviarMensaje.start();
	}
}
