package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque01;

import javax.swing.JOptionPane;

import tutorialJava.UtilsArrays;



public class Ejercicio05_SumaNumerosConIndicePar {

	/**
	 * Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre 0 y 100. Debes mostrar al usuario la suma 
	 * de los elementos cuyo índice sea par.
	 * @param args
	 */
	public static void main(String[] args) {
		int sumaNumerosConIndicePar = 0;
		// Declaración de array
		int array[] = new int[5];
		
		// Inicializamos el contenido del array
		for (int i = 0; i < array.length; i++) {
			array[i] = obtenerNumeroAleatorio(0, 100);
		}

		// Imprimir en la consola el array creado
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		
		// Imprimo un salto de línea
		System.out.println();
		
		
		// Mostramos el array 
		UtilsArrays.mostrarArray(array);
		
		// Recorro el array y sumo los que tienen indice par
		for (int i = 0; i < array.length; i++) {
			if ((i % 2) == 0) { // índice par
				sumaNumerosConIndicePar += array[i];
			}
		}
		
		// IMprimo el resultado
		System.out.println("\nSuma números con índice par: " + sumaNumerosConIndicePar);
	}
	
	
	/**
	 * 
	 * @return
	 */
	private static int obtenerNumeroAleatorio (int limiteInferior, int limiteSuperior) {
		return (int) Math.round(Math.random() * (limiteSuperior - limiteInferior) + limiteInferior);
	}

	
}
