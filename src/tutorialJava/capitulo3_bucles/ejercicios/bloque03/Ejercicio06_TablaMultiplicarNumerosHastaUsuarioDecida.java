package tutorialJava.capitulo3_bucles.ejercicios.bloque03;

import javax.swing.JOptionPane;

public class Ejercicio06_TablaMultiplicarNumerosHastaUsuarioDecida {

	/**
	 * Realiza un ejercicio que pida números al usuario, hasta que uno de ellos sea 0 (cero). Para cada número introducido 
	 * se debe mostrar en pantalla su tabla de multiplicar, desde el 0 (cero) hasta el 10.
	 * @param args
	 */
	public static void main(String[] args) {
		int num = -1;
		String tablaMultiplicar = "";

		// Bucle para pedir número y enseñar tabla de multiplicar
		do { 
			num = Integer.parseInt(JOptionPane.showInputDialog(
				"Introduzca número (0 -> Salir): "));
			
			// Si el número es diferente de cero se imprime una tabla de multiplicar
			if (num != 0) {
				tablaMultiplicar = "";
				for (int i = 1; i < 11; i++) {
					tablaMultiplicar += num + " x " + i + " = " + 
							(num * i) + "\n";
				}
				JOptionPane.showMessageDialog(null, tablaMultiplicar); 
			}
		} while (num != 0);
		
	}
	
	

}
