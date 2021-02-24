package tutorialJava.capitulo8_AWT_SWING.v06_EjemplosJTable;

import java.util.List;

import tutorialJava.modelosBasesDeDatosComunesJPA.poblacionPorProvincias.Persona;
import tutorialJava.modelosBasesDeDatosComunesJPA.poblacionPorProvincias.controladores.PersonaControlador;

public class DatosDeTabla {

	/** 
	 * 
	 * @return
	 */
	public static String[] getTitulosColumnas() {
		return new String[] {"Id", "Nombre", "1º apellido", "2º apellido", "Fecha Nac.", "Edad", "Activo", "Provincia"};
	}

	/**
	 * 
	 * @return
	 */
	public static Object[][] getDatosDeTabla() {
		// Obtengo todas las personas
		List<Persona> personas = PersonaControlador.getControlador().findAllPersonas();
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[personas.size()][8];
		// Cargo los datos de la lista de personas en la matriz de los datos
		for (int i = 0; i < personas.size(); i++) {
			Persona persona = personas.get(i);
			datos[i][0] = persona.getId();
			datos[i][1] = persona.getNombre();
			datos[i][2] = persona.getPrimerApellido();
			datos[i][3] = persona.getSegundoApellido();
			datos[i][4] = persona.getFechaNacimiento();
			datos[i][5] = persona.getEdad();
			datos[i][6] = persona.getActivo();
			datos[i][7] = persona.getProvincia();
		}
		
		return datos;
	}
	
	
}
