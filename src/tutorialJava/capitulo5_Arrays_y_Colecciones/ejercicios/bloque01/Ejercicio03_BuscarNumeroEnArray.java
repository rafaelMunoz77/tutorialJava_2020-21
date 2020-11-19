package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque01;

import javax.swing.JOptionPane;

import tutorialJava.UtilsArrays;

public class Ejercicio03_BuscarNumeroEnArray {

	/**
	 * Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre 0 y 100. A continuación 
	 * pedirás al usuario un valor y buscarás dicho valor en el array. Si lo encuentras, debes indicar al usuario 
	 * la posición del array en que se encuenta. En caso de que no encuentres el valor buscado, debes indicárselo también al usuario.
	 * @param args
	 */
	public static void main(String[] args) {
		int numeroBuscado;
		// Declaración de array
		int array[] = new int[5];
		
		// Inicializamos el contenido del array
		for (int i = 0; i < array.length; i++) {
			array[i] = obtenerNumeroAleatorio(0, 100);
		}

		// Imprimir en la consola el array creado
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		
		// Imprimo un salto de línea
		System.out.println();
		
		// Pedir número al usuario
		numeroBuscado = Integer.parseInt(JOptionPane.showInputDialog("Introduzca número"));

		// Una línea en blanco
		System.out.println();
		
		boolean estaNumeroBuscadoEnArray = false;
		// Buscar el número del usuario
		for (int i = 0; i < array.length && !estaNumeroBuscadoEnArray; i++) {
			if (numeroBuscado == array[i]) {
				System.out.println("He encontrado el número " + numeroBuscado + 
						" en posición " + i);
				estaNumeroBuscadoEnArray = true;
			}
		}

		// Si el contador está a cero, después de haber recorrido el array,
		// sabemos que el número buscado no está en el mismo
		if (!estaNumeroBuscadoEnArray) {
			System.out.println("El número " + numeroBuscado + " no se encuentra");
		}
	}
	
	

	/**
	 * 
	 * @return
	 */
	private static int obtenerNumeroAleatorio (int limiteInferior, int limiteSuperior) {
		return (int) Math.round(Math.random() * (limiteSuperior - limiteInferior) + limiteInferior);
	}

}
