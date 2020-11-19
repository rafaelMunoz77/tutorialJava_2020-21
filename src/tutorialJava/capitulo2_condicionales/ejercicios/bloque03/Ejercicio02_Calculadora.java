package tutorialJava.capitulo2_condicionales.ejercicios.bloque03;

import javax.swing.JOptionPane;

public class Ejercicio02_Calculadora {
	
	/**
	 * Realiza una calculadora avanzada, pero con la particularidad de que las operaciones deben ser raices, potencias 
	 * y el módulo de la división.
	 * @param args
	 */
	public static void main(String[] args) {
		// Muestro menú y obtengo elección del usuario
		String str = JOptionPane.showInputDialog("1.- Raíz enésima\n"
				+ "2.- Potencia\n"
				+ "3.- Módulo de división\n\n"
				+ "Introduzca opción: ");
		int opcion = Integer.parseInt(str);
		
		// Comienzo con el tratamiento de la opción elegida, en el switch
		switch (opcion) {
		case 1: // La raíz enésima 
			// Lectura del radicando y del índice de la raíz
			str = JOptionPane.showInputDialog("Introduzca el radicando");
			int radicando = Integer.parseInt(str);
			str = JOptionPane.showInputDialog("Introduzca el índice");
			int indice = Integer.parseInt(str);
			// Calculo la raíz
			float raiz = (float) Math.pow(radicando, 1f / indice);
			System.out.println("La raíz vale " + raiz);
			break;
			
		case 2: // Potencia
			// Lectura de la base y el exponente
			str = JOptionPane.showInputDialog("Introduzca la base");
			int base = Integer.parseInt(str);
			str = JOptionPane.showInputDialog("Introduzca el exponente");
			int exponente = Integer.parseInt(str);
			// Cálculo de la potencia
			System.out.println("La potencia vale " + Math.pow(base, exponente));
			break;
			
		case 3: // M�dulo de la división entera
			// Lectura de dividendo y divisor
			str = JOptionPane.showInputDialog("Introduzca el dividendo");
			int dividendo = Integer.parseInt(str);
			str = JOptionPane.showInputDialog("Introduzca el divisor");
			int divisor = Integer.parseInt(str);
			// C�lculo de la potencia
			System.out.println("El módulo vale " + (dividendo % divisor));
			break;
			
		default:
			System.out.println("Opción no permitida");
		}
	}

}
