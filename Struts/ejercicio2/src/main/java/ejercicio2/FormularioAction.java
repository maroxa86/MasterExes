package ejercicio2;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class FormularioAction extends ActionSupport {
	private String nombre;
	private String apellidos;
	private String telefono;
	private String fechaNacimiento;
	private String sueldo;
	private String numHijos;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getSueldo() {
		return sueldo;
	}

	public void setSueldo(String sueldo) {
		this.sueldo = sueldo;
	}

	public String getNumHijos() {
		return numHijos;
	}

	public void setNumHijos(String numHijos) {
		this.numHijos = numHijos;
	}

	public String loadFormulario(){
		return SUCCESS;
	}
	
	public String resultado(){
		return SUCCESS;
	}
}
