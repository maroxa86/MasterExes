package modelo;

import enums.Colores;

public abstract class Pieza {

	protected char forma;
	protected Colores color;
	
	protected abstract void moverPieza();
	
	public char getForma(){
		return this.forma;
	}
	
	public String getPieza(){
		return this.forma + this.color.getColor();
	}

	public Pieza(char forma, Colores color) {
		super();
		this.forma = forma;
		this.color = color;
	}
}
