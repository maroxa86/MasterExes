package modelo;

import java.util.ArrayList;
import java.util.List;

import enums.Colores;
import enums.Piezas;

public class Tablero {

	private List<Pieza> piezasBlancas;
	private List<Pieza> piezasNegras;
	private Casilla casillas[][];
	
	public Tablero(){
		this.casillas = new Casilla[8][8];
		this.crearBlancas();
		this.crearBlancas();
		this.colocarPiezas();
	}
	
	private void crearBlancas(){
		this.piezasBlancas = new ArrayList<>();
		
	}
	
	private void crearPieza(List<Pieza> listadoPiezas) {
		for(Piezas pieza : Piezas.values()){
			switch(pieza){
				case PEON:
					for(int i = 0; i < 8; i++){
						listadoPiezas.add(new Peon());
					}
					break;
				case TORRE:
					for(int i = 0; i < 2; i++){
						this.piezasBlancas.add(new Torre());
					}
					break;
				case CABALLO:
					for(int i = 0; i < 2; i++){
						this.piezasBlancas.add(new Caballo());
					}
					break;
				case ALFIL:
					for(int i = 0; i < 2; i++){
						this.piezasBlancas.add(new Alfil());
					}
					break;
				case REINA:
					this.piezasBlancas.add(new Reina());
					break;
				case REY:
					this.piezasBlancas.add(new Rey());
					break;
			}
		}
		
	}

	private void colocarPiezas(){
		this.piezasNegras = new ArrayList<>();
	}
}
