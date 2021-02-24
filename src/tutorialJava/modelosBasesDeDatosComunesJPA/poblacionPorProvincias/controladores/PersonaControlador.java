package tutorialJava.modelosBasesDeDatosComunesJPA.poblacionPorProvincias.controladores;

import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import tutorialJava.Utils;
import tutorialJava.modelosBasesDeDatosComunesJPA.Controlador;
import tutorialJava.modelosBasesDeDatosComunesJPA.poblacionPorProvincias.Persona;
import tutorialJava.modelosBasesDeDatosComunesJPA.poblacionPorProvincias.Provincia;



public class PersonaControlador extends Controlador {

	private static PersonaControlador controller = null;
	
	
	
	public PersonaControlador() {
		super(Persona.class, "PoblacionProvincial");
	}

	/**
	 * 
	 * @return
	 */
	public static PersonaControlador getControlador () {
		if (controller == null) {
			controller = new PersonaControlador();
		}
		return controller;
	}

	/**
	 * 
	 */
	public Provincia find (int id) {
		return (Provincia) super.find(id);
	}


	/**
	 * 
	 * @return
	 */
	public List<Persona> findAllPersonas () {
		List<Persona> entities = new ArrayList<Persona>();
		EntityManager em = getEntityManagerFactory().createEntityManager();
		try {			
			Query q = em.createNativeQuery("SELECT * FROM persona", Persona.class);
			entities = (List<Persona>) q.getResultList();
		}
		catch (NoResultException nrEx) {
		}
		em.close();
		return entities;
	}
	
	
	
	// Arrays para generación de personas al azar
	private static String nombres[] = new String[] {"Eva", "Juan", "Carmen", "Pablo", "Rafa", "Pilar", "Pedro", 
			"Lola", "Casimiro", "Gertrudis", "Eustaquio", "Gerarda", "Nepomunosio", "Argimira", "Ascensio", "Baltasara", "Baudilio", "Bernabea"};
	private static String apellidos[] = new String[] {"Gonzalez", "Lopez", "Gutierrez", "Ruiz", "Jurado", "Carrasco", "Flores", 
			"Sanchez", "Bose", "Martin", "Martinez", "Santos", "Pozo", "Quijano", "Romero", "Pisano", "Cuevas", "Sanz"};

	/**
	 * 
	 */
	public static void inicializaDatosEnTabla () {
		int personasPorProvincia = 100;
		// Para cada provincia, eliminaré a las personas creadas y crearé nuevas
		PersonaControlador.getControlador().deleteAll();
		List<Provincia> provincias = ProvinciaControlador.getControlador().findAllProvincias();
		for (Provincia provincia : provincias) {
			for (int i = 0; i < 100; i++) {
				Persona persona = new Persona();
				persona.setNombre(getStringAlAzar(nombres));
				persona.setPrimerApellido(getStringAlAzar(apellidos));
				persona.setSegundoApellido(getStringAlAzar(apellidos));
				persona.setProvincia(provincia);
				persona.setFechaNacimiento(getFechaAzar(1900, 2019));
				persona.setEdad(calculaEdad(persona.getFechaNacimiento()));
				persona.setActivo( (Utils.obtenerNumeroAzar(0, 100) <= 50)? true : false );
				PersonaControlador.getControlador().persist(persona);
			}
		}
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
	private static Date getFechaAzar (int anioMin, int anioMax) {
		Calendar calendar = new GregorianCalendar(Utils.obtenerNumeroAzar(anioMin, anioMax) /*año*/, Utils.obtenerNumeroAzar(0, 11) /*mes*/, Utils.obtenerNumeroAzar(1, 31) /*día*/);
	
		return calendar.getTime();
	}
	
	/**
	 * 
	 * @return
	 */
	private static int calculaEdad (Date fechaNacimiento) {
		return (int) ChronoUnit.YEARS.between(fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
	}
	

	

}
