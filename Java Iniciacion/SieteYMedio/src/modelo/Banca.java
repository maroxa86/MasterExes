package modelo;

import java.util.ArrayList;
import java.util.List;

public class Banca extends Jugador{

	private Baraja baraja;
	private List<Jugador> jugadores;
	
	public Banca(){
		super();
		jugadores = new ArrayList<>();
	}

	public void setBaraja(Baraja baraja) {
		this.baraja = baraja;
	}

	public void addJugador(Jugador jugador){
		this.jugadores.add(jugador);
	}

	public void jugarPartida() {
		this.repartirCartasInicialesALosJugadores();
		this.cederTurnoAlosJugadores();
		this.buscarGanador();
	}

	private void repartirCartasInicialesALosJugadores() {
		System.out.println("Se repartes las cartas iniciales");
		for(Jugador jugador : this.jugadores){
			Carta primera = baraja.cogerPrimeraCarta();
			jugador.darCarta(primera);
		}
	}
	
	private void cederTurnoAlosJugadores() {
		for(Jugador jugador : this.jugadores){
			System.out.println("Turno del jugador: " + jugador.getNombreJugador());
			jugador.jugarTurno();
		}
	}
	
	private void buscarGanador() {
		float sumaMayor = 0f;
		Jugador jugadorGanador=null;
		for(Jugador jugador : this.jugadores){
			if(jugador.calcularSuma() > sumaMayor && jugador.calcularSuma() <= 7.5f){
				sumaMayor = jugador.calcularSuma();
				jugadorGanador = jugador;
			}
		}
		System.out.println("El ganador es:" + jugadorGanador.getNombreJugador());
		System.out.print("Y sus cartas son: ");
		jugadorGanador.mostrarCartas();
	}

	public Carta pedirCarta() {
		return baraja.cogerPrimeraCarta();
	}
}
