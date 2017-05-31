package ejercicio4.bean;

public class Comida {
	private int id;
	private String comida;

	public Comida() {

	}

	public Comida(int id, String comida) {
		this.id = id;
		this.comida = comida;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComida() {
		return comida;
	}

	public void setComida(String comida) {
		this.comida = comida;
	}
	
}
