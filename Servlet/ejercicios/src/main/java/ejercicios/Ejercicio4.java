package ejercicios;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ejercicio4
 */
@WebServlet(name="ejercicio4", urlPatterns={"/ejercicio4"})
public class Ejercicio4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio4() {
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

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MostrarCookies</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<form id='ejercicio4' action='guardarSession' method='GET'/>");
            out.println("<label for='valor'/>");
            out.println("<input type='text' id='valor' name='valor'/>");
            out.println("<input type='submit' id='enviar' name='enviar' value='enviar'/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        } finally { 
            out.close();
        }
	}

}
