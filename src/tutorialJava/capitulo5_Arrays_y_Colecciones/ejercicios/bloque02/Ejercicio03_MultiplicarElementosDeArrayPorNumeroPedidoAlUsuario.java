package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque02;

import javax.swing.JOptionPane;

import tutorialJava.Utils;
import tutorialJava.UtilsArrays;

public class Ejercicio03_MultiplicarElementosDeArrayPorNumeroPedidoAlUsuario {

	/**
	 * Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre 0 y 100. Debes conseguir 
	 * multiplicar cada uno de los elementos del array por un número determinado, pedido al usuario
	 * @param args
	 */
	public static void main(String[] args) {
		// Declaración del array
		int array[] = new int[150];
		
		// Inicializamos el contenido de los arrays
		for (int i = 0; i < array.length; i++) {
			array[i] = obtenerNumeroAleatorio(-100, 100);
		}

		// Pido un número al usuario
		int numUsuario = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un número: "));

		// Imprimir en la consola el array
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		
		// Recorro el array multiplicando por un valor
		for (int i = 0; i < array.length; i++) {
			array[i] *= numUsuario;
		}
		
		// Vuelvo a imprimir en la consola el array
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	
	/**
	 * 
	 * @return
	 */
	private static int obtenerNumeroAleatorio (int limiteInferior, int limiteSuperior) {
		return (int) Math.round(Math.random() * (limiteSuperior - limiteInferior) + limiteInferior);
	}	
}
