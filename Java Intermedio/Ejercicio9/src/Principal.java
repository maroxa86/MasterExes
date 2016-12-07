
public class Principal {

	public static void main(String[] args) throws InterruptedException{
		Hilo hilo1 = new Hilo();
		Hilo hilo2 = new Hilo();
		Hilo hilo3 = new Hilo();
		
		hilo1.start();
		Thread.sleep(1000);
		hilo2.start();
		Thread.sleep(2000);
		hilo3.start();
	}
}
