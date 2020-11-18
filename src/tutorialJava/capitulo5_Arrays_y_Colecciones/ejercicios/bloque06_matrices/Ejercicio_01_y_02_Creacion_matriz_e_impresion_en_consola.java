package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque06_matrices;

import tutorialJava.Utils;

public class Ejercicio_01_y_02_Creacion_matriz_e_impresion_en_consola {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		int matriz[][] = new int[5][5];
		
		generaMatriz(matriz, 0, 100);
		
		imprimeMatriz(matriz);
	}

	
	/**
	 * 
	 * @param matriz
	 * @param min
	 * @param max
	 */
	public static void generaMatriz (int matriz[][], int min, int max) {
		// Asignación de valores al azar en las posiciones de la matriz
		for (int i = 0; i < matriz.length; i++) { // Con la variable "i" recorro todas las filas
			for (int j = 0; j < matriz[i].length; j++) { // Con la variable "j" recorro las columnas de cada fila
				// Asigno número al azar
				matriz[i][j] = Utils.obtenerNumeroAzar(min, max);
			}
		}
	}

	/**
	 * 
	 * @param filas
	 * @param cols
	 * @param min
	 * @param max
	 * @return
	 */
	public static int[][] generaMatriz (int filas, int cols, int min, int max) {
		int matriz[][] = new int[filas][cols];
		
		// Asignación de valores al azar en las posiciones de la matriz
		for (int i = 0; i < matriz.length; i++) { // Con la variable "i" recorro todas las filas
			for (int j = 0; j < matriz[i].length; j++) { // Con la variable "j" recorro las columnas de cada fila
				// Asigno n�mero al azar
				matriz[i][j] = Utils.obtenerNumeroAzar(min, max);
			}
		}
		return matriz;
	}
	
	/**
	 * 
	 * @param matriz
	 */
	public static void imprimeMatriz (int matriz[][]) {
		// Recorrido de los valores de la matriz
		for (int i = 0; i < matriz.length; i++) { // Recorro todas las filas
			for (int j = 0; j < matriz[i].length; j++) { // Recorro las columnas de la fila "i"
				System.out.print(matriz[i][j] + "\t"); // Imprimo el valor, con un tabulador y sin \n
			}
			System.out.println(); // Al finalizar una fila, incluyo un salto de línea
		}
	}
}
