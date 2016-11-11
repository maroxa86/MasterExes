package enums;

public enum Piezas {
	PEON("P"), TORRE("T"), CABALLO("C"), ALFIL("A"), REINA("W"), REY("R");

	public final String piezas;

	Piezas(String piezas){
		this.piezas = piezas;
	}

	public String getPiezas() {
		return piezas;
	}

}
