
public class Principal {

	public static void main(String[] args) {
		Mesa mesa = new Mesa();
		Productor productor = new Productor(mesa);
		Cliente cliente = new Cliente(mesa);
		
		productor.start();
		cliente.start();
		
		try {
			productor.join();
			cliente.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Finaliza el programa");
	}

}
