package carritoCompra.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class Modelo {
	private DataSource ds;
	
	public Modelo(DataSource ds) {
		this.ds = ds;
	}
			
	public List<String> getListadoProductos(){
		Connection conn = null;
		Statement stmt = null;
		List<String> listadoProductos = new ArrayList<>();
		try {
			conn = ds.getConnection();
			String query = "select producto from productos";
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				listadoProductos.add(rs.getString(1));
			}
		} catch (SQLException e) {
			System.err.println("Error al insertar un producto");
		}
		finally{
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					System.err.println("Error al cerrar el statement del insertar de un producto");
				}
			}
			
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.println("Error al cerrar la conexion del insertar de un producto");
				}
			}
			
		}
		
		return listadoProductos;
	}
	
}
