package tutorialJava.modelosBasesDeDatosComunesJPA.poblacionPorProvincias.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import tutorialJava.modelosBasesDeDatosComunesJPA.Controlador;
import tutorialJava.modelosBasesDeDatosComunesJPA.poblacionPorProvincias.Provincia;


public class ProvinciaControlador extends Controlador {

	private static ProvinciaControlador controller = null;
	
	
	
	public ProvinciaControlador() {
		super(Provincia.class, "PoblacionProvincial");
	}

	/**
	 * 
	 * @return
	 */
	public static ProvinciaControlador getControlador () {
		if (controller == null) {
			controller = new ProvinciaControlador();
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
	public List<Provincia> findAllProvincias () {
		List<Provincia> entities = new ArrayList<Provincia>();
		EntityManager em = getEntityManagerFactory().createEntityManager();
		try {			
			Query q = em.createNativeQuery("SELECT * FROM provincia", Provincia.class);
			entities = (List<Provincia>) q.getResultList();
		}
		catch (NoResultException nrEx) {
		}
		em.close();
		return entities;
	}
	
	
	
	

	/**
	 * 
	 */
	public static void inicializaDatosEnTabla () {
		String nombresProvincias[] = new String[] {"Álava", "Albacete", "Alicante", "Almería", "Asturias", "Ávila", "Badajoz", 
				"Barcelona", "Burgos", "Cáceres", "Cádiz", "Cantabria", "Castellón", "Ciudad Real", "Córdoba", "Cuenca", "Gerona", 
				"Granada", "Guadalajara", "Guipúzcoa", "Huelva", "Huesca", "Islas Baleares", "Jaén", "La Coruña", "La Rioja", 
				"Las Palmas", "León", "Lérida", "Lugo", "Madrid", "Málaga", "Murcia", "Navarra", "Orense", "Palencia", "Pontevedra", 
				"Salamanca", "Segovia", "Sevilla", "Soria", "Tarragona", "Tenerife", "Teruel", "Toledo", "Valencia", "Valladolid", 
				"Vizcaya", "Zamora", "Zaragoza"};
		Provincia entidades[] = new Provincia[nombresProvincias.length];
		// Tenemos 50 provincias, si no se llega a tener todas, se eliminan los datos de la BBDD y se crea nuevamente
		if (ProvinciaControlador.getControlador().findAll().size() != 50) {
			// Elimino los datos de personas y después los de provincias
			PersonaControlador.getControlador().deleteAll();
			ProvinciaControlador.getControlador().deleteAll();

			// Recorro el array de Strings, dando de alta entidades en la tabla
			for (String nombreProvincia : nombresProvincias) {
				Provincia provincia = new Provincia();
				provincia.setDescripcion(nombreProvincia);
				ProvinciaControlador.getControlador().persist(provincia);
			}
		}		
	}

		

}
