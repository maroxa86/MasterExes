import java.time.LocalTime;

public class Hilo extends Thread{

	public void run(){
		while(true){
			try {
				System.out.println("Ejecutandose el hilo " + Thread.currentThread().getName() + " la hora es: " + LocalTime.now());
				sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
