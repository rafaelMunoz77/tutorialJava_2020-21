package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque02;

import tutorialJava.UtilsArrays;

public class Ejercicio01_CambiarSignoAElementosEnArray {

	/**
	 * Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre -100 y 100. Debes conseguir que 
	 * todos los números pares del array cambien de signo, los positivos deben pasar a negativos y viceversa.
	 * @param args
	 */
	public static void main(String[] args) {
		// Declaración de array
		int array[] = new int[100];
		
		// Inicializamos el contenido del array
		for (int i = 0; i < array.length; i++) {
			array[i] = obtenerNumeroAleatorio(-100, 100);
		}

		// Imprimir en la consola el array creado
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		
		// Imprimo un salto de línea
		System.out.println();
		
		// Recorro el array buscando los pares y cambiando su signo
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				array[i] *= -1;
			}
		}
		
		// Imprimir en la consola el array creado
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
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
