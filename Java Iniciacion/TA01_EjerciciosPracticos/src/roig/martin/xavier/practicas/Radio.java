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
public class Radio {
    
    private final int FREQUENCIA_INICIAL = 80;
    private final int FREQUENCIA_FINAL = 108;
    private double frequencia;
    
    public Radio(){
        super();
        this.frequencia = this.FREQUENCIA_INICIAL;
    }
    
    public void subirFrequencia(){
        if(this.frequencia == this.FREQUENCIA_FINAL){
            this.frequencia = this.FREQUENCIA_INICIAL;
        }
        else{
            this.frequencia = this.frequencia + 0.5;
        }
    }
    
    public void bajarFrequencia(){
        if(this.frequencia == this.FREQUENCIA_INICIAL){
            this.frequencia = this.FREQUENCIA_FINAL;
        }
        else{
            this.frequencia = this.frequencia - 0.5;
        }
    }
    
    public void getFrequencia(){
        System.out.println("La frecuencia actual es: " + this.frequencia);
    }
}
