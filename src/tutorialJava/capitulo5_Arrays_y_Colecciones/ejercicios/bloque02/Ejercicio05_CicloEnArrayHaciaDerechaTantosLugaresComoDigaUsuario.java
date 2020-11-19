package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque02;

import javax.swing.JOptionPane;

import tutorialJava.Utils;
import tutorialJava.UtilsArrays;

public class Ejercicio05_CicloEnArrayHaciaDerechaTantosLugaresComoDigaUsuario {

	/**
	 * Realiza un ejercicio igual al anterior, pero en el que el usuario pueda indicar la cantidad de posiciones que 
	 * deseamos desplazar.
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
		
		// Pido al usuario un número de veces a desplazar los elementos
		int numCiclos = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un número de veces a desplazar los elementos "));
		
		for (int i = 0; i < numCiclos; i++) {
			// Comienzo el algoritmo de ciclo del ejercicio anterior.
			int aux = array[array.length - 1];
			for (int j = array.length - 1; j > 0; j--) {
				array[j] = array[j-1];
			}
			array[0] = aux;
			// Finalizo el algotitmo del ciclo
		}
		
		
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
