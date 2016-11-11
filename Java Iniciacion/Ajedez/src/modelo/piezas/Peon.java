package modelo.piezas;

import enums.Colores;
import enums.Piezas;
import modelo.Pieza;
import modelo.tablero.Casilla;

public class Peon extends Pieza {

	public Peon(String color){
		super(Piezas.PEON.getPiezas(), color);
	}

	@Override
	protected boolean movimientoValido(Casilla casillaDestino) {
		int sentidoFila = 0;
		
		/*****
		 * Sentido de pieza; 
		 * 
		 * 1: Ascendente
		 * -1 : Descente
		 */
		
		if(this.getColor().equals(Colores.BLANCO.getColor())){
			sentidoFila = 1;
		}
		else{
			sentidoFila = -1;
		}
		
		if(getCasilla().getColumna() == casillaDestino.getColumna()){
			if((casillaDestino.getPieza() == null && getCasilla().getFila() == (casillaDestino.getFila() + sentidoFila))
					|| (numeroDeMovimientos() == 0 && casillaDestino == null && getCasilla().getFila() == (casillaDestino.getFila() + (2 * sentidoFila)))){
				return true;
			}
			else{
				System.out.println("El peon no puede realizar ese movimiento");
				return false;
			}
		}
		
		if(Math.abs(getCasilla().getColumna() - casillaDestino.getColumna()) == 1
				&& getCasilla().getFila() == (casillaDestino.getFila() + sentidoFila)){
			
			if(casillaDestino.getPieza() == null){
				return true;
			}
			
			Pieza peon = getCasillas()[casillaDestino.getFila()][getCasilla().getColumna()].getPieza();
			
			if(peon != null && peon instanceof Peon && peon.numeroDeMovimientos() == 1){
				if(peon.getJugador().getColor() == getJugador().getColor()){
					System.out.println("Tienes otra pieza en la casilla destino");
					return false;
				}
				
				if((getJugador().getColor() == Colores.BLANCO && casillaDestino.getFila() == 2) 
						|| (getJugador().getColor() == Colores.NEGRO && casillaDestino.getFila() == 5)){
					return true;
				}
			}
		}
		
		System.out.println("No se ha podido realizar el movimiento del peon");
		return false;
	}
}
