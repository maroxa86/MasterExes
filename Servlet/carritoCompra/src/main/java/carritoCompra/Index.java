package carritoCompra;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MostrarCookies</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("La lista de productos de la tienda es la siguiente: <br/>");
            out.println("<table><tr><td>Producto</td><td></td></tr>");
            for(String producto : listadoProductos){
            	
            	out.println("<tr><td>" + producto + "</td><td><a href='addProducto?producto=" + producto  + "'>A�adir producto</a></td></tr>");
            }
            out.println("</table>");
            List<String> listadoProductosCarrito = (List<String>) request.getSession().getAttribute("listadoProductosCarrito");
            if(listadoProductosCarrito != null){
            	out.println("Productos en el carrito: " + listadoProductosCarrito.size());
            }
            else{
            	out.println("Productos en el carrito: " + 0);
            }
            out.println("</body>");
            out.println("</html>");
        } finally { 
            out.close();
        }
	}

}
