package tutorialJava.capitulo3_bucles.ejercicios.bloque02;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ejercicio04_MultiplosDeUnNumeroIndicadoConLimiteIndicado {

	/**
	 * Reforma el ejercicio anterior, para que el límite sea también introducido por el usuario.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// Petición al usuario de la cantidad de números a introducir
		System.out.println("Introduzca número al que calcular múltiplos");
		int num = scanner.nextInt();
		
		// Petición del límite hasta el que llegar 
		System.out.println("Introduzca el límite hasta el que llegar");
		int limite = scanner.nextInt();
		
		for (int i = 0; i <= limite; i++) {
			// Sólo imprimo si el valor de "i" es múltiplo del "num"
			if (i % num == 0) {
				// Muestro un múltiplo
				System.out.println(i);
			}
		}
	}

}
