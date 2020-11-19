package tutorialJava.capitulo2_condicionales.ejercicios.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio05_Mayor_y_menor_de_5_variables {

	/**
	 * Pedir al usuario cinco números, e imprimir posteriormente el mayor valor introducido y el menor valor introducido.
	 * @param args
	 */
	public static void main(String[] args) {
		// Pido las 5 variables
		String str = JOptionPane.showInputDialog("Introduzca el primer número");
		int num1 = Integer.parseInt(str);

		str = JOptionPane.showInputDialog("Introduzca el segundo número");
		int num2 = Integer.parseInt(str);

		str = JOptionPane.showInputDialog("Introduzca el tercer número");
		int num3 = Integer.parseInt(str);

		str = JOptionPane.showInputDialog("Introduzca el cuarto número");
		int num4 = Integer.parseInt(str);

		str = JOptionPane.showInputDialog("Introduzca el quinto número");
		int num5 = Integer.parseInt(str);

		// Determino el mayor
		if (num1 >= num2 && num1 >= num3 && num1 >= num4 && num1 >= num5) {
			System.out.println("El mayor es " + num1);
		}
		else {
			if (num2 >= num3 && num2 >= num4 && num2 >= num5) {
				System.out.println("El mayor es " + num2);
			}
			else {
				if (num3 >= num4 && num3 >= num5) {
					System.out.println("El mayor es " + num3);
				}
				else {
					if (num4 >= num5) {
						System.out.println("El mayor es " + num4);
					}
					else {
						System.out.println("El mayor es " + num5);
					}
				}
			}
		}
		
		// Determino el menor
		if (num1 <= num2 && num1 <= num3 && num1 <= num4 && num1 <= num5) {
			System.out.println("El menor es " + num1);
		}
		else {
			if (num2 <= num3 && num2 <= num4 && num2 <= num5) {
				System.out.println("El menor es " + num2);
			}
			else {
				if (num3 <= num4 && num3 <= num5) {
					System.out.println("El menor es " + num3);
				}
				else {
					if (num4 <= num5) {
						System.out.println("El menor es " + num4);
					}
					else {
						System.out.println("El menor es " + num5);
					}
				}
			}
		}
		
	}

}
