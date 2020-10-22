package tutorialJava.capitulo5_Arrays_y_Colecciones.ListYArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tutorialJava.capitulo5_Arrays_y_Colecciones.ejerciciosResueltos.bloque01.ejercicio06.Cromo;

public class EjemploListYArrayList {

	public static void main (String args[]) {

		// Construyo dos objetos de tipo Cromo, que se añadirán a la lista
		Cromo pauGasol = new Cromo (1, "Pau Gasol");
		Cromo marcGasol = new Cromo (2, "Marc Gasol");
		
		// Instancio un nuevo elemento de la Interface List, a través de la creación de un objeto
		// que implementa la interfaz, en concreto en este caso se utiliza la clase ArrayList
		List<Cromo> cromosBasket1 = new ArrayList<Cromo>();

		imprimeList(cromosBasket1, "Lista vacía");		
		
		// Un elemento de tipo List puede añadir elementos al final de la lista o en cualquier 
		// posición concreta
		cromosBasket1.add(pauGasol);

		imprimeList(cromosBasket1, "Lista con un elemento");		

		// Posición concreta: primer elemento de la lista
		cromosBasket1.add(0, marcGasol);
		
		imprimeList(cromosBasket1, "Lista con dos elementos");		

		Cromo cromoBorrado = cromosBasket1.remove(0);
		System.out.println("Cromo borrado: " + cromoBorrado);

		


		// Ahora repito el experimento con otros dos cromos y otra lista diferente
		Cromo rudyFernandez = new Cromo (3, "Rudy Fernández");
		Cromo rickyRubio = new Cromo (4, "Ricky Rubio");
		
		List<Cromo> cromosBasket2 = new ArrayList<Cromo>();
		
		cromosBasket2.add(rudyFernandez);
		cromosBasket2.add(rickyRubio);
		
		cromosBasket1.addAll(cromosBasket2);
		
		imprimeList(cromosBasket1, "Dos Listas concatenadas");		

		
		for(int i = 0; i < 5; i++) {
			cromosBasket1.add(new Cromo(10 + i, "Jugador-" + i));
		}
		
		imprimeList(cromosBasket1, "Con más jugadores agregados");
		
	}
	
	
	/**
	 * 
	 * @param lista
	 */
	private static void imprimeList (List<Cromo> lista, String titulo) {
		System.out.println(titulo);
		for (int i = 0; i < lista.size(); i++) {
			System.out.println("Elemento en posición: " + i + ": " + lista.get(i).toString());
		}
	}
}
