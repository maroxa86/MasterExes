package ejercicio3.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import ejercicio3.beans.Usuario;
import ejercicio3.dao.UsuarioDAO;
import ejercicio3.dao.UsuarioDAOImpl;

public class LoginAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 7555459193349514327L;
	private String user;
	private String password;
	private Usuario usuario;
	private Map<String, Object> sessionMap;

	public String loadFormulario(){
		return SUCCESS;
	}
	
	public String resultado(){
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
			usuario = usuarioDAO.getUsuario(this.user);

			if(usuario != null && this.password.equals(usuario.getPassword())){
				addActionMessage("Acceso correcto");
				this.sessionMap.put("autenticacion", true);
				this.sessionMap.put("usuario", usuario);
				return SUCCESS;
			}
			else{
				addActionError("Usuario o Contraseña erroneos");
				return INPUT;
			}
		} catch (Exception e) {
			addActionError(e.getMessage());
			return INPUT;
		}
	}
	
	public String logout(){
		this.sessionMap.clear();
		return SUCCESS;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
