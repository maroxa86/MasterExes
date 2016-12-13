
public class Mesa {

	private Boolean objeto;
	private int cantidadObjetos;
	
	public Mesa(){
		this.objeto = false;
		this.cantidadObjetos = 0;
	}
	
	public synchronized void dejarObjeto() throws Exception{
		while(objeto){
			System.out.println("El productor se bloquea porque ya hay un objeto en la mesa");
			wait();
		}
		
		System.out.println("El productor deja un objeto");
		
		objeto = true;
		
		notifyAll();
	}
	
	public synchronized void cogerObjecto()throws Exception{
		while(!objeto){
			System.out.println("El cliente se bloquea porque no hay un objeto en la mesa");
			wait();
		}
		
		System.out.println("El cliente recoge el objeto");
		
		objeto = false;
		cantidadObjetos++;
		
		notifyAll();
	}

	public boolean hayObjeto() {
		return objeto;
	}

	public int getCantidadObjetos() {
		return this.cantidadObjetos;
	}
	
}
