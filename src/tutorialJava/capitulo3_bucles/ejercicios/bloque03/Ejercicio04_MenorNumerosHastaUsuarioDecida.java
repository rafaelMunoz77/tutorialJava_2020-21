package tutorialJava.capitulo3_bucles.ejercicios.bloque03;

import javax.swing.JOptionPane;

public class Ejercicio04_MenorNumerosHastaUsuarioDecida {

	/**
	 * Realiza un ejercicio igual al anterior, con la particularidad de que debe imprimir en pantalla el menor, no el mayor.
	 * @param args
	 */
	public static void main(String[] args) {
		int menor = 0, num = -1; // Declaro e inicializo variables

		// Pido números y calculo el menor
		for (int i = 0; num != 0; i++) {
			num = Integer.parseInt(JOptionPane.showInputDialog(
					"Introduzca número (0 -> Salir): "));
			
			// Si se pide el primer número, se considera que es el menor
			if (i == 0) {
				menor = num;
			}
			else {
				if (num < menor && num != 0) {
					menor = num;
				}
			}
		}
		
		// Sacamos el mensaje final con el valor acumulado
		JOptionPane.showMessageDialog(null, "Menor total " + menor); 
	}
	
	

}
