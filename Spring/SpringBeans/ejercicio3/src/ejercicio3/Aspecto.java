package ejercicio3;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aspecto {

	@Before("execution(* ejercicio3.Accion.*(..))")
	public void ejecucionPrevia(){
		System.out.println("Accion previa del aspecto");
	}

	@AfterReturning("execution(* ejercicio3.Accion.*(..))")
	public void ejecucionPosterior(){
		System.out.println("Accion posterior del aspecto");
	}
	
	@AfterThrowing("execution(* ejercicio3.Accion.*(..))")
	public void ejecucionError(){
		System.out.println("Accion del aspecto al producirse un error");
	}
}

