package carritoCompra;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Index
 */
@WebServlet(name = "index", urlPatterns={"/index"})
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private List<String> listadoProductos;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
    }
    
    @Override
    public void init(){
    	listadoProductos = new ArrayList<>();
    	listadoProductos.add("Agua");
    	listadoProductos.add("Pan");
    	listadoProductos.add("Leche");
    	listadoProductos.add("Tomates");
    	listadoProductos.add("Lechuga");
    	listadoProductos.add("Salmon");
    	listadoProductos.add("Lubina");
    	listadoProductos.add("Naranja");
    	listadoProductos.add("Limon");
    	listadoProductos.add("Aguacate");
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
		request.setAttribute("listadoProductos", listadoProductos);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
