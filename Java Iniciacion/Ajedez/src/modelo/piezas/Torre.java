package modelo.piezas;

import enums.Piezas;
import modelo.Pieza;
import modelo.tablero.Casilla;

public class Torre extends Pieza {

	public Torre(String color){
		super(Piezas.TORRE.getPiezas(), color);
	}

	@Override
	protected boolean movimientoValido(Casilla casillaDestino) {
		if(getCasilla().getFila() != casillaDestino.getFila() && getCasilla().getColumna() != casillaDestino.getColumna()){
			System.out.println("La torre no puede realizar ese movimiento");
			return false;
		}
		return this.comprobarCaminoA(casillaDestino);
	}
}
