/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import java.util.List;

/**
 *
 * @author Xavi
 */
public class Camarero {
    
    private Menu menu;
    
    public Camarero(){
        super();
    }
    
    public Camarero(Menu menu){
        super();
        this.menu = menu;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
 
    public void mostrarMenu(){
        menu.toString();
    }

    public void servirPlatos(List<Cliente> comensales, String plato) {
        for(Cliente cliente : comensales){
            switch (plato){
                case "primero":
                    System.out.println("Sirviendo los primeros platos");
                    cliente.getPrimerPlato().setServido(true); 
                    break;
                case "segundo":
                    System.out.println("Sirviendo los segundos platos");
                    cliente.getSegundoPlato().setServido(true);
                    break;
                case "postre":
                    System.out.println("Sirviendo los postres");
                    cliente.getPostre().setServido(true);
                    break;
            }          
        }
    }
}
