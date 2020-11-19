package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque05_Metodos_sobre_arrays;

import tutorialJava.UtilsArrays;

public class Ejercicio05_Remove_Integer {

	/**
	 * Realiza un método llamado "removeInteger", que reciba:
		   - Un array de números enteros.
		   - Un valor entero.
		Si el valor entero recibido como segundo parámetro existe dentro del array recibido como primer parámetro, debes conseguir que ese valor desaparezca del array. Puedes seguir la siguiente guía:
		   - Utiliza el método del ejercicio 4 para saber cuántas veces aparece el valor entero (segundo parámetro) dentro del array (primer parámetro).
		   - Crea un nuevo array, que tenga la dimensión del array recibido como primer parámetro menos la cantidad de veces que el valor entero del segundo parámetro aparezca en dicho array.
		   - Copia todos los elementos del array recibido como primer parámetro, dentro del nuevo array creado por ti en el método. Lógicamente no debes copiar en el array los valores del primer array que coincidan con el valor introducido como segundo parámetro.
		   - Devuelve el nuevo array.
		El método debe devolver "int[]". El método main debe recoger el nuevo array creado e imprimir en consola.
	 * @param args
	 */
	public static void main(String[] args) {
		int array[] = new int[] {1, 2, 3, 4, 5};

		int nuevo[] = removeInteger(array, 2);
		UtilsArrays.mostrarArray(nuevo);
	}
	
	/**
	 * 
	 * @param array
	 * @param valorAEliminar
	 * @return
	 */
	public static int[] removeInteger (int array[], int valorAEliminar) {
		// Cuento la cantidad de veces que ocurre el valorAEliminar dentro del array
		int countOccurs = Ejercicio04_Count_occurrences.countOccurrences(array, valorAEliminar);
		
		// Creo un nuevo array, con longitud igual a la del original menos la cantidad de ocurrencias
		int nuevoArray[] = new int[array.length - countOccurs];
		
		// Copio los elementos del viejo array al nuevo, excepto los que se quieren eliminar
		int j = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != valorAEliminar) {
				nuevoArray[j] = array[i];
				j++;
			}
		}
		
		// finalmente devuelvo el nuevo array
		return nuevoArray;
	}

}
