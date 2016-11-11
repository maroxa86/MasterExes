package ajedrez;

import modelo.Tablero;

public class Ajedrez {

	public static void main(String[] args) {
		Tablero tablero = new Tablero();
		Partida partida = new Partida(tablero);
		partida.empezarPartida();
	}
}