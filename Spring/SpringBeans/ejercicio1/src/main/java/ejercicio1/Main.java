package ejercicio1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Main {
	
	public static void main(String[] args) {
		System.out.println("Creación del contexto de Spring");
		ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
		
		System.out.println("Obtenición del bean Mensaje");
		
		MensajeImpl mensaje = context.getBean(MensajeImpl.class);
		
		System.out.println("Utilización del metodo imprimir");
		
		mensaje.imprimir();
		
		System.out.println("Destruccion del contexto de spring");
		
		((AnnotationConfigApplicationContext)context).close();
		
	}

}
