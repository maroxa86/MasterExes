package tienda.service.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import tienda.dao.ClienteDAO;
import tienda.dominios.Cliente;
import tienda.service.ClienteService;

@Stateless
public class ClienteServiceImpl implements ClienteService {

    @EJB
    private ClienteDAO clienteDAO;

    @Override
    public List<Cliente> getListadoClientes() {
        return clienteDAO.buscarTodos();
    }

    public ClienteDAO getClienteDAO() {
        return clienteDAO;
    }

    public void setClienteDAO(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public void addCliente(Cliente cliente) {
        clienteDAO.insertar(cliente);
    }

    @Override
    public Cliente getClienteById(Integer idCliente) {
        return clienteDAO.buscarPorClave(idCliente);
    }
}
