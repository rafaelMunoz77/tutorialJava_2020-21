package tutorialJava.capitulo5_Arrays_y_Colecciones.ejemplo01_arraysPrimitivos;

import tutorialJava.Utils;

public class EjemploArraysPrimitivos {
	
	/**
	 * Método principal
	 * @param args
	 */
	public static void main(String[] args) {
		primerEjemploArray();
//		segundoEjemploArray();
	}
	
	
	/**
	 * Ejemplo de declaración de un array, inicialización de valores al azar y mostrar el array en consola
	 */
	public static void primerEjemploArray () {
		// Declaración del array, a través de la sentencia "new"
		int numeros[] = new int[10];
		
		
		// Inicialización de los valores del array
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = Utils.obtenerNumeroAzar();
		}

		// Recorrido del array para imprimir sus valores en pantalla
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
		} 
	}
	
	
	/**
	 * Ejemplo de una segunda forma de crear un array, en este caso lo creamos con unos valores directamente, en
	 * lugar de inicializarlo con valores al azar.
	 */
	public static void segundoEjemploArray() {
		// Otra forma de inicializar el array
		int array2[] = new int[] {88, 89, 90, 4, 5, 6, 7, 8, 9, 10};

		// Recorrido del array para imprimir sus valores en pantalla.
		// Este tipo de bucle se conoce como "for each".
		for (int i : array2) {
			System.out.println(i);
		}
	}

}
