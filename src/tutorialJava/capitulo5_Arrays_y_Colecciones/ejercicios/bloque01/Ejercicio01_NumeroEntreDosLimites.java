package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio01_NumeroEntreDosLimites {

	/**
	 * Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre un límite inferior y uno superior 
	 * que debe especificar el usuario. Debes mostrar el array en pantalla para comprobar el funcionamiento
	 * @param args
	 */
	public static void main(String[] args) {
		// Declaración de variables
		int limiteInf, limiteSup;
		int numeros[] = new int[150];
		
		// Petición de límites al usuario
		limiteInf = Integer.parseInt(JOptionPane.showInputDialog("Introduzca límite inferior"));
		limiteSup = Integer.parseInt(JOptionPane.showInputDialog("Introduzca límite superior"));

		// Inicializamos el contenido del array
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = (int) Math.round(Math.random() * (limiteSup - limiteInf) + limiteInf);
		}
		
		// Imprimir en la consola el array creado
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
		}
		
		// Imprimo un salto de línea
		System.out.println();
		
		// Otra forma de iterar sobre un array
		for (int num : numeros) {
			System.out.print(num + " ");
		}
	}

}
