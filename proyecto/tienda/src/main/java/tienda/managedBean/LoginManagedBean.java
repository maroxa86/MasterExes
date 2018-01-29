package tienda.managedBean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import tienda.dominios.Trabajador;
import tienda.dominios.Usuario;
import tienda.service.LoginService;
import tienda.utils.SessionUtil;

@ManagedBean(name = "login")
@SessionScoped
public class LoginManagedBean {

	@ManagedProperty("#{loginService}")
	private LoginService loginService;
	
	private String user;
	private String pwd;
	private Trabajador datosTrabajador;

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Trabajador getDatosTrabajador() {
		return datosTrabajador;
	}

	public void setDatosTrabajador(Trabajador datosTrabajador) {
		this.datosTrabajador = datosTrabajador;
	}

	public String validateUser() {
		Usuario usuario = getLoginService().login(user, pwd);
		if (usuario != null) {
			HttpSession session = SessionUtil.getSession();
			session.setAttribute("username", usuario.getUsuario());

			datosTrabajador = usuario.getIdTrabajador();
			session.setAttribute("tipoTrabajador", datosTrabajador.getTipoTrabajador().getId());
			session.setAttribute("datosTrabajador", datosTrabajador);
			switch (datosTrabajador.getTipoTrabajador().getId()) {
			case 1:
				return "admin";
			case 2:
				return "comercial";
			case 3:
				return "mozoAlmacen";
			default:
				return "login";
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario o clave incorrecto", ""));
			return "login";
		}
	}

	public String logout() {
		HttpSession session = SessionUtil.getSession();
		session.invalidate();
		return "login";
	}

	public String perfil() {
		HttpSession session = SessionUtil.getSession();
		datosTrabajador = (Trabajador) session.getAttribute("datosTrabajador");
		return "perfil";
	}
}
