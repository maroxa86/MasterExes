package articulos.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import articulos.beans.Articulo;
import articulos.beans.Usuario;

public class Modelo {

	private DataSource ds;
	
	public Modelo(DataSource ds) {
		this.ds = ds;
	}

	public void insertar(Articulo articulo) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String queryId = "select max(idArticulo) + 1 from articulo";
		String sql = "insert into articulo values(?,?,?,?)";
		
		try{
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(queryId);
			
			while(rs.next()){
				ps = conn.prepareStatement(sql);
				ps.setInt(1, rs.getInt(1));
				ps.setString(2, articulo.getNombre());
				ps.setString(3, articulo.getTipo());
				ps.setDouble(4, articulo.getPrecio());
				
				ps.execute();
			}
		}
		finally{
			if(ps != null){
				ps.close();
			}
			
			if(rs != null){
				rs.close();
			}
			
			if(stmt != null){
				stmt.close();
			}
			if(conn != null){
				conn.close();
			}
		}
	}
	
	public void actualizar(Articulo articulo) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		String query = "update articulo set nombre = ?, tipo = ?, precio = ? where idArticulo = ?";
	
		try{
			conn = ds.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, articulo.getNombre());
			ps.setString(2, articulo.getTipo());
			ps.setDouble(3, articulo.getPrecio());
			ps.setInt(4, articulo.getId());
			
			ps.execute();
		}
		finally{
			if(ps != null){
				ps.close();
			}
			if(conn != null){
				conn.close();
			}
		}
	}
	
	public void eliminar(Articulo articulo) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		String query = "delete from articulo where idArticulo = ?";
	
		try{
			conn = ds.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, articulo.getId());
			ps.execute();
		}
		finally{
			if(ps != null){
				ps.close();
			}
			if(conn != null){
				conn.close();
			}
		}
	}
	
	public List<Articulo> mostrarArticulos() throws SQLException{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Articulo> listadoArticulos = new ArrayList<>();
		
		try{
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select idArticulo, nombre, tipo, precio from articulo");
			
			while(rs.next()){
				Articulo articulo = new Articulo();
				articulo.setId(rs.getInt(1));
				articulo.setNombre(rs.getString(2));
				articulo.setTipo(rs.getString(3));
				articulo.setPrecio(rs.getDouble(4));
			
				listadoArticulos.add(articulo);
			}
		}
		finally{
			if(rs != null){
				rs.close();
			}
			
			if(stmt != null){
				stmt.close();
			}
			
			if(conn != null){
				stmt.close();
			}
		}
		
		
		return listadoArticulos;
	}

	public Articulo getArticuloById(Integer idArticulo) throws SQLException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Articulo articulo = null;
		
		try{
			conn = ds.getConnection();
			ps = conn.prepareStatement("select idArticulo, nombre, tipo, precio from articulo where idArticulo = ?");
			ps.setInt(1, idArticulo);
			rs = ps.executeQuery();
			
			while(rs.next()){
				articulo = new Articulo();
				articulo.setId(rs.getInt(1));
				articulo.setNombre(rs.getString(2));
				articulo.setTipo(rs.getString(3));
				articulo.setPrecio(rs.getDouble(4));
			}
		}
		finally{
			if(rs != null){
				rs.close();
			}
			
			if(ps != null){
				ps.close();
			}
			
			if(conn != null){
				conn.close();
			}
		}
		
		
		return articulo;
	}

	public Usuario getUsarioByLogin(String usuario, String password) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Usuario user = null;
		
		try{
			conn = ds.getConnection();
			ps = conn.prepareStatement("select usuario, rol from usuarios where usuario = ? and password = ?");
			ps.setString(1, usuario);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			while(rs.next()){
				user = new Usuario();
				user.setUsuario(rs.getString(1));
				user.setRol(rs.getString(2));
			}
		}
		finally{
			if(rs != null){
				rs.close();
			}
			
			if(ps != null){
				ps.close();
			}
			
			if(conn != null){
				conn.close();
			}
		}

		return user;
	}
}
