package hipodromo;

public class Tablon {

	private int[] matrizPosicion;
	private int numeroParticipantes;
	
	public Tablon(int numeroParticipantes){
		this.numeroParticipantes = numeroParticipantes;
		this.matrizPosicion = new int[numeroParticipantes];
		for(int i = 0; i < numeroParticipantes; i++){
			matrizPosicion[i] = 0;
		}
	}
	
	public boolean finCarrera(){
		for(int i = 0; i < numeroParticipantes; i++){
			if(matrizPosicion[i] == 75){
				return true;
			}
		}
		
		return false;
	}
	
	public void incrementarPosicion(int dorsal){
		matrizPosicion[dorsal]++;
	}
	
	public int posicion(int dorsal){
		return matrizPosicion[dorsal];
	}
	
	public int numeroParticipantes(){
		return numeroParticipantes;
	}
}
