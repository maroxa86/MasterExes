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
		this.inicializarTablero();
		this.crearPiezas(piezasBlancas, Colores.BLANCO);
		this.crearPiezas(piezasNegras, Colores.NEGRO);
		this.colocarPiezas();
	}
	
	private void inicializarTablero() {
		this.casillas = new Casilla[8][8];
		for(int fila = 0; fila < 8; fila++){
			for(int columna = 0; columna < 8; columna++){
				Casilla casilla = new Casilla();
				casilla.setPieza(new Vacia());
				casillas[fila][columna] = casilla;
			}
		}
		this.piezasBlancas = new ArrayList<>();
		this.piezasNegras = new ArrayList<>();
	}

	private void crearPiezas(List<Pieza> listadoPiezas, Colores color) {
		for(Piezas pieza : Piezas.values()){
			switch(pieza){
				case PEON:
					listadoPiezas.add(new Peon(color));
					break;
				case TORRE:
					listadoPiezas.add(new Torre(color));
					break;
				case CABALLO:
					listadoPiezas.add(new Caballo(color));
					break;
				case ALFIL:
					listadoPiezas.add(new Alfil(color));
					break;
				case REINA:
					listadoPiezas.add(new Reina(color));
					break;
				case REY:
					listadoPiezas.add(new Rey(color));
					break;
			}
		}
		
	}

	private void colocarPiezas(){
		colocarPeones(casillas[1], piezasNegras);
		colocarFiguras(casillas[0], Colores.NEGRO, piezasNegras);
		colocarPeones(casillas[6], piezasBlancas);
		colocarFiguras(casillas[7], Colores.BLANCO,piezasBlancas);
	}

	private void colocarFiguras(Casilla[] casillas, Colores color, List<Pieza> piezas) {
		for(Pieza pieza : piezas){
			switch(pieza.getForma()){
				case 'T':
					casillas[0].setPieza(pieza);
					casillas[7].setPieza(pieza);
					break;
				case 'C':
					casillas[1].setPieza(pieza);
					casillas[6].setPieza(pieza);
					break;
				case 'A':
					casillas[2].setPieza(pieza);
					casillas[5].setPieza(pieza);
					break;
				case 'W':
					if(color.equals(Colores.BLANCO)){
						casillas[4].setPieza(pieza);
					}
					else{
						if(color.equals(Colores.NEGRO)){
							casillas[3].setPieza(pieza);
						}
					}
					break;
				case 'R':
					if(color.equals(Colores.NEGRO)){
						casillas[4].setPieza(pieza);
					}
					else{
						if(color.equals(Colores.BLANCO)){
							casillas[3].setPieza(pieza);
						}
					}
					break;
			}
		}
	}

	private void colocarPeones(Casilla[] casillas, List<Pieza> piezas) {
		for(Pieza pieza : piezas){
			if('P' == pieza.getForma()){
				for(int i = 0; i < 8; i++){
					casillas[i].setPieza(pieza);
				}
			}
		}
	}

	public void mostrarTablero() {
		for(int i = 0; i < 8; i++){
			if(i == 0){
				System.out.println("    a   b   c   d   e   f   g   h ");
			}
			for(int j = 0; j < 8; j++){
				if(j == 0){
					System.out.print(" " + (i + 1) + " ");
				}
				System.out.print(" " + casillas[i][j].getPieza().getPieza() + " ");
			}
			System.out.println();
		}
		
	}
}
