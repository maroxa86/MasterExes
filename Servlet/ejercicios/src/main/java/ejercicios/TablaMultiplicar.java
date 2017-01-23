package ejercicios;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TablaMultiplicar
 */
@WebServlet(name="tablaMultiplicar", urlPatterns={"/tablaMultiplicar"})
public class TablaMultiplicar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TablaMultiplicar() {
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
		String valor = request.getParameter("valor");
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MostrarCookies</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("Tabla de multiplicar del " + valor + "<br/>");
            for(int i=1; i <= 10; i++){
            	out.println(valor + " x " + i + " = " + (Integer.parseInt(valor)*i) + "<br/>");
            }
            out.println("</body>");
            out.println("</html>");
        } finally { 
            out.close();
        }
	}
}
