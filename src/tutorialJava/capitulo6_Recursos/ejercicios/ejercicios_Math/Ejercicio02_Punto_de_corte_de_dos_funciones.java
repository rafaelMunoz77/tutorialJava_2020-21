package tutorialJava.capitulo6_Recursos.ejercicios.ejercicios_Math;

public class Ejercicio02_Punto_de_corte_de_dos_funciones {

	/**
	 * Averiguar, con una precisión inferior a 0.001, en qué punto (x, y) se cortan las gráficas de las siguientes funciones:
         y = sqrt(x)
         y = - ln(x)
	 * @param args
	 */
	public static void main(String[] args) {
		
		for (float x = 0.0001f; x < 1; x+=0.0001) {
			float y1 = (float) Math.sqrt(x);
			System.out.println("x: " + x + ", y1 = sqrt(x): " + y1);
			float y2 = (float) (0 - Math.log(x));
			System.out.println("x: " + x + ", y2 = -ln(x): " + y2);
			
			if (Math.abs(y2-y1) < 0.0001) {
				System.out.println("Solución encontrada en x = " + x + ", y = " + y1);
				break;
			}
		}

	}

}
