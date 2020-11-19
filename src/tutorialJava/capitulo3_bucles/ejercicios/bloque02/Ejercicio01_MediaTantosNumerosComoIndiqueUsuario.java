package tutorialJava.capitulo3_bucles.ejercicios.bloque02;

import javax.swing.JOptionPane;

public class Ejercicio01_MediaTantosNumerosComoIndiqueUsuario {

	/**
	 * Media de una cantidad de números introducidos por el usuario. El usuario especificará una cantidad de números, 
	 * tras lo cual se le deben pedir tantos como este haya indicado. Al final se debe imprimir la media.
	 * @param args
	 */
	public static void main(String[] args) {
		float media = 0;
		
		// Petición al usuario de la cantidad de números a introducir
		int numsAPedir = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad de números a proporcionar"));
		
		for (int i = 0; i < numsAPedir; i++) {
			// Pido un número al usuario
			int num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un número"));
			// Voy acumulando los números dados por el usuario en la variable "media"
			media += num;
		}

		// Muestro los datos al usuario
		System.out.println("Media " + (media / numsAPedir));
	}

}
