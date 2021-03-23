package tutorialJava.capitulo8_AWT_SWING.v02_LayoutsYPrimerosJComponents.vistoEnClase.FabricanteConWindowBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControladorFabricante {

	private static ControladorFabricante instance = null;
	private Connection conn = null;
	
	public static ControladorFabricante getInstance () {
		if (instance == null) {
			instance = new ControladorFabricante();
		}
		return instance;
	}
	
	
	public ControladorFabricante() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = (Connection) DriverManager.getConnection ("jdbc:mysql://localhost/tutorialjavacoches?serverTimezone=UTC","java", "1234");		   
			
		}
		catch (ClassNotFoundException ex) {
			System.out.println("Imposible acceder al driver Mysql");
			ex.printStackTrace();
		}
		catch (SQLException ex) {
			System.out.println("Error en la ejecuci�n SQL: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	
	public Fabricante getPrimero () {
		Fabricante f = null;
		try {
			Statement s = (Statement) this.conn.createStatement(); 

			ResultSet rs = s.executeQuery ("select * from fabricante order by id limit 1");
		   
			if (rs.next()) {
				f = new Fabricante();
				f.setId(rs.getInt("id"));
				f.setCif(rs.getString("cif"));
				f.setNombre(rs.getString("nombre"));
			}
			// Cierre de los elementos
			rs.close();
			s.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return f;
	}
	
	public Fabricante getUltimo () {
		Fabricante f = null;
		try {
			Statement s = (Statement) this.conn.createStatement(); 

			ResultSet rs = s.executeQuery ("select * from fabricante order by id desc limit 1");
		   
			if (rs.next()) {
				f = new Fabricante();
				f.setId(rs.getInt("id"));
				f.setCif(rs.getString("cif"));
				f.setNombre(rs.getString("nombre"));
			}
			// Cierre de los elementos
			rs.close();
			s.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return f;
	}
	
	public Fabricante getSiguiente (int idActual) {
		Fabricante f = null;
		try {
			Statement s = (Statement) this.conn.createStatement(); 

			ResultSet rs = s.executeQuery ("select * from fabricante where id > " + idActual + " order by id limit 1");
		   
			if (rs.next()) {
				f = new Fabricante();
				f.setId(rs.getInt("id"));
				f.setCif(rs.getString("cif"));
				f.setNombre(rs.getString("nombre"));
			}
			// Cierre de los elementos
			rs.close();
			s.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return f;
	}
	
	public Fabricante getAnterior (int idActual) {
		Fabricante f = null;
		try {
			Statement s = (Statement) this.conn.createStatement(); 

			ResultSet rs = s.executeQuery ("select * from fabricante where id < " + idActual + " order by id desc limit 1");
		   
			if (rs.next()) {
				f = new Fabricante();
				f.setId(rs.getInt("id"));
				f.setCif(rs.getString("cif"));
				f.setNombre(rs.getString("nombre"));
			}
			// Cierre de los elementos
			rs.close();
			s.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return f;
	}
	

	public int guardarExistente (Fabricante f) {
		int registrosAfectados = 0;
		try {
			Statement s = (Statement) this.conn.createStatement(); 

			registrosAfectados = s.executeUpdate ("update fabricante set cif='" + f.getCif() + "', " +
					" nombre='" + f.getNombre() + "' where id=" + f.getId() + ";");
		   
			
			// Cierre de los elementos
			s.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return registrosAfectados;
	}
	

	
	public int guardarNuevo (Fabricante f) {
		int registrosAfectados = 0;
		int idNuevoRegistro = 0;
		try {
			Statement s = (Statement) this.conn.createStatement(); 

			idNuevoRegistro = nextId();
			registrosAfectados = s.executeUpdate ("insert into fabricante values(" + idNuevoRegistro + ", " +
			"'" + f.getCif() + "', '" + f.getNombre() + "');");
		   	
			// Cierre de los elementos
			s.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return idNuevoRegistro;
	}
	

	/**
	 * 
	 * @param conn
	 * @param tabla
	 * @return
	 * @throws SQLException
	 */
	private int nextId () throws SQLException {
		Statement s = (Statement) this.conn.createStatement();

		String sql = "select max(id) from tutorialjavacoches.fabricante";
		ResultSet rs = s.executeQuery(sql);
		int max = 1; 
		if (rs.next() ) {
			max = rs.getInt(1);
		}
		rs.close();
		s.close();
		return max + 1;
	}
	
	
	public int eliminar(int id) {
		int registrosAfectados = 0;
		try {
			Statement s = (Statement) this.conn.createStatement(); 

			registrosAfectados = s.executeUpdate ("delete from fabricante where id=" + id + ";");
			
			// Cierre de los elementos
			s.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return registrosAfectados;
	}
}
