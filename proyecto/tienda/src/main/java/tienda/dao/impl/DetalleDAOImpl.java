package tienda.dao.impl;

import org.springframework.stereotype.Repository;

import tienda.dao.DetalleDAO;
import tienda.dominios.Detalle;
import tienda.dominios.pk.DetallePK;

@Repository
public class DetalleDAOImpl extends AbstractGenericDAOImpl<Detalle, DetallePK> implements DetalleDAO {

}
