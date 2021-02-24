package tutorialJava.capitulo7_Acceso_A_Datos.gestionVentaCoches.modelo.controladores;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class JDBCPropiedades {

	private static Properties propiedades = null;

	public JDBCPropiedades () {
		super();
	}
	
	/**
	 * 
	 * @return
	 */
	private static Properties getPropiedades() {
		if (propiedades == null) {
			propiedades = new Properties();
		    
			try {
				propiedades.load(propiedades.getClass().getResourceAsStream("/tutorialJava/capitulo7_Acceso_A_Datos/gestionVentaCoches/modelo/controladores/jdbc.properties"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		}
		return propiedades;
	}

	/**
	 * 
	 * @param nombrePropiedad
	 * @return
	 */
	public static String getProperty(String nombrePropiedad) {
		return getPropiedades().getProperty(nombrePropiedad);
	}

	
	/**
	 * 
	 * @param nombrePropiedad
	 * @return
	 */
	public static int getIntProperty (String nombrePropiedad) {
		return Integer.parseInt(getPropiedades().getProperty(nombrePropiedad));
	}
	
	
	/**
	 * 
	 * @param nombrePropiedad
	 * @return
	 */
	public static Float getFloatProperty (String nombrePropiedad) {
		return Float.parseFloat(getPropiedades().getProperty(nombrePropiedad));
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main (String args[]) {
		String usuario = JDBCPropiedades.getProperty("USUARIO");
		String password = JDBCPropiedades.getProperty("PASSWORD");
		int id = JDBCPropiedades.getIntProperty("ID_USUARIO");
		
		System.out.println("Usuario le�do del fichero de propiedades: " + usuario);
		System.out.println("Password le�do del fichero de propiedades: " + password);
		System.out.println("Id de usuario le�do del fichero de propiedades: " + id);
	}
}
