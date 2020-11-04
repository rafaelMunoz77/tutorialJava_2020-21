package tutorialJava.examenes.examen20201103.examenA;

import tutorialJava.Utils;

public class EjercicioC_20_num_azar_pares_entre_25_y_100 {

	public static void main(String[] args) {
		int numeros[] = new int[20];
		
		for (int i = 0; i < numeros.length; i++) {
			do {
				numeros[i] = (int) Math.round(Math.random() * (100 - 25) + 25);
			} while (!(numeros[i] % 2 == 0));
		}
		
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
		}
	}

}
