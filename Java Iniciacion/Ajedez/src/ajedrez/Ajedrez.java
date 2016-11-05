package ajedrez;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import modelo.Tablero;

public class Ajedrez {

	public static void main(String[] args) {
		Tablero tablero = new Tablero();
		
		String nombreJugador = introducirDatos("Introduzca el nombre el nombre del jugador 1: ");
		Jugador jugador1 = new Jugador(nombreJugador);
		nombreJugador = introducirDatos("Introduzca el nombre el nombre del jugador 2: ");
		Jugador jugador2 = new Jugador(nombreJugador);
		
		
	}
	
	private static String introducirDatos(String mensaje){
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(mensaje);
			return reader.readLine();
		}
		catch(IOException ex){
			System.out.println("Error al introducir los datos, vuelve a introducir la información");
			return introducirDatos(mensaje);
		}
	}

}
