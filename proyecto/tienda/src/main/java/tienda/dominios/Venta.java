package tienda.dominios;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import tienda.dominios.pk.VentaPK;

/**
 *
 * @author Xavi
 */
@Entity
@Table(name = "VENTA")
public class Venta implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected VentaPK ventaPK;
	@Basic(optional = false)
	@NotNull
	@Column(name = "CANTIDAD")
	private int cantidad;
	@Basic(optional = false)
	@NotNull
	@Column(name = "FECHA_VENTA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaVenta;
	@JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Producto producto;
	@JoinColumn(name = "ID_TRABAJADOR", referencedColumnName = "ID", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Trabajador trabajador;

	public Venta() {
	}

	public Venta(VentaPK ventaPK) {
		this.ventaPK = ventaPK;
	}

	public Venta(VentaPK ventaPK, int cantidad, Date fechaVenta) {
		this.ventaPK = ventaPK;
		this.cantidad = cantidad;
		this.fechaVenta = fechaVenta;
	}

	public Venta(int idTrabajador, int idProducto) {
		this.ventaPK = new VentaPK(idTrabajador, idProducto);
	}

	public VentaPK getVentaPK() {
		return ventaPK;
	}

	public void setVentaPK(VentaPK ventaPK) {
		this.ventaPK = ventaPK;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ventaPK != null ? ventaPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Venta)) {
			return false;
		}
		Venta other = (Venta) object;
		if ((this.ventaPK == null && other.ventaPK != null)
				|| (this.ventaPK != null && !this.ventaPK.equals(other.ventaPK))) {
			return false;
		}
		return true;
	}

	@Override
    public String toString() {
        return "xavier.roig.login.model.Venta[ ventaPK=" + ventaPK + " ]";
    }
}