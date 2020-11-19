package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque05_Metodos_sobre_arrays;

import tutorialJava.UtilsArrays;

public class Ejercicio03_Add_integer {

	/**
	 * Realiza un método llamado "addInteger", que reciba:
		   - Un array de números enteros.
		   - Un valor entero.
	   Dentro del método debes:
		   - Crear un nuevo array, cuya longitud sea la del array recibido como primer parámetro + 1.
		   - Copiar el array del primer parámetro en el array creado dentro del método, elemento tras elemento.
		   - Agregar el nuevo elemento al final del nuevo array.
		   - Asignar, al array recibido mediante el primer parámetro, el puntero al nuevo array creado en el interior del método.
		   - El método debe devolver un array de tipo entero. Main debe recoger el array devuelto e imprimirlo en consola.
	 * @param args
	 */
	public static void main(String[] args) {
		int array[] = new int[] {1, 2, 3, 4, 5};
		
		int nuevoArray[] = addInteger(array, 6);
		
		UtilsArrays.mostrarArray(nuevoArray);
	}
	
	
	/**
	 * 
	 * @param array
	 * @param nuevoValor
	 * @return
	 */
	public static int[] addInteger (int array[], int nuevoValor) {
		// Creo un nuevo array, con una longitud mayor a la del array que me han enviado
		int nuevoArray[] = new int[array.length + 1];
		
		// Copio los componentes del array antiguo al nuevo
		for (int i = 0; i < array.length; i++) {
			nuevoArray[i] = array[i];
		}
		
		// Pongo el nuevo elemento en la última posición del nuevo array
		nuevoArray[nuevoArray.length-1] = nuevoValor;
		
		// Devuelvo el nuevo array
		return nuevoArray;
	}

}
