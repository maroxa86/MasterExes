package tienda.service;

import java.util.List;

import tienda.dominios.Detalle;
import tienda.dominios.Factura;

public interface FacturaService {
	void insertFactura(Factura factura);
	void insertFactura(Factura factura, List<Detalle> listadoDetalles);
	List<Factura> getListadoFacturaByIdUsuario(int idUsuario);
}
