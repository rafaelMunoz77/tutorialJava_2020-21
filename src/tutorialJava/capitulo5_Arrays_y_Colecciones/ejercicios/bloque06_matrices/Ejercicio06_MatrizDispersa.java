package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque06_matrices;

public class Ejercicio06_MatrizDispersa {

	/**
	 * Crea un método que compruebe si la matriz es dispersa. (Todos las filas y todas las columnas contienen al menos un elemento nulo).
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

		// Compruebo el método e imprimo en pantalla
		System.out.println("Matriz dispersa: " + esMatrizDispersa(matriz));
	}

	
	/**
	 * 
	 * @param matriz
	 * @return
	 */
	public static boolean esMatrizDispersa (int matriz[][]) {
		// Recorro las filas de la matriz, en cada fila utilizo una bandera indicando que no hay ceros en la fila. Cuando encuentre
		// un cero sabré que esa fila cumple con lo que se pide
		for (int i = 0; i < matriz.length; i++) {
			boolean hayCero = false;
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] == 0) { 
					// Si encuentro un elemento cero actualizo la bandera
					hayCero = true;
				}
			}
			// Al acabar la fila sé si hay un cero o no
			if (hayCero == false) {
				return false; // Si en una fila no hay un cero, puedo decir que la matriz no es dispersa
			}
		}
		
		// Ahora recorro las columnas
		for (int i = 0; i < matriz[0].length; i++) {
			boolean hayCero = false;
			for (int j = 0; j < matriz.length; j++) {
				if (matriz[j][i] == 0) { 
					// Si encuentro un elemento cero actualizo la bandera
					hayCero = true;
				}
			}
			// Al acabar la fila sé si hay un cero o no
			if (hayCero == false) {
				return false; // Si en una fila no hay un cero, puedo decir que la matriz no es dispersa
			}
		}
		
		
		// Si llego hasta la siguiente línea de código, significa que la matriz es dispersa
		return true;
	}
}
