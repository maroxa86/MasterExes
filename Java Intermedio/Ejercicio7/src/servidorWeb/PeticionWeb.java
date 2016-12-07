package servidorWeb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import java.net.Socket;
import java.util.Date;
import java.util.StringTokenizer;

public class PeticionWeb extends Thread{
	int contador = 0;

	final int ERROR = 0;
	final int WARNING = 1;
	final int DEBUG = 2;
	private Socket scliente 	= null;		// representa la petición de nuestro cliente
	private PrintWriter out 	= null;		// representa el buffer donde escribimos la respuesta

   	public PeticionWeb(Socket ps){
		contador ++;
		scliente = ps;
		setPriority(NORM_PRIORITY - 1); // hacemos que la prioridad sea baja
   	}

	public void run(){

		try	{
			BufferedReader in = new BufferedReader (new InputStreamReader(scliente.getInputStream()));
  			out = new PrintWriter(new OutputStreamWriter(scliente.getOutputStream(),"8859_1"),true) ;


			String cadena = "";		// cadena donde almacenamos las lineas que leemos
			int i=0;				// lo usaremos para que cierto codigo solo se ejecute una vez
	
			do			
			{
				cadena = in.readLine();

				if(i == 0){ // la primera linea nos dice que fichero hay que descargar
			        i++;
			        
			        StringTokenizer st = new StringTokenizer(cadena);
                    
                    if ((st.countTokens() >= 2) && st.nextToken().equals("GET")){
                    	retornaFichero(st.nextToken()) ;
                    }
                    else{
                    	out.println("400 Petición Incorrecta") ;
                    }
				}
				
			}while (cadena != null && cadena.length() != 0);
		}
		catch(Exception e){
			System.err.println("Error en servidor\n" + e.toString());
		}
	}
	
	public void retornaFichero(String sfichero){
		// comprobamos si tiene una barra al principio
		if (sfichero.startsWith("/")){
			sfichero = sfichero.substring(1) ;
		}
        
        // si acaba en /, le retornamos el index.htm de ese directorio
        // si la cadena esta vacia, no retorna el index.htm principal
        if (sfichero.endsWith("/") || sfichero.equals("")){
        	sfichero = sfichero + "fichero.htm" ;
        }
        
        try{
	        
		    // Ahora leemos el fichero y lo retornamos
		    File mifichero = new File(sfichero);
		        
		    if (mifichero.exists()){
	      		out.println("HTTP/1.0 200 ok");
				out.println("Date: " + new Date());
				out.println("Content-Type: text/html");
				out.println("Content-Length: " + mifichero.length());
				out.println("\n");
			
				BufferedReader ficheroLocal = new BufferedReader(new FileReader(mifichero));
				
				String linea = "";
				
				do{
					linea = ficheroLocal.readLine();
	
					if (linea != null ){
						out.println(linea);
					}
				}while (linea != null);
				
				ficheroLocal.close();
				out.close();
				
			}  // fin de si el fiechero existe 
			else{
	      		out.println("HTTP/1.0 400 ok");
	      		out.close();
			}
			
		}
		catch(Exception e){
			System.err.println("Error al retornar fichero");	
		}
	}
}