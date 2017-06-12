/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejercicios.dao.PersonaDAO;
import ejercicios.modelo.Persona;
import ejercicios.services.PersonaService;

/**
 *
 * @author Xavi
 */
@Service(value="personaService")
public class PersonaServiceImpl implements PersonaService{
    
    private PersonaDAO personaDAO;

    public PersonaDAO getPersonaDAO() {
        return personaDAO;
    }
      
    @Autowired
    public void setPersonaDAO(PersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }

    @Override
    public Persona getPersona(String dni){
        return personaDAO.getPersona(dni);
    }

    @Override
    public List<Persona> getListadoPersona() {
        return personaDAO.getListadoPersona();
    }

    @Override
    public void nuevaPersona(Persona persona) {
        personaDAO.nuevaPersona(persona);
    }

    @Override
    public void editarPersona(Persona persona) {
        personaDAO.editarPersona(persona);
    }

    @Override
    public void borrarPersona(String dni) {
        personaDAO.borrarPersona(dni);
    }
}