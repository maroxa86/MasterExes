package modelo;

import modelo.piezas.Rey;
import modelo.tablero.Casilla;

public abstract class Pieza {
	private Casilla casilla;
	private Casilla[][] casillas;
	private Jugador jugador;
	private String pieza;
	private String color;
	private int movimientos;

	public Pieza(String pieza, String color) {
		this.color = color;
		this.pieza = pieza;
	}

	public Casilla getCasilla() {
		return casilla;
	}

	public void setCasilla(Casilla casilla) {
		this.casilla = casilla;
	}

	public Casilla[][] getCasillas() {
		return casillas;
	}

	public void setCasillas(Casilla[][] casillas) {
		this.casillas = casillas;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public String getPieza() {
		return pieza;
	}

	public String getColor() {
		return color;
	}
	
	public int getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(int movimientos) {
		this.movimientos = movimientos;
	}
	
	protected abstract boolean movimientoValido(Casilla casillaDestino);

	public boolean puedeMoverseA(Casilla casillaDestino) {
		if(casilla.equals(casillaDestino)){
			System.out.println("No puedes mover la pieza a la misma casilla");
			return false;
		}
		
		Pieza piezaDestino = casillaDestino.getPieza();
		if(piezaDestino != null){
			if(jugador.getColor().getColor().equals(piezaDestino.getColor())){
				System.out.println("No puedes mover a la misma casilla que una pieza de las tuyas.");
				return false;
			}
		}
		
		if(!movimientoValido(casillaDestino)){
			System.out.println("No es un movimiento valido");
			return false;
		}
		
		Casilla casillaRey = null;
		
		if(this instanceof Rey){
			casillaRey = casillaDestino;
		}
		else{
			casillaRey = getJugador().getRey().getCasilla();
		}
		
		if(getJugador().getRey().jaque(casillaRey)){
			return false;
		}
		
		return true;
	}
	
	protected boolean comprobarCaminoA(Casilla casillaDestino) {
		//Comprobación si hay alguna pieza en la horizontal hasta el destino
		if(casilla.getFila() == casillaDestino.getFila() && casilla.getColumna() != casillaDestino.getColumna()){
			int actual = Math.min(casilla.getColumna(), casillaDestino.getColumna()) + 1;
			int limite = Math.max(casilla.getColumna(), casillaDestino.getColumna()) - 1;
			
			while(actual <= limite){
				if(casillas[casilla.getFila()][actual++].getPieza() != null){
					System.out.println("Hay una pieza en el camino");
					return false;
				}
			}
		}
		else{
			//Comprobación si hay algúna pieza en la vertical hasta el destino
			if(casilla.getFila() != casillaDestino.getFila() && casilla.getColumna() == casillaDestino.getColumna()){
				int actual = Math.min(casilla.getFila(), casillaDestino.getFila()) + 1;
				int limite = Math.max(casilla.getFila(), casillaDestino.getFila()) - 1;
				
				while(actual <= limite){
					if(casillas[actual++][casilla.getColumna()].getPieza() != null){
						System.out.println("Hay una pieza en el camino");
						return false;
					}
				}
				return true;
			}
			else{
				//Comprobación de la diagonales
				if(Math.abs(casilla.getColumna() - casillaDestino.getColumna()) == Math.abs(casilla.getFila() - casillaDestino.getFila())){
					int direccionColumna = 0;
					int direccionFila = 0; 
					/*******
					 * Direcciones diagonales:
					 * 
					 * 1 --> Dirección Ascendente Fila / Dirección Derecha columna;
					 * 2 --> Dirección Descendente Fila / Dirección Izquierda columna;
					 ********/
					if(casilla.getColumna() < casillaDestino.getColumna()){
						direccionColumna = 1;
					}
					else{
						direccionColumna = -1;
					}
					
					if(casilla.getFila() < casillaDestino.getFila()){
						direccionFila = 1;
					}
					else{
						direccionFila = -1;
					}
					
					int actualColumna = casilla.getColumna() + direccionColumna;
					int actualFila = casilla.getFila() + direccionFila;
					while((direccionColumna == 1 && actualColumna < casillaDestino.getColumna()) || (direccionColumna == -1 && actualColumna > casillaDestino.getColumna())){
						if(casillas[actualFila][actualColumna].getPieza() != null){
							System.out.println("Hay una pieza en el camino");
							return false;
						}
						actualColumna += direccionColumna;
						actualFila += direccionFila;
					}
					return true;
				}
			}
		}
		System.out.println("Hay una pieza en el camino");
		return false;
	}
	
	public int numeroDeMovimientos() {
		return movimientos;
	} 
	
	public void incrementarMovimientos(){
		movimientos++;
	}
}
