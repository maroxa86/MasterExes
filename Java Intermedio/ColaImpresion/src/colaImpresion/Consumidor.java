package colaImpresion;

public class Consumidor extends Thread{
	
	private CMatriz matriz;
	private boolean continuar;
	
	public Consumidor(CMatriz matriz){
		this.matriz = matriz;
		this.continuar = true; 
	}
	
	public void run(){
		int numero;
		
		while(continuar){
			numero = this.matriz.obtener();
			System.out.println("Productor: " + super.getName() + " almacena: numero " + numero);
		}
	}
	
	public void terminar(){
		continuar = false;
	}
}
