package tienda.managedBean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import tienda.dominios.TipoTrabajador;
import tienda.service.TipoTrabajadorService;

@ManagedBean(name = "usuario")
@RequestScoped
public class UsuarioManagedBean {

	private String user;
	private String pwd;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private List<TipoTrabajador> tipoTrabajadorList;
	private TipoTrabajador tipoTrabajador;
	
	@ManagedProperty("#{tipoTrabajadorService}")
	private TipoTrabajadorService tipoTrabajadorService;
	
	@PostConstruct
	public void init() {
		tipoTrabajadorList = tipoTrabajadorService.getListadoTipoTrabajador();
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public List<TipoTrabajador> getTipoTrabajadorList() {
		return tipoTrabajadorList;
	}

	public void setTipoTrabajadorList(List<TipoTrabajador> tipoTrabajadorList) {
		this.tipoTrabajadorList = tipoTrabajadorList;
	}

	public TipoTrabajadorService getTipoTrabajadorService() {
		return tipoTrabajadorService;
	}

	public void setTipoTrabajadorService(TipoTrabajadorService tipoTrabajadorService) {
		this.tipoTrabajadorService = tipoTrabajadorService;
	}

	public TipoTrabajador getTipoTrabajador() {
		return tipoTrabajador;
	}

	public void setTipoTrabajador(TipoTrabajador tipoTrabajador) {
		this.tipoTrabajador = tipoTrabajador;
	}
	
	
}
