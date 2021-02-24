package tutorialJava.capitulo7_Acceso_A_Datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;

import java.sql.PreparedStatement;

import tutorialJava.Utils;

public class Ejemplo05_CreacionDatosEnEsquemaPreparedStatement {

	private static String tablas[] = new String[] {"venta", "concesionario", "cliente", "coche", "fabricante"};
	private static String nombres[] = new String[] {"Eva", "Juan", "Carmen", "Pablo", "Rafa", "Pilar", "Pedro", 
			"Lola", "Casimiro", "Gertrudis", "Eustaquio", "Gerarda", "Nepomunosio", "Argimira", "Ascensio", "Baltasara", "Baudilio", "Bernabea"};
	private static String apellidos[] = new String[] {"Gonzalez", "Lopez", "Gutierrez", "Ruiz", "Jurado", "Carrasco", "Flores", 
			"Sanchez", "Bose", "Martin", "Martinez", "Santos", "Pozo", "Quijano", "Romero", "Pisano", "Cuevas", "Sanz"};
	private static String tiposEmpresas[] = new String[] {"Hermanos", "Sociedad", "Concesionario", "Coches de"};
	private static String localidades[] = new String[] {"Lucena", "Cabra", "Priego de Cordoba", "Puente Genil", "Benameji", "Palenciana"};
	private static String fabricantes[] = new String[] {"Renault", "Citroen", "Peugeot", "Dacia", "Kia", "Hyundai", "Honda"};
	private static String colores[] = new String[] {"Blanco", "Negro", "Azul", "Rojo", "Verde", "Amarillo", "Gris"};
	private static String abecedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
	private static int CONT_NOTIFICACION_INSERCION = 10;
	private static int REGISTROS_A_INSERTAR_EN_CONCESIONARIO = 20;
	private static int REGISTROS_A_INSERTAR_EN_CLIENTE = 200;
	private static int REGISTROS_A_INSERTAR_EN_COCHE = 200;
	private static boolean LOG = true;
	
	private static Hashtable<String, PreparedStatement> psMaxIdsEnTabla;
	
	
	
	/**
	 * 
	 * @param conn
	 * @throws SQLException
	 */
	private static void vaciarTablas (Connection conn) throws SQLException {
		Statement s = (Statement) conn.createStatement();
		
		if (LOG)
			System.out.println("Eliminando los registros de todas las tablas");
		
		for (String tabla : tablas) {
			int registrosAfectados = s.executeUpdate("delete from tutorialjavacoches." + tabla);
			if (LOG)
				System.out.println("\t" + registrosAfectados + " registros eliminados en la tabla " + tabla);
		}
		s.close();
	}
	
	
	/**
	 * @throws ImposibleConectarException 
	 * @throws SQLException 
	 * 
	 */
	private static void creacionDatosConcesionario (Connection conn) throws SQLException, ImposibleConectarException {
		PreparedStatement ps = (PreparedStatement) conn.
				prepareStatement("INSERT INTO tutorialjavacoches.concesionario (id, cif, nombre, localidad) VALUES  (?, ?, ?, ?)");
		int registrosInsertados;
		int contRegistrosInsertados = 0;		
		
		if (LOG)
			System.out.println("\nInsertando registros de en la tabla concesionario");

		for (int i = 0; i < REGISTROS_A_INSERTAR_EN_CONCESIONARIO; i++) {
			
			ps.setInt(1, nextIdEnTabla(conn, "concesionario"));
			ps.setString(2, getDNICIFAzar());
			ps.setString(3, getStringAlAzar(tiposEmpresas) + " " + getStringAlAzar(apellidos));
			ps.setString(4, getStringAlAzar(localidades));
			
			registrosInsertados = ps.executeUpdate();
			if (registrosInsertados != 1) {
				throw new SQLException ("No ha sido posible la inserciï¿½n en concesionario");
			}
			contRegistrosInsertados++;
			if (contRegistrosInsertados % CONT_NOTIFICACION_INSERCION == 0 && LOG) {
				System.out.println("\t" + contRegistrosInsertados + " registros insertados en tabla concesionario");
			}
		}
		ps.close();
	}
	
	
	/**
	 * @throws ImposibleConectarException 
	 * @throws SQLException 
	 * 
	 */
	private static void creacionDatosCliente (Connection conn) throws SQLException, ImposibleConectarException {
		PreparedStatement ps = (PreparedStatement) conn.
				prepareStatement("INSERT INTO tutorialjavacoches.cliente (id, nombre, apellidos, localidad, dniNie, fechaNac, activo) VALUES  (?, ?, ?, ?, ?, ?, ?)");
		int registrosInsertados;
		int contRegistrosInsertados = 0;		
		
		if (LOG)
			System.out.println("\nInsertando registros de en la tabla cliente");

		for (int i = 0; i < REGISTROS_A_INSERTAR_EN_CLIENTE; i++) {
			
			ps.setInt(1, nextIdEnTabla(conn, "cliente"));
			ps.setString(2, getStringAlAzar(nombres));
			ps.setString(3, getStringAlAzar(apellidos) + " " + getStringAlAzar(apellidos));
			ps.setString(4, getStringAlAzar(localidades));
			ps.setString(5, getDNICIFAzar());
			ps.setDate(6, getFechaAzar(1960, 2000));
			ps.setBoolean(7, true);

			
			registrosInsertados = ps.executeUpdate();
			if (registrosInsertados != 1) {
				throw new SQLException ("No ha sido posible la inserciï¿½n en cliente");
			}
			contRegistrosInsertados++;
			if (contRegistrosInsertados % CONT_NOTIFICACION_INSERCION == 0 && LOG) {
				System.out.println("\t" + contRegistrosInsertados + " registros insertados en tabla cliente");
			}
		}
		ps.close();
	}
	
	
	
