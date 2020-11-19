package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque05_Metodos_sobre_arrays;

public class Ejercicio01_String_from_array {

	/**
	 * Un método llamado "stringFromArray", que reciba un array de números enteros y devuelva una cadena de caracteres. 
	 * El método debe recorrer el array, de la misma forma en la que harías para mostrarlo en consola, pero en lugar de 
	 * imprimir en consola debes construir un objeto String. Finalmente debes devolver el String e imprimirlo en el método "main".
	 * @param args
	 */
	public static void main(String[] args) {
		int array[] = new int[] {1, 2, 3, 4, 5};
		String str = stringFromArray(array);
		System.out.println(str);
	}
	
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public static String stringFromArray (int array[]) {
		String str = ""; // Declaro e inicializo un String
		
		// Recorro todo el array, agregando cada elemento al String que estoy creando
		for (int i = 0; i < array.length; i++) {
			str += array[i] + " ";
		}
		
		// Finalmente devuelvo el String
		return str;
	}

}
