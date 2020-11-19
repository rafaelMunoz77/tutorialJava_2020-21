package tutorialJava.capitulo2_condicionales.ejercicios.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio07_Numero_par_o_impar_por_bits {

	/**
	 * Utiliza la operación AND y el operador "if", para tratar de averiguar si un número introducido por el usuario es par o impar. 
	 * Sería recomendable que estudiases el código de la clase "OperadoresANivelDeBits" del capítulo 1 de este tutorial.
	 * @param args
	 */
	public static void main(String[] args) {
		// Pido una variable
		String str = JOptionPane.showInputDialog("Introduzca un número");
		int num = Integer.parseInt(str);

		// Compruebo si es par o impar
		if ((num & 1) == 0) {
			System.out.println("El número es par");
		}
		else {
			System.out.println("El número es impar");
		}
	}

}
