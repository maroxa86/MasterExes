package articulos.filtros;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import articulos.beans.Usuario;
import articulos.modelo.Modelo;

/**
 * Servlet Filter implementation class ValidacionUsuarios
 */
public class ValidacionUsuarios implements Filter {

	private Modelo modelo;
    /**
     * Default constructor. 
     */
    public ValidacionUsuarios() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		Usuario user = (Usuario)session.getAttribute("usuario");
		
		try {
			if(user == null){
				ServletContext application = request.getServletContext();
				String usuario = req.getParameter("usuario");
				String password = req.getParameter("password");
				
				if(usuario == null || password == null){
					request.setAttribute("error", "accesoProhibido");
					application.getRequestDispatcher("/login.jsp").forward(request, response);
				}
				
				Usuario usuarioLogin = modelo.getUsarioByLogin(usuario, password);
				
				if(usuarioLogin == null){
					request.setAttribute("error", "loginInvalido");
					application.getRequestDispatcher("/login.jsp").forward(request, response);
				}
				else{
					session.setAttribute("usuario", usuarioLogin);
					chain.doFilter(request, response);
				}
			}
			else{
				chain.doFilter(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		modelo = (Modelo) fConfig.getServletContext().getAttribute("modelo");
	}

}
