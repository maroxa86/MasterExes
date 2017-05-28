package ejercicio3.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.apache.struts2.ServletActionContext;

public class GenericDAOImpl implements GenericDAO {

	DataSource dataSource = null;

	public Connection getConnection() throws SQLException {
		ServletContext servletContext = ServletActionContext.getServletContext();
		if (dataSource == null) {
			dataSource = (DataSource) servletContext.getAttribute("dataSource");
		}
		Connection connection = null;
		if (dataSource != null) {
			try {
				connection = dataSource.getConnection();
			} catch (SQLException e) {
				throw new SQLException("Error al obtener el dataSource", e);
			}
		}

		// devolver la conexión
		return connection;
	}

	// Posicionar una dataSource
	public void setConnection(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void closeResultSet(ResultSet rs) throws SQLException {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new SQLException("Error al cerrar el ResultSet", e);
			}
		}
	}

	public void closeStatement(Statement stmt) throws SQLException {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				throw new SQLException("Error al cerrar el Statement", e);
			}
		}
	}

	public void closeConnection(Connection conn) throws SQLException {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new SQLException("Error al cerrar la conexión", e);
			}
		}
	}

}
