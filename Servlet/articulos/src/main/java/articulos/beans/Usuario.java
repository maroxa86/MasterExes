package articulos.beans;

public class Usuario {

	private String usuario;
	private String rol;
	
	public Usuario() {
		
	}

	public Usuario(String usuario) {
		super();
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	
}
