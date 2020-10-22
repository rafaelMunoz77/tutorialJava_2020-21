package tutorialJava.capitulo5_Arrays_y_Colecciones.HashMap;

import java.util.HashMap;
import java.util.Iterator;

public class EjemploHashMap {

	
	
	
	
	/**
	 * 
	 */
	private static void ejemploHashMapGeneral () {
		// Creación de un HashMap general
		HashMap hm = new HashMap();
		
		// Inserción de datos en un HashMap general
		hm.put("1", new Persona ("11111111A", "Pérez Pérez", "José"));
		hm.put("2", new Persona ("22222222A", "Muñoz Muñoz", "Rafael"));
		hm.put("3", new Persona ("33333333A", "Cuenca Cuenca", "Juan"));
		hm.put("4", new Persona ("44444444A", "Torralbo Torralbo", "Patricia"));
		hm.put("5", new Persona ("55555555A", "Lérida Lérida", "Lucía"));
		
		
		// Recuperación de datos en un HashMap general
		System.out.println("Objeto con id 1: " + hm.get("1"));  // Recuperación de un solo objeto
		
		// Inserción de un objeto con un tipo de identificador diferente
		hm.put(new Integer(6), new Persona ("66666666A", "Ramírez Ramírez", "Ramiro"));
		
		
		// Recuperación de todas las claves de objetos en el HM
		System.out.println("\nRecorrido del HashMap:");
		Object claves[] = hm.keySet().toArray();
		for (int i = 0; i < claves.length; i++) {
			System.out.println("Identificador tipo: " + claves[i].getClass().getName() + " - valor: " + claves[i].toString() + " - Objeto obtenido: "  + hm.get(claves[i]));
		}
	}
	
	
	/**
	 * 
	 */
	private static void ejemploHashMapEspecifico () {
		// Creación de un HashMap general
		HashMap<String, Persona> hm = new HashMap<String, Persona>();
		
		// Inserción de datos en un HashMap general
		hm.put("1", new Persona ("11111111A", "Pérez Pérez", "José"));
		hm.put("2", new Persona ("22222222A", "Muñoz Muñoz", "Rafael"));
		hm.put("3", new Persona ("33333333A", "Cuenca Cuenca", "Juan"));
		hm.put("4", new Persona ("44444444A", "Torralbo Torralbo", "Patricia"));
		hm.put("5", new Persona ("55555555A", "Lérida Lérida", "Lucía"));
		
		// Eliminación de algún elemento en el HM
		hm.remove("5");
		
		// Recuperación de todos los objetos en el HM
		System.out.println("\nRecorrido de los objetos del HashMap:");
		Iterator<Persona> personas = hm.values().iterator();
		while (personas.hasNext()) {
			System.out.println("Objeto obtenido: "  + personas.next());
		}
	}
	
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main (String args[]) {
		ejemploHashMapGeneral();
		//ejemploHashMapEspecifico();
	}
}
