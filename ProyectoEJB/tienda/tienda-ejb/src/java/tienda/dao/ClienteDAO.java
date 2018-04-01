package tienda.dao;

import javax.ejb.Local;
import tienda.dominios.Cliente;

@Local
public interface ClienteDAO extends GenericDAO<Cliente, Integer>{

}
