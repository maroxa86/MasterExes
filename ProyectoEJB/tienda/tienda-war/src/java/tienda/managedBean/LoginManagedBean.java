package tienda.managedBean;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tienda.dominios.Trabajador;
import tienda.dominios.Usuario;
import tienda.service.LoginService;

@ManagedBean(name = "login")
@SessionScoped
public class LoginManagedBean implements Serializable{

    public static final String ADMIN_PAGE_REDIRECT = "admin";
    public static final String COMERCIAL_PAGE_REDIRECT = "comercial";
    public static final String MOZO_PAGE_REDIRECT = "mozoAlmacen";
    public static final String LOGIN_PAGE_REDIRECT = "/login.xhtml?faces-redirect=true";
    public static final String LOGOUT_PAGE_REDIRECT = "/logout.xhtml?faces-redirect=true";
    
    @EJB
    private LoginService loginServiceImpl;

    private String user;
    private String pwd;
    private Trabajador datosTrabajador;
    private Usuario usuario;
    
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
    
    public String login(){
        usuario = loginServiceImpl.login(user, pwd);
        
        if(usuario != null){
            datosTrabajador = usuario.getIdTrabajador();
            return seleccionPaginaUsuario();
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario o clave incorrecto", ""));
            return LOGIN_PAGE_REDIRECT;
        }
    }
    
    private String seleccionPaginaUsuario(){
        switch (datosTrabajador.getTipoTrabajador().getId()) {
            case 1:
                return ADMIN_PAGE_REDIRECT;
            case 2:
                return COMERCIAL_PAGE_REDIRECT;
            case 3:
                return MOZO_PAGE_REDIRECT;
            default:
                return LOGIN_PAGE_REDIRECT;
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return LOGOUT_PAGE_REDIRECT;
    }

    public boolean isLoggedIn(){
        return usuario != null;
    }
    
    public String isLoggedForward(){
        if(isLoggedIn()){
            return seleccionPaginaUsuario();
        }
        return null;
    }
    
    public String perfil() {
        return "perfil";
    }
}
