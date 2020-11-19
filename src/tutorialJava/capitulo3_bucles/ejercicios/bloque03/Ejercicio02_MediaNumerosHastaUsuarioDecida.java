package tutorialJava.capitulo3_bucles.ejercicios.bloque03;

import javax.swing.JOptionPane;

public class Ejercicio02_MediaNumerosHastaUsuarioDecida {

	/**
	 * Realiza un ejercicio igual al anterior, con la particularidad de imprimir la media al final del ejercicio, no la suma
	 * @param args
	 */
	public static void main(String[] args) {
		int suma = 0, num = -1, i; // Declaro e inicializo variables

		// Bucle que pedirá números al usuario
		for (i = 0; num != 0; i++) {
			num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca n�mero (0 -> Salir): "));
			suma = suma + num;
		}
		
		// Sacamos el mensaje final con el valor acumulado
		JOptionPane.showMessageDialog(null, "Media total " + ((float) suma / (i-1))); 
	}
	
	

}
