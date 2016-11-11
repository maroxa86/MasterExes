package modelo.piezas;

import enums.Piezas;
import modelo.Pieza;
import modelo.tablero.Casilla;

public class Alfil extends Pieza {

	public Alfil(String color){
		super(Piezas.ALFIL.getPiezas(), color);
	}

	@Override
	public boolean movimientoValido(Casilla casillaDestino) {
		int fila = Math.abs(casillaDestino.getFila() - getCasilla().getFila());
		int columna = Math.abs(casillaDestino.getColumna() - getCasilla().getColumna());
		
		if(fila != columna){
			System.out.println("Movimiento incorrecto del Alfil");
			return false;
		}
		
		return comprobarCaminoA(casillaDestino);
	}
}