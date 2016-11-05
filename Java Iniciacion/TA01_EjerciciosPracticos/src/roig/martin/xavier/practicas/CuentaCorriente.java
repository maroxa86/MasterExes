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
public class CuentaCorriente {
    private double saldo;
    
    public CuentaCorriente(){
        super();
        this.saldo = 0;
    }
    
    public CuentaCorriente(double saldoInicial){
        super();
        this.saldo = saldoInicial;
    }
    
    public void getSaldo(){
        System.out.println("El saldo actual de la cuenta es: " + this.saldo + " €");
    }
    
    public void ingresarSaldo(double cantidad){
        this.saldo = this.saldo + cantidad;
    }
    
    public void reintegro(double cantidad){
        this.saldo = this.saldo - cantidad;
    }
}
