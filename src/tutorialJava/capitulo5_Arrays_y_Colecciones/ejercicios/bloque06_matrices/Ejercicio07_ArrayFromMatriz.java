package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque06_matrices;

import tutorialJava.UtilsArrays;

public class Ejercicio07_ArrayFromMatriz {

	/**
	 * Crea un método que construya un array unidimensional con todos los elementos de la matriz. El método recibirá una matriz 
	 * y devolverá un array.
	 * @param args
	 */
	public static void main(String[] args) {
		// Declaro e inicializo la matriz
		int matriz[][] = new int[][] {  {1,	2, 3, 4, 0},
										{6, 0, 8, 9, 1},
										{2, 3, 4, 0, 6},
										{7, 8, 0, 1, 2},
										{0, 4, 5, 6, 7}};

		// Muestro en pantalla
		Ejercicio_01_y_02_Creacion_matriz_e_impresion_en_consola.imprimeMatriz(matriz);

		// Obtengo y muestro el array
		int array[] = arrayFromMatriz(matriz);
		UtilsArrays.mostrarArray(array);
	}
	
	
	/**
	 * 
	 * @param matriz
	 * @return
	 */
	public static int[] arrayFromMatriz (int matriz[][]) {
		// Determino la dimensión del array a partir de la cantidad de filas de la matriz y las columnas de la primera fila
		int array[] = new int[matriz.length * matriz[0].length];
		
		// Recorro la matriz almacenando elementos en el array
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				array[matriz.length * i + j] = matriz[i][j];
			}
		}
		
		// Devuelvo el array
		return array;
	}

}
