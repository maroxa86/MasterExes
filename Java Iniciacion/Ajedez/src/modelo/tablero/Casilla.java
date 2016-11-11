package modelo.tablero;

import modelo.Pieza;

public class Casilla {
	private int fila;
	private int columna;
	private Pieza pieza;

	public Casilla(int fila, int columna){
		this.fila = fila;
		this.columna = columna;
	}
	
	public Pieza getPieza() {
		return pieza;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}
	
}