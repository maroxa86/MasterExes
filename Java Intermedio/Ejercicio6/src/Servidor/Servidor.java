package Servidor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	private ServerSocket servidor;
	
	public Servidor(){
		
	}
	
	public void arrancarServidor(){
		try {
			servidor = new ServerSocket(9000);
		} catch (IOException e) {
			System.err.println("Error al arrancar el servidor.\n" + e);
			System.exit(1);
		}
		
		System.out.println("Esperando conexión.....");
		while(true){
			try {
				Socket cliente = servidor.accept();//Accept comienza el socket y espera una conexión desde un cliente
				System.out.println("Cliente conectado");
				DataOutputStream salidaCliente = new DataOutputStream(cliente.getOutputStream());
				salidaCliente.writeUTF("Nuevo usuario en el chat\n");
				
				atenderUsuario(cliente);				
			} catch (IOException e) {
				System.err.println("Error en la ejecución del servidor.\n" + e);
			} 	
			finally{
				try {
					servidor.close();
				} catch (IOException e) {
					System.err.println("Error al cerrar el servidor.\n" + e);
				}
			}
		}
	}

	private void atenderUsuario(Socket cliente) {
		
		
	}
}
