package ejercicio1;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class MensajeImpl implements Mensaje{
	
	@PostConstruct
	public void init(){
		System.out.println("Creación del bean");
	}
	
	public void imprimir(){
		System.out.println("El bean ya ha sido creado");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("Destrucción del bean");
	}
}
