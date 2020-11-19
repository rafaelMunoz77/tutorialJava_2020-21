package tutorialJava.capitulo1.ejercicios.bloque01;

import javax.swing.JOptionPane;

public class EJercicio03_Calcula_suma_3_numeros {

	/*
	 3º.- Realiza un programa que pida al usuario tres números y calcule y muestre
	  en pantalla la suma de los tres
	 */
	
	public static void main(String[] args) {
		int numEntero;
		float numFlotante;
		double numDouble;
		double suma;
		
		// Número entero
		String str = JOptionPane.showInputDialog("Introduce un número entero: ");
		numEntero = Integer.parseInt(str);
		
		// Número flotante, lo leo del usuario
		str = JOptionPane.showInputDialog("Introduce un número flotante: ");
		numFlotante = Float.parseFloat(str);
		
		// Número double, lo leo del usuario 
		str = JOptionPane.showInputDialog("Introduce un número double: ");
		numDouble = Double.parseDouble(str);
		
		suma = numEntero + numFlotante + numDouble;
		System.out.println("La suma es: " + suma);
		
	}

}
