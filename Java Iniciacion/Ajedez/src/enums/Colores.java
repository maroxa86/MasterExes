package enums;

public enum Colores {
	BLANCO("B"), NEGRO("N");
	
	public final String color;
	
	Colores(String color){
		this.color = color;
	}
	
	public String getColor(){
		return this.color;
	}
}
