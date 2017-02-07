package carritoCompra.listener;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import carritoCompra.modelo.Modelo;


@WebListener
public class DataSourceCarrito implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		Context initContext = null;
		try {
			initContext = new InitialContext();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	    DataSource ds = null;
		try {
			ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/carrito");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		Modelo modelo = new Modelo(ds);
		sce.getServletContext().setAttribute("modelo", modelo);
	}

}
