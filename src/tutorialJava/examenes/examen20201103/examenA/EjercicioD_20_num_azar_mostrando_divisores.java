package tutorialJava.examenes.examen20201103.examenA;


/**
 * Crea una clase con un método “main” que cree un array de 20 posiciones con números
enteros generados al azar entre 0 y 100. Muestra el array. Para cada número del array debes mostrar
en pantalla sus divisores
 */
public class EjercicioD_20_num_azar_mostrando_divisores {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int numeros[] = new int[20]; // Declaro el array
		
		// Recorreo el array y le asigno números al azar entre 0 y 100
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = (int) Math.round(Math.random() * 100);
		}
		
		// Recorro el array y, para cada elemento, busco sus divisores
		for (int i = 0; i < numeros.length; i++) {			
			System.out.println("Divisores de " + numeros[i]);
			
			// Recorro los valores entre "2" y la mitad más 1 del elemento numeros[i].
			// De esa manera tengo el intervalo en el que puedo encontrar divisores
			for (int j = 2; j < (numeros[i] / 2 + 1); j++) {
				if (numeros[i] % j == 0) { // Divisor encontrado. j es divisor de numeros[i]
					System.out.println("\t " + j + " es divisor de " + numeros[i]);
				}
			}
		}
	}

}
