/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenraya;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xavi
 */
public class Tablero {
    
    private Casilla[][] tablero;
    private final int NUMERO_FILAS = 3;
    private final int NUMERO_COLUMNAS = 3;
    public Tablero(){
        super();
        
        tablero  = new Casilla[NUMERO_FILAS][NUMERO_COLUMNAS];
        
        for(int i = 0; i < NUMERO_FILAS; i++){
            for(int j = 0; j < NUMERO_COLUMNAS; j++){
                tablero[i][j] = new Casilla("x");
            }
        }
    }

    public Casilla[][] getTablero() {
        return tablero;
    }

    public void setTablero(Casilla[][] tablero) {
        this.tablero = tablero;
    }
    
    public boolean insertarFicha(int columna, String valor){
        for(int i = (NUMERO_FILAS - 1); i >= 0; i--){
           Casilla casilla = tablero[i][columna];
           if("x".equals(casilla.getValor())){
               casilla.setValor(valor);
               return comprobarGanador(i, columna, valor);
           }   
        }
        return false;
    }
    
    public void imprimirTablero(){
        for(int i = 0; i < NUMERO_FILAS; i++){
            System.out.print("|");
            for(int j = 0; j < NUMERO_COLUMNAS; j++){
                System.out.print("  " + tablero[i][j].getValor() + "  ");
            }
            System.out.print("|");
            System.out.println("");
        }
    }

    public List<Integer> getColumnasLibres() {
        List<Integer> columnasLibres = new ArrayList<>();
        for(int i = 0; i < NUMERO_COLUMNAS; i++){
           if("x".equals(tablero[0][i].getValor())){
               columnasLibres.add(i);
           }
        }
        return columnasLibres;
    }

    private boolean comprobarGanador(int fila, int columna, String valor) {  
        boolean tresEnRaya;
        
        tresEnRaya = comprobarHorizontal(fila, columna, valor);
        
        if(!tresEnRaya){
            if(fila != (NUMERO_FILAS - 1)){
                tresEnRaya = comprobarVertical(fila, columna, valor);
            }
            if(!tresEnRaya){
                tresEnRaya = comprobarDiagonales(fila, columna, valor);
            }
        }
        
        return tresEnRaya;
    }

    private boolean comprobarHorizontal(int fila, int columna, String valor) {
        if(columna == 0){
            if(valor.equals(tablero[fila][columna+1].getValor())){
                if(valor.equals(tablero[fila][columna+2].getValor())){
                    return true;
                }
            }
        }
        else{
            if(columna == (NUMERO_COLUMNAS-1)){
                if(valor.equals(tablero[fila][columna-1].getValor())){
                    if(valor.equals(tablero[fila][columna-2].getValor())){
                        return true;
                    }
                }  
            }
            else{
                if(columna == 1){
                    if(valor.equals(tablero[fila][columna-1].getValor())){
                        if(valor.equals(tablero[fila][columna+1].getValor())){
                            return true;
                        }
                    }
                }
                else{
                    if(columna == NUMERO_COLUMNAS -2){
                        if(valor.equals(tablero[fila][columna+1].getValor())){
                            if(valor.equals(tablero[fila][columna-1].getValor())){
                                return true;
                            }
                        }
                    }
                    else{
                        if(valor.equals(tablero[fila][columna+1].getValor())){
                            if(valor.equals(tablero[fila][columna+2].getValor())){
                                return true;
                            }
                            else{
                                if(valor.equals(tablero[fila][columna - 1].getValor())){
                                    return true;
                                }
                            }
                        }
                        else{
                            if(valor.equals(tablero[fila][columna - 1].getValor())){
                                if(valor.equals(tablero[fila][columna - 2].getValor())){
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return false;
    }

    private boolean comprobarVertical(int fila, int columna, String valor) {
        if(fila == 0){
            if(valor.equals(tablero[fila + 1][columna].getValor())){
                if(valor.equals(tablero[fila + 2][columna].getValor())){
                    return true;
                }
            }
        }
        else{
            if(fila == 1 || fila == (NUMERO_FILAS - 2)){
                if(valor.equals(tablero[fila - 1][columna].getValor())){
                    if(valor.equals(tablero[fila + 1][columna].getValor())){
                        return true;
                    }
                }
            }
            else{
                if(valor.equals(tablero[fila - 1][columna].getValor())){
                    if(valor.equals(tablero[fila + 2][columna].getValor())){
                            return true;
                    }
                    else{
                        if(valor.equals(tablero[fila + 1][columna].getValor())){
                            return true;
                        }
                    }
                }
                else{
                    if(valor.equals(tablero[fila + 1][columna].getValor())){
                        if(valor.equals(tablero[fila + 2][columna].getValor())){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean comprobarDiagonales(int fila, int columna, String valor) {
        if(fila == 0 && columna == 0){
            if(valor.equals(tablero[fila+1][columna+1].getValor())){
                if(valor.equals(tablero[fila+2][columna+2].getValor())){
                    return true;
                }
            }
        }
        else{
            if(fila == 0 && columna == (NUMERO_COLUMNAS-1)){
                if(valor.equals(tablero[fila+1][columna - 1].getValor())){
                    if(valor.equals(tablero[fila+2][columna - 2].getValor())){
                        return true;
                    }
                }  
            }
            else{
                if(fila == (NUMERO_FILAS - 1) && columna == 0){
                    if(valor.equals(tablero[fila - 1][columna + 1].getValor())){
                        if(valor.equals(tablero[fila - 2][columna + 2].getValor())){
                            return true;
                        }
                    }
                }
                else{
                    if(fila == (NUMERO_FILAS - 1) && columna == (NUMERO_COLUMNAS-1)){
                        if(valor.equals(tablero[fila - 1][columna - 1].getValor())){
                            if(valor.equals(tablero[fila - 2][columna - 2].getValor())){
                                return true;
                            }
                        }  
                    }
                    else{
                        if((fila > 0 && fila < (NUMERO_FILAS - 1)) && (columna > 0 && columna < (NUMERO_COLUMNAS - 1))){ 
                            if(valor.equals(tablero[fila - 1][columna - 1].getValor())){
                                 if(valor.equals(tablero[fila + 1][columna + 1].getValor())){
                                     return true;
                                 }
                            }
                            else{
                                if(valor.equals(tablero[fila + 1][columna - 1].getValor())){
                                     if(valor.equals(tablero[fila - 1][columna + 1].getValor())){
                                         return true;
                                     }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return false;
    }

}
