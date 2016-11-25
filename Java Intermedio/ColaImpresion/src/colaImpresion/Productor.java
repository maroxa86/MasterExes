package colaImpresion;

public class Productor extends Thread{
	
	private CMatriz matriz;
	private boolean continuar;
	
	public Productor(CMatriz matriz){
		this.matriz = matriz;
		this.continuar = true; 
	}
	
	public void run(){
		int numero;
		
		while(continuar){
			numero = (int)(Math.random()*100);
			matriz.almacenar(numero);
			System.out.println("Productor: " + super.getName() + " almacena: numero " + numero);
		}
	}
	
	public void terminar(){
		continuar = false;
	}
}
