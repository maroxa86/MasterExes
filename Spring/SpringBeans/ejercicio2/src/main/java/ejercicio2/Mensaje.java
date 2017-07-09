package ejercicio2;

public class Mensaje implements Visibilidad {

	private String mensaje;
	
	public void imprimir() {
		System.out.println(mensaje);
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
