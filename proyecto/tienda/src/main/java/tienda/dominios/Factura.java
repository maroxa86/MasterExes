package tienda.dominios;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Factura")
@NamedQueries({
	@NamedQuery(name="listadoFacturaByUsuario", query="SELECT factura "
														+ "FROM Factura factura "
														+ "INNER JOIN factura.IdCliente cliente "
														+ "WHERE cliente.trabajador.id = :idTrabajador"),
	@NamedQuery(name="listadoFacturaMensualByUsuario", query="SELECT factura "
																+ "FROM Factura factura "
																+ "INNER JOIN factura.IdCliente cliente "
																+ "WHERE cliente.trabajador.id = :idTrabajador "
																+ "AND factura.fechaFactura BETWEEN trunc(sysdate,'month') "
																+ "AND last_day(sysdate) AND factura.procesado = 1"
																),
	@NamedQuery(name="listadoFacturasPendientes", query="SELECT factura "
															+ "FROM Factura factura "
															+ "WHERE factura.procesado = 0")
	
})
public class Factura implements Serializable{

	private static final long serialVersionUID = 6590902736659221877L;

	@Id
	@Column(name="NUM_FACTURA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FACTURA_SEQ")
    @SequenceGenerator(sequenceName = "FACTURA_SEQ", allocationSize = 1, name = "FACTURA_SEQ")
	private Long numFactura;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE", referencedColumnName="ID")
	private Cliente IdCliente;
	
	@Column(name="FECHA_FACTURA")
	@NotNull
	private Date fechaFactura;
	
	@OneToMany(mappedBy="factura", fetch=FetchType.EAGER)
	private List<Detalle> listadoDetalles;
	
	@Column(name="PROCESADO")
	private Integer procesado;
	
	@Transient
	private Double totalFactura;
	
	@Transient
	private Double beneficioFactura;
	
	@Transient
	private boolean finalizar;
	
	public Factura() {
		super();
	}

	public Factura(Cliente idCliente, Date fechaFactura, List<Detalle> listadoDetalles) {
		super();
		IdCliente = idCliente;
		this.fechaFactura = fechaFactura;
		this.listadoDetalles = listadoDetalles;
	}

	public Factura(Long numFactura, Cliente idCliente, Date fechaFactura) {
		super();
		this.numFactura = numFactura;
		IdCliente = idCliente;
		this.fechaFactura = fechaFactura;
	}

	public Long getNumFactura() {
		return numFactura;
	}

	public void setNumFactura(Long numFactura) {
		this.numFactura = numFactura;
	}

	public Cliente getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		IdCliente = idCliente;
	}

	public Date getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public List<Detalle> getListadoDetalles() {
		return listadoDetalles;
	}

	public void setListadoDetalles(List<Detalle> listadoDetalles) {
		this.listadoDetalles = listadoDetalles;
	}	

	public Integer getProcesado() {
		return procesado;
	}

	public void setProcesado(Integer procesado) {
		this.procesado = procesado;
	}

	public Double getTotalFactura() {
		return totalFactura;
	}

	public void setTotalFactura(Double totalFactura) {
		this.totalFactura = totalFactura;
	}

	public Double getBeneficioFactura() { 
		return ((this.getTotalFactura() * this.getIdCliente().getComision()) /100);
	}

	public void setBeneficioFactura(Double beneficioFactura) {
		this.beneficioFactura = beneficioFactura;
	}

	public boolean isFinalizar() {
		for(Detalle detalle : this.listadoDetalles){
			if(!detalle.isHayStock()){
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Factura other = (Factura) obj;
		if (numFactura == null) {
			if (other.numFactura != null)
				return false;
		} else if (!numFactura.equals(other.numFactura))
			return false;
		return true;
	}
	
	
}
