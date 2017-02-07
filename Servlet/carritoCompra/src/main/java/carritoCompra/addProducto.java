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
 * Servlet implementation class addProducto
 */
@WebServlet(name = "addProducto", urlPatterns={"/addProducto"})
public class addProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addProducto() {
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
		if(request.getSession().getAttribute("listadoProductosCarrito") == null){
			List<String> listadoProductosCarrito = new ArrayList<>();
			listadoProductosCarrito.add(request.getParameter("producto").toString());
			request.getSession().setAttribute("listadoProductosCarrito", listadoProductosCarrito);
		}
		else{
			((List<String>)request.getSession().getAttribute("listadoProductosCarrito")).add(request.getParameter("producto").toString());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/mostrarCarrito");
		rd.forward(request, response);
	}
}
