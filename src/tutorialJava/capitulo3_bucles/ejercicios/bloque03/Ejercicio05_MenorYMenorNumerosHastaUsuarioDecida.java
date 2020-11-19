package tutorialJava.capitulo3_bucles.ejercicios.bloque03;

import javax.swing.JOptionPane;

public class Ejercicio05_MenorYMenorNumerosHastaUsuarioDecida {

	/**
	 * Realiza un ejercicio parecido a los dos anteriores, dónde se imprima el mayor valor y el menor de todos los introducidos.
	 * @param args
	 */
	public static void main(String[] args) {
		int menor = 0, mayor = 0, num = -1; // Declaro variables e inicializo

		// Pido números y voy calculando el mayor y el menor
		for (int i = 0; num != 0; i++) {
			num = Integer.parseInt(JOptionPane.showInputDialog(
					"Introduzca número (0 -> Salir): "));
			
			// Si es el primer número pedido, entiendo que es el menor y el mayor
			if (i == 0) {
				menor = num;
				mayor = menor;
			}
			else {
				if (num < menor && num != 0) {
					menor = num;
				}
				if (num > mayor && num != 0) {
					mayor = num;
				}
			}
		}
		
		// Sacamos el mensaje final con el valor acumulado
		JOptionPane.showMessageDialog(null, "Mayor " + mayor + 
				" y menor " + menor); 
	}
	
	

}
