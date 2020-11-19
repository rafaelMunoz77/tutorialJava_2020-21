package tutorialJava.capitulo3_bucles.ejercicios.bloque04;

import javax.swing.JOptionPane;

public class Ejercicio02_SumaYMedia100NumerosAzar {

	public static void main(String[] args) {
		// Declaración de variables necesarias
		int num;
		int suma = 0, i, mayor = -1, menor = -1;

		// Bucle con la generación de números y cálculo de suma
		for (i = 0; i < 1000; i++) {
			num = (int) Math.round(Math.random() * 1000);
			System.out.println("Número " + i + ": " + num);
			suma += num;
			// Caso especial para la primera iteración
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
		
		// Impresión de la suma, mayor, menor y cálculo e impresión de la media
		System.out.println("Suma total: " + suma);
		System.out.println("Mayor: " + mayor);
		System.out.println("Menor: " + menor);
		// Para calcular la media recuerda que hemos utilizado una variable de tipo "contador" llamada "i". Esa 
		// variable también se ha usado para el bucle for, por lo que los incrementos han llevado a la variable 
		// "i" a tener un valor igual a la cantidad de números generados al azar.
		System.out.println("Media: " +  ((float) suma / i));
	}

}
