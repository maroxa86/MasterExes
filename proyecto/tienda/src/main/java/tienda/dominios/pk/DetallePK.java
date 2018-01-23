package tienda.dominios.pk;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import tienda.dominios.Factura;

@Embeddable
public class DetallePK implements Serializable{

	private static final long serialVersionUID = 3996350197824180546L;

	@Column(name="NUM_DETALLE")
	private Integer numDetalle;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="NUM_FACTURA", referencedColumnName="NUM_FACTURA")
	private Factura numFactura;
	
	public DetallePK() {
		super();
	}

	public DetallePK(Integer numDetalle, Factura numFactura) {
		super();
		this.numDetalle = numDetalle;
		this.numFactura = numFactura;
	}

	public Integer getNumDetalle() {
		return numDetalle;
	}

	public void setNumDetalle(Integer numDetalle) {
		this.numDetalle = numDetalle;
	}

	public Factura getNumFactura() {
		return numFactura;
	}

	public void setNumFactura(Factura numFactura) {
		this.numFactura = numFactura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numDetalle == null) ? 0 : numDetalle.hashCode());
		result = prime * result + ((numFactura == null) ? 0 : numFactura.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetallePK other = (DetallePK) obj;
		if (numDetalle == null) {
			if (other.numDetalle != null)
				return false;
		} else if (!numDetalle.equals(other.numDetalle))
			return false;
		if (numFactura == null) {
			if (other.numFactura != null)
				return false;
		} else if (!numFactura.equals(other.numFactura))
			return false;
		return true;
	}
}
