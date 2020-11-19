package tutorialJava.capitulo1.ejercicios.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio05_Intercambiar_valores_dos_variables {

	/*
	 * 5º.- Realiza un programa en C que pida dos variables al usuario, intercambie 
	 * los valores de las dos variables y las muestre en pantalla ANTES y DESPUéS 
	 * del intercambio de valores.
	 */
	
	public static void main(String[] args) {
		int num1, num2, aux;
		
		// Número entero
		String str = JOptionPane.showInputDialog("Introduce un número entero: ");
		num1 = Integer.parseInt(str);

		// Número entero
		str = JOptionPane.showInputDialog("Introduce un número entero: ");
		num2 = Integer.parseInt(str);

		System.out.println("Num1 vale: " + num1 + " - y Num2 vale: " + num2);
		
		aux = num1;
		num1 = num2;
		num2 = aux;
		
		System.out.println("Num1 vale: " + num1 + " - y Num2 vale: " + num2);
	}

}
