package tutorialJava.examenes.examen20201103.examenB;

import tutorialJava.Utils;

/**
 * Capítulo 5 - Bloque 1 - Ejercicio 0.
 * Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre 0 y 100. 
 * Debes mostrar el array en pantalla y obtener la suma, la media, el menor y el mayor de todos 
 * los números que aparecen en el array.
 *
 */
public class EjercicioA_Mayor_Menor_Suma_Media_de_Array {
	
	/**
	 * Método principal
	 * @param args
	 */
	public static void main(String[] args) {
		// Declaro las variables implicadas en el programa
		int mayor, menor, suma;

		// Declaración del array, a través de la sentencia "new"
		int numeros[] = new int[5];
		
		// Inicializo el array
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = Utils.obtenerNumeroAzar();
		}
		
		// Muestro el array en pantalla
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
		}
		
		// Comienzo asumiendo que el primer número del array es, al mismo tiempo, el
		// mayor y el menor
		mayor = numeros[0];
		menor = numeros[0];
		suma = numeros[0];
		
		// Una vez he trabajado con el primer elemento del array, recorro a partir de 
		// la posición 1 para descubrir mayores y menores, y calcular la suma
		for (int i = 1; i < numeros.length; i++) {
			suma += numeros[i];
			if (numeros[i] > mayor) {
				mayor = numeros[i];
			}
			if (numeros[i] < menor) {
				menor = numeros[i];
			}
		}
		
		// Muestro los resultados en consola. Para mostrar la media, la calculo
		System.out.println("mayor " + mayor + " menor " + menor + " suma " + suma +
				" media " + (suma / (float) numeros.length));
	}

}
