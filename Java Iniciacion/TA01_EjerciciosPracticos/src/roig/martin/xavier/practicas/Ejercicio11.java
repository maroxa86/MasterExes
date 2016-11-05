/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roig.martin.xavier.practicas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xavi
 */
public class Ejercicio11 {
    
    public static void main(String[] args){
        List<Libro> listaLibros = new ArrayList<>();
        
        Libro libro1 = new Libro("Primer Libro", "Autor del Libro", 2015, "Editorial primera");        
        Libro libro2 = new Libro("Segundo Libro", "Autor segundo Libro", 2016, "Editorial Segundo Libro");
        
        listaLibros.add(libro1);
        listaLibros.add(libro2);
        
        for(Libro libro : listaLibros){
            libro.infoLibro();
        }
        
    }
}
