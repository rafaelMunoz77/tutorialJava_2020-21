package tutorialJava.capitulo3_bucles.ejercicios.bloque03;

import javax.swing.JOptionPane;

public class Ejercicio03_MayorNumerosHastaUsuarioDecida {

	/**
	 * Realiza un ejercicio que pida números al usuario hasta que este introduzca el 0 (cero). Al finalizar el ejercicio 
	 * se debe imprimir en pantalla el valor mayor introducido. El valor 0 (cero) no debe tenerse en cuenta.
	 * @param args
	 */
	public static void main(String[] args) {
		int mayor = 0, num = -1; // Declaro e inicializo las variables

		// Bucle que pide números y localiza el mayor
		for (int i = 0; num != 0; i++) {
			num = Integer.parseInt(JOptionPane.showInputDialog(
					"Introduzca número (0 -> Salir): "));
			
			// Si es la primera vez que se ejecuta el bucle, se considera que el número introducido es el mayor
			if (i == 0) {
				mayor = num;
			}
			else {
				if (num > mayor && num != 0) {
					mayor = num;
				}
			}
		}
		
		// Sacamos el mensaje final con el valor acumulado
		JOptionPane.showMessageDialog(null, "Mayor total " + mayor); 
	}
	
	

}
