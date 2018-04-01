/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.utils;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Xavi
 */
@ManagedBean(name="constantes")
@ApplicationScoped
public class Constantes {
    private Integer admin = 1;
    private Integer comercial = 2;
    private Integer mozoAlmacen = 3;    

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    public Integer getComercial() {
        return comercial;
    }

    public void setComercial(Integer comercial) {
        this.comercial = comercial;
    }

    public Integer getMozoAlmacen() {
        return mozoAlmacen;
    }

    public void setMozoAlmacen(Integer mozoAlmacen) {
        this.mozoAlmacen = mozoAlmacen;
    }
    
    
}
