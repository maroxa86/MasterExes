/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xavi
 */
public class Mesa {
    
    private int idMesa;
    private int sillas;
    private List<Cliente> comensales;
    private Camarero camarero;
    private boolean primerosServidos = false;
    private boolean segundoServidos = false;
    private boolean postresServidos = false;
    
    public Mesa(){
        super();
    }

    public Mesa(int idMesa, int sillas) {
        this.idMesa = idMesa;
        this.sillas = sillas;
        this.comensales = new ArrayList<>();
    }

    public Mesa(int idMesa, int sillas, Camarero camarero) {
        this.idMesa = idMesa;
        this.sillas = sillas;
        this.camarero = camarero;
        this.comensales = new ArrayList<>();
    }
    
    public Mesa(int idMesa, int sillas, List<Cliente> comensales) {
        this.idMesa = idMesa;
        this.sillas = sillas;
        this.comensales = comensales;
    }
    
    public Mesa(int idMesa, int sillas, List<Cliente> comensales, Camarero camarero){
        super();
        this.idMesa = idMesa;
        this.sillas = sillas;
        this.comensales = comensales;
        this.camarero = camarero;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getSillas() {
        return sillas;
    }

    public void setSillas(int sillas) {
        this.sillas = sillas;
    }

    public List<Cliente> getComensales() {
        return comensales;
    }

    public void setComensales(List<Cliente> comensales) {        
        this.comensales = comensales;
    }

    public Camarero getCamarero() {
        return camarero;
    }

    public void setCamarero(Camarero camarero) {
        this.camarero = camarero;
    }

    public void addComensal(Cliente cliente){
        if(this.comensales == null){
            this.comensales = new ArrayList<>();
        }
        this.comensales.add(cliente);
    }

    boolean mesaDisponible(int comensales) {
        if(this.sillas >= comensales && this.comensales.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isPrimerosServidos() {
        return primerosServidos;
    }

    public void setPrimerosServidos(boolean primerosServidos) {
        this.primerosServidos = primerosServidos;
    }

    public boolean isSegundoServidos() {
        return segundoServidos;
    }

    public void setSegundoServidos(boolean segundoServidos) {
        this.segundoServidos = segundoServidos;
    }

    public boolean isPostresServidos() {
        return postresServidos;
    }

    public void setPostresServidos(boolean postresServidos) {
        this.postresServidos = postresServidos;
    }

    public boolean mesaLibre() {
        if(this.comensales == null || this.comensales.isEmpty()){
            System.out.println("La mesa " + this.idMesa + " esta libre");
            return true;
        }
        return false;
    }

    public double cobrar() {
        if(postresServidos){
            double cuenta = 0;
            for(Cliente cliente : this.comensales){
               cuenta += cliente.getPrimerPlato().getPrecio();
               cuenta += cliente.getSegundoPlato().getPrecio();
               cuenta += cliente.getPostre().getPrecio();
            }
            return cuenta;
        }
        else{
            System.out.println("Aún quedan platos por servir en la mesa " + this.idMesa);
            return 0;
        }     
    }
    
    
}
