package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque06_matrices;

public class Ejercicio10_MatrizOpuesta {

	/**
	 * Crea un método que realice la matriz opuesta de la que recibe. El método recibe una matriz y devuelve otra, la opuesta
	 * @param args
	 */
	public static void main(String[] args) {
		// Declaro e inicializo la matriz
		int matriz[][] = new int[][] {  {1,	3, -5, 7, 9},
										{2, 4, 6, 8, 10},
										{1, 3, 5, 7, 9},
										{2, 4, 6, 8, 10}};

		// Muestro en pantalla
		Ejercicio_01_y_02_Creacion_matriz_e_impresion_en_consola.imprimeMatriz(matriz);

		// Obtengo y muestro la matriz opuesta
		int opuesta[][] = matrizOpuesta(matriz);
		System.out.println();
		Ejercicio_01_y_02_Creacion_matriz_e_impresion_en_consola.imprimeMatriz(opuesta);
	}
	
	/**
	 * 
	 * @param matriz
	 * @return
	 */
	public static int[][] matrizOpuesta (int matriz[][]) {
		// Determino la dimensión de la matriz opuesta a partir de las dimensiones de la matriz recibida
		int opuesta[][] = new int[matriz.length][matriz[0].length];
		
		// Recorro la matriz almacenando elementos en la matriz opuesta
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				opuesta[i][j] = -matriz[i][j];
			}
		}
		
		// Devuelvo la dispersa
		return opuesta;
	}
}
