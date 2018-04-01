package tienda.dao.impl;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import tienda.dao.FacturaDAO;
import tienda.dominios.Factura;

@Stateless
public class FacturaDAOImpl extends AbstractGenericDAOImpl<Factura, Long> implements FacturaDAO {

    @Override
    @Transactional
    public List<Factura> getListadoFacturasByIdUsuario(int idUsuario) {
        TypedQuery<Factura> consulta = getManager().createNamedQuery("listadoFacturaByUsuario", Factura.class);
        consulta.setParameter("idTrabajador", idUsuario);
        return consulta.getResultList();
    }

    @Override
    public List<Factura> getListadoFacturaMensual(int idUsuario, Date fechaInicial, Date fechaFinal) {
        TypedQuery<Factura> consulta = getManager().createNamedQuery("listadoFacturaMensualByUsuario", Factura.class);
        consulta.setParameter("idTrabajador", idUsuario);
        consulta.setParameter("fechaInicio", fechaInicial);
        consulta.setParameter("fechaFin", fechaFinal);
        return consulta.getResultList();
    }

    @Override
    public List<Factura> getListadoFacturasPendientes() {
        TypedQuery<Factura> consulta = getManager().createNamedQuery("listadoFacturasPendientes", Factura.class);
        return consulta.getResultList();
    }

}
