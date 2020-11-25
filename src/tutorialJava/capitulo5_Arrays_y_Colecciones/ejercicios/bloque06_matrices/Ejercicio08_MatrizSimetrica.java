package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque06_matrices;

public class Ejercicio08_MatrizSimetrica {

	/**
	 * Crea un método que compruebe si la matriz es simétrica. (Los elementos de la matriz (i, j) y (j, i), si existen, 
	 * son iguales). El método recibirá una matriz y devolverá un boolean.
	 * @param args
	 */
	public static void main(String[] args) {
		// Declaro e inicializo la matriz
		int matriz[][] = new int[][] {  {1,	2, 3, 4, 5},
										{2, 1, 2, 3, 4},
										{3, 2, 1, 2, 3},
										{4, 3, 2, 1, 2},
										{5, 4, 3, 2, 1}};

		// Muestro en pantalla
		Ejercicio_01_y_02_Creacion_matriz_e_impresion_en_consola.imprimeMatriz(matriz);

		// Compruebo el método e imprimo en pantalla
		System.out.println("Matriz simétrica: " + esMatrizSimetrica(matriz));
	}

	
	/**
	 * 
	 * @param matriz
	 * @return
	 */
	public static boolean esMatrizSimetrica (int matriz[][]) {

		// Recorro la matriz buscando un elemento no simétrico
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] != matriz[j][i]) { 
					return false; // Si encuentro un elemento no simétrico, devuelvo que la matriz no es simétrica
				}
			}
		}
		// Si llego hasta la siguiente línea de código, significa que la matriz es simétrica
		return true;
	}
}
