package articulos.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import articulos.beans.Articulo;
import articulos.modelo.Modelo;



/**
 * Servlet implementation class Controlador
 */
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Modelo modelo;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
    }

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

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher despachador = null;
		try {
			switch(request.getServletPath()){
				case "/login.do":
					despachador = request.getRequestDispatcher("mostrarArticulos.do");
					break;
				case "/mostrarArticulos.do":
					List<Articulo> listadoArticulos = modelo.mostrarArticulos();
					request.setAttribute("listadoArticulos", listadoArticulos);
					despachador = request.getRequestDispatcher("mostrarArticulos.jsp");
					break;
				case "/mostrarCarrito.do":
					Map<Integer, Integer> listadoCarrito = (Map<Integer, Integer>) request.getSession().getAttribute("listadoCarrito");
					Map<String, Integer> listadoCantidadArticulos = new HashMap<>();
					
					if(listadoCarrito != null){
						for(Map.Entry<Integer, Integer> entry : listadoCarrito.entrySet()){
							Articulo articulo = modelo.getArticuloById(entry.getKey());
							if(articulo != null){
								listadoCantidadArticulos.put(articulo.getNombre(), entry.getValue());
							}
						}
					}
					
					request.setAttribute("listadoArticulos", listadoCantidadArticulos);
					
					despachador = request.getRequestDispatcher("mostrarCarrito.jsp");
					break;
				case "/addCarrito.do":
					int idArticulo = Integer.parseInt(request.getParameter("idArticulo"));
					int valor = 1;
					Map<Integer, Integer> listadoCarritoSession = (Map<Integer, Integer>) request.getSession().getAttribute("listadoCarrito");
					if(listadoCarritoSession == null){
						listadoCarritoSession = new HashMap<>();
						request.getSession().setAttribute("listadoCarrito", listadoCarritoSession);
					}
					if(listadoCarritoSession.containsKey(idArticulo)){
						valor = listadoCarritoSession.get(idArticulo) + 1;
					}
					
					listadoCarritoSession.put(idArticulo, valor);

					despachador = request.getRequestDispatcher("mostrarCarrito.do");

					break;
				case "/editarArticulo.do":
					int idArticuloEditar = Integer.parseInt(request.getParameter("idArticulo"));
					Articulo datosArticulo = modelo.getArticuloById(idArticuloEditar);
					request.setAttribute("articulo", datosArticulo);
					despachador = request.getRequestDispatcher("editarArticulo.jsp");
					break;
				case "/salvarArticulo.do":
					Articulo articulo = new Articulo();
					articulo.setId(Integer.parseInt(request.getParameter("idArticulo")));
					articulo.setNombre(request.getParameter("nombre"));
					articulo.setTipo(request.getParameter("tipo"));
					articulo.setPrecio(Double.parseDouble(request.getParameter("precio")));
					
					modelo.actualizar(articulo);
					
					despachador = request.getRequestDispatcher("mostrarArticulos.do");
					
					break;
				case "/nuevoArticulo.do":
					despachador = request.getRequestDispatcher("nuevoArticulo.jsp");
					break;
				case "/insertarArticulo.do":
					Articulo articuloNuevo = new Articulo();
					articuloNuevo.setNombre(request.getParameter("nombre"));
					articuloNuevo.setTipo(request.getParameter("tipo"));
					articuloNuevo.setPrecio(Double.parseDouble(request.getParameter("precio")));
					
					modelo.insertar(articuloNuevo);
					
					despachador = request.getRequestDispatcher("mostrarArticulos.do");
					
					break;
					
				case "/borrarArticulo.do":
					int idArticuloBorrado = Integer.parseInt(request.getParameter("idArticulo"));
					Articulo articuloBorrado = new Articulo(idArticuloBorrado);
					
					modelo.eliminar(articuloBorrado);
					
					despachador = request.getRequestDispatcher("mostrarArticulos.do");
					
					break;
				case "/volver.do":
					despachador = request.getRequestDispatcher("mostrarArticulos.do");
					break;
				case "/logout.do":
					request.getSession().removeAttribute("usuario");
					despachador = request.getRequestDispatcher("login.jsp");
					break;
				default:
					despachador = request.getRequestDispatcher("mostrarArticulos.do");
					break;
			}
			despachador.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
