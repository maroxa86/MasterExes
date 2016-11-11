package modelo.piezas;

import enums.Piezas;
import modelo.Pieza;
import modelo.tablero.Casilla;

public class Rey extends Pieza {

	public Rey(String color){
		super(Piezas.REY.getPiezas(), color);
	}

	@Override
	protected boolean movimientoValido(Casilla casillaDestino) {
		int columna = Math.abs(casillaDestino.getColumna() - getCasilla().getColumna());
		int fila = Math.abs(casillaDestino.getFila() - getCasilla().getFila());
		
		if(columna <= 1 && fila <= 1){
			return true;
		}
		
		if(!enroque(fila, columna, casillaDestino)){
			return false;
		}
		
		return false;
	}

	private boolean enroque(int fila, int columna, Casilla casillaDestino) {
		if(columna != 2 || numeroDeMovimientos() != 0 || casillaDestino.getFila() != getCasilla().getFila()){
			System.out.println("No se puede realizar el enroque");
		}
		int posicionTorre;
		if(casillaDestino.getColumna() == 6){
			posicionTorre = 7;
		}
		else{
			posicionTorre = 0;
		}
		
		Pieza torre = getCasillas()[getCasilla().getFila()][posicionTorre].getPieza();
		
		if(torre == null || !(torre instanceof Torre) || torre.numeroDeMovimientos() != 0){
			System.out.println("No se puede realizar el enroque");
			return false;
		}
		
		if(posicionTorre == 7){
			if(getCasillas()[getCasilla().getFila()][5].getPieza() == null
					& getCasillas()[getCasilla().getFila()][6] == null){
				return true;
			}
			else{
				System.out.println("No se puede realizar el enroque");
				return false;
			}
		}
		else{
			if(getCasillas()[getCasilla().getFila()][1].getPieza() == null
					& getCasillas()[getCasilla().getFila()][2] == null){
				return true;
			}
			else{
				System.out.println("No se puede realizar el enroque");
				return false;
			}
		}
	}

	public boolean jaque(Casilla casillaRey) {
		for(Pieza pieza : getJugador().getOponente().getPiezas()){
			if(pieza.getCasilla() == null){
				return false;
			}
			
			if(pieza.puedeMoverseA(casillaRey) && pieza.getCasilla() != null){
				System.out.println("Tienes al rey en jaque");
				return true;
			}
		}
		return false;
	}

	public boolean jaqueMate(Casilla casillaRey) {
		Casilla superior = new Casilla(casillaRey.getFila() + 1, casillaRey.getFila());
		Casilla inferior = new Casilla(casillaRey.getFila() - 1, casillaRey.getFila());
		Casilla derechaArriba = new Casilla(casillaRey.getFila() + 1, casillaRey.getFila() + 1);
		Casilla izquierdaArriba = new Casilla(casillaRey.getFila() + 1, casillaRey.getFila() - 1);
		Casilla derechaAbajo = new Casilla(casillaRey.getFila() - 1, casillaRey.getFila() + 1);
		Casilla izquierdaAbajo = new Casilla(casillaRey.getFila() - 1, casillaRey.getFila() - 1);
		
		if(superior.getColumna() >= 0 && superior.getColumna() <= 7
			&& superior.getFila() >= 0 && superior.getFila() <= 7){
			if(!jaque(superior) && getCasillas()[superior.getFila()][superior.getColumna()].getPieza() == null){
				return false;
			}
			
		}
			
		return true;
	}
}
