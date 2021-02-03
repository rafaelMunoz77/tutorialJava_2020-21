package tutorialJava.capitulo6_Recursos.ejercicios.ejercicios_Math;

public class Ejercicio03_Calcular_numero_PI {

	/**
	 * Aproximar, con una precisión de 0.00001 décimas, el número PI. Para esto debes utilizar el método "Calcular el valor de PI 
	 * utilizando series infinitas" (Método 2) del enlace https://es.wikihow.com/calcular-Pi
	 * @param args
	 */
	public static void main(String[] args) {
		double piCalculado = 4;
		int signo = -1;
		int denominadorProgresivo = 3;

		do {
			piCalculado += signo * (4.0 / denominadorProgresivo);
			denominadorProgresivo += 2;
			signo = -signo;
			
		} while (Math.abs(piCalculado - Math.PI) > 0.00001);
		
		System.out.println("PI calculado: " + piCalculado);
	}

}
