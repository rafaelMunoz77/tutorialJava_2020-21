package tutorialJava.capitulo3_bucles.ejercicios.bloque02;

import javax.swing.JOptionPane;

public class Ejercicio03_MultiplosDeUnNumeroIndicado {

	/**
	 * Ejercicio que obtenga todos los múltiplos de un número introducido por el usuario. Se imprimirán 
	 * todos los múltiplos menores de 100, este será el límite.
	 * @param args
	 */
	public static void main(String[] args) {
		// Petición al usuario de la cantidad de números a introducir
		int num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca número al que calcular múltiplos"));
		
		for (int i = 0; i <= 100; i++) {
			// Sólo imprimo si el valor de "i" es múltiplo del "num"
			if (i % num == 0) {
				// Muestro un múltiplo
				System.out.println(i);
			}
		}
	}

}
