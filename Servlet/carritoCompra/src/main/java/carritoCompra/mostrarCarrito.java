package carritoCompra;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mostrarCarrito
 */
@WebServlet(name = "mostrarCarrito", urlPatterns={"/mostrarCarrito"})
public class mostrarCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mostrarCarrito() {
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
               out.println("La lista de productos de la tienda es la siguiente: <br/>");
               List<String> listadoProductosCarrito = (List<String>) request.getSession().getAttribute("listadoProductosCarrito");
               if(listadoProductosCarrito != null){
            	   out.println("<table><tr><td>Producto</td><td></td></tr>");
            	   for(String producto : listadoProductosCarrito){
            		   out.println("<tr><td>" + producto + "</td><td><a href='/addCarrito'>Añadir producto</a></td></tr>");
            	   }
            	   out.println("</table>");
            	   out.println("Productos en el carrito: " + listadoProductosCarrito.size());
               }
               else{
               		out.println("Productos en el carrito: " + 0);
               }
               out.println("<a href='index'>Volver</a>");
               out.println("</body>");
               out.println("</html>");
           } finally { 
               out.close();
           }
   	}

}