	/**
	 * @throws ImposibleConectarException 
	 * @throws SQLException 
	 * 
	 */
	private static void creacionDatosFabricantes (Connection conn) throws SQLException, ImposibleConectarException {
		PreparedStatement ps = (PreparedStatement) conn.
				prepareStatement("INSERT INTO tutorialjavacoches.fabricante (id, cif, nombre) VALUES  (?, ?, ?)");
		int registrosInsertados;
		int contRegistrosInsertados = 0;		
		
		if (LOG)
			System.out.println("\nInsertando registros de en la tabla fabricante");

		for (int i = 0; i < fabricantes.length; i++) {

			ps.setInt(1, nextIdEnTabla(conn, "fabricante"));
			ps.setString(2, getDNICIFAzar());
			ps.setString(3, fabricantes[i]);
			
			registrosInsertados = ps.executeUpdate();
			if (registrosInsertados != 1) {
				throw new SQLException ("No ha sido posible la inserciï¿½n en fabricante");
			}
			contRegistrosInsertados++;
			if (contRegistrosInsertados % CONT_NOTIFICACION_INSERCION == 0 && LOG) {
				System.out.println("\t" + contRegistrosInsertados + " registros insertados en tabla fabricante");
			}
		}
		ps.close();
	}
	
	
	
