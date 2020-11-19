package tutorialJava.capitulo2_condicionales.ejercicios.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio06_Numero_par_o_impar {

	/**
	 * Realizar un ejercicio que pida un número al usuario e indique en pantalla si se trata de un número par o impar. 
	 * Recuerda que un número par es aquel cuyo resto de su división entre dos sea siempre cero, y recuerda que un número 
	 * impar es aquel cuyo resto de su división entre dos sea siempre uno.
	 * @param args
	 */
	public static void main(String[] args) {
		// Pido una variable
		String str = JOptionPane.showInputDialog("Introduzca un número");
		int num = Integer.parseInt(str);

		// Compruebo si es par o impar
		if (num % 2 == 0) {
			System.out.println("El número es par");
		}
		else {
			System.out.println("El número es impar");
		}
	}
}
