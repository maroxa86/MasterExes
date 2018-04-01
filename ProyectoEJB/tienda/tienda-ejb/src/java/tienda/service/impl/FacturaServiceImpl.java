package tienda.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import tienda.dao.DetalleDAO;
import tienda.dao.FacturaDAO;
import tienda.dao.ProductoDAO;
import tienda.dominios.Detalle;
import tienda.dominios.Factura;
import tienda.dominios.Producto;
import tienda.service.FacturaService;

@Stateless
public class FacturaServiceImpl implements FacturaService {

    @EJB
    private FacturaDAO facturaDAO;

    @EJB
    private DetalleDAO detalleDAO;

    @EJB
    private ProductoDAO productoDAO;

    @Override
    @Transactional
    public void insertFactura(Factura factura, List<Detalle> listadoDetalles) {
        facturaDAO.insertar(factura);
        for (Detalle detalle : listadoDetalles) {
            detalle.setFactura(factura);
            detalleDAO.insertar(detalle);
        }
    }

    @Override
    public List<Factura> getListadoFacturaByIdUsuario(int idUsuario) {
        List<Factura> listadoFacturas = facturaDAO.getListadoFacturasByIdUsuario(idUsuario);
        for (Factura factura : listadoFacturas) {
            double totalFactura = 0;
            for (Detalle detalle : factura.getListadoDetalles()) {
                totalFactura += detalle.getCantidad() * detalle.getPrecio();
            }

            factura.setTotalFactura(totalFactura);
        }
        return listadoFacturas;
    }

    public FacturaDAO getFacturaDAO() {
        return facturaDAO;
    }

    public void setFacturaDAO(FacturaDAO facturaDAO) {
        this.facturaDAO = facturaDAO;
    }

    public DetalleDAO getDetalleDAO() {
        return detalleDAO;
    }

    public void setDetalleDAO(DetalleDAO detalleDAO) {
        this.detalleDAO = detalleDAO;
    }

    @Override
    @Transactional
    public void insertFactura(Factura factura) {
        facturaDAO.insertar(factura);

    }

    @Override
    public List<Factura> getListadoPedidosMensual(int idUsuario) {
        List<Factura> listadoFacturas = new ArrayList();
        try {
            listadoFacturas = facturaDAO.getListadoFacturaMensual(idUsuario, fechaInicio(), fechaFin());

            for (Factura factura : listadoFacturas) {
                double totalFactura = 0;
                for (Detalle detalle : factura.getListadoDetalles()) {
                    totalFactura += detalle.getCantidad() * detalle.getPrecio();
                }
                factura.setTotalFactura(totalFactura);
            }

        } catch (ParseException ex) {
            Logger.getLogger(FacturaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listadoFacturas;
    }

    private Date fechaInicio() throws ParseException {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        cal.set(Calendar.DAY_OF_MONTH, 1);
         Date fechaInicio = cal.getTime();
        
        return sdf.parse(sdf.format(fechaInicio));
    }
    
    private Date fechaFin() throws ParseException {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date fechaFin = cal.getTime();
        
        return sdf.parse(sdf.format(fechaFin));
    }

    @Override
    public List<Factura> getListadoFacturasPendientes() {
        return facturaDAO.getListadoFacturasPendientes();
    }

    @Override
    public Factura getFacturaById(Long numFactura) {
        return facturaDAO.buscarPorClave(numFactura);
    }

    @Override
    @Transactional
    public void finalizarFactura(Factura factura) {
        for (Detalle detalle : factura.getListadoDetalles()) {
            Producto producto = detalle.getProducto();
            producto.setStock(producto.getStock() - detalle.getCantidad());
            productoDAO.salvar(producto);
        }
        factura.setProcesado(1);
        factura.setFechaProcesado(new Date());
        facturaDAO.salvar(factura);
    }

    public ProductoDAO getProductoDAO() {
        return productoDAO;
    }

    public void setProductoDAO(ProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }

}
