package tutorialJava.capitulo7_Acceso_A_Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CompruebaPassword {

	public static void main(String[] args) {
		String nombre = "rafa";
		String pass = "' or ''='";
		
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps =  conn.prepareStatement(
					"select * from ciclistas.usuario where username = ? and password = ?");
			ps.setString(1, nombre);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
//			
//			String sql = "select * from ciclistas.usuario where username = '" + nombre + "' and "
//					+ "password = '" + pass + "'";
//			
//			System.out.println("comando: " + sql);
//			
//			ResultSet rs = s.executeQuery(sql);
			
			if (rs.next()) {
				System.out.println("Usuario correcto");
			}
			else {
				System.out.println("INCORRECTO");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
