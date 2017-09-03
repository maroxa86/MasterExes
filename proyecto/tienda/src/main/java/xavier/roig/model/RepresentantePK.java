/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xavier.roig.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Xavi
 */
@Embeddable
public class RepresentantePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TRABAJADOR")
    private int idTrabajador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CLIENTE")
    private int idCliente;

    public RepresentantePK() {
    }

    public RepresentantePK(int idTrabajador, int idCliente) {
        this.idTrabajador = idTrabajador;
        this.idCliente = idCliente;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTrabajador;
        hash += (int) idCliente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RepresentantePK)) {
            return false;
        }
        RepresentantePK other = (RepresentantePK) object;
        if (this.idTrabajador != other.idTrabajador) {
            return false;
        }
        if (this.idCliente != other.idCliente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "xavier.roig.login.model.RepresentantePK[ idTrabajador=" + idTrabajador + ", idCliente=" + idCliente + " ]";
    }
    
}
