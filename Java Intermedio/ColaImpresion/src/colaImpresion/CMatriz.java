package colaImpresion;

public class CMatriz {
	private int[] matriz;
	private int indiceProductor;
	private int indiceConsumidor;
	private int elementosVacios;
	private int elementosLlenos;
	
	public CMatriz(int longitudMatriz){
		if(longitudMatriz < 1 ){
			longitudMatriz = 10;
		}
		
		matriz = new int[longitudMatriz];
		indiceProductor = 0;
		indiceConsumidor = 0;
		elementosVacios = matriz.length;
		elementosLlenos = 0;
	}
	
	public synchronized void almacenar(int num){
		while(elementosVacios == 0){
			try{
				wait();
			}
			catch(InterruptedException e){
				System.err.println("Error al realizar el wait:\n" + e);
			}
		}
		
		elementosVacios--;
		elementosLlenos++;
		
		System.out.println("vacios: " + elementosVacios + ", llenos: " + elementosLlenos + "\r");
		
		matriz[indiceProductor] = num;
		
		indiceProductor = (indiceProductor + 1) % matriz.length;
		
		notifyAll();
	}
	
	public synchronized int obtener(){
		while(elementosLlenos == 0){
			try{
				wait();
			}
			catch(InterruptedException e){
				System.err.println("Error al realizar el wait:\n" + e);
			}
		}
		
		elementosVacios++;
		elementosLlenos--;
		
		System.out.println("vacios: " + elementosVacios + ", llenos: " + elementosLlenos + "\r");
		
		int num = matriz[indiceConsumidor];
		
		indiceConsumidor = (indiceConsumidor + 1) % matriz.length;
		
		notifyAll();
		
		return num;
	}
}
