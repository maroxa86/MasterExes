package modelo;

import enums.Colores;

public class Vacia extends Pieza {

	
	public Vacia() {
		super('x', Colores.VACIA);
	}

	@Override
	protected void moverPieza() {
	}

}
