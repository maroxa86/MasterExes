package tienda.dao.impl;

import javax.ejb.Stateless;

import tienda.dao.ClienteDAO;
import tienda.dominios.Cliente;

@Stateless
public class ClienteDAOImpl extends AbstractGenericDAOImpl<Cliente, Integer> implements ClienteDAO {
}
