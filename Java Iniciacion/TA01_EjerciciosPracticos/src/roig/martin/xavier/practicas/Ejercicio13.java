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
public class Ejercicio13 {
    
    public static void main(String[] args){
        
        CuentaCorriente cuenta = new CuentaCorriente();
        
        cuenta.getSaldo();
        
        cuenta.ingresarSaldo(10.25);
        cuenta.getSaldo();
        
        cuenta.reintegro(30);
        cuenta.getSaldo();
        
        System.out.println("Nueva cuenta corriente");
        
        CuentaCorriente cuentaConSaldo = new CuentaCorriente(200);
        
        cuentaConSaldo.getSaldo();
        
        cuentaConSaldo.ingresarSaldo(10.25);
        cuentaConSaldo.getSaldo();
        
        cuentaConSaldo.reintegro(30);
        cuentaConSaldo.getSaldo();
        
    }
}
