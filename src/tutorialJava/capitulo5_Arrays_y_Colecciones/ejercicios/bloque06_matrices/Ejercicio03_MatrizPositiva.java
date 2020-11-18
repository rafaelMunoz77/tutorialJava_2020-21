package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque06_matrices;

public class Ejercicio03_MatrizPositiva {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int matriz[][] = new int[][] {  {1, 2, 3, 4, 5},
										{6, 7, 8, 9, 10},
										{11, 12, 13, 14, 15},
										{16, 17, 18, 19, 20},
										{21, 22, 23, 24, 25}};

		Ejercicio_01_y_02_Creacion_matriz_e_impresion_en_consola.imprimeMatriz(matriz);
		
		System.out.println(esMatrizPositiva(matriz) + " es Positiva");
	}
	
	/**
	 * 
	 * @param matriz
	 * @return
	 */
	public static boolean esMatrizPositiva (int matriz[][]) {
		boolean esPositiva = true;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] < 0) {
					esPositiva = false;
				}
			}
		}
		return esPositiva;
	}

}
