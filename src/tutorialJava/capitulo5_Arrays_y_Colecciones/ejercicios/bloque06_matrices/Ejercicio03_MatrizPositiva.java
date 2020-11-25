package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque06_matrices;

public class Ejercicio03_MatrizPositiva {

	/**
	 * Crea un método que compruebe si la matriz es positiva. (Todos sus elementos mayores o iguales a cero). El método recibirá 
	 * una matriz y devolver un valor "boolean", indicando si la matriz es o no es positiva.
	 * @param args
	 */
	public static void main(String[] args) {
		// Declaro e inicializo la matriz
		int matriz[][] = new int[][] {  {1,	 2,  3,  4,  5},
										{6,  7,  8,  9,  10},
										{11, 12, 13, 14, 15},
										{16, 17, 18, 19, 20},
										{21, 22, 23, 24, 25}};

		// Muestro en pantalla
		Ejercicio_01_y_02_Creacion_matriz_e_impresion_en_consola.imprimeMatriz(matriz);
		
		// Determino si es positiva, llamando al método
		System.out.println(esMatrizPositiva(matriz) + " es Positiva");
	}
	
	/**
	 * 
	 * @param matriz
	 * @return
	 */
	public static boolean esMatrizPositiva (int matriz[][]) {
		// Recorro todos los valores de la matriz, buscando uno que sea negativo
		for (int i = 0; i < matriz.length; i++) { // Recorro filas
			for (int j = 0; j < matriz[i].length; j++) {  // Recorro columnas
				if (matriz[i][j] < 0) {
					return false; // Si un sólo elemento es negativo, la matriz no es positiva
				}
			}
		}
		// Si llego hasta la siguiente línea de código, significa que la matriz es positiva
		return true;
	}

}
