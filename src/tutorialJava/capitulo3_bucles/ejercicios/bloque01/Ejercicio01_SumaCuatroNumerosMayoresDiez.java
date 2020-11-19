package tutorialJava.capitulo3_bucles.ejercicios.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio01_SumaCuatroNumerosMayoresDiez {

	/**
	 * Realiza un programa que pida al usuario cuatro números enteros, y calcule la suma solo de aquellos números 
	 * introducidos por el usuario, que sean mayores de 10. Es decir, que si el usuario introduce el 5, el 15, el 6 
	 * y el 25, el programa debe calcular la suma solo de 15 más 25, ya que 5 y 6 son menores de 10.
	 * @param args
	 */
	public static void main(String[] args) {
		int acumuladorMayoresDiez = 0; // Inicializo un acumulador
		
		// Pido 4 números y sumo sólo los mayores de 10
		for (int i = 0; i < 4; i++) {
			int num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un n�mero"));
			if (num >= 10) {
				acumuladorMayoresDiez += num;
			}
		}

		// Muestro los datos al usuario
		System.out.println("Suma de los mayores de diez introducidos: " + acumuladorMayoresDiez);
	}

}
