
public class Cliente extends Thread {
	
	private Mesa mesa;
	
	public Cliente(Mesa mesa){
		this.mesa = mesa;
	}

	public void run(){
		while(mesa.getCantidadObjetos() <= 10){
			try {
				mesa.cogerObjecto();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
