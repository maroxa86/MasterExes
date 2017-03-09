/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Nombres;
import dao.NombresDAO;

/**
 *
 * @author Xavi
 */
@Stateless
public class NombresService implements NombresServiceLocal {

    @EJB
    private NombresDAO nombresDAO;

    @Override
    public List<Nombres> listadoNombres() {
        return nombresDAO.nombresList();
    }

    @Override
    public void saveNombre(Nombres nombre) {
        nombresDAO.saveNombres(nombre);
    }

    @Override
    public Nombres getNombre(long idNombre) {
        return nombresDAO.getNombres(idNombre);
    }

    @Override
    public void deleteNombre(long idNombre) {
        Nombres nombre = this.getNombre(idNombre);
        nombresDAO.deleteNombres(nombre);
    }

}
