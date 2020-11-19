package tutorialJava.capitulo3_bucles.ejercicios.bloque03;

import javax.swing.JOptionPane;

public class Ejercicio07_ContadorPositivosYNegativosHastaUsuarioDecida {

	/**
	 * Realiza un ejercicio que pida números al usuario, hasta que uno de ellos sea 0 (cero). Al finalizar se debe imprimir 
	 * en pantalla cuantos son positivos y cuantos negativos. No debes tener en cuenta el 0 (cero).
	 * @param args
	 */
	public static void main(String[] args) {
		int num = -1, contPos = 0, contNeg = 0;

		
		do {
			num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca número (0 -> Salir): "));

			if (num < 0) { // Es negativo
				contNeg++;
			}
			if (num > 0) { // Es positivo
				contPos++;
			}
		} while (num != 0);
		
		// Impresión de los resultados
		JOptionPane.showMessageDialog(null, "Positivos " + contPos + 
				" y negativos " + contNeg);
	}
	
	

}
