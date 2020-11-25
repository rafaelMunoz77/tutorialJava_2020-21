package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque06_matrices;

public class Ejercicio11_EliminarFilaEnMatriz {

	/**
	 * Crea un método que pida al usuario un número de fila sobre una matriz. Debes crear una matriz igual a la original 
	 * pero eliminando el número de fila que el usuario ha especificado. El método recibirá una matriz y un valor entero, 
	 * que representa una fila de la matriz, y devuelve una nueva matriz.
	 * @param args
	 */
	public static void main(String[] args) {
		// Declaro e inicializo la matriz
		int matriz[][] = new int[][] {  {1,	1, 1, 1, 1},
										{2, 2, 2, 2, 2},
										{3, 3, 3, 3, 3},
										{4, 4, 4, 4, 4},
										{5, 5, 5, 5, 5}};

		// Muestro en pantalla
		Ejercicio_01_y_02_Creacion_matriz_e_impresion_en_consola.imprimeMatriz(matriz);

		// Obtengo y muestro la matriz con una fila menos
		int nuevaMatriz[][] = eliminarFilaEnMatriz(matriz, 4);
		System.out.println();
		Ejercicio_01_y_02_Creacion_matriz_e_impresion_en_consola.imprimeMatriz(nuevaMatriz);
	}
	
	/**
	 * 
	 * @param matriz
	 * @return
	 */
	public static int[][] eliminarFilaEnMatriz (int matriz[][], int rowToRemove) {
		// Determino la dimensión de la nueva matriz a partir de las dimensiones de la matriz recibida
		int nueva[][] = new int[matriz.length-1][matriz[0].length];
		
		// Recorro la matriz almacenando elementos en la matriz nueva matriz
		for (int i = 0, k = 0; i < matriz.length; i++) {
			// Si la fila de "i" no corresponde con la fila a eliminar, copio la fila en la nueva matriz
			if (i != rowToRemove) {
				for (int j = 0; j < matriz[i].length; j++) {
					nueva[k][j] = matriz[i][j];
				}
				k++;
			}
		}
		
		// Devuelvo la nueva matriz creada, en la que falta una fila con respecto a la original
		return nueva;
	}

}
