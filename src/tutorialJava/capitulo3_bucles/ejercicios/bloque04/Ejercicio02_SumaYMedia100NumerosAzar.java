package tutorialJava.capitulo3_bucles.ejercicios.bloque04;

import javax.swing.JOptionPane;

public class Ejercicio02_SumaYMedia100NumerosAzar {

	public static void main(String[] args) {
		// Declaraci�n de variables necesarias
		int num;
		int suma = 0, i, mayor = -1, menor = -1;

		// Bucle con la generaci�n de n�meros y c�lculo de suma
		for (i = 0; i < 1000; i++) {
			num = (int) Math.round(Math.random() * 1000);
			System.out.println("N�mero " + i + ": " + num);
			suma += num;
			// Caso especial para la primera iteraci�n
			if  (i == 0) {
				mayor = num;
				menor = num;
			}
			// Resto de iteraciones
			else {
				if (num > mayor) mayor = num;
				if (num < menor) menor = num;
			}
		}
		
		// Impresi�n de la suma, mayor, menor y c�lculo e impresi�n de la media
		System.out.println("Suma total: " + suma);
		System.out.println("Mayor: " + mayor);
		System.out.println("Menor: " + menor);
		// Para calcular la media recuerda que hemos utilizado una variable de tipo "contador" llamada "i". Esa 
		// variable tambi�n se ha usado para el bucle for, por lo que los incrementos han llevado a la variable 
		// "i" a tener un valor igual a la cantidad de n�meros generados al azar.
		System.out.println("Media: " +  ((float) suma / i));
	}

}
