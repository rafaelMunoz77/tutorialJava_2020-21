package tutorialJava.capitulo3_bucles.ejercicios.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio03_ContadorPositivosYNegativos {

	/**
	 * Realiza un ejercicio que pida números al usuario, tantos como indique el usuario. al final debe aparecer cuantos 
	 * números positivos y negativos se han introducido.
	 * @param args
	 */
	public static void main(String[] args) {
		// Inicializo los contadores
		int contadorPositivos = 0, contadorNegativos = 0;
		
		// Petición al usuario de la cantidad de números a introducir
		int numsAPedir = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad de números a proporcionar"));
		
		// Pido los números dentro de un bucle
		for (int i = 0; i < numsAPedir; i++) {
			int num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un número"));
			if (num < 0) {
				contadorNegativos++;
			}
			else {
				contadorPositivos++;
			}
		}

		// Muestro los datos al usuario
		System.out.println("Positivos introducidos: " + contadorPositivos + " - negativos: "
				+ contadorNegativos);
	}

}
