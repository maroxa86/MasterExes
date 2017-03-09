/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Local;
import modelo.Nombres;

/**
 *
 * @author Xavi
 */
@Local
public interface NombresDAO {
    
    public List<Nombres> nombresList();
    public void saveNombres(Nombres nombre);
    public Nombres getNombres(long idNombre);
    public void deleteNombres(Nombres nombre);
    
}
