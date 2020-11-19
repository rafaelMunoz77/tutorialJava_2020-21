package tutorialJava.capitulo1.ejercicios.bloque01;

public class Ejercicio06_Calculo_cuota_mensual_hipoteca {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Valor de referencia fijado por el BCE
		float euribor = (float) -0.167; 
		float diferencial = (float) 0.89; // Ganancia del banco
		int capital = 500000; // Cantidad de dinero prestada
		int meses = 120; // Cantidad de meses para la devolución

		
		float interesAnual = euribor + diferencial;
		float interesMensual = interesAnual / 12 / 100;
		float calculoIntermedio = (float) Math.pow(1 + interesMensual, meses);
		float cuotaMensual = capital * (interesMensual * calculoIntermedio) / (calculoIntermedio - 1);

		System.out.println("La cuota mensual es de " + cuotaMensual + " �");
	}

}
