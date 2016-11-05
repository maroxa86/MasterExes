/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xavi
 */
public class Menu {
    private List<Plato> primerosPlatos;
    private List<Plato> segundosPlatos;
    private List<Plato> postres;
    
    public Menu(){
        super();
        primerosPlatos = new ArrayList<>();
        segundosPlatos = new ArrayList<>();
        postres = new ArrayList<>();
    }

    public List<Plato> getPrimerosPlatos() {
        return primerosPlatos;
    }

    public void setPrimerosPlatos(List<Plato> primerosPlatos) {
        this.primerosPlatos = primerosPlatos;
    }

    public List<Plato> getSegundosPlatos() {
        return segundosPlatos;
    }

    public void setSegundosPlatos(List<Plato> segundosPlatos) {
        this.segundosPlatos = segundosPlatos;
    }

    public List<Plato> getPostres() {
        return postres;
    }

    public void setPostres(List<Plato> postres) {
        this.postres = postres;
    }
    
    public void addPrimerPlato(Plato plato){
        primerosPlatos.add(plato);
    }
    
    public void addSegundoPlato(Plato plato){
        segundosPlatos.add(plato);
    }
    
    public void addPostre(Plato plato){
        postres.add(plato);
    }
    
    @Override
    public String toString(){
        StringBuilder menu = new StringBuilder();
        
        menu.append("El menú consta de los siguientes platos. \n");
        menu.append(primerosPlatos());
        menu.append(segundoPlatos());
        menu.append(postres());
        
        return menu.toString();
    }
    
    public String primerosPlatos(){
        StringBuilder primeros = new StringBuilder();
        primeros.append("Primeros platos: \n");
        for(Plato plato : primerosPlatos){
            primeros = datosPlato(plato);
        }
        return primeros.toString();
    }
    
    public String segundoPlatos(){
        StringBuilder segundos = new StringBuilder();
        segundos.append("\nLos segundos platos son:\n");
        for(Plato plato : segundosPlatos){
            segundos = datosPlato(plato);
        }
        return segundos.toString();
    }
    
    public String postres(){
        StringBuilder postresString = new StringBuilder();
        postresString.append("\nLos postres son:\n");
        for(Plato plato : postres){
            postresString = datosPlato(plato);
        }
        return postresString.toString();
    }

    private StringBuilder datosPlato(Plato plato) {
        StringBuilder datos = new StringBuilder();
        datos.append(plato.getIdPlato());
        datos.append("- ");
        datos.append(plato.getNombrePlato());
        datos.append("\t ");
        datos.append(plato.getPrecio());
        datos.append(" €");
        return datos;
    }
}
