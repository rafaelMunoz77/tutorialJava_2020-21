package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque06_matrices;

public class Ejercicio05_MatrizDiagonalSuperior {

	/**
	 * Crea un método que compruebe si la matriz es triangular superior. (Todos los elementos que están por debajo 
	 * de la diagonal principal son nulos).
	 * @param args
	 */
	public static void main(String[] args) {
		// Declaro e inicializo la matriz
		int matriz[][] = new int[][] {  {1,	0, 0, 0, 7},
										{0, 2, 0, 6, 0},
										{0, 0, 3, 0, 0},
										{0, 0, 0, 4, 0},
										{0, 0, 0, 0, 5}};

		// Muestro en pantalla
		Ejercicio_01_y_02_Creacion_matriz_e_impresion_en_consola.imprimeMatriz(matriz);

		// Compruebo el método e imprimo en pantalla
		System.out.println("Matriz diagonal superior: " + esMatrizDiagonalSuperior(matriz));
	}

	
	/**
	 * 
	 * @param matriz
	 * @return
	 */
	public static boolean esMatrizDiagonalSuperior (int matriz[][]) {
		// Recorro la matriz buscando un elemento fuera debajo de la diagonal principal que no sea 0
		for (int i = 1; i < matriz.length; i++) {
			for (int j = 0; j < i; j++) {
				if (matriz[i][j] != 0) { 
					// Si encuentro un elemento debajo de la diagonal principal distinto de 0, la matriz no es diagonal
					return false;
				}
			}
		}
		// Si llego hasta la siguiente línea de código, significa que la matriz es diagonal superior
		return true;
	}

}
