package tutorialJava.capitulo6_Recursos.ejercicios.ejercicios_Math;

public class Ejercicio05_Maximos_locales_en_una_funcion {

	/**
	 * Hallar los cinco primero máximos locales de la función y = x * sen(x) con una precisión de 0.01
	 * @param args
	 */
	public static void main (String args[]) {
		
		double ant2 = 0, ant = 0, actual = 0;
		double x = 0;
		for (int i = 0; i < 5; i++) {
			do {
				ant2 = ant;
				ant = actual;
				actual = x * Math.sin(x);
				x += 0.00001;
			} while (!(ant > actual && ant > ant2));
			System.out.println("x: " + x + " - y: " + actual + " - y ant: " + ant + " - y ant2: " + ant2);
		}
	}
}
