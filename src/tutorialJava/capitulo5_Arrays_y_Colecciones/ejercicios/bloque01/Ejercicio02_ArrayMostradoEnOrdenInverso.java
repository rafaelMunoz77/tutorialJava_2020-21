package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio02_ArrayMostradoEnOrdenInverso {

	/**
	 * Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre 0 y 100. Después de su inicialización 
	 * debéis imprimir el array en orden inverso.
	 * @param args
	 */
	public static void main(String[] args) {
		int numeros[] = new int[5];

		// Inicializamos el contenido del array
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = numeroAleatorio();
		}
		
		// Imprimir en la consola el array creado
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
		}
		
		// Imprimo un salto de línea
		System.out.println();

		// Muestro el array en orden inverso
		for (int i = numeros.length - 1; i > -1; i--) {
			System.out.print(numeros[i] + " ");
		}
	}

	
	/**
	 * 
	 * @return
	 */
	private static int numeroAleatorio () {
		return (int) Math.round(Math.random() * 100);
	}
}
