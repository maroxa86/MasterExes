/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Repository;

import ejercicios.dao.PersonaDAO;
import ejercicios.modelo.Persona;

/**
 *
 * @author Xavi
 */
@Repository
public class PersonaDAOImpl implements PersonaDAO{

    private static final Map<String, Persona> listadoPersonas;
    
    static{
    	listadoPersonas = new TreeMap<>();
    	Persona persona = new Persona();
    	persona.setDni("57070114F");
    	persona.setNombre("Persona1");
    	persona.setApellidos("Apellidos1");
    	persona.setEmail("persona@persoan.com");
    	persona.setFechaNacimiento(new Date());
    	persona.setTelefono(987654321);
    	
    	listadoPersonas.put(persona.getDni(), persona);
    }
    
    public PersonaDAOImpl(){
    }
    
    @Override
    public Persona getPersona(String dni) {
        return listadoPersonas.get(dni);
    }

    @Override
    public List<Persona> getListadoPersona() {
        List<Persona> personas = new ArrayList<>(listadoPersonas.values());
        return personas;
    }

    @Override
    public void nuevaPersona(Persona persona) {
        listadoPersonas.put(persona.getDni(), persona);
    }

    @Override
    public void editarPersona(Persona persona) {
        Persona per = listadoPersonas.get(persona.getDni());
        per.setNombre(persona.getNombre());
        per.setApellidos(persona.getApellidos());
        per.setEmail(persona.getEmail());
        per.setTelefono(persona.getTelefono());
        per.setFechaNacimiento(persona.getFechaNacimiento());
    }

    @Override
    public void borrarPersona(String dni) {
        listadoPersonas.remove(dni);
    }
    
}