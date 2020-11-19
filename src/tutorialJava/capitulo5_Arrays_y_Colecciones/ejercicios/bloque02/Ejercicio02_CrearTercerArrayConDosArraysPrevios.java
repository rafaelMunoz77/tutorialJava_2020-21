package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque02;

import tutorialJava.UtilsArrays;

public class Ejercicio02_CrearTercerArrayConDosArraysPrevios {

	/**
	 * Realiza un ejercicio que inicialice dos arrays de 150 elementos enteros al azar entre 0 y 100. Debes crear 
	 * un tercer array, compuesto de la siguiente forma: en los elementos de índice impar del tercer array debes copiar 
	 * los elementos de índice impar del primer array; en los elementos de índice par del tercer array debes copiar los 
	 * elementos de índice par del segundo array.
	 * @param args
	 */
	public static void main(String[] args) {
		// Declaración de arrays
		int primerArray[] = new int[150];
		int segundoArray[] = new int[150];
		int tercerArray[] = new int[150];
		
		// Inicializamos el contenido de los arrays
		for (int i = 0; i < primerArray.length; i++) {
			primerArray[i] = obtenerNumeroAleatorio(-100, 100);
			segundoArray[i] = obtenerNumeroAleatorio(-100, 100);
		}

		// Imprimir en la consola el primer array creado
		for (int i = 0; i < primerArray.length; i++) {
			System.out.print(primerArray[i] + " ");
		}
		
		// Imprimo un salto de línea
		System.out.println();

		// Imprimir en la consola el segundo array creado
		for (int i = 0; i < segundoArray.length; i++) {
			System.out.print(segundoArray[i] + " ");
		}
		
		// Imprimo un salto de línea
		System.out.println();

		// Recorro los dos arrays, pasando elementos al tercer array, dependiendo del par o no par del índice de cada elemento
		for (int i = 0; i < tercerArray.length; i++) {
			if (i % 2 == 0) {
				tercerArray[i] = primerArray[i];
			}
			else {
				tercerArray[i] = segundoArray[i];
			}
		}
		
		// Imprimir en la consola el tercer array creado
		for (int i = 0; i < tercerArray.length; i++) {
			System.out.print(tercerArray[i] + " ");
		}
		
	}
	
	
	/**
	 * 
	 * @return
	 */
	private static int obtenerNumeroAleatorio (int limiteInferior, int limiteSuperior) {
		return (int) Math.round(Math.random() * (limiteSuperior - limiteInferior) + limiteInferior);
	}

	

}
