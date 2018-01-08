package tienda.service;

import java.util.List;

import tienda.dominios.Cliente;

public interface ClienteService {

	List<Cliente> getListadoClientes();
	void addCliente(Cliente cliente);
}
