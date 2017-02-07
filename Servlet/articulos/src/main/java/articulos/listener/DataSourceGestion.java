package articulos.listener;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import articulos.modelo.Modelo;

public class DataSourceGestion implements ServletContextListener{

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
			ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/articulo");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	    
		Modelo modelo = new Modelo(ds);
		sce.getServletContext().setAttribute("modelo", modelo);
	}
}
