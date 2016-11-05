package sieteymedio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import modelo.Banca;
import modelo.Baraja;
import modelo.Jugador;

public class SieteYMedia {

	public static void main(String[] args) {
		Baraja baraja = new Baraja();
		Banca banca = new Banca();
		
		banca.setBaraja(baraja);
		for(int i = 0; i < 4; i++){
			String nombreJugador = introducirDatos("Introduce el nombre del jugador " + i + ": ");
			Jugador jugador = new Jugador(nombreJugador);
			banca.addJugador(jugador);
			jugador.setBanca(banca);
		}
				
		banca.jugarPartida();

	}
	
	private static String introducirDatos(String mensaje){
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print(mensaje);
			return reader.readLine();			
		}
		catch(IOException ex){
			System.err.println("Ha habido algún problema al introducir los datos. Vuelve a introducirlos.");
			return introducirDatos(mensaje);
		}
	}

}
