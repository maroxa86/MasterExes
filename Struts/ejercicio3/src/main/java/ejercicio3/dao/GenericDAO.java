package ejercicio3.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface GenericDAO {
	
	public Connection getConnection() throws SQLException;
	public void closeResultSet(ResultSet rs) throws SQLException;
	public void closeStatement(Statement stmt) throws SQLException;
	public void closeConnection(Connection conn) throws SQLException;
}
