package tienda.service.impl;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import tienda.dao.ProductoDAO;
import tienda.dominios.Producto;
import tienda.service.ProductoService;

@Stateless
public class ProductoServiceImpl implements ProductoService {
    
    @EJB
    private ProductoDAO productoDAO;

    public ProductoDAO getProductoDAO() {
        return productoDAO;
    }

    public void setProductoDAO(ProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }

    public List<Producto> getListadoProductos() {
        return productoDAO.buscarTodos();
    }

    @Override
    @Transactional
    public void addProducto(Producto producto) {
        productoDAO.insertar(producto);
    }

    @Override
    public Producto getProducto(int id) {
        return productoDAO.buscarPorClave(id);
    }

    @Override
    @Transactional
    public void saveProducto(Producto producto) {
        productoDAO.salvar(producto);
    }

    @Override
    @Transactional
    public void cambioPrecio(int idProducto, BigDecimal nuevoPrecio) {

    }

    @Override
    @Transactional
    public void augmentarStock(int idProducto, int nuevoStock) {

    }

    @Override
    public void restarStock(int idProducito, int restaProducto) {

    }

    @Override
    public List<Producto> cantidadStockProductos() {
        return productoDAO.cantidadStockProductos();
    }

}
