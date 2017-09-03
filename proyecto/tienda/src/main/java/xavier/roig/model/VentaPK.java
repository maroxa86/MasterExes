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
public class VentaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TRABAJADOR")
    private int idTrabajador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PRODUCTO")
    private int idProducto;

    public VentaPK() {
    }

    public VentaPK(int idTrabajador, int idProducto) {
        this.idTrabajador = idTrabajador;
        this.idProducto = idProducto;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTrabajador;
        hash += (int) idProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaPK)) {
            return false;
        }
        VentaPK other = (VentaPK) object;
        if (this.idTrabajador != other.idTrabajador) {
            return false;
        }
        if (this.idProducto != other.idProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "xavier.roig.login.model.VentaPK[ idTrabajador=" + idTrabajador + ", idProducto=" + idProducto + " ]";
    }
    
}
