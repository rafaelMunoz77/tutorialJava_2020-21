package tutorialJava.capitulo7_Acceso_A_Datos.gestionVentaCoches.modelo.controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class ControladorBBDD {

	protected static SimpleDateFormat sdfMySQL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	protected static void iniciaConnectionPool () {
		Thread conexionUCP = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					ConnectionManagerV2.getConexion();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ImposibleConectarException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		conexionUCP.start();			
	}
	
	
	
	
	/**
	 * 
	 * @param conn
	 * @param tabla
	 * @return
	 * @throws SQLException
	 */ 
	protected static int nextIdEnTabla (Connection conn, String tabla) throws SQLException {
		return maxIdEnTabla(conn, tabla) + 1;
	}
	
	
	
	/**
	 * 
	 * @param conn
	 * @param tabla
	 * @return
	 * @throws SQLException
	 */
	protected static int maxIdEnTabla (Connection conn, String tabla) throws SQLException {
		
		PreparedStatement ps = conn.prepareStatement("select max(id) from " + tabla);

		int max = 1; 
		if (ps != null) {
			ResultSet rs = ps.executeQuery();

			if (rs.next() ) {
				max = rs.getInt(1);
			}
			rs.close();
		}
		
		return max;
	}
	


	/**
	 * @throws ErrorBBDDException 
	 * 
	 */
	protected static int eliminarTodoEnTabla () throws ErrorBBDDException {
		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			Statement s = conn.createStatement();
			int registrosModificados = s.executeUpdate("delete from " + JDBCPropiedades.getProperty("JDBC_SCHEMA_NAME") + ".actor");
			s.close();
			return registrosModificados;
			
		} catch (SQLException | ImposibleConectarException e) {			
			throw new ErrorBBDDException(e);
		}

	}
	
	

}
