package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque06_matrices;

public class Ejercicio04_Matriz_diagonal {

	/**
	 * Crea un método que compruebe si la matriz es diagonal (Todos los elementos que no están en la diagonal principal son nulos)
	 * @param args
	 */
	public static void main(String[] args) {
		// Declaro e inicializo la matriz
		int matriz[][] = new int[][] {  {1,	0, 0, 0, 0},
										{0, 2, 0, 0, 0},
										{0, 0, 3, 0, 0},
										{0, 0, 0, 4, 0},
										{0, 0, 0, 0, 5}};

		// Muestro en pantalla
		Ejercicio_01_y_02_Creacion_matriz_e_impresion_en_consola.imprimeMatriz(matriz);

		// Llamo al método y compruebo si es diagonal
		System.out.println("Es matriz diagonal: " + esMatrizDiagonal(matriz));
	}

	
	/**
	 * 
	 * @param matriz
	 * @return
	 */
	public static boolean esMatrizDiagonal (int matriz[][]) {
		boolean diagonal = true; // Utilizo una bandera, parto de que la matriz va a ser diagonal e intento demostrar lo contrario
		
		// Recorro la matriz buscando un elemento fuera de la diagonal principal que no sea 0
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (i != j && matriz[i][j] != 0) { 
					// Si encuentro un elemento fuera de la diagonal principal distinto de 0, la matriz no es diagonal
					diagonal = false;
				}
			}
		}
		// Devuelvo la bandera
		return diagonal;
	}
}
