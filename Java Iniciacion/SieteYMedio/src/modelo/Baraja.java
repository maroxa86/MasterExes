package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import enumerados.Palo;

public class Baraja {
	
	private List<Carta> cartas;
	
	public Baraja(){
		super();		
		cartas = new ArrayList<>();
		for(Palo palo : Palo.values()){
			for(int numero = 1; numero <= 12; numero++){
				if(numero != 8 && numero != 9){
					Carta carta = new Carta(numero, palo);
					cartas.add(carta);
				}
			}
		}
		Collections.shuffle(cartas);
	}

	public Carta cogerPrimeraCarta() {
		Carta carta = cartas.remove(0);
		return carta;
	}

}
