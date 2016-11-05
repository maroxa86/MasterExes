/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roig.martin.xavier.practicas;

/**
 *
 * @author Xavi
 */
public class Libro {
    private String titulo;
    private String autor;
    private int anyoPulicacion;
    private String editorial;

    public Libro(){
        super();
    }
    
    public Libro(String titulo, String autor, int anyoPulicacion, String editorial) {
        super();
        this.titulo = titulo;
        this.autor = autor;
        this.anyoPulicacion = anyoPulicacion;
        this.editorial = editorial;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnyoPulicacion() {
        return anyoPulicacion;
    }

    public void setAnyoPulicacion(int anyoPulicacion) {
        this.anyoPulicacion = anyoPulicacion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
            
    public void infoLibro(){
        System.out.print("La información del libro es:\n");
        System.out.print("Titulo: " + this.titulo + "\n");
        System.out.print("Autor: " + this.autor + "\n");
        System.out.print("Año Publicación: " + this.anyoPulicacion + "\n");
        System.out.println("Editorial " + this.editorial);
        System.out.println();
    }
}
