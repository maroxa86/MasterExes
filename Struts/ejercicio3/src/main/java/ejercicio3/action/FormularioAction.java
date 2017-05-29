package ejercicio3.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import ejercicio3.beans.Usuario;
import ejercicio3.dao.UsuarioDAO;
import ejercicio3.dao.UsuarioDAOImpl;

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
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		try {
			usuarioDAO.saveUsuario(usuario);
			session.put("usuario", usuario);
		} catch (Exception e) {
			addActionError("Error al guardar la informacion del usuario");
			e.printStackTrace();
			return INPUT;
		}
		addActionMessage("Información del usuario guardada correctamente");
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
