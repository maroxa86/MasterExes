package tienda.dao.impl;

import org.springframework.stereotype.Repository;

import tienda.dao.TrabajadorDAO;
import tienda.dominios.Trabajador;

@Repository
public class TrabajadorDAOImpl extends AbstractGenericDAOImpl<Trabajador, Integer> implements TrabajadorDAO {
}
