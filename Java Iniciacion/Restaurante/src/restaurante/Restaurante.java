/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xavi
 */
public class Restaurante {

    private static List<Mesa> listadoMesas;
    private static boolean finalizar = false;
    private static double recaudacion;
    private static Menu menu;
    private static Cocina cocina;
    
    public static void main(String[] args) {  
        System.out.println("APLICACIÓN RESTAURANTE");
        try{
            creacionRestaurante();
            do {                
                Integer accion = accionesRestaurante();
                switch(accion){
                    case 1:
                        recibirClientes();
                        break;
                    case 2: 
                        tomarNotaClientes();
                        break;
                    case 3:
                        consultarMesas();
                        break;
                    case 4:
                        cobrarClientes();
                        break;
                    case 5:
                        cerrarRestaurante();
                        break;
                    default:
                        System.out.println("No se ha escogido una accion correcta, vuelve a seleccionar");
                }
            } while(!finalizar);
        }
        catch(IOException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    private static void creacionRestaurante() throws IOException {
        cocina = new Cocina();
        listadoMesas = new ArrayList<>();      
        adquisionMesas();
        creacionMenu();       
        recaudacion = 0;
    }
    
    private static Integer introducirDatosInteger() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.valueOf(reader.readLine());
    }

    private static String introducirDatosString() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    private static Integer accionesRestaurante() throws IOException {
        System.out.println("Que quieres hacer en el restaurante: ");
        System.out.println("1. - Atender cliente");
        System.out.println("2. - Tomar Nota Clientes");
        System.out.println("3. - Comprobar estado mesas");
        System.out.println("4. - Cobrar");
        System.out.println("5. - Cerrar el restaurante");
        System.out.print("Que accion escoges: ");
        return introducirDatosInteger();
    }

    private static void recibirClientes() throws IOException {
        System.out.print("Cuantos comensales hay? ");
        Integer comensales = introducirDatosInteger();
        for(Mesa mesa : listadoMesas){
            if(mesa.mesaDisponible(comensales)){
                System.out.println("Los clientes se sentaran en la mesa " + mesa.getIdMesa());
                for(int i = 0; i < comensales; i++){
                    mesa.addComensal(new Cliente()); 
                }
            }
            else{
                System.out.println("No hay mesas disponibles ahora mismo");
            }
        }
    }

    private static void consultarMesas() {
        for(Mesa mesa : listadoMesas){
            if(mesa.mesaLibre()){
                continue;
            }
            
            if(!mesa.isPrimerosServidos()){
                for(Cliente cliente : mesa.getComensales()){
                    if(!cliente.getPrimerPlato().isPreparado()){
                        cocina.cocinarPlatos(mesa.getIdMesa(), "primeros");
                    }
                    else{
                        if(!cliente.getPrimerPlato().isServido()){
                            mesa.getCamarero().servirPlatos(mesa.getComensales(), "primero");
                            mesa.setPrimerosServidos(true);
                        }
                    }
                    break;
                }
            }
            else{
                if(!mesa.isSegundoServidos()){
                    for(Cliente cliente : mesa.getComensales()){
                        if(!cliente.getSegundoPlato().isPreparado()){
                            cocina.cocinarPlatos(mesa.getIdMesa(), "segundos");
                        }
                        else{
                            if(!cliente.getSegundoPlato().isServido()){
                                mesa.getCamarero().servirPlatos(mesa.getComensales(), "segundo");
                                mesa.setSegundoServidos(true);
                            }
                        }
                        break;
                    }
                }
                else{
                    if(!mesa.isPostresServidos()){
                        for(Cliente cliente : mesa.getComensales()){
                            if(!cliente.getPostre().isPreparado()){
                                cocina.cocinarPlatos(mesa.getIdMesa(), "postres");
                            }
                            else{
                                if(!cliente.getPostre().isServido()){
                                    mesa.getCamarero().servirPlatos(mesa.getComensales(), "postre");
                                    mesa.setPostresServidos(true);
                                }
                            }
                            break;
                        }
                    }
                    else{
                        System.out.println("Los comensales han acabado de cenar");
                    }
                }
            }
        }
    }

    private static void cerrarRestaurante() {
        finalizar = true;
        System.out.println("El restaurante ha ganado: " + recaudacion + " €");
    }

    private static void adquisionMesas() throws IOException {
        System.out.print("Cuantas mesas dispondra el restaurante: ");
        Integer cantidadMesas = introducirDatosInteger();
        
        for(int i = 1; i <= cantidadMesas; i++){
            System.out.print("Cuantos comensales hay en la mesa " + i + ": ");
            Integer comensalesMesa = introducirDatosInteger();
            
            Mesa mesa = new Mesa(i, comensalesMesa, new Camarero());
            listadoMesas.add(mesa);
        } 
    }

    private static void creacionMenu() throws IOException {
        boolean salir = false;
        int idPrimerPlato = 1;
        int idSegundoPlato = 1;
        int idPostre = 1;
        menu = new Menu();
        do{
            System.out.println("Que plato quieres añadir al menú:");
            System.out.println("1.- Primer plato");
            System.out.println("2.- Segundo plato");
            System.out.println("3.- Postre");
            System.out.println("4.- Salir");
            System.out.print("Que plato eliges: ");
            Integer opcion = introducirDatosInteger();

            String nombre;
            double precio;
            Plato plato;
            switch(opcion){
                case 1:
                    nombre = introducirNombrePlato();
                    precio = introducirPrecio();
                    plato = new Plato(idPrimerPlato,nombre, precio);
                    menu.addPrimerPlato(plato);
                    idPrimerPlato++;
                    break;
                case 2:
                    nombre = introducirNombrePlato();
                    precio = introducirPrecio();
                    plato = new Plato(idSegundoPlato, nombre, precio);
                    menu.addSegundoPlato(plato);
                    idSegundoPlato++;
                    break;
                case 3:
                    nombre = introducirNombrePlato();
                    precio = introducirPrecio();
                    plato = new Plato(idPostre, nombre, precio);
                    menu.addPostre(plato);
                    idPostre++;
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("No se ha escogido una opcion correcta");
                    break;
            }
        }while(!salir);
        
        for(Mesa mesa : listadoMesas){
            mesa.getCamarero().setMenu(menu);
        }
    }

    private static String introducirNombrePlato() throws IOException {
        System.out.print("Nombre del plato: ");
        return introducirDatosString();       
    }

    private static Double introducirPrecio() throws IOException {
       System.out.print("Precio del plato: ");
       return introducirDatosDouble();
    }

    private static void tomarNotaClientes() throws IOException {
        for(Mesa mesa : listadoMesas){
            System.out.println("Atentemos la mesa " + mesa.getIdMesa());
            Menu menu = mesa.getCamarero().getMenu();
            menu.toString();
            for(int i = 0; i < mesa.getComensales().size(); i++){
                escogerPrimerPlato(mesa.getComensales().get(i), menu);
                escogerSegundoPlato(mesa.getComensales().get(i), menu);
                escogerPostre(mesa.getComensales().get(i), menu);
            }
            enviarPedidoCocina(mesa);
        }
    }

    private static void cobrarClientes() {
        for(Mesa mesa : listadoMesas){
        	System.out.println("Se cobra a la mesa " + mesa.getIdMesa());
            recaudacion += mesa.cobrar();
        }
    }

    private static void escogerPrimerPlato(Cliente cliente, Menu menu) throws IOException {
        boolean elegido = false;
        System.out.println(menu.primerosPlatos());
        do{
            System.out.print("Que primer plato eliges: ");
            Integer opcion = introducirDatosInteger();
            for(Plato plato : menu.getPrimerosPlatos()){
                if(opcion == plato.getIdPlato()){
                    cliente.setPrimerPlato(plato);
                    elegido = true;
                }
            }
            if(!elegido){
                System.out.println("La opción elegida no es valida.");
            }
            
        }while(!elegido);
    }

    private static void escogerSegundoPlato(Cliente cliente, Menu menu) throws IOException {
        boolean elegido = false;
        System.out.println(menu.segundoPlatos());
        do{
            System.out.print("Que segundo plato eliges: ");
            Integer opcion = introducirDatosInteger();
            for(Plato plato : menu.getSegundosPlatos()){
                if(opcion == plato.getIdPlato()){
                    cliente.setSegundoPlato(plato);
                    elegido = true;
                }
            }
            if(!elegido){
                System.out.println("La opción elegida no es valida.");
            }
        }while(!elegido);
    }

    private static void escogerPostre(Cliente cliente, Menu menu) throws IOException {
        boolean elegido = false;
        System.out.println(menu.postres());
        do{
            System.out.print("Que postre eliges: ");
            Integer opcion = introducirDatosInteger();
            for(Plato plato : menu.getPostres()){
                if(opcion == plato.getIdPlato()){
                    cliente.setPostre(plato);
                    elegido = true;
                }
            }
            if(!elegido){
                System.out.println("La opción elegida no es valida.");
            }
        }while(!elegido);
    }

    private static void enviarPedidoCocina(Mesa mesa) {
        cocina.recibirPedidoMesa(mesa);
    }

    private static Double introducirDatosDouble() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return Double.valueOf(reader.readLine());
    }
}