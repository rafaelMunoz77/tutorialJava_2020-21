package tutorialJava.capitulo8_AWT_SWING;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ControladorFabricante {

	private static ControladorFabricante instance = null;
	public Connection conn = null;
	
	/**
	 * 
	 * @return
	 */
	public static ControladorFabricante getInstance () {
		if (instance == null) {
			instance = new ControladorFabricante();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public ControladorFabricante() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection ("jdbc:mysql://localhost/tutorialjavacoches?serverTimezone=UTC","java", "1234");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		   

	}
	
	
	/**
	 * 
	 * @return
	 */
	public Fabricante findPrimero () {
		Fabricante f = null;
		try {
			Statement s = this.conn.createStatement();
			ResultSet rs =  s.executeQuery("select * from tutorialjavacoches.fabricante order by id limit 1");
			if (rs.next()) {
				f = new Fabricante();
				f.setId(rs.getInt("id"));
				f.setCif(rs.getString("cif"));
				f.setNombre(rs.getString("nombre"));
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return f;
	}
	

	/**
	 * 
	 * @return
	 */
	public Fabricante findUltimo () {
		Fabricante f = null;
		try {
			Statement s = this.conn.createStatement();
			ResultSet rs =  s.executeQuery("select * from tutorialjavacoches.fabricante order by id desc limit 1");
			if (rs.next()) {
				f = new Fabricante();
				f.setId(rs.getInt("id"));
				f.setCif(rs.getString("cif"));
				f.setNombre(rs.getString("nombre"));
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return f;
	}
	
	/**
	 * 
	 * @return
	 */
	public Fabricante findSiguiente (int idActual) {
		Fabricante f = null;
		try {
			Statement s = this.conn.createStatement();
			ResultSet rs =  s.executeQuery("select * from tutorialjavacoches.fabricante where id > " + idActual + " order by id limit 1");
			if (rs.next()) {
				f = new Fabricante();
				f.setId(rs.getInt("id"));
				f.setCif(rs.getString("cif"));
				f.setNombre(rs.getString("nombre"));
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return f;
	}
	


	/**
	 * 
	 * @return
	 */
	public Fabricante findAnterior (int idActual) {
		Fabricante f = null;
		try {
			Statement s = this.conn.createStatement();
			ResultSet rs =  s.executeQuery("select * from tutorialjavacoches.fabricante where id < " + idActual + " order by id desc limit 1");
			if (rs.next()) {
				f = new Fabricante();
				f.setId(rs.getInt("id"));
				f.setCif(rs.getString("cif"));
				f.setNombre(rs.getString("nombre"));
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return f;
	}
	


}
