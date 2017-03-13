/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Local;
import modelo.InsertarTres;

/**
 *
 * @author Xavi
 */
@Local
public interface InsertarTresDAO {

    void insertarTres(InsertarTres primerEntero, InsertarTres segundoEntero, InsertarTres tercerEntero);

    void insertar(InsertarTres entero);
    
}
