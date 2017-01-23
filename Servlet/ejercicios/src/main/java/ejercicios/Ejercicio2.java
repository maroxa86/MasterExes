package ejercicios;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ejercicio2
 */
@WebServlet(name="ejercicio2", urlPatterns={"/ejercicio2"})
public class Ejercicio2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio2() {
        super();
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MostrarCookies</title>");  
            out.println("</head>");
            out.println("<body>");
            Enumeration<String> parametros = request.getParameterNames();
            while(parametros.hasMoreElements()){
            	String param = parametros.nextElement();
            	String[] valores = request.getParameterValues(param);
            	for(String valor : valores){
            		out.println("Parametros " + param + ": " + valor + "<br/>");
            	}
            }
            out.println("</body>");
            out.println("</html>");
        } finally { 
            out.close();
        }
	}

}
