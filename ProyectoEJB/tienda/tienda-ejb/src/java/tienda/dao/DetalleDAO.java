package tienda.dao;

import javax.ejb.Local;
import tienda.dominios.Detalle;

@Local
public interface DetalleDAO extends GenericDAO<Detalle, Integer> {

}
