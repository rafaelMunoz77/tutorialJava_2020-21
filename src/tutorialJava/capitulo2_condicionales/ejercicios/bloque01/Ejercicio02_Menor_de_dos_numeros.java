package tutorialJava.capitulo2_condicionales.ejercicios.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio02_Menor_de_dos_numeros {

	/**
	 * Realiza un ejercicio que pida dos variables al usuario, tras lo cual, muestre en pantalla el número menor de los dos introducidos.
	 * @param args
	 */
	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog("Introduzca el primer número");
		int num1 = Integer.parseInt(str);

		str = JOptionPane.showInputDialog("Introduzca el segundo número");
		int num2 = Integer.parseInt(str);
		
		// Comparo los dos números
		if (num1 <= num2) {
			System.out.println("El " + num1 + " es el menor");
		}
		else {
			System.out.println("El " + num2 + " es el menor");
		}	
	}

}
