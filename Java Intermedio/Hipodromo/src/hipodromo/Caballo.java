package hipodromo;

public class Caballo extends Thread {

	private Tablon tablon;
	private int dorsal;
	private String nombre;
	
	public Caballo(){
		this.nombre = new String("Caballo desconocido");
		this.dorsal = 0;
	}
	
	public Caballo(int dorsal, String nombre, Tablon tablon){
		this.tablon = tablon;
		this.nombre = nombre;
		this.dorsal = dorsal;
	}
	
	public void run(){
		int limiteInf = 1;
		int limiteSuperior = 1000;
		
		while(!tablon.finCarrera()){
			try{
				sleep((int)((limiteSuperior - limiteInf+1) * Math.random() + limiteInf));
			}
			catch(InterruptedException e){
				
			}
			tablon.incrementarPosicion(dorsal);
		}
	}
}
