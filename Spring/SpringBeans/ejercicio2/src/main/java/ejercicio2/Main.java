package ejercicio2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
		
		Mensaje singleton = context.getBean(Singleton.class);
		singleton.setMensaje("Esto es un singleton");
		
		singleton.imprimir();
		
		Mensaje segundoSingleton = context.getBean(Singleton.class);
		
		segundoSingleton.imprimir();
		
		
		Mensaje prototype = context.getBean(Prototype.class);
		prototype.setMensaje("Esto es un Prototype");
		
		prototype.imprimir();
		
		Mensaje segundoPrototype = context.getBean(Prototype.class);
		
		segundoPrototype.imprimir();
	}

}
