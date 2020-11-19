package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque04_Metodos;

import tutorialJava.Utils;
import tutorialJava.UtilsArrays;

public class EjerciciosMetodos {

	/**
	 * Método main, para testear los métodos pedidos
	 * @param args
	 */
	public static void main(String[] args) {
		// Testeo del método "media()"
		float valorMedia = media(3, 4, 5, 6.7f);
		System.out.println("Media calculada: " + valorMedia);
		
		// Testeo del método "obtenerNumeroDeUsuarioEntreMinimoYMaximo()"
//		System.out.println("Introduzca un número entre 0 y 10");
//		int valorIntroducido = obtenerNumeroUsuarioEntreMinimoYMaximo(0, 10);
//		System.out.println("Valor introducido: " + valorIntroducido);
		
		// Testeo del método "maximo()"
//		System.out.println("Mayor valor es: " + maximo(4, 5));
		
		// Testeo del método "aleatorioImparEntreLimites()"
//		System.out.println("Aleatorio impar entre 4 y 16: " + aleatorioImparEntreLimites(4, 16));
		
		// Testeo del método "traduceNumero()"
//		System.out.println("Traduce Número: " + traduceNumero(6));
		
		// Testeo del método "minimoAMaximo()"
//		minimoAMaximo(45, 12, 22);
		
		// Testeo del método "fibonacci()"
//		int fibo[] = fibonacci(20);
		//Muestro el array
//		for (int i = 0; i < fibo.length; i++) {
//			System.out.print(fibo[i] + " ");
//		}
//		System.out.println();
		
		// Testeo del método "imprimeArray()"
//		int array[] = new int[] {1, 2, 3, 4, 5};
//		imprimeArray(array);
		
		// Testeo del método "recortaArray()"
//		int array[] = new int[] {1, 2, 3, 4, 5};
//		int nuevoArray[] = recortaArray(array, 2, 4);
//		imprimeArray(nuevoArray);
		
		// Testeo del método "imprimeHastaNumero()"
//		imprimeHastaNumero(100);
		
	}
	
	/**
	 * Método que reciba como parámetros de entrada tres valores enteros y uno flotante. El método se llamará "media" y debe devolver la 
	 * media aritmética de los cuatro valores. El valor devuelto debe ser flotante. El método "main" debe llamar a este otro método, con 
	 * valores inventados por ti, e imprimir el valor de la media en la conso
	 * 
	 * @param n1
	 * @param n2
	 * @param n3
	 * @param n4
	 * @return
	 */
	public static float media (int n1, int n2, int n3, float n4) {
		return (n1 + n2 + n3 + n4) / 4;
	}
	
	/**
	 * Método llamado "obtenerNumeroDeUsuarioEntreMinimoYMaximo" que reciba dos valores enteros: un valor mínimo y un valor máximo. 
	 * El método debe pedir un numero al usuario. El método examinará el número introducido por el usuario y, si dicho número no está 
	 * entre el valor mínimo y el máximo que se ha indicado, seguirá pidiendo números al usuario hasta que se obtenga uno válido. 
	 * Finalmente se debe devolver dicho valor del usuario al método main, que lo imprimirá en la consola.

	 * @param min
	 * @param max
	 * @return
	 */
	public static int obtenerNumeroUsuarioEntreMinimoYMaximo (int min, int max) {
		int num;
		do {
			num = Utils.obtenerEnteroPorScanner();
			if (num < min || num > max) {
				System.out.println("El número no es válido, introduzca entre " + min + " y " + max);
			}
		} while (num < min || num > max);
		return num;
	}
	
