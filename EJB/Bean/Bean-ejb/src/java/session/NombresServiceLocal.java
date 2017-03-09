/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.List;
import javax.ejb.Local;
import modelo.Nombres;

/**
 *
 * @author Xavi
 */
@Local
public interface NombresServiceLocal {

    public List<Nombres> listadoNombres();

    public void saveNombre(Nombres nombre);

    public Nombres getNombre(long idNombre);

    void deleteNombre(long idNombre);
    
}
