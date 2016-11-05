/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

/**
 *
 * @author Xavi
 */
public class Cliente {
    
    private Plato primerPlato;
    private Plato segundoPlato;
    private Plato postre;
    
    public Cliente(){
        super();
    }

    public Plato getPrimerPlato() {
        return primerPlato;
    }

    public void setPrimerPlato(Plato primerPlato) {
        this.primerPlato = primerPlato;
    }

    public Plato getSegundoPlato() {
        return segundoPlato;
    }

    public void setSegundoPlato(Plato segundoPlato) {
        this.segundoPlato = segundoPlato;
    }

    public Plato getPostre() {
        return postre;
    }

    public void setPostre(Plato postre) {
        this.postre = postre;
    }
    
    
}
