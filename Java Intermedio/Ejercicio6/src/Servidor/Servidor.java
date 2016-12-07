package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Servidor {
	
	private ServerSocket servidor;
	private Vector<Socket> vectorClientes;
	public Servidor(){
		vectorClientes = new Vector<>();
	}
	
	public void arrancarServidor(){
		try {
			servidor = new ServerSocket(1234);
		} catch (IOException e) {
			System.err.println("Error al arrancar el servidor.\n" + e);
			System.exit(1);
		}
		
		System.out.println("Esperando conexión.....");
		while(true){
			try {
				Socket cliente = servidor.accept();//Accept comienza el socket y espera una conexión desde un cliente
				vectorClientes.add(cliente);
				Thread hilo = new Thread(new Runnable(){

					@Override
					public void run() {
						atenderCliente(cliente);
					}
					
				});
				hilo.start();
			} catch (IOException e) {
				System.err.println("Error en la ejecución del servidor.\n" + e);
			} 
		}
	}

	private void atenderCliente(Socket cliente) {
		System.out.println("Cliente conectado");
		try {
			OutputStream os = cliente.getOutputStream();
			os.write(("Bienvenido al chat" + System.getProperty("line.separator")).getBytes("ASCII"));
			os.flush();
			os.write("Tu Nombre de usuario es: " .getBytes("ASCII"));
			os.flush();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			String nick = br.readLine();
			
			String linea = null;
			while((linea = br.readLine()) != null){
				System.out.println(linea);
				for(Socket usuario : vectorClientes){
					try{
						OutputStream os2 = usuario.getOutputStream();
						os2.write((("Usuario " + nick + " escribe: " + linea).toUpperCase() + System.getProperty("line.separator")).getBytes("ASCII"));
						os2.flush();
					}catch(IOException e){
						System.err.println("Cliente Desconectado");
						vectorClientes.remove(usuario);
					}
				}
			}
		} catch (IOException e) {
			System.err.println("Error en el cliente.\n" + e);
		}
	}
}
