package hipodromo;

public class Marcador extends Thread {
	
	private Tablon tablon;
	
	public Marcador(Tablon tablon){
		this.tablon = tablon;
	}
	
	public void run(){
		int numeroParticipantes = tablon.numeroParticipantes();
		
		while(!tablon.finCarrera()){
			System.out.println("POSICIONES DE CARRERA");
			System.out.println("---------------------");
			
			for(int i = 0; i < numeroParticipantes; i++){
				for(int j = 0; j < tablon.posicion(i); j++){
					System.out.print(".");
				}
				System.out.println("*");
			}
			
			try{
				sleep(500);
			}
			catch(InterruptedException e){
				
			}
		}
	}
	
	
}
