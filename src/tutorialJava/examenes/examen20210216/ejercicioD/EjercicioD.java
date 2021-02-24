package tutorialJava.examenes.examen20210216.ejercicioD;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class EjercicioD {

	private static Properties propiedades = null;

	public EjercicioD () {
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
				// Una forma de leer el fichero de propiedades
//				propiedades.load(propiedades.getClass().getResourceAsStream("/tutorialJava/capitulo6_Recursos/ejemplo.properties"));

				// Otra forma de leer el fichero de propiedades
				File file = new File("./src/tutorialJava/examenes/examen20210216/ejercicioD/ejemplo.properties");
				System.out.println("Fichero encontrado: " + file.exists());
				propiedades.load(new FileReader(file));
			
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
		return Integer.parseInt(getProperty(nombrePropiedad));
	}
	
	
	/**
	 * 
	 * @param nombrePropiedad
	 * @return
	 */
	public static Float getFloatProperty (String nombrePropiedad) {
		return Float.parseFloat(getProperty(nombrePropiedad));
	}
	
	
	/**
	 * 
	 * @param nombrePropiedad
	 * @return
	 */
	public static boolean getBooleanProperty (String nombrePropiedad) {
		return Boolean.parseBoolean(getProperty(nombrePropiedad));
	}
	
	
	/**
	 * 
	 * @param nombrePropiedad
	 * @return
	 */
	public static Date getDateProperty (String nombrePropiedad) {
		String strDate = getProperty(nombrePropiedad);
		Date fecha = new Date();
		try {
			fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fecha;
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main (String args[]) {
		String entero = EjercicioD.getProperty("ENTERO");
		String password = EjercicioD.getProperty("PASSWORD");
		int id = EjercicioD.getIntProperty("ID_USUARIO");
		
		System.out.println("Usuario leído del fichero de propiedades: " + entero);
		System.out.println("Password leído del fichero de propiedades: " + password);
		System.out.println("Id de usuario leído del fichero de propiedades: " + id);
	}
}
