package tutorialJava.examenes.examen20201103.examenA;

import tutorialJava.Utils;

public class EjercicioB_100_num_azar_entre_limites_e_invertido {

	public static void main(String[] args) {
		int numeros[] = new int[5];
		int limInf, limSup;
		
		System.out.println("Dame un límite inf: ");
		limInf = Utils.obtenerEntero();
		
		System.out.println("Dame un límite sup: ");
		limSup = Utils.obtenerEntero();
		
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = (int) Math.round(Math.random() * (limSup - limInf) + limInf);
		}
		
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
		}
		System.out.println("");
		
		for (int i = numeros.length - 1; i >= 0; i--) {
			System.out.print(numeros[i] + " ");
		}

	}

}
