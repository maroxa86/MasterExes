/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.managedBeans;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import ejercicios.modelo.Persona;
import ejercicios.services.PersonaService;

/**
 *
 * @author Xavi
 */
@Named(value="personaManagedBean")
@RequestScoped
public class PersonaManagedBean {

    @Autowired
    private PersonaService personsaService;

    private int id;
    private String dni;
    private String nombre;
    private String apellidos;
    private int telefono;
    private Date fechaNacimiento;
    private String email;
    private List<Persona> listadoPersonas;
    private UIComponent nuevaPersonaBoton;
    
    public PersonaManagedBean() {
        super();
    }

    public void getPersona(String dni){
    	Persona persona = personsaService.getPersona(dni);
    	setearValoresPersona(persona);
    }
    
    private void setearValoresPersona(Persona persona) {
		setDni(persona.getDni());
		setNombre(persona.getNombre());
		setApellidos(persona.getApellidos());
		setFechaNacimiento(persona.getFechaNacimiento());
		setTelefono(persona.getTelefono());
		setEmail(persona.getEmail());
		
	}

	public String nuevaPersona(){
		Persona persona = personsaService.getPersona(dni);
		if(persona == null){
			personsaService.nuevaPersona(datosPersona());
			return "agenda.xhtml";
		}
		else{
			FacesMessage message = new FacesMessage("Ya existe una persona con ese DNI");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(nuevaPersonaBoton.getClientId(context), message);
			return "nuevaPersona.xhtml";
		}
    }
    
	public String editarPersona(String dni){
		getPersona(dni);
		return "editarPersona.xhtml";
	}
	
    public String guardarPersona(){
        personsaService.editarPersona(datosPersona());
        return "agenda.xhtml";
    }
    
    private Persona datosPersona(){
        Persona persona = new Persona();
        persona.setDni(dni);
        persona.setNombre(nombre);
        persona.setApellidos(apellidos);
        persona.setFechaNacimiento(fechaNacimiento);
        persona.setEmail(email);
        persona.setTelefono(telefono);
        
        return persona;
    }
    
    public String borrarPersona(String dni){
        personsaService.borrarPersona(dni);
        return "agenda.xhtml";
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Persona> getListadoPersonas() {
    	listadoPersonas = personsaService.getListadoPersona();
    	return listadoPersonas;
    }

    public void setListadoPersonas(List<Persona> listadoPersonas) {
        this.listadoPersonas = listadoPersonas;
    }

    public PersonaService getPersonsaService() {
        return personsaService;
    }

    public void setPersonsaService(PersonaService personsaService) {
        this.personsaService = personsaService;
    }
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public UIComponent getNuevaPersonaBoton() {
		return nuevaPersonaBoton;
	}

	public void setNuevaPersonaBoton(UIComponent nuevaPersonaBoton) {
		this.nuevaPersonaBoton = nuevaPersonaBoton;
	}
    
}
