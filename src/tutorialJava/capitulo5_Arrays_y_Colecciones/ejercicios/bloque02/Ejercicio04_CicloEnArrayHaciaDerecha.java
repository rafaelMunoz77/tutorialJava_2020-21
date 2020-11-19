package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque02;

import javax.swing.JOptionPane;

import tutorialJava.Utils;
import tutorialJava.UtilsArrays;

public class Ejercicio04_CicloEnArrayHaciaDerecha {

	/**
	 * Realiza un ejercicio en que inicialice un array de 5 elementos enteros al azar entre 0 y 100. Debes conseguir que 
	 * se desplacen los números un lugar a su derecha, de manera que el desplazamiento sea circular, si un número sale por 
	 * la derecha volverá a entrar por la izquierda. Ejemplo: 1 2 3 4 5 pasa a ser 5 1 2 3 4 que pasa a ser 4 5 1 2 3.
	 * @param args
	 */
	public static void main(String[] args) {		
		// Declaración del array
		int array[] = new int[5];
		
		// Inicializamos el contenido del array
		for (int i = 0; i < array.length; i++) {
			array[i] = obtenerNumeroAleatorio(-100, 100);
		}
		
		// Imprimo en la consola el array
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();

		// Pongo a salvo el último elemento del array
		int aux = array[array.length - 1];
		// Desplazo uno a uno los elementos del array, desde la derecha hacia la izquierda
		for (int i = array.length - 1; i > 0; i--) {
			array[i] = array[i-1];
		}
		// Introduzco el último valor, puesto a salvo, en la primera posición del array
		array[0] = aux;
		
		// Imprimo en la consola el array
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	
	/**
	 * 
	 * @return
	 */
	private static int obtenerNumeroAleatorio (int limiteInferior, int limiteSuperior) {
		return (int) Math.round(Math.random() * (limiteSuperior - limiteInferior) + limiteInferior);
	}	

}
