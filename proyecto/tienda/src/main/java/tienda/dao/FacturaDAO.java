package tienda.dao;

import java.util.List;

import tienda.dominios.Factura;

public interface FacturaDAO extends GenericDAO<Factura, Long>{

	List<Factura> getListadoFacturasByIdUsuario(int idUsuario);

	List<Factura> getListadoFacturaMensual(int idUsuario);

}
