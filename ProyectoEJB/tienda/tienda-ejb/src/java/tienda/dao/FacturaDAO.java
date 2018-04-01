package tienda.dao;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;

import tienda.dominios.Factura;

@Local
public interface FacturaDAO extends GenericDAO<Factura, Long>{

	List<Factura> getListadoFacturasByIdUsuario(int idUsuario);

	List<Factura> getListadoFacturaMensual(int idUsuario, Date fechaInicial, Date fechaFinal);

	List<Factura> getListadoFacturasPendientes();

}
