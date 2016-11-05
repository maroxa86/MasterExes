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
public class Ejercicio7 {
    
    public static void main(String[] args){
        Complejo primerComplejo = new Complejo(2.0, 1.0);
        Complejo segundoComplejo = new Complejo(3.0,2.0);
        
        Complejo resultadoSuma = sumarComplejos(primerComplejo, segundoComplejo);
        System.out.println("El resultado de la suma es: (" + resultadoSuma.getReal() + ", " + resultadoSuma.getImaginario() + "i)");
        
        Complejo resultadoResta = restaComplejos(primerComplejo, segundoComplejo);
        System.out.println("El resultado de la suma es: (" + resultadoResta.getReal() + ", " + resultadoResta.getImaginario() + "i)");
        
        Complejo resultadoMultiplicacion = multiplicacionComplejos(primerComplejo, segundoComplejo);
        System.out.println("El resultado de la suma es: (" + resultadoMultiplicacion.getReal() + ", " + resultadoMultiplicacion.getImaginario() + "i)");
        
        Complejo resultadoDivision = divisionComplejos(primerComplejo, segundoComplejo);
        System.out.println("El resultado de la suma es: (" + resultadoDivision.getReal() + ", " + resultadoDivision.getImaginario() + "i)");
    }
   
    private static Complejo sumarComplejos(Complejo primerComplejo, Complejo segundoComplejo){
        Complejo resultado = new Complejo(); 
        
        resultado.setImaginario(primerComplejo.getImaginario() + segundoComplejo.getImaginario());
        resultado.setReal(primerComplejo.getReal() + segundoComplejo.getReal());
        
        return resultado;
    }
    
    private static Complejo restaComplejos(Complejo primerComplejo, Complejo segundoComplejo){
        Complejo resultado = new Complejo(); 
        
        resultado.setImaginario(primerComplejo.getImaginario() - segundoComplejo.getImaginario());
        resultado.setReal(primerComplejo.getReal() - segundoComplejo.getReal());
        
        return resultado;
    }
    
    private static Complejo multiplicacionComplejos(Complejo primerComplejo, Complejo segundoComplejo){
        Complejo resultado = new Complejo(); 
        
        double real = (primerComplejo.getReal() * segundoComplejo.getReal()) - (primerComplejo.getImaginario() * segundoComplejo.getImaginario());
        double imaginario = (primerComplejo.getReal() * segundoComplejo.getImaginario()) + (segundoComplejo.getReal() * primerComplejo.getImaginario());
        
        resultado.setImaginario(imaginario);
        resultado.setReal(real);
        
        return resultado;
    }
    
    private static Complejo divisionComplejos(Complejo primerComplejo, Complejo segundoComplejo){
        Complejo resultado = new Complejo(); 
        
        double numeradorReal = (primerComplejo.getReal() * segundoComplejo.getReal()) + (primerComplejo.getImaginario() * segundoComplejo.getImaginario());
        double numeradorIrreal = (segundoComplejo.getReal() * primerComplejo.getImaginario()) - (primerComplejo.getReal() * segundoComplejo.getImaginario()) ; 
        double denominador = Math.sqrt(primerComplejo.getImaginario()) + Math.sqrt(segundoComplejo.getImaginario());
            
        resultado.setReal(numeradorReal/denominador);
        resultado.setImaginario(numeradorIrreal/denominador);
        
        return resultado;
    }
}
