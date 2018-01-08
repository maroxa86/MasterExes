package tienda.dao.impl;

import org.springframework.stereotype.Repository;

import tienda.dao.ClienteDAO;
import tienda.dominios.Cliente;

@Repository
public class ClienteDAOImpl extends AbstractGenericDAOImpl<Cliente, Integer> implements ClienteDAO {
}
