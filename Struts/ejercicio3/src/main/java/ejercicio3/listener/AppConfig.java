package ejercicio3.listener;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

public class AppConfig implements ServletContextListener {

	Context context = null;

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		try {
			if (context != null) {
				context.close();
			}
		} catch (Exception e) {
			System.out.println("¡Error en al destruir el contexto!");
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		String dataSource = servletContext.getInitParameter("dataSource");

		try {
			context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(dataSource);
			if (ds == null) {
				System.out.println("No se encuentra el dataSource");
			}
			servletContext.setAttribute("dataSource", ds);
		} catch (NamingException e) {
			throw new RuntimeException();
		} finally {
			try {
				if (context != null) {
					context.close();
				}
			} catch (Exception e) {
				System.out.println("¡Error en al finalizar el contexto!");
			}
		}
	}

}
