package colaImpresion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		CMatriz matriz = new CMatriz(10);
		Productor productor = new Productor(matriz);
		Consumidor consumidor = new Consumidor(matriz);
		
		System.out.println("Pulse [Entrar] para continuar y");
		System.out.println("vuelva a pulsar [Entrar] para finalizar");
		
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		
		try{
			br.readLine();
			productor.start();
			consumidor.start();
			br.readLine();
		}
		catch(IOException e){
			
		}
		
		productor.terminar();
		consumidor.terminar();
	}

}
