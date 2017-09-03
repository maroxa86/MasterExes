/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xavier.roig.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Xavi
 */
@Entity
@Table(name = "REPRESENTANTE")
public class Representante implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RepresentantePK representantePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COMISION")
    private BigDecimal comision;
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "ID_TRABAJADOR", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Trabajador trabajador;

    public Representante() {
    }

    public Representante(RepresentantePK representantePK) {
        this.representantePK = representantePK;
    }

    public Representante(int idTrabajador, int idCliente) {
        this.representantePK = new RepresentantePK(idTrabajador, idCliente);
    }

    public RepresentantePK getRepresentantePK() {
        return representantePK;
    }

    public void setRepresentantePK(RepresentantePK representantePK) {
        this.representantePK = representantePK;
    }

    public BigDecimal getComision() {
        return comision;
    }

    public void setComision(BigDecimal comision) {
        this.comision = comision;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
        hash += (representantePK != null ? representantePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Representante)) {
            return false;
        }
        Representante other = (Representante) object;
        if ((this.representantePK == null && other.representantePK != null) || (this.representantePK != null && !this.representantePK.equals(other.representantePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "xavier.roig.login.model.Representante[ representantePK=" + representantePK + " ]";
    }
    
}
