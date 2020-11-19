package tutorialJava.capitulo3_bucles.ejercicios.bloque02;

import javax.swing.JOptionPane;

public class Ejercicio02_MayorYMenorDeTantosNumerosComoIndiqueUsuario {

	/**
	 * Mayor y menor de una cantidad de números dada por el usuario. El usuario introducirá una cantidad de números, tras lo cual 
	 * se le deben pedir tantos como este haya indicado. Al final se debe imprimir el mayor y el menor de todos los introducidos.
	 * @param args
	 */
	public static void main(String[] args) {
		int mayor = 0, menor = 0;
		
		// Petición al usuario de la cantidad de números a introducir
		int numsAPedir = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad de números a proporcionar"));
		
		for (int i = 0; i < numsAPedir; i++) {
			// Pido un número al usuario
			int num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un número"));
			// Compruebo si es la primera iteración, la primera vez que se pide número al usuario
			// Si es el primer número pedido, automáticamente ese es el mayor y el menor
			if (i == 0) {
				mayor = num;
				menor = num;
			}
			// Si no es el primer número pedido, debe comparar cada número pedido con el
			// actual mayor y el actual menor
			else {
				// Comparo con el mayor
				if (num > mayor) mayor = num;
				// Comparo con el menor
				if (num < menor) menor = num;
			}
		}

		// Muestro los datos al usuario
		System.out.println("Mayor: " + mayor + " - Menor: " + menor);
	}

}
