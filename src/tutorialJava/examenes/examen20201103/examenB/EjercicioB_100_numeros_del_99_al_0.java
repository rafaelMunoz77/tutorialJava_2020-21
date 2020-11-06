package tutorialJava.examenes.examen20201103.examenB;

/**
 * Crea una clase con un método “main” que cree un array de 100 elementos. Los elementos
serán de tipo entero y deben corresponder con los números del 99 al 0, en ese orden. Muestra el array
 */
public class EjercicioB_100_numeros_del_99_al_0 {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int numeros[] = new int[100]; // Declaro el array
		
		// Recorro el array, asignando a cada elemento el resultado de 99 menos el valor de i.
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = 99 - i;
		}
		
		// Muestro el array.
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
		}
	}

}
