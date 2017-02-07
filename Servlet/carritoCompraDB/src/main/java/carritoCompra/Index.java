package carritoCompra;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carritoCompra.modelo.Modelo;

/**
 * Servlet implementation class Index
 */
@WebServlet(name = "index", urlPatterns={"/index"})
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Modelo modelo;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
    }
    
    @Override
    public void init(){
    	modelo = (Modelo) this.getServletContext().getAttribute("modelo");
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
		request.setAttribute("listadoProductos", modelo.getListadoProductos());
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
