package tutorialJava.capitulo5_Arrays_y_Colecciones.arraysPrimitivos;

public class EjemploArraysPrimitivos {
	
	public static void main(String[] args) {
		// Declaraci�n del array, a trav�s de la sentencia "new"
		int numeros[] = new int[10];
		
		
		// Inicializaci�n de los valores del array
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = i + 1;
		}

		// Recorrido del array para imprimir sus valores en pantalla
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
		} 
		
/*		
		
		// Otra forma de inicializar el array
		int array2[] = new int[] {88, 89, 90, 4, 5, 6, 7, 8, 9, 10};

		// Recorrido del array para imprimir sus valores en pantalla
		for (int i : array2) {
			System.out.println(i);
		} */
	}

}
