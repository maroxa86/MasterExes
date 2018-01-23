package tienda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tienda.dao.ClienteDAO;
import tienda.dominios.Cliente;
import tienda.service.ClienteService;

@Service(value="clienteService")
public class ClienteServiceImpl implements ClienteService {

	private ClienteDAO clienteDAO;
	
	@Override
	public List<Cliente> getListadoClientes() {
		return clienteDAO.buscarTodos();
	}

	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	@Autowired
	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	@Override
	@Transactional
	public void addCliente(Cliente cliente) {
		clienteDAO.insertar(cliente);
	}

	@Override
	public Cliente getClienteById(Integer idCliente) {
		return clienteDAO.buscarPorClave(idCliente);
	}
}
