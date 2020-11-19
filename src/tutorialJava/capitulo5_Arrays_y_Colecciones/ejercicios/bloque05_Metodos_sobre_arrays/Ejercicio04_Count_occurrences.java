package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque05_Metodos_sobre_arrays;

public class Ejercicio04_Count_occurrences {

	/**
	 * Realiza un método llamado "countOccurrences", que reciba:
		   - Un array de números enteros.
		   - Un valor entero.
		El método debe devolver un valor entero, que corresponda con el número de veces que el valor entero recibido como segundo parámetro exista dentro del array recibido como primer parámetro.
	 * @param args
	 */
	public static void main(String[] args) {
		int array[] = new int[] {1, 2, 3, 4, 5, 3};

		int contador = countOccurrences(array, 3);
		System.out.println("Hay " + contador + " ocurrencias del 3");
	}

	/**
	 * 
	 * @param array
	 * @param valorABuscar
	 */
	public static int countOccurrences (int array[], int valorABuscar) {
		int contadorOcurrencias = 0;
		
		// Recorro el array buscando ocurrencias
		for (int i = 0; i < array.length; i++) {
			if (array[i] == valorABuscar) {
				contadorOcurrencias++;
			}
		}
		
		// Devuelvo las ocurrencias encontradas
		return contadorOcurrencias;
	}
}
