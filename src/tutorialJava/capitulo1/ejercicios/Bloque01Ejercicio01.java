package tutorialJava.capitulo1.ejercicios;

import javax.swing.JOptionPane;

public class Bloque01Ejercicio01 {
	
	/*
	 1º.-Realiza un programa que pida al usuario tres números: uno de tipo entero, 
	 otro de tipo flotante y otro de tipo doble. A continuación se tienen que mostrar 
	 en pantalla los tres números en una sola fila de la consola de salida.
	  */

	public static void main(String[] args) {
		int numEntero;
		float numFlotante;
		double numDouble;
		
		String str = JOptionPane.showInputDialog("Introduce un número entero: ");
		numEntero = Integer.parseInt(str);
		str = JOptionPane.showInputDialog("Introduce un número flotante: ");
		numFlotante = Float.parseFloat(str);
		str = JOptionPane.showInputDialog("Introduce un número double: ");
		numDouble = Double.parseDouble(str);
		
		System.out.println("El número entero es: " + numEntero + 
				"\nEl número flotante es: " + numFlotante + 
				"\nEl número dobule es: " + numDouble);
		
	}

}
