package tienda.dao.impl;

import org.springframework.stereotype.Repository;

import tienda.dao.FacturaDAO;
import tienda.dominios.Factura;

@Repository
public class FacturaDAOImpl extends AbstractGenericDAOImpl<Factura, Long> implements FacturaDAO {
	
}
