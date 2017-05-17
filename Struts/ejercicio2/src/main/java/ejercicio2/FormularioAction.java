package ejercicio2;

import com.opensymphony.xwork2.ActionSupport;

import ejercicio2.beans.Formulario;

@SuppressWarnings("serial")
public class FormularioAction extends ActionSupport {

	private Formulario formulario;
	
	public String loadFormulario(){
		return SUCCESS;
	}
	
	public String resultado(){
		return SUCCESS;
	}

	public Formulario getFormulario() {
		return formulario;
	}

	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}
}