	/**
	 * @throws ImposibleConectarException 
	 * @throws SQLException 
	 * 
	 */
	private static void creacionDatosCoches (Connection conn) throws SQLException, ImposibleConectarException {
		PreparedStatement ps = (PreparedStatement) conn.
				prepareStatement("INSERT INTO tutorialjavacoches.coche (id, idFabricante, bastidor, modelo, color) VALUES  (?, ?, ?, ?, ?)");
		int registrosInsertados;
		int contRegistrosInsertados = 0;		
		
		if (LOG)
			System.out.println("\nInsertando registros de en la tabla coche");

		for (int i = 0; i < REGISTROS_A_INSERTAR_EN_COCHE; i++) {
			
			ps.setInt(1, nextIdEnTabla(conn, "coche"));
			ps.setInt(2, getIdAzarEnTabla(conn, "fabricante"));
			ps.setString(3, getBastidorAzar());
			ps.setString(4, getModeloCoche());
			ps.setString(5, getStringAlAzar(colores));

			registrosInsertados = ps.executeUpdate();
			if (registrosInsertados != 1) {
				throw new SQLException ("No ha sido posible la inserciï¿½n en coche");
			}
			contRegistrosInsertados++;
			if (contRegistrosInsertados % CONT_NOTIFICACION_INSERCION == 0 && LOG) {
				System.out.println("\t" + contRegistrosInsertados + " registros insertados en tabla coche");
			}
		}
		ps.close();
	}
	
	
	
	
	/**
	 * @throws ImposibleConectarException 
	 * @throws SQLException 
	 * 
	 */
	private static void creacionDatosVentas (Connection conn) throws SQLException, ImposibleConectarException {
		PreparedStatement ps = (PreparedStatement) conn.
				prepareStatement("INSERT INTO tutorialjavacoches.venta (id, idCliente, idConcesionario, idCoche, fecha, precioVenta) VALUES  (?, ?, ?, ?, ?, ?)");
		int registrosInsertados;
		int contRegistrosInsertados = 0;		
		
		if (LOG)
			System.out.println("\nInsertando registros de en la tabla venta");
		
		ArrayList<Integer> idsClientes = getIdsEnTabla(conn, "cliente");
		ArrayList<Integer> idsCoches = getIdsEnTabla(conn, "coche");

		for (int i = 0; i < idsClientes.size(); i++) {

			ps.setInt(1, nextIdEnTabla(conn, "venta"));
			ps.setInt(2, idsClientes.get(i));
			ps.setInt(3, getIdAzarEnTabla(conn, "concesionario"));
			ps.setInt(4, idsCoches.get(i));
			ps.setDate(5, (java.sql.Date) getFechaAzar(2000, 2018));
			ps.setFloat(6, getPrecioAzar(1500, 45000));

			registrosInsertados = ps.executeUpdate();
			if (registrosInsertados != 1) {
				throw new SQLException ("No ha sido posible la inserciï¿½n en venta");
			}
			contRegistrosInsertados++;
			if (contRegistrosInsertados % CONT_NOTIFICACION_INSERCION == 0 && LOG) {
				System.out.println("\t" + contRegistrosInsertados + " registros insertados en tabla venta");
			}
		}
		ps.close();
	}
	
	
	
	
	/**
	 * 
	 * @param conn
	 * @param tabla
	 * @return
	 * @throws SQLException
	 */
	private static int getIdAzarEnTabla (Connection conn, String tabla) throws SQLException {
		int maxIdFabricante = maxIdEnTabla(conn, tabla);
		int idFabricanteAzar;
		
		Statement s = (Statement) conn.createStatement();
		ResultSet rs;
		do {
			idFabricanteAzar = Utils.obtenerNumeroAzar(1, maxIdFabricante);
			rs = s.executeQuery("select * from tutorialjavacoches." + tabla + " where id = " + idFabricanteAzar);
		} while (!rs.next());
		
		rs.close();
		s.close();
		return idFabricanteAzar;
	}


	
	/**
	 * 
	 * @param conn
	 * @param tabla
	 * @return
	 * @throws SQLException
	 */
	private static ArrayList<Integer> getIdsEnTabla (Connection conn, String tabla) throws SQLException {
		ArrayList<Integer> ids = new ArrayList<Integer>();
		
		Statement s = (Statement) conn.createStatement();
		ResultSet rs;
		rs = s.executeQuery("select id from tutorialjavacoches." + tabla + " order by id");
		
		while (rs.next()) {
			ids.add(rs.getInt(1));
		}
		
		rs.close();
		s.close();
		return ids;
	}

	
	
