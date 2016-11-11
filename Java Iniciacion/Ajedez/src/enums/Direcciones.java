package enums;

public enum Direcciones {
	IZQUIERDA("IZQUIERDA"), DERECHA("DERECHA"), ARRIBA("ARRIBA"), ABAJO("ABAJO"), DIAGONAL_IZQUIERDA("DIAGONAL IZQUIERDA"), DIAGONAL_DERECHA("DIAGONAL DERECHA");
	
	private final String direccion;
	
	Direcciones(String direccion){
		this.direccion = direccion;
	}
	
	public String getDireccion(){
		return this.direccion;
	}
}
