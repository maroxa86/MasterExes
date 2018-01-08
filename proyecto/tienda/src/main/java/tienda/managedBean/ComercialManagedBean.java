package tienda.managedBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.commons.lang3.StringUtils;

import tienda.dominios.Cliente;
import tienda.service.ClienteService;

@ManagedBean(name = "comercial")
@SessionScoped
public class ComercialManagedBean {

	@ManagedProperty("#{clienteService}")
	private ClienteService clienteService;
	
	@ManagedProperty("#{login}")
	private LoginManagedBean loginManagedBean;
	
	private List<Cliente> listadoClientes;
	private String nombre;
	private String cif;
	private String comision;
	
	public String clientes(){
		setListadoClientes(clienteService.getListadoClientes());
		return "clientes";
	}
	
	public String newCliente(){
		nombre = null;
		cif = null;
		comision = null;
		return "newCliente";
	}
	
	public void addCliente(){
		StringUtils.replace(comision, ",", ".");
		Cliente cliente = new Cliente(nombre, cif, Double.valueOf(comision.replace(",", ".")), loginManagedBean.getDatosTrabajador());
		clienteService.addCliente(cliente);
	}

	public List<Cliente> getListadoClientes() {
		return listadoClientes;
	}

	public void setListadoClientes(List<Cliente> listadoClientes) {
		this.listadoClientes = listadoClientes;
	}

	public ClienteService getClienteService() {
		return clienteService;
	}

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getComision() {
		return comision;
	}

	public void setComision(String comision) {
		this.comision = comision;
	}

	public LoginManagedBean getLoginManagedBean() {
		return loginManagedBean;
	}

	public void setLoginManagedBean(LoginManagedBean loginManagedBean) {
		this.loginManagedBean = loginManagedBean;
	}
	
}
