package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque05_Metodos_sobre_arrays;

import tutorialJava.UtilsArrays;

public class Ejercicio02_Find_and_replace {

	/**
	 * Un método llamado "findAndReplace", que reciba: 
		   - Un array de números enteros.
		   - Un valor entero que debe buscarse en el array.
		   - Un valor entero que debe servir para reemplazar.
		El método buscará todas las ocasiones en las que el segundo parámetro aparezca dentro del array y reemplazará ese valor 
		con el valor del tercer parámetro.
		El método main debe crear un array, imprimirlo en consola, llamar al método "findAndReplace" y volver a imprimir el array 
		en consola.
	 * @param args
	 */
	public static void main(String[] args) {
		int array[] = new int[] {1, 2, 3, 4, 5};
		UtilsArrays.mostrarArray(array);
		
		findAndReplace(array, 3, 60);
		UtilsArrays.mostrarArray(array);
	}

	/**
	 * 
	 * @param array
	 * @param valorABuscar
	 * @param valorAReemplazar
	 */
	public static void findAndReplace (int array[], int valorABuscar, int valorAReemplazar) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == valorABuscar) {
				array[i] = valorAReemplazar;
			}
		}
	}
}
