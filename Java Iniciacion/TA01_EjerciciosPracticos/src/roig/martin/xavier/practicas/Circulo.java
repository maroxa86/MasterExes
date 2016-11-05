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
public class Circulo {
    private double radio;
    private double x;
    private double y;
    
    public Circulo(){
        super();
    }
    
    public Circulo(double radio, double x, double y) {
        this.radio = radio;
        this.x = x;
        this.y = y;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public double calcularArea(){
        return Math.PI * Math.sqrt(radio);
    }
    
    public double calcularPermitro(){
        return 2 * Math.PI * radio;
    }
    
}
