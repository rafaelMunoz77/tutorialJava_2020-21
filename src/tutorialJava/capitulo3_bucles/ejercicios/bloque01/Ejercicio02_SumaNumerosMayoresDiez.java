package tutorialJava.capitulo3_bucles.ejercicios.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio02_SumaNumerosMayoresDiez {

	/**
	 * Modifica el ejercicio anterior de manera que, en lugar de que el programa siempre pida cuatro números, sea el 
	 * usuario el que decida cuantos números se van a pedir.
	 * @param args
	 */
	public static void main(String[] args) {
		int acumuladorMayoresDiez = 0;
		
		// Petición al usuario de la cantidad de números a introducir
		int numsAPedir = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad de números a proporcionar"));
		
		// Pido los números y sumo sólo aquellos mayores de 10
		for (int i = 0; i < numsAPedir; i++) {
			int num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un número"));
			if (num >= 10) {
				acumuladorMayoresDiez += num;
			}
		}

		// Muestro los datos al usuario
		System.out.println("Suma de los mayores de diez introducidos: " + acumuladorMayoresDiez);
	}

}
