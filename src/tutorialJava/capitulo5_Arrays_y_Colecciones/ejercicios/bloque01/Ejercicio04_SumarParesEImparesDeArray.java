package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque01;

import javax.swing.JOptionPane;

import tutorialJava.UtilsArrays;



public class Ejercicio04_SumarParesEImparesDeArray {

	/**
	 * Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre 0 y 100. A continuación pedirás al 
	 * usuario un valor y buscarás dicho valor en el array. Si lo encuentras, debes indicar al usuario la posición del array en 
	 * que se encuenta. En caso de que no encuentres el valor buscado, debes indicárselo también al usuario.
	 * @param args
	 */
	public static void main(String[] args) {
		int sumaPares = 0, sumaImpares = 0;
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
		
		for (int numero : array) {
			if ((numero & 1) == 1) { // impar
				sumaImpares += numero;
			}
			else { // par 
				sumaPares += numero;
			}
		}
		
		// IMprimo el resultado
		System.out.println("\nSuma impares: " + sumaImpares + 
				" - suma pares: " + sumaPares);
	}
	
	

	/**
	 * 
	 * @return
	 */
	private static int obtenerNumeroAleatorio (int limiteInferior, int limiteSuperior) {
		return (int) Math.round(Math.random() * (limiteSuperior - limiteInferior) + limiteInferior);
	}

}
