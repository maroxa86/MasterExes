package modelo.piezas;

import enums.Piezas;
import modelo.Pieza;
import modelo.tablero.Casilla;

public class Caballo extends Pieza {

	public Caballo(String color) {
		super(Piezas.CABALLO.getPiezas(), color);
	}

	@Override
	protected boolean movimientoValido(Casilla casillaDestino) {
		int columna = Math.abs(casillaDestino.getColumna() - getCasilla().getColumna());
		int fila = Math.abs(casillaDestino.getFila() - getCasilla().getFila());
		
		if(columna == 2 && fila == 1){
			return true;
		}
		
		if(columna == 1 && fila == 2){
			return true;
		}
		
		System.out.println("El caballo no puede realizar ese movimiento");
		return false;
	}

}
