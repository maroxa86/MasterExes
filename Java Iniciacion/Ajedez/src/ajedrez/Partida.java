package ajedrez;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import enums.Colores;
import modelo.Tablero;

public class Partida {

	private Tablero tablero;
	
	public Partida(Tablero tablero){
		this.tablero = tablero;
	}
	
	public void empezarPartida() {
		tablero.mostrarTablero();
		
		while(true){
			String jugador = tablero.getTurno().getColor() == Colores.BLANCO ? "BLANCO" : "NEGRO";
			System.out.println("Turno del jugador " + jugador);
			jugada();
		}
	}

	private void jugada() {	
		System.out.println("Que quires hacer:");
		System.out.println("1.- Mover pieza");
		System.out.println("2.- Rendirse");
		System.out.print("Elige una opción: ");
		int opcion = introducirNumero();
		switch(opcion){
			case 1:
				realizarMovimiento();
				break;
			case 2:
				rendirse();
				break;
			default:
				System.out.println("Opción incorrecta");
		}
	}

	private int introducirNumero() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try{
			return Integer.parseInt(reader.readLine());
		}
		catch(IOException ex){
			return 0;
		}
		catch(NumberFormatException ex){
			return 0;
		}
	}
	
	private String introduceDatos(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try{
			return reader.readLine();
		}
		catch(IOException ex){
			return "";
		}
	}

	private void realizarMovimiento() {
		System.out.print("Elige casilla origen(Ejemplo a1):");
		String origen = introduceDatos();
		if("".equals(origen)){
			System.out.println("Opción incorrecta");
			return;
		}
		System.out.print("Elige casilla destino(Ejemplo a1):");
		String destino = introduceDatos();
		if("".equals(destino)){
			System.out.println("Opción incorrecta");
			return;
		}
		
		int columnaOrigen = origen.toLowerCase().charAt(0);
		int filaOrigen = Character.getNumericValue(origen.charAt(1));
		int columnaDestino = destino.toLowerCase().charAt(0);
		int filaDestino = Character.getNumericValue(destino.charAt(1));
		
		if((columnaOrigen < 'a' || columnaOrigen > 'h')
				|| (filaOrigen < 1 || filaOrigen > 8)
				|| (columnaDestino < 'a' || columnaDestino > 'h')
				|| (filaDestino < 1 || filaDestino > 8)){
			System.out.println("Opción incorrecta");
			return;
		}
		
		if(!tablero.movimiento(origen, destino)){
			System.out.println("Opción incorrecta");
			return;
		}
		
	}
	
	private void rendirse() {
		String ganador;
		String perdedor;
		
		if(tablero.getTurno().getColor().getColor().equals("B")){
			ganador = "NEGRO";
			perdedor = "BLANCO";
		}
		else{
			perdedor = "NEGRO";
			ganador = "BLANCO";
		}
		
		System.out.println(perdedor + " abandona. " + ganador + " gana la partida!!!!!");
		System.exit(0);
		
	}
}
