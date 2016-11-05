package modelo;

import enumerados.Palo;

class Carta {

	private int numero;
	private Palo palo;
	
	public Carta(){
		super();
	}

	public Carta(int numero, Palo palo) {
		super();
		this.numero = numero;
		this.palo = palo;
	}

	public int getNumero() {
		return numero;
	}

	public Palo getPalo() {
		return palo;
	}
	
	@Override
	public String toString(){
		return "Carta[" + numero + " " + palo + "]";
	}
}
