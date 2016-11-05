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
public class Lampara {
    private boolean encendida;
    
    public Lampara(){
        super();
        this.encendida = false;
    }
    
    public void encenderLampara(){
        this.encendida = true;
    }
    
    public void apagarLampara(){
        this.encendida = false;
    }
    
    public String estadoLampara(){
        if(encendida){
            return "encendida";
        }
        else{
            return "apagada";
        }
    }
}
