import java.time.LocalTime;

public class Principal {

	public static void main(String[] args) {
		Thread hilo = new Thread(){

			@Override
			public void run() {
				while(true){
					try {
						LocalTime hora = LocalTime.now();
						System.out.println("La hora actual es: " + hora);
						sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		};
		hilo.start();
	}

}
