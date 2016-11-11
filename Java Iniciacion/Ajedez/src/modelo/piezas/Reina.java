package modelo.piezas;

import enums.Piezas;
import modelo.Pieza;
import modelo.tablero.Casilla;

public class Reina extends Pieza {

	public Reina(String color){
		super(Piezas.REINA.getPiezas(), color);
	}

	@Override
	protected boolean movimientoValido(Casilla casillaDestino) {
		if((getCasilla().getColumna() == casillaDestino.getColumna()) 
				|| (getCasilla().getFila() == casillaDestino.getFila())
				|| (Math.abs(getCasilla().getColumna() - casillaDestino.getColumna()) == Math.abs(getCasilla().getFila() - casillaDestino.getFila()))){
			return this.comprobarCaminoA(casillaDestino);
		}
		System.out.println("No se ha podido realizar el movimiento");
		return false;
	}
}
