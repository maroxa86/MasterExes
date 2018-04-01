package tienda.managedBean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.convert.BigDecimalConverter;
import javax.faces.model.SelectItem;

import org.apache.commons.lang3.StringUtils;

import tienda.dominios.Cliente;
import tienda.dominios.Detalle;
import tienda.dominios.Factura;
import tienda.dominios.Producto;
import tienda.service.ClienteService;
import tienda.service.FacturaService;
import tienda.service.ProductoService;

@ManagedBean(name = "comercial")
@SessionScoped
public class ComercialManagedBean implements Serializable {

    @EJB
    private ClienteService clienteService;

    @ManagedProperty("#{login}")
    private LoginManagedBean loginManagedBean;

    @EJB
    private ProductoService productoService;

    @EJB
    private FacturaService facturaService;

    private List<Cliente> listadoClientes;
    private List<SelectItem> listadoProductosSelectItem;
    private List<SelectItem> listadoClientesSelectItem;
    private String nombre;
    private String cif;
    private String comision;
    private Integer idProducto;
    private Integer idCliente;
    private int cantidad;
    private boolean disabledClienteSelect = false;
    private boolean renderProductoZone = false;
    private List<Detalle> listaDetalle;
    private Factura factura;
    private List<Factura> listadoFacturas;
    private Double sueldo;

    public String clientes() {
        setListadoClientes(clienteService.getListadoClientes());
        return "clientes";
    }

    public String newCliente() {
        nombre = null;
        cif = null;
        comision = null;
        return "crearCliente";
    }

    public void addCliente() {
        Short valor = Short.valueOf(Long.toString(Math.round(Double.valueOf(comision.replace(",", ".")))));
        Cliente cliente = new Cliente(nombre, cif, valor, loginManagedBean.getDatosTrabajador());
        clienteService.addCliente(cliente);
    }

    public String crearPedido() {
        loadListadoClientesSelectItem();
        loadListadoProductoSelectItem();
        return "crearPedido";
    }

    private void loadListadoProductoSelectItem() {
        List<Producto> listadoProductos = productoService.getListadoProductos();
        listadoProductosSelectItem = new ArrayList<>();
        for (Producto producto : listadoProductos) {
            listadoProductosSelectItem.add(new SelectItem(producto.getId(), producto.getNombre()));
        }
    }

    private void loadListadoClientesSelectItem() {
        List<Cliente> listadoClientes = clienteService.getListadoClientes();
        listadoClientesSelectItem = new ArrayList<>();
        for (Cliente cliente : listadoClientes) {
            listadoClientesSelectItem.add(new SelectItem(cliente.getId(), cliente.getNombre()));
        }
    }

    public void onChangeCliente() {
        disabledClienteSelect = true;
        renderProductoZone = true;
    }

    public void agregar() {
        if (listaDetalle == null) {
            listaDetalle = new ArrayList<>();
        }

        Cliente cliente = clienteService.getClienteById(idCliente);
        if (factura == null) {
            factura = new Factura(cliente, new Date(), null);
        }

        Producto producto = productoService.getProducto(idProducto);

        Detalle detalle = new Detalle(listaDetalle.size() + 1, null, producto, cantidad, producto.getPrecio());

        listaDetalle.add(detalle);

    }

    public void registrarFactura() {
        if (factura != null) {
            facturaService.insertFactura(factura, listaDetalle);
            factura = null;
        }
    }

    public String pedidos() {
        this.setListadoFacturas(facturaService.getListadoFacturaByIdUsuario(loginManagedBean.getDatosTrabajador().getId()));
        return "pedidos";
    }

    public String consultarSueldo() {
        sueldo = new Double(0);
        this.setListadoFacturas(facturaService.getListadoPedidosMensual(loginManagedBean.getDatosTrabajador().getId()));

        for (Factura factura : this.getListadoFacturas()) {
            sueldo += factura.getBeneficioFactura();
        }
        return "sueldo";
    }

    public List<Cliente> getListadoClientes() {
        return listadoClientes;
    }

    public void setListadoClientes(List<Cliente> listadoClientes) {
        this.listadoClientes = listadoClientes;
    }

    public ClienteService getClienteService() {
        return clienteService;
    }

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getComision() {
        return comision;
    }

    public void setComision(String comision) {
        this.comision = comision;
    }

    public LoginManagedBean getLoginManagedBean() {
        return loginManagedBean;
    }

    public void setLoginManagedBean(LoginManagedBean loginManagedBean) {
        this.loginManagedBean = loginManagedBean;
    }

    public ProductoService getProductoService() {
        return productoService;
    }

    public void setProductoService(ProductoService productoService) {
        this.productoService = productoService;
    }

    public List<SelectItem> getListadoProductosSelectItem() {
        return listadoProductosSelectItem;
    }

    public void setListadoProductosSelectItem(List<SelectItem> listadoProductosSelectItem) {
        this.listadoProductosSelectItem = listadoProductosSelectItem;
    }

    public List<SelectItem> getListadoClientesSelectItem() {
        return listadoClientesSelectItem;
    }

    public void setListadoClientesSelectItem(List<SelectItem> listadoClientesSelectItem) {
        this.listadoClientesSelectItem = listadoClientesSelectItem;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdCliente() {
        System.out.println("get");
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        System.out.println("set");
        this.idCliente = idCliente;
    }

    public boolean isDisabledClienteSelect() {
        return disabledClienteSelect;
    }

    public void setDisabledClienteSelect(boolean disabledClienteSelect) {
        this.disabledClienteSelect = disabledClienteSelect;
    }

    public boolean isRenderProductoZone() {
        return renderProductoZone;
    }

    public void setRenderProductoZone(boolean renderProductoZone) {
        this.renderProductoZone = renderProductoZone;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public List<Detalle> getListaDetalle() {
        return listaDetalle;
    }

    public void setListaDetalle(List<Detalle> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }

    public FacturaService getFacturaService() {
        return facturaService;
    }

    public void setFacturaService(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public List<Factura> getListadoFacturas() {
        return listadoFacturas;
    }

    public void setListadoFacturas(List<Factura> listadoFacturas) {
        this.listadoFacturas = listadoFacturas;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

}
