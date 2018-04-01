package tienda.service;

import java.util.List;
import javax.ejb.Local;

import tienda.dominios.Detalle;
import tienda.dominios.Factura;

@Local
public interface FacturaService {
	void insertFactura(Factura factura);
	void insertFactura(Factura factura, List<Detalle> listadoDetalles);
	List<Factura> getListadoFacturaByIdUsuario(int idUsuario);
	List<Factura> getListadoPedidosMensual(int idUsuario);
	List<Factura> getListadoFacturasPendientes();
	Factura getFacturaById(Long numFactura);
	void finalizarFactura(Factura factura);
}
