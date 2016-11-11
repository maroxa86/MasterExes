package modelo;

import enums.Colores;
import modelo.piezas.Alfil;
import modelo.piezas.Caballo;
import modelo.piezas.Peon;
import modelo.piezas.Reina;
import modelo.piezas.Rey;
import modelo.piezas.Torre;
import modelo.tablero.Casilla;

public class Tablero {

	private Casilla casillas[][];
	private Jugador blanco;
	private Jugador negro;
	private Jugador turno;
	private boolean jaqueBlancas;
	private boolean jaqueNegras;
	private Pieza[] capturadasBlancas;
	private Pieza[] capturadasNegras;
	private int contadorCapturadasBlancas;
	private int contadorCapturadasNegras;
	
	public Tablero(){
		this.inicializarTablero();
		blanco = new Jugador(Colores.BLANCO);
		negro = new Jugador(Colores.NEGRO);
		blanco.setOponente(negro);
		blanco.setOponente(negro);		
		turno = blanco;
		jaqueBlancas = false;
		jaqueNegras = false;
		capturadasBlancas = new Pieza[16];
		capturadasNegras = new Pieza[16];
		this.crearPiezas(blanco);
		this.crearPiezas(negro);
	}
	
	public Jugador getTurno() {
		return turno;
	}

	private void inicializarTablero() {
		this.casillas = new Casilla[8][8];
		for(int fila = 0; fila < 8; fila++){
			for(int columna = 0; columna < 8; columna++){
				casillas[fila][columna] = new Casilla(fila, columna);
			}
		}
	}

	private void crearPiezas(Jugador jugador) {
		int filaFiguras;
		int filaPeones;
		if(Colores.BLANCO.equals((jugador.getColor()))){
			filaFiguras = 7;
			filaPeones = 6;
		}
		else{
			filaFiguras = 0;
			filaPeones = 1;
		}
		
		ubicarFiguras(filaFiguras, jugador);
		ubicarPeones(filaPeones, jugador);
		
	}

	private void ubicarPeones(int filaPeones, Jugador jugador) {
		for(int i = 0; i < 8; i++){
			Pieza peon = new Peon(jugador.getColor().getColor());
			peon.setCasilla(casillas[filaPeones][i]);
			peon.setCasillas(casillas);
			casillas[filaPeones][i].setPieza(peon);
			casillas[filaPeones][i].getPieza().setJugador(jugador);
			jugador.addPieza(peon);
		}
	}

	private void ubicarFiguras(int filaFiguras, Jugador jugador){
		Pieza[] piezas = new Pieza[]{
					new Torre(jugador.getColor().getColor()),
					new Caballo(jugador.getColor().getColor()), 
					new Alfil(jugador.getColor().getColor()), 
					new Reina(jugador.getColor().getColor()), 
					new Rey(jugador.getColor().getColor()), 
					new Alfil(jugador.getColor().getColor()), 
					new Caballo(jugador.getColor().getColor()), 
					new Torre(jugador.getColor().getColor()) 
				};
		
		jugador.setRey((Rey)piezas[4]);
		
		for(int i = 0; i < 8; i++){
			piezas[i].setCasilla(casillas[filaFiguras][i]);
			piezas[i].setCasillas(casillas);
			casillas[filaFiguras][i].setPieza(piezas[i]);
			casillas[filaFiguras][i].getPieza().setJugador(jugador);
			jugador.addPieza(piezas[i]);
		}
	}

	public void mostrarTablero() {
		int i;
		int j;
		for(i = 0; i < 8; i++){
			for(j = 0; j < 8; j++){
				Pieza pieza = casillas[i][j].getPieza();
				if(pieza == null){
					if(i % 2 == 0){
						if(j % 2 == 0){
							System.out.print("   ");
							continue;
						}
						else{
							System.out.print("## ");
							continue;
						}
					}
					else{
						if(j % 2 == 0){
							System.out.print("## ");
							continue;
						}
						else{
							System.out.print("   ");
							continue;
						}
					}
				}
				
				System.out.print(pieza.getPieza() + pieza.getColor() + " ");
			}
			System.out.println(j - i); 
		}
		System.out.println("a  b  c  d  e  f  g  h");
		System.out.println();
	}

	public boolean movimiento(String origen, String destino) {
		jaqueBlancas = false;
		jaqueNegras = false;
		
		int fila = obtenerFila(origen.charAt(0));
		int columna = 8 - Character.getNumericValue(origen.charAt(1));
		
		Casilla casillaOrigen = casillas[fila][columna];
		Pieza piezaOrigen = casillaOrigen.getPieza();
		
		fila = obtenerFila(destino.charAt(0));
		columna = 8 - Character.getNumericValue(destino.charAt(1));
		
		Casilla casillaDestino = casillas[fila][columna];
		Pieza piezaDestino = casillaDestino.getPieza();
		
		if(piezaOrigen == null){
			System.out.println("No hay ninguna pieza en la casilla origen");
			return false;
		}
		
		if(piezaOrigen.getJugador().getColor() != turno.getColor()){
			System.out.println("La pieza que quieres mover no es tuya");
			return false;
		}
		
		if(!piezaOrigen.puedeMoverseA(casillaDestino)){
			System.out.println("La pieza no puede moverse a la casilla destino");
		}
		
		if(piezaDestino != null){
			piezaDestino.setCasilla(null);
			if(turno == blanco){
				capturadasNegras[contadorCapturadasNegras++] = piezaDestino;
			}
			else{
				capturadasBlancas[contadorCapturadasBlancas++] = piezaDestino;
			}
		}
		
		if(piezaOrigen instanceof Peon){
			passante(piezaOrigen, casillaDestino);
		}
		
		//TODO: SEGUIR A PARTIR DE AQUI
		
		return false;
	}

	private void passante(Pieza piezaOrigen, Casilla casillaDestino) {
		int sentidoFila = 0;
		
		/*****
		 * Sentido de pieza; 
		 * 
		 * 1: Ascendente
		 * -1 : Descente
		 */
		
		if(piezaOrigen.getColor().equals(Colores.BLANCO.getColor())){
			sentidoFila = 1;
		}
		else{
			sentidoFila = -1;
		}
		
		if(Math.abs(piezaOrigen.getCasilla().getColumna() - casillaDestino.getColumna()) == 1 && piezaOrigen.getCasilla().getFila() == (casillaDestino.getFila() + sentidoFila)){
			Pieza piezaCapturada = casillas[piezaOrigen.getCasilla().getFila()][casillaDestino.getColumna()].getPieza();
			if(turno == blanco){
				capturadasNegras[contadorCapturadasNegras++] = piezaCapturada;
			}
			else{
				capturadasBlancas[contadorCapturadasBlancas++] = piezaCapturada;
			}
		}
	}

	private int obtenerFila(char letra) {
		switch(letra){
			case 'a':
				return 0;
			case 'b':
				return 1;
			case 'c':
				return 2;
			case 'd':
				return 3;
			case 'e':
				return 4;
			case 'f':
				return 5;
			case 'g':
				return 6;
			case 'h':
				return 7;
			default:
				return -1;
		}
	}

}
