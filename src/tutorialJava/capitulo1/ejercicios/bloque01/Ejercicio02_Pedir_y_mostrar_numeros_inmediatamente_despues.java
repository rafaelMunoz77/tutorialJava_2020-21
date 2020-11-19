package tutorialJava.capitulo1.ejercicios.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio02_Pedir_y_mostrar_numeros_inmediatamente_despues {

	/*
	 2º.-Realiza un programa igual al anterior, con la particularidad de que ahora 
	 se debe mostrar cada número justo a continuación del momento en que ha sido 
	 introducido.
	 */
	
	public static void main(String[] args) {
		int numEntero;
		float numFlotante;
		double numDouble;
		
		// Número entero
		String str = JOptionPane.showInputDialog("Introduce un número entero: ");
		numEntero = Integer.parseInt(str);
		System.out.println("El número entero es: " + numEntero);
		
		// Número flotante, lo leo del usuario y lo imprimo
		str = JOptionPane.showInputDialog("Introduce un número flotante: ");
		numFlotante = Float.parseFloat(str);
		System.out.println("El número flotante es: " + numFlotante );
		
		// Número double, lo leo del usuario y lo imprimo
		str = JOptionPane.showInputDialog("Introduce un número double: ");
		numDouble = Double.parseDouble(str);
		System.out.println("El número dobule es: " + numDouble);
		

	}

}
