package tienda.dao;

import javax.ejb.Local;
import tienda.dominios.Trabajador;

@Local
public interface TrabajadorDAO extends GenericDAO<Trabajador, Integer> {

}
