package ejercicio1.javabeans;

public class Fichero {
	
	private String fichero;

	public Fichero(){
		super();
	}
	
	public Fichero(String fichero){
		super();
		this.fichero = fichero;
	}
	
	public String getFichero() {
		return fichero;
	}

	public void setFichero(String fichero) {
		this.fichero = fichero;
	}
}
