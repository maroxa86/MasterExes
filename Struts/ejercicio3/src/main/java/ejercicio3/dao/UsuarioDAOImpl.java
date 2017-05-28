package ejercicio3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ejercicio3.beans.Usuario;

public class UsuarioDAOImpl extends GenericDAOImpl implements UsuarioDAO {

	@Override
	public Usuario getUsuario(String usuario) throws Exception {

		// Variables
		PreparedStatement consulta = null;
		Usuario user = null;
		String consultaString = null;

		Connection conexion = null;
		ResultSet resultado = null;
		try {
			// Apertura de una conexión
			conexion  = super.getConnection();

			// Creación de la consulta
			consultaString = "SELECT * FROM usuarios WHERE usuario=?";

			// Se prepara la consulta

			consulta = conexion.prepareStatement(consultaString);
			consulta.setString(1, usuario);

			// Ejecución de la consulta
			resultado  = consulta.executeQuery();

			// Se almacena el resultado en el objeto cliente
			if (resultado != null) {
				if (resultado.next()) {
					user = new Usuario();
					user.setUsuario(resultado.getString("usuario"));
					user.setPassword(resultado.getString("password"));
				}
			}
		} catch (Exception e) {
			System.out.println("Error al realizar la consulta");
			throw new Exception("Error al realizar la consulta para buscar el usuario", e);
		} finally {
			try {
				// Cierre de la conexión
				if (resultado != null) {
					super.closeResultSet(resultado);
				}
				if (consulta != null) {
					super.closeStatement(consulta);
				}
				if (conexion != null) {
					super.closeConnection(conexion);
				}
			} catch (Exception ex) {
				System.out.println("Error en el cierre de la conexión");
				throw new Exception("Error en el cierre de la conexión", ex);
			}
		}

		return user;
	}

	@Override
	public void saveUsuario(Usuario usuario) throws Exception {
		// Variables
		PreparedStatement consulta = null;
		String consultaString = null;

		Connection conexion = null;
		try {
			// Apertura de una conexión
			conexion  = super.getConnection();

			// Creación de la consulta
			consultaString = "UPDATE USUARIOS SET NOMBRE = ?, APELLIDOS = ?, TELEFONO = ?, FECHA_NACIMIENTO = TO_DATE(?,'DD/MM/YYYY'), SUELDO = ?, NUM_HIJOS = ? WHERE USUARIO = ?";

			// Se prepara la consulta
			consulta = conexion.prepareStatement(consultaString);
			consulta.setString(1, usuario.getNombre());
			consulta.setString(2, usuario.getApellidos());
			consulta.setInt(3, usuario.getTelefono());
			consulta.setString(4, usuario.getFechaNacimiento().toString());
			consulta.setInt(5, usuario.getSueldo());
			consulta.setInt(6, usuario.getNumHijos());
			consulta.setString(7, usuario.getUsuario());

			// Ejecución de la consulta
			consulta.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error al realizar la consulta");
			throw new Exception("Error al realizar la consulta para buscar el usuario", e);
		} finally {
			try {
				if (consulta != null) {
					super.closeStatement(consulta);
				}
				if (conexion != null) {
					super.closeConnection(conexion);
				}
			} catch (Exception ex) {
				System.out.println("Error en el cierre de la conexión");
				throw new Exception("Error en el cierre de la conexión", ex);
			}
		}
	}

}
