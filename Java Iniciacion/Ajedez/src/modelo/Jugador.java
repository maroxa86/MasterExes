package modelo;

import java.util.ArrayList;
import java.util.List;

import enums.Colores;
import modelo.piezas.Rey;

public class Jugador {
	private Jugador oponente;
	private Colores color;
	private Rey rey;
	private List<Pieza> piezas;

	public Jugador(Colores color) {
		this.color = color;
		this.piezas = new ArrayList<>();
	}
	
	
	public Colores getColor() {
		return color;
	}

	public void setColor(Colores color) {
		this.color = color;
	}

	public Jugador getOponente() {
		return oponente;
	}

	public void setOponente(Jugador oponente) {
		this.oponente = oponente;
	}


	public Rey getRey() {
		return rey;
	}


	public void setRey(Rey rey) {
		this.rey = rey;
	}
	
	public List<Pieza> getPiezas(){
		return this.piezas;
	}
	
	public void addPieza(Pieza pieza){
		this.piezas.add(pieza);
	}
}
