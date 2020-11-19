package tutorialJava.capitulo3_bucles.ejercicios.bloque03;

import javax.swing.JOptionPane;

public class Ejercicio01_SumaNumerosHastaUsuarioDecida {

	/**
	 * Realiza un ejercicio que pida números al usuario. El programa debe detenerse cuando el usuario introduzca el número 0 (cero), 
	 * que no debe tenerse en cuenta para ninguna operación aritmética, simplemente para salir de la aplicación. Cuando el programa 
	 * haya terminado, se debe sacar en pantalla el valor de la suma de todos los números.
	 * @param args
	 */
	public static void main(String[] args) {
		int suma = 0, num;

		do {
			num = Integer.parseInt(JOptionPane.showInputDialog(	"Introduzca número (0 -> Salir): "));
			suma = suma + num;
		} while (num != 0);
		
		// Sacamos el mensaje final con el valor acumulado
		JOptionPane.showMessageDialog(null, "Total acumulado " + suma);

	}

}
