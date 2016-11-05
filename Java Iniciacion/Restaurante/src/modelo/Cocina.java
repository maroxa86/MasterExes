/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xavi
 */
public class Cocina {
    
    List<Mesa> pedidoMesas;
    
    public Cocina(){
        super();
        this.pedidoMesas = new ArrayList<>();
    }

    public void recibirPedidoMesa(Mesa mesa) {
        pedidoMesas.add(mesa);
    }
    
    public void cocinarPlatos(int idMesa, String plato){
        for(Mesa mesa : pedidoMesas){
            if(idMesa == mesa.getIdMesa()){
            	switch(plato){
            		case "primeros":
            			for(Cliente cliente : mesa.getComensales()){
                            System.out.println("Se estan cocinando los primeros platos");
                            cliente.getPrimerPlato().setPreparado(true);
            			}
            			break;
            		case "segundos":
            			for(Cliente cliente : mesa.getComensales()){
                            System.out.println("Se estan cocinando los segundos platos");
                            cliente.getSegundoPlato().setPreparado(true);
                        }
            			break;
            		case "postres":
            			for(Cliente cliente : mesa.getComensales()){
                            System.out.println("Se estan cocinando los postres platos");
                            cliente.getPostre().setPreparado(true);
                        }
            			break;
            		default:
            			System.out.println("No quedan platos por preparar");
            	}
            }
        }
    }
    
}
