package articulos.beans;

public class Articulo {

	private int id;
	private String nombre;
	private String tipo;
	private double precio;
	
	public Articulo() {
		super();
	}
	
	public Articulo(int id) {
		super();
		this.id = id;
	}

	public Articulo(int id, String nombre, String tipo, double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