	/**
	 * Método llamado "maximo" que devuelva el valor máximo de dos números enteros recibidos como argumentos de entrada. El método 
	 * main pedirá dos números al usuario y los enviará a este nuevo método. Finalmente imprimirá en consola el valor devuelto por el método
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static int maximo (int n1, int n2) {
		if (n1 >= n2) {
			return n1;
		}
		else {
			return n2;
		}
	}
	
	/**
	 * Método llamado "numeroImparEntreLimites" que devuelva un número entero aleatorio, impar y comprendido entre dos límites recibidos 
	 * como parámetros de entrada. "main" debe llamar a este método e imprimir el valor devuelto.
	 * @param min
	 * @param max
	 * @return
	 */
	public static int aleatorioImparEntreLimites (int min, int max) {
		int num;
		
		do {
			num = Utils.obtenerNumeroAzar(min, max);
		} while(num % 2 == 0);
		
		return num;
	}
	
	/**
	 * Realiza un método que reciba un valor entero, del 1 al 10, como argumento de entrada y devuelva un String, con  dicho número escrito en 
	 * palabras. Llama a este método "getStringFromEntero".
	 * @param num
	 * @return
	 */
	public static String traduceNumero (int num) {
		String traducciones[] = new String[] {"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", 
				"siete", "ocho", "nueve", "diez"};
		if (num >= traducciones.length) {
			return "no hay traducción";
		}
		return traducciones[num];
	}
	
	/**
	 * Método, llamado "imprimeMinimoAMaximo", que reciba tres valores enteros como argumentos de entrada. Debe imprimir dichos valores en orden 
	 * de menor a mayor.
	 * @param n1
	 * @param n2
	 * @param n3
	 */
	public static void minimoAMaximo (int n1, int n2, int n3) {
		int array[] = new int[] {n1, n2, n3};
		UtilsArrays.ordenaArray(array);
		UtilsArrays.mostrarArray(array);
	}
	
	/**
	 * La serie de Fibonacci es una serie numérica que comienza en los números 1, 1 y continua de forma infinita, calculando cada mienbro de 
	 * la serie como la suma de los dos anteriores. De esta manera, la serie de Fibonacci comienza 1, 1, 2, 3, 5, 8, 13, 21, 34, 55.......... 
	 * Debes realizar un método llamado "fibonacci". Recibirá un argumento de entrada, de tipo entero. El método debe devolver un array con 
	 * la serie de Fibonacci. El parámetro de entrada del método determinará la longitud del array a devolver. El método main recibirá el 
	 * array y lo imprimirá en la consola.
	 * @param longitud
	 * @return
	 */
	public static int[] fibonacci (int longitud) {
		int fibo[] = new int[longitud];
		
		for (int i = 0; i < fibo.length; i++) {
			if (i < 2) {
				fibo[i] = 1;
			}
			else {
				fibo[i] = fibo[i-1] + fibo[i-2];
			}
		}
		return fibo;
	}
	
	/**
	 * Método que imprima en pantalla un array, recibirá un array como parámetro de entrada y lo mostrará en consola. Main debe enviar 
	 * el array al método, llamado "imprimeArray".
	 * @param array
	 */
	public static void imprimeArray (int array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
	
	/**
	 * Método que "recorte" un array. El método recibirá un array, un "primerIndice" y un "ultimoIndice" y debe devolver un array, formado 
	 * con los elementos del array recibido, cuyos índices estén dentro del intervalo cerrado formado por los dos índices recibidos
	 * @param original
	 * @param indiceIni
	 * @param indiceFin
	 * @return
	 */
	public static int[] recortaArray (int original[], int indiceIni, int indiceFin) {
		int recortado[] = new int[indiceFin - indiceIni + 1];
		
		for (int i = 0; i < recortado.length; i++) {
			recortado[i] = original[i + indiceIni];
		}
		
		return recortado;
	}
	
	/**
	 * Método que muestre en pantalla los números del 1 al 100. El único requisito para esto es que debe hacerse utilizando la recursividad.
	 * @param num
	 */
	public static void imprimeHastaNumero (int num) {
		if (num != 0) {
			System.out.println(num);
			imprimeHastaNumero(num-1);
		}
	}

}
