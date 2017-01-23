import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {

	private static Connection conn = null;

	public static void main(String[] args) {

		try {
			conn = DriverManager.getConnection("jdbc:derby:ejercicio11;create=true");
			// creacionTabla();
			// insertarDatos();
			visualizarDatos();
			comparativaEjecuciones();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void comparativaEjecuciones() throws SQLException {
		long tiempoEjecucionPS_Start = System.currentTimeMillis();
		ejecutarPreparedStatement();
		long tiempoEjecucionPS_End = System.currentTimeMillis();
		long tiempoEjecucionS_Start = System.currentTimeMillis();
		ejecutarStatement();
		long tiempoEjecucionS_End = System.currentTimeMillis();
		
		long tiempoTotalPS = tiempoEjecucionPS_End - tiempoEjecucionPS_Start;
		long tiempoTotalS = tiempoEjecucionS_End - tiempoEjecucionS_Start;
		
		System.out.println("Tiempo Ejecución PreparedStatement: " + tiempoTotalPS);
		System.out.println("Tiempo Ejecución Statement: " + tiempoTotalS);
		
		if(tiempoTotalPS < tiempoTotalS){
			System.out.println("La ejecución de preparedStatement es más eficiente");
		}
		else{
			if(tiempoTotalPS > tiempoTotalS){
				System.out.println("La ejecución de Statement es más eficiente");
			}
			else{
				System.out.println("No hay diferencia entre una ejecución o otra");
			}
		}
	}

	private static void ejecutarStatement() throws SQLException {
		System.out.println("=================================================");
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsm;
		try {
			stmt = conn.createStatement();
			int i = 1;
			while (i <= 100) {
				System.out.println("Iteracion " + i);
				String sql1 = "select * from tabla where COL2 = 1";
				String sql2 = "select * from tabla where COL2 = 2";
				
				if(i % 2 == 0){
					rs = stmt.executeQuery(sql2);
				}
				else{
					rs = stmt.executeQuery(sql1);
				}

				System.out.println("Hola: " + stmt.getQueryTimeout());

				while (rs.next()) {
					rsm = rs.getMetaData();

					System.out.print(rsm.getColumnLabel(1) + "\t\t");
					System.out.print(rsm.getColumnLabel(2) + "\t");
					System.out.print(rsm.getColumnLabel(3) + "\t");
					System.out.print(rsm.getColumnLabel(4) + "\n");

					System.out.print(rs.getString(1) + "\t");
					System.out.print(rs.getString(1) + "\t");
					System.out.print(rs.getInt(2) + "\t");
					System.out.print(rs.getBoolean(3) + "\t");
					System.out.print(rs.getDate(4) + "\n");

					System.out.println();
				}
				
				i++;
			}
		} finally {

			if (rs != null) {
				rs.close();
			}

			if (stmt != null) {
				stmt.close();
			}
		}
	}

	private static void ejecutarPreparedStatement() throws SQLException {
		System.out.println("===========================================");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsm;

		try {
			String sql = "select * from tabla where COL2=?";
			pstmt = conn.prepareStatement(sql);
			int i = 1;
			while (i <= 100) {
				System.out.println("Iteracion " + i);
				if (i % 2 == 0) {
					pstmt.setInt(1, 2);
				} else {
					pstmt.setInt(1, 1);
				}

				rs = pstmt.executeQuery();

				while (rs.next()) {
					rsm = rs.getMetaData();

					System.out.print(rsm.getColumnLabel(1) + "\t\t");
					System.out.print(rsm.getColumnLabel(2) + "\t");
					System.out.print(rsm.getColumnLabel(3) + "\t");
					System.out.print(rsm.getColumnLabel(4) + "\n");

					System.out.print(rs.getString(1) + "\t");
					System.out.print(rs.getInt(2) + "\t");
					System.out.print(rs.getBoolean(3) + "\t");
					System.out.print(rs.getDate(4) + "\n");

					System.out.println();
				}

				i++;
			}
		} finally {

			if (rs != null) {
				rs.close();
			}

			if (pstmt != null) {
				pstmt.close();
			}
		}
	}

	private static void visualizarDatos() throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsm;
		try {
			stmt = conn.createStatement();
			String sql = "select * from tabla";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				rsm = rs.getMetaData();

				System.out.print(rsm.getColumnLabel(1) + "\t\t");
				System.out.print(rsm.getColumnLabel(2) + "\t");
				System.out.print(rsm.getColumnLabel(3) + "\t");
				System.out.print(rsm.getColumnLabel(4) + "\n");

				System.out.print(rs.getString(1) + "\t");
				System.out.print(rs.getInt(2) + "\t");
				System.out.print(rs.getBoolean(3) + "\t");
				System.out.print(rs.getDate(4) + "\n");

				System.out.println();
			}
		} finally {

			if (rs != null) {
				rs.close();
			}

			if (stmt != null) {
				stmt.close();
			}
		}
	}

	private static void insertarDatos() throws SQLException {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String sql1 = "insert into tabla(col1, col2, col3, col4) values" + "('REGISTRO'," + 1 + "," + true
					+ ",DATE('05/05/2012'))";
			stmt.execute(sql1);
			String sql2 = "insert into tabla(col1, col2, col3, col4) values" + "('REGISTRO'," + 2 + "," + false
					+ ", DATE('04/04/2014'))";
			stmt.execute(sql2);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}

	private static void creacionTabla() throws SQLException {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String sql = "create table tabla(" + "col1 VARCHAR(50)," + "col2 INT," + "col3 BOOLEAN," + "col4  DATE)";
			stmt.execute(sql);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}
}
