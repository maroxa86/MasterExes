
public class Productor extends Thread {

	private Mesa mesa;
	
	public Productor(Mesa mesa){
		this.mesa = mesa;
	}
	
	public void run(){
		while(mesa.getCantidadObjetos() < 10){
			try {
				mesa.dejarObjeto();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
