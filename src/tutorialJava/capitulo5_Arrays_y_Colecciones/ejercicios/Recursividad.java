package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios;

public class Recursividad {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(factorial(6));
	}

	/**
	 * Calcula el factorial de un número haciendo uso de la recursividad
	 * @param num
	 * @return
	 */
	public static int factorial (int num) {
		if (num > num) {
			return num;
		}
		else {
			return num * factorial(num - 1);
		}
	}
	
}
