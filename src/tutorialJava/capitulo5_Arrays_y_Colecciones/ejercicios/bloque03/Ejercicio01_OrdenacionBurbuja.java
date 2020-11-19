package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque03;

import java.util.Date;

import tutorialJava.UtilsArrays;

/**
 * Capítulo 5 - Bloque 3 - Ejercicio 1
 * Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre 0 y 1.000. 
 * Una vez que lo hayas conseguido debes realizar implementar el algoritmo de ordenación llamado 
 * "Burbuja", con el objetivo de ordenar el array completamente. Puedes consultar el siguiente
 * http://lwh.free.fr/pages/algo/tri/tri_bulle_es.html
 */
public class Ejercicio01_OrdenacionBurbuja {

	/**
	 * Método principal
	 * @param args
	 */
	public static void main(String[] args) {		
		
		int vector[] = UtilsArrays.creaArrayNumerosAzar(5, 0, 10);
		
		UtilsArrays.mostrarArray(vector);
		
		// Mido el tiempo de inicio
		long millisAntesDeLaOrdenacion = new Date().getTime();
		
		ordenaArrayPorBurbuja(vector);

		// Mido el tiempo después
		long millisDespuesDeLaOrdenacion = new Date().getTime();
		
		// Muestro el tiempo en millis
		System.out.println("\nEjecución en " + (millisDespuesDeLaOrdenacion - millisAntesDeLaOrdenacion) + " millis\n");
		
		// Mostramos el resultado
		UtilsArrays.mostrarArray(vector);
	}

	
	/**
	 * Implementa el algoritmo de la buburja para ordenar un array
	 * @param array Array desordenado que se ordenará
	 */
	public static void ordenaArrayPorBurbuja (int array[]) {
		boolean hayIntercambios;
		do {
			hayIntercambios = false;
			// Empieza el algoritmo
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i+1] < array[i]) {
					// Entonces hago un intercambio
					int aux = array[i+1];
					array[i+1] = array[i];
					array[i] = aux;
					hayIntercambios = true;
				}
			}
		} while (hayIntercambios == true);
	}
}
