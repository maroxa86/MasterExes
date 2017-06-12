/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.dao;

import java.util.List;
import ejercicios.modelo.Persona;

/**
 *
 * @author Xavi
 */
public interface PersonaDAO {
    
    public Persona getPersona(String dni);
    public List<Persona> getListadoPersona();
    public void nuevaPersona(Persona persona);
    public void editarPersona(Persona persona);
    public void borrarPersona(String dni);
       
}
