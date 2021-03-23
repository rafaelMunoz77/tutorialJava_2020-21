package tutorialJava.capitulo7_Acceso_A_Datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import tutorialJava.Utils;

public class Ejemplo04_CreacionDatosEnEsquema {

	private static String tablas[] = new String[] {"venta", "concesionario", "cliente", "coche", "fabricante"};
	private static String nombres[] = new String[] {"Eva", "Juan", "Carmen", "Pablo", "Rafa", "Pilar", "Pedro", 
			"Lola", "Casimiro", "Gertrudis", "Eustaquio", "Gerarda", "Nepomunosio", "Argimira", "Ascensio", "Baltasara", "Baudilio", "Bernabea"};
	private static String apellidos[] = new String[] {"Gonzalez", "Lopez", "Gutierrez", "Ruiz", "Jurado", "Carrasco", "Flores", 
			"Sanchez", "Bose", "Martin", "Martinez", "Santos", "Pozo", "Quijano", "Romero", "Pisano", "Cuevas", "Sanz"};
	private static String tiposEmpresas[] = new String[] {"Hermanos", "Sociedad", "Concesionario", "Coches de"};
	private static String localidades[] = new String[] {"Lucena", "Cabra", "Priego de Cordoba", "Puente Genil", "Benameji", "Palenciana","Baena","Albendin", "Moriles", "Rute", "Aguilar de la Frontera"};
	private static String fabricantes[] = new String[] {"Renault", "Citroen", "Peugeot", "Dacia", "Kia", "Hyundai", "Honda"};
	private static String colores[] = new String[] {"Blanco", "Negro", "Azul", "Rojo", "Verde", "Amarillo", "Gris"};
	private static String abecedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
	private static SimpleDateFormat sdfFechaNacimiento = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static int CONT_NOTIFICACION_INSERCION = 10;
	private static int REGISTROS_A_INSERTAR_EN_CONCESIONARIO = 20;
	private static int REGISTROS_A_INSERTAR_EN_CLIENTE = 200;
	private static int REGISTROS_A_INSERTAR_EN_COCHE = 200;
	private static boolean LOG = true;
	
	
	
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
		Statement s = (Statement) conn.createStatement();
		int registrosInsertados;
		int contRegistrosInsertados = 0;		
		
		if (LOG)
			System.out.println("\nInsertando registros de en la tabla concesionario");

