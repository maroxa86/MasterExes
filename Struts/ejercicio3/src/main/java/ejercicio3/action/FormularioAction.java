package ejercicio3.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import ejercicio3.beans.Usuario;

@SuppressWarnings("serial")
public class FormularioAction extends ActionSupport {

	private Usuario usuario;
	
	public String loadFormulario(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		usuario = (Usuario) session.get("usuario");
		return SUCCESS;
	}

	public String resultado(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		Usuario usuarioAntiguo = (Usuario) session.get("usuario");
		updateFieldUsuario(usuarioAntiguo);
		return SUCCESS;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	private void updateFieldUsuario(Usuario oldInfo){
		usuario.setUsuario(oldInfo.getUsuario());
		usuario.setPassword(oldInfo.getPassword());
	}
}
