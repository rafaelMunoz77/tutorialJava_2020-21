package tutorialJava.examenes.examen20201103.examenA;

import tutorialJava.Utils;

/**
 * Crea una clase con un método “main” que cree un array con 100 elementos de longitud,
los elementos deben ser números enteros al azar comprendidos entre dos límites, que deben ser
preguntados al usuario. Muestra el array en orden normal y también en orden invertido.
 */
public class EjercicioB_100_num_azar_entre_limites_e_invertido {

	public static void main(String[] args) {
		int numeros[] = new int[100]; // Declaro el array
		int limInf, limSup; // Declaro los límites de generación de números al azar
		
		// Pido el límite inferior
		System.out.println("Dame un límite inf: ");
		limInf = Utils.obtenerEntero();
		
		// Pido el límite superior
		System.out.println("Dame un límite sup: ");
		limSup = Utils.obtenerEntero();
		
		// Obtengo números al azar entre dos límites, para todo el array
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = (int) Math.round(Math.random() * (limSup - limInf) + limInf);
		}
		
		// Imprimo en orden normal, de izquierda a derecha
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
		}
		System.out.println("");
		
		// Imprimo el array en orden invertido, de derecha a izquierda
		for (int i = numeros.length - 1; i >= 0; i--) {
			System.out.print(numeros[i] + " ");
		}

	}

}
