package servidor;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	private ServerSocket servidor;
	
	public Servidor(){
		try {
			servidor = new ServerSocket(1234);
		} catch (IOException e) {
			System.err.println("Error al inicializar el servidor:\n" + e);
			System.exit(1);
		}
	}
	
	public void startServer(){
		try {
			System.out.println("Esperando conexión.....");
			while(true){
				Socket cliente = servidor.accept(); //Accept comienza el socket y espera una conexión desde un cliente
				System.out.println("Cliente conectado");
				DataOutputStream salidaCliente = new DataOutputStream(cliente.getOutputStream());
				salidaCliente.writeUTF("Peticion recibida y aceptada");
				DataInputStream dis = new DataInputStream(cliente.getInputStream());
				BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
				String mensajeServidor;
				File fichero = new File("datos.txt");
				FileWriter textOut = new FileWriter(fichero,true);
				while((mensajeServidor = entrada.readLine()) != null){
					textOut.write(mensajeServidor);
				}
				textOut.close();
				servidor.close();
			}
		} catch (IOException e) {
			System.err.println("Error en el servidor:\n" + e.getMessage());
		}
	}
}
