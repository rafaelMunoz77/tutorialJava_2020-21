package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque06_matrices;

import tutorialJava.UtilsArrays;

public class Ejercicio09_MatrizDispersa {

	/**
	 * Crea un método que realice la matriz traspuesta de la que recibe. El método recibe una matriz y devuelve otra matriz, la traspuesta.
	 * @param args
	 */
	public static void main(String[] args) {
		// Declaro e inicializo la matriz
		int matriz[][] = new int[][] {  {1,	3, 5, 7, 9},
										{2, 4, 6, 8, 10},
										{1, 3, 5, 7, 9},
										{2, 4, 6, 8, 10}};

		// Muestro en pantalla
		Ejercicio_01_y_02_Creacion_matriz_e_impresion_en_consola.imprimeMatriz(matriz);

		// Obtengo y muestro la matriz dispersa
		int dispersa[][] = dispersaFromMatriz(matriz);
		System.out.println();
		Ejercicio_01_y_02_Creacion_matriz_e_impresion_en_consola.imprimeMatriz(dispersa);
	}
	
	/**
	 * 
	 * @param matriz
	 * @return
	 */
	public static int[][] dispersaFromMatriz (int matriz[][]) {
		// Determino la dimensión de la matriz dispersa a partir de la cantidad de filas de la matriz y las columnas de la primera fila
		int dispersa[][] = new int[matriz[0].length][matriz.length];
		
		// Recorro la matriz almacenando elementos en el array
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				dispersa[j][i] = matriz[i][j];
			}
		}
		
		// Devuelvo la dispersa
		return dispersa;
	}

}