		for (int i = 0; i < REGISTROS_A_INSERTAR_EN_CONCESIONARIO; i++) {
			String empresa = getStringAlAzar(tiposEmpresas) + " " + getStringAlAzar(apellidos);
			String sql = "INSERT INTO tutorialjavacoches.concesionario (id, cif, nombre, localidad) " +
					"VALUES  (" + nextIdEnTabla(conn, "concesionario") + ", '" + getDNICIFAzar() + "', '" + empresa + "', '" + getStringAlAzar(localidades) + "')";
			registrosInsertados = s.executeUpdate(sql);
			if (registrosInsertados != 1) {
				throw new SQLException ("No ha sido posible la inserci�n con la cadena:\n" + sql);
			}
			contRegistrosInsertados++;
			if (contRegistrosInsertados % CONT_NOTIFICACION_INSERCION == 0 && LOG) {
				System.out.println("\t" + contRegistrosInsertados + " registros insertados en tabla concesionario");
			}
		}
		s.close();
	}
	
	
	/**
	 * @throws ImposibleConectarException 
	 * @throws SQLException 
	 * 
	 */
	private static void creacionDatosCliente (Connection conn) throws SQLException, ImposibleConectarException {
		Statement s = (Statement) conn.createStatement();
		int registrosInsertados;
		int contRegistrosInsertados = 0;		
		
		if (LOG)
			System.out.println("\nInsertando registros de en la tabla cliente");

		for (int i = 0; i < REGISTROS_A_INSERTAR_EN_CLIENTE; i++) {
			String nombre = getStringAlAzar(nombres);
			String ape = getStringAlAzar(apellidos) + " " + getStringAlAzar(apellidos);
			String localidad = getStringAlAzar(localidades);
			String dni = getDNICIFAzar();
			String fechaNac = getFechaAzar(1960, 2000, sdfFechaNacimiento);
			
			String sql = "INSERT INTO tutorialjavacoches.cliente (id, nombre, apellidos, localidad, dniNie, fechaNac, activo) " +
					"VALUES  (" + nextIdEnTabla(conn, "cliente") + ", '" + nombre + "', '" + ape + "', '" + localidad + "', "
							+ "'" + dni + "', '" + fechaNac + "', true)";
			registrosInsertados = s.executeUpdate(sql);
			if (registrosInsertados != 1) {
				throw new SQLException ("No ha sido posible la inserci�n con la cadena:\n" + sql);
			}
			contRegistrosInsertados++;
			if (contRegistrosInsertados % CONT_NOTIFICACION_INSERCION == 0 && LOG) {
				System.out.println("\t" + contRegistrosInsertados + " registros insertados en tabla cliente");
			}
		}
		s.close();
	}
	
	
	
	/**
	 * @throws ImposibleConectarException 
	 * @throws SQLException 
	 * 
	 */
	private static void creacionDatosFabricantes (Connection conn) throws SQLException, ImposibleConectarException {
		Statement s = (Statement) conn.createStatement();
		int registrosInsertados;
		int contRegistrosInsertados = 0;		
		
		if (LOG)
			System.out.println("\nInsertando registros de en la tabla fabricante");

		for (int i = 0; i < fabricantes.length; i++) {
			String cif = getDNICIFAzar();
			
			String sql = "INSERT INTO tutorialjavacoches.fabricante (id, cif, nombre) " +
					"VALUES  (" + nextIdEnTabla(conn, "fabricante") + ", '" + cif + "', '" + fabricantes[i] + "')";
			registrosInsertados = s.executeUpdate(sql);
			if (registrosInsertados != 1) {
				throw new SQLException ("No ha sido posible la inserci�n con la cadena:\n" + sql);
			}
			contRegistrosInsertados++;
			if (contRegistrosInsertados % CONT_NOTIFICACION_INSERCION == 0 && LOG) {
				System.out.println("\t" + contRegistrosInsertados + " registros insertados en tabla fabricante");
			}
		}
		s.close();
	}
	
	
	
	/**
	 * @throws ImposibleConectarException 
	 * @throws SQLException 
	 * 
	 */
	private static void creacionDatosCoches (Connection conn) throws SQLException, ImposibleConectarException {
		Statement s = (Statement) conn.createStatement();
		int registrosInsertados =0;
		int contRegistrosInsertados = 0;		
		
		if (LOG)
			System.out.println("\nInsertando registros de en la tabla coche");

		for (int i = 0; i < REGISTROS_A_INSERTAR_EN_COCHE; i++) {
			int idFabricante = getIdAzarEnTabla(conn, "fabricante");
			String bastidor = getBastidorAzar();
			String modelo = getModeloCoche();
			String color = getStringAlAzar(colores);
			
			String sql = "INSERT INTO tutorialjavacoches.coche (id, idFabricante, bastidor, modelo, color) " +
					"VALUES  (" + nextIdEnTabla(conn, "coche") + ", " + idFabricante + ", '" + bastidor + "', '" + modelo + "', "
							+ "'" + color + "')";
			try {
				registrosInsertados = s.executeUpdate(sql);
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
			if (registrosInsertados != 1) {
				throw new SQLException ("No ha sido posible la inserci�n con la cadena:\n" + sql);
			}
			contRegistrosInsertados++;
			if (contRegistrosInsertados % CONT_NOTIFICACION_INSERCION == 0 && LOG) {
				System.out.println("\t" + contRegistrosInsertados + " registros insertados en tabla coche");
			}
		}
		s.close();
	}
	
	
	
	
	/**
	 * @throws ImposibleConectarException 
	 * @throws SQLException 
	 * 
	 */
	private static void creacionDatosVentas (Connection conn) throws SQLException, ImposibleConectarException {
		Statement s = (Statement) conn.createStatement();
		int registrosInsertados;
		int contRegistrosInsertados = 0;		
		
		if (LOG)
			System.out.println("\nInsertando registros en la tabla venta");
		
		ArrayList<Integer> idsClientes = getIdsEnTabla(conn, "cliente");
		ArrayList<Integer> idsCoches = getIdsEnTabla(conn, "coche");

		for (int i = 0; i < idsClientes.size(); i++) {
			int idConcesionario = getIdAzarEnTabla(conn, "concesionario");
			String fecha = getFechaAzar(2000, 2018, sdfFechaNacimiento);
			float precio = getPrecioAzar(1500, 45000);
			
			String sql = "INSERT INTO tutorialjavacoches.venta (id, idCliente, idConcesionario, idCoche, fecha, precioVenta) " +
					"VALUES  (" + nextIdEnTabla(conn, "venta") + ", " + idsClientes.get(i) + ", " + getIdAzarEnTabla(conn, "concesionario") + 
					", " + idsCoches.get(i) + ", '" + fecha + "', " + precio + ")";
			registrosInsertados = s.executeUpdate(sql);
			if (registrosInsertados != 1) {
				throw new SQLException ("No ha sido posible la inserci�n con la cadena:\n" + sql);
			}
			contRegistrosInsertados++;
			if (contRegistrosInsertados % CONT_NOTIFICACION_INSERCION == 0 && LOG) {
				System.out.println("\t" + contRegistrosInsertados + " registros insertados en tabla venta");
			}
		}
		s.close();
	}
	
	
	
	
	/**
	 * 
	 * @param conn
	 * @param tabla
	 * @return
	 * @throws SQLException
	 */
	private static int getIdAzarEnTabla (Connection conn, String tabla) throws SQLException {
		int maxId = maxIdEnTabla(conn, tabla);
		int idAzar;
		
		Statement s = (Statement) conn.createStatement();
		ResultSet rs;
		do {
			idAzar = Utils.obtenerNumeroAzar(1, maxId);
			rs = s.executeQuery("select * from tutorialjavacoches." + tabla + " where id = " + idAzar);
		} while (!rs.next());
		
		rs.close();
		s.close();
		return idAzar;
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
	private static String getFechaAzar (int anioMin, int anioMax, SimpleDateFormat sdf) {
		Calendar calendar = new GregorianCalendar(Utils.obtenerNumeroAzar(anioMin, anioMax) /*a�o*/, Utils.obtenerNumeroAzar(0, 11) /*mes*/, Utils.obtenerNumeroAzar(1, 31) /*d�a*/, 
				Utils.obtenerNumeroAzar(0, 23) /*hora*/, Utils.obtenerNumeroAzar(0, 59) /*minuto*/, Utils.obtenerNumeroAzar(0, 59) /*segundo*/);
	
		return sdf.format(calendar.getTime());
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
		Statement s = (Statement) conn.createStatement();

		String sql = "select max(id) from tutorialjavacoches." + tabla;
		ResultSet rs = s.executeQuery(sql);
		int max = 1; 
		if (rs.next() ) {
			max = rs.getInt(1);
		}
		rs.close();
		s.close();
		return max;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			long startTime = new Date().getTime();
			
			Connection conn;
			conn = ConnectionManagerV2.getConexion();
			
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
			
			long usedMillis = new Date().getTime() - startTime;
			int secs = (int) (usedMillis/1000);
			System.out.println("\nProceso terminado en " + secs + " segundos y " + (usedMillis - secs * 1000) + " milisegundos");
			
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