	/**
	 * 
	 * @return
	 */
	private static Date getFechaAzar (int anioMin, int anioMax) {
		Calendar calendar = new GregorianCalendar(Utils.obtenerNumeroAzar(anioMin, anioMax) /*aï¿½o*/, Utils.obtenerNumeroAzar(0, 11) /*mes*/, Utils.obtenerNumeroAzar(1, 31) /*dï¿½a*/, 
				Utils.obtenerNumeroAzar(0, 23) /*hora*/, Utils.obtenerNumeroAzar(0, 59) /*minuto*/, Utils.obtenerNumeroAzar(0, 59) /*segundo*/);
	
		return new Date(calendar.getTimeInMillis());
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	private static String getModeloCoche () {
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < 2; i++) {
			sb.append(abecedario.charAt(Utils.obtenerNumeroAzar(0, abecedario.length()-1)));
		}
		for (int i = 0; i < 2; i++) {
			sb.append(Utils.obtenerNumeroAzar(0, 9));
		}
		
		return sb.toString();
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	private static String getDNICIFAzar () {
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < 8; i++) {
			sb.append(Utils.obtenerNumeroAzar(0, 9));
		}
		sb.append(abecedario.charAt(Utils.obtenerNumeroAzar(0, abecedario.length()-1)));
		
		return sb.toString();
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	private static String getBastidorAzar () {
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < 17; i++) {
			sb.append(Utils.obtenerNumeroAzar(0, 9));
		}
		
		return sb.toString();
	}
	
	
	
	/**
	 * 
	 * @param strings
	 * @return
	 */
	private static String getStringAlAzar (String strings[]) {
		return strings[Utils.obtenerNumeroAzar(0, strings.length - 1)];
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	private static float getPrecioAzar (int min, int max) {
		return (float) (Utils.obtenerNumeroAzar(min, max-1) + (Utils.obtenerNumeroAzar(0, 99) / 100.0));
	}
	
	
	
	/**
	 * 
	 * @param conn
	 * @param tabla
	 * @return
	 * @throws SQLException
	 */
	private static int nextIdEnTabla (Connection conn, String tabla) throws SQLException {
		return maxIdEnTabla(conn, tabla) + 1;
	}
	
	
	
	/**
	 * 
	 * @param conn
	 * @param tabla
	 * @return
	 * @throws SQLException
	 */
	private static int maxIdEnTabla (Connection conn, String tabla) throws SQLException {
		
		PreparedStatement ps = psMaxIdsEnTabla.get(tabla);

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
	 * 
	 * @param conn
	 * @throws SQLException 
	 */
	private static void inicializaPreparedStatementConsultas (Connection conn) throws SQLException {
		psMaxIdsEnTabla = new Hashtable<String, PreparedStatement>();
		psMaxIdsEnTabla.put("concesionario", conn.prepareStatement("select max(id) from tutorialjavacoches.concesionario"));
		psMaxIdsEnTabla.put("cliente", conn.prepareStatement("select max(id) from tutorialjavacoches.cliente"));
		psMaxIdsEnTabla.put("fabricante", conn.prepareStatement("select max(id) from tutorialjavacoches.fabricante"));
		psMaxIdsEnTabla.put("coche", conn.prepareStatement("select max(id) from tutorialjavacoches.coche"));
		psMaxIdsEnTabla.put("venta", conn.prepareStatement("select max(id) from tutorialjavacoches.venta"));
	}
	
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Connection conn = null;

		try {
			long startTime = new java.util.Date().getTime();
			
			conn = ConnectionManagerV2.getConexion();
			
			// Con este método evitamos que se haga un commit en cada update que se ejecuta sobre la BBDD
			conn.setAutoCommit(false);
			
			inicializaPreparedStatementConsultas(conn);
			
			// Limpieza en las tablas
			vaciarTablas(conn);
			// Datos de concesionarios
			creacionDatosConcesionario(conn);
			// Datos de clientes
			creacionDatosCliente(conn);
			// Datos de fabricantes
			creacionDatosFabricantes(conn);
			// Datos de coches
			creacionDatosCoches(conn);
			// Datos de venta
			creacionDatosVentas(conn);
			
			// Si llegamos hasta esta línea es porque todo se ha ejecutado correctamente, debemos hacer permanentes
			// los cambios en la BBDD
			conn.commit();
			
			long usedMillis = new java.util.Date().getTime() - startTime;
			int secs = (int) (usedMillis/1000);
			System.out.println("\nProceso terminado en " + secs + " segundos y " + (usedMillis - secs * 1000) + " milisegundos");
			
		} catch (SQLException | ImposibleConectarException e) {
			// Si estamos en este punto es porque ha existido un problema en la actualización de alguno de los datos, en ese
			// momento debemos hacer una vuelta al estado anterior, a través del método "rollback()".
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println("Imposible hacer rollback");
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}

	}

}
