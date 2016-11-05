package tresenraya;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 *
 * @author Xavi
 */
public class Partida {
    private static Tablero tablero;
    private static Jugador jugador1;
    private static Jugador jugador2;
    private static boolean finalizar = false;
    
    public static void main(String[] args) {
        boolean inicio = true;
        tablero = new Tablero();
        System.out.println("Bienvenido al juego del tres en raya");
        try{
            do {            
                if(inicio){
                    datosInicioPartida();
                    inicio = false;
                }
                
                opcionesDeJuego(jugador1); 
                if(!finalizar){
                    opcionesDeJuego(jugador2);
                }
                
            } while (!finalizar);
        }
        catch(IOException ex){
            System.err.println(ex.getMessage());
        }
    }
 
    private static void mostrarTablero(){
        tablero.imprimirTablero();
    }
    
    private static String introducirDatos() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
    
    private static String escogerColor() throws IOException{
        System.out.println("Colores para tus fichas:");
        System.out.println("1.- Blanco");
        System.out.println("2.- Rojo");
        System.out.println("3.- Azul");
        System.out.println("4.- Verde");
        System.out.println("Que color eliges:");
        String color = introducirDatos();
        
        switch(color){
            case "1":
                return "Blanco";
            case "2":
                return "Rojo";
            case "3":
                return "Azul";
            case "4":
                return "Verde";
            default:
                System.out.println("Opción no valida, vuelve a elegir color");
                escogerColor();
        }
        return "";
    }
    
    private static void datosInicioPartida() throws IOException{
        System.out.print("Introducir el nombre del primer jugador: ");
        String nombrePrimerJugador = introducirDatos();
        String colorPrimerJugador = escogerColor();
       
        System.out.print("Introducir el nombre del segundo jugador: ");
        String nombreSegundoJugador = introducirDatos();
        String colorSegundoJugador = escogerColor();
       
        while(colorSegundoJugador.equals(colorPrimerJugador)){
            System.out.println("Has ecogido el mismo color que el primer jugador, escoge otro color.");
            colorSegundoJugador = escogerColor();
        }
        
        jugador1 = new Jugador(nombrePrimerJugador, colorPrimerJugador);
        jugador2 = new Jugador(nombreSegundoJugador, colorSegundoJugador);
        
        System.out.println("Emprezamos la partida");
    }

    private static void opcionesDeJuego(Jugador jugador) throws IOException {
        System.out.println("Te toca jugador " + jugador.getNombre() + ", escoger una opción: ");
        System.out.println("1.- Jugar Ficha");
        System.out.println("2.- Mostrar Tablero");
        System.out.println("3.- Rendirse");
        System.out.print("Que eliges: ");
        String jugada = introducirDatos();
        
        switch(jugada){
            case "1":
                jugarFicha(jugador);
                break;
            case "2":
                mostrarTablero();
                opcionesDeJuego(jugador);
                break;
            case "3":
                System.out.println("El jugador " + jugador.getNombre() + " se ha rendido y pierde la partida");
                finalizar = true;
                break;
            default:
                System.out.println("La opción no es correcta");
        }
    }
    
    private static void jugarFicha(Jugador jugador) throws IOException{
        System.out.println("Ahora toca elegir donde quieres poner la ficha.");
        int columna = columnasLibres();
        boolean ganador = tablero.insertarFicha(columna, jugador.getFicha().getId());
        mostrarTablero();
        
        if (ganador) {
            System.out.println("El ganador de la partida es: " + jugador.getNombre());
            finalizar = true;
        }
    }
    
    private static int columnasLibres() throws IOException{
        List<Integer> columnasLibres = tablero.getColumnasLibres();
        
        System.out.print("Las columnas libres son: ");
        for(Integer columna : columnasLibres){
            System.out.print(columna + 1);
        }
        
        System.out.print("\nQue columna eliges? ");
        String dato = introducirDatos();
        int columna = Integer.valueOf(dato) - 1;
        
        if(!columnasLibres.contains(columna)){
            System.out.println("No se ha escogido una opción valida.");
            columna = columnasLibres();
        }
        
        return columna;
    }
    
}
