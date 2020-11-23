package tutorialJava.capitulo5_Arrays_y_Colecciones.ejemplo02_ListYArrayList;

import java.util.ArrayList;
import java.util.List;

public class Ejemplo01_ListYArrayListConInteger {

	public static void main(String[] args) {

		// Creo una nueva lista, con la siguiente sintaxis, en la que cada elemento de la lista es un Integer
		List<Integer> lista1 = new ArrayList<Integer>();
		imprimeList(lista1, "Lista vacía");		
		
		// Una lista puede agreagar elementos al final de la misma o en cualquier 
		// posición concreta
		lista1.add(11);
		imprimeList(lista1, "Lista con un elemento");		

		// Inserción en una posición concreta: primer elemento de la lista
		lista1.add(0, 1000);
		imprimeList(lista1, "Lista con dos elementos");		


		// Ahora repito el experimento con otros dos números enteros y otra lista diferente
		List<Integer> lista2 = new ArrayList<Integer>();
		lista2.add(100);
		lista2.add(101);
		
		// Agrego todos los elementos de la lista1 en la lista2
		lista2.addAll(lista1);
		imprimeList(lista2, "Dos Listas concatenadas en una sóla");		

		// Agregación de más elementos al final de la lista2
		for(int i = 0; i < 5; i++) {
			lista2.add(200 + i);
		}		
		imprimeList(lista2, "Con más elementos agregados");
		
		// Eliminación de un elemento en una lista, dado el índice que ocupa
		lista2.remove(0);
		imprimeList(lista2, "Elimino el primer elemento");
		
		// Eliminación del último elemento de la lista
		lista2.remove(lista2.size()-1);
		imprimeList(lista2, "Elimino el último elemento");
		
	}
	
	
	/**
	 * Imprime en la consola una lista, recorriendo sus elementos
	 * @param lista
	 */
	private static void imprimeList (List<Integer> lista, String titulo) {
		System.out.println(titulo);
		for (int i = 0; i < lista.size(); i++) {
			System.out.println("Elemento en posición: " + i + ": " + lista.get(i));
		}
	}
	
	
	
	
	
	
	
	

}
