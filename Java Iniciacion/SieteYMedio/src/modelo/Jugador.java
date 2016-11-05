package modelo;

import java.util.ArrayList;
import java.util.List;

import enumerados.Decision;

public class Jugador {
	
	private List<Carta> misCartas;
	private Banca banca;
	private String nombreJugador;
	
	public Jugador(){
		super();
	}
	
	public Jugador(String nombreJugador){
		super();
		this.nombreJugador = nombreJugador;
		this.misCartas = new ArrayList<>();
	}

	public void darCarta(Carta carta) {
		misCartas.add(carta);
	}

	public void jugarTurno() {
		Decision decision = Decision.PEDIR_CARTA;
		do{
			decision = this.evaluarMisCartas(misCartas);
			if(decision == Decision.PEDIR_CARTA){
				this.misCartas.add(banca.pedirCarta());
			}
		}while(decision == Decision.PEDIR_CARTA);
	}

	private Decision evaluarMisCartas(List<Carta> misCartas2) {
		float suma = calcularSuma();
		if(suma > 7.5f){
			System.out.println("El jugador se ha pasado");
			return Decision.PASARSE;
		}
		else{
			if(suma > 5.5f){
				System.out.println("El jugador se ha plantado");
				return Decision.PLANTASE;
			}
			else{
				System.out.println("El jugador pide carta");
				return Decision.PEDIR_CARTA;
			}
		}
	}

	protected float calcularSuma() {
		float suma = 0f;
		for(Carta carta : this.misCartas){
			int numero = carta.getNumero();
			if(numero <= 7){
				suma += numero;
			}
			else{
				suma += 0.5;
			}
		}
		return suma;
	}

	public void setBanca(Banca banca) {
		this.banca = banca;
	}

	public String getNombreJugador() {
		return nombreJugador;
	}

	public void mostrarCartas(){
		for(Carta carta : this.misCartas){
			System.out.print(carta.toString() + " ");
		}
	}
}
