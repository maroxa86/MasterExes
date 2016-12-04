package servidor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalTime;

public class EnviarMensaje extends Thread {
	private DataOutputStream salidaCliente;
	private Socket cliente;
	private boolean continuar = true;
	
	public EnviarMensaje(){
		
	}
	
	public void addCliente(Socket cliente){
		this.cliente = cliente;
	}
	
	@Override
	public void run() {
		while(continuar){
			try {
				salidaCliente = new DataOutputStream(cliente.getOutputStream());
				salidaCliente.writeUTF(LocalTime.now().toString());
				sleep(1000);
			} catch (IOException | InterruptedException e) {
				continuar = false;
				System.err.println("Error al escribir en el cliente:\n" + e);
				
			} 
		}
	}

}
