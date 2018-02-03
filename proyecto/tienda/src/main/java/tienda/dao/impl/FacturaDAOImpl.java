package tienda.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tienda.dao.FacturaDAO;
import tienda.dominios.Factura;

@Repository
public class FacturaDAOImpl extends AbstractGenericDAOImpl<Factura, Long> implements FacturaDAO {

	@Override
	@Transactional(readOnly=true)
	public List<Factura> getListadoFacturasByIdUsuario(int idUsuario) {
        TypedQuery<Factura> consulta = getManager().createNamedQuery("listadoFacturaByUsuario", Factura.class);
        consulta.setParameter("idTrabajador", idUsuario);
        return consulta.getResultList();
	}

	@Override
	public List<Factura> getListadoFacturaMensual(int idUsuario) {
		TypedQuery<Factura> consulta = getManager().createNamedQuery("listadoFacturaMensualByUsuario", Factura.class);
        consulta.setParameter("idTrabajador", idUsuario);
        return consulta.getResultList();
	}

	@Override
	public List<Factura> getListadoFacturasPendientes() {
		TypedQuery<Factura> consulta = getManager().createNamedQuery("listadoFacturasPendientes", Factura.class);
        return consulta.getResultList();
	}
	
}
