package tutorialJava.capitulo1.ejercicios.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio07_Complemento_a_2 {

	/**
	 * Realiza el "complemento a dos" de un número dado por el usuario. El complemento a dos consiste en dos pasos: 
	 * en primer lugar se deben cambiar todos los bits del valor al que el complemento se está aplicando, 
	 * en segundo lugar se le debe sumar 1 (uno). Este ejercicio pedirá al usuario un valor y mostrará el complemento a dos del mismo
	 * @param args
	 */
	public static void main(String[] args) {

		// Pido un número entero
		String str = JOptionPane.showInputDialog("Introduce un número entero: ");
		int num = Integer.parseInt(str);
		
		// Calculo el complemento a 2
		num = ~num + 1;
		System.out.println("Complemento a 2 calculado: " + num);
	}

}
