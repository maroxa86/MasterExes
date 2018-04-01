package tienda.dao.impl;

import javax.ejb.Stateless;
import tienda.dao.TrabajadorDAO;
import tienda.dominios.Trabajador;

@Stateless
public class TrabajadorDAOImpl extends AbstractGenericDAOImpl<Trabajador, Integer> implements TrabajadorDAO {
}
