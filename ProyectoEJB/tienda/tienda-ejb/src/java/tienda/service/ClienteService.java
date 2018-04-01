package tienda.service;

import java.util.List;
import javax.ejb.Local;

import tienda.dominios.Cliente;

@Local
public interface ClienteService {

	List<Cliente> getListadoClientes();
	void addCliente(Cliente cliente);
	Cliente getClienteById(Integer idCliente);
}
