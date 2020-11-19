package tutorialJava.capitulo2_condicionales.ejercicios.bloque02;

import javax.swing.JOptionPane;

public class Ejercicio02_ContadorCuatroCategorias {

	/**
	 * Realiza un ejercicio igual al anterior, pero con las dos siguientes diferencias: no existe la categoría de números negativos, 
	 * por tanto si el usuario introduce un negativo, el programa debe terminar; la otra diferencia es que, al acabar, el programa 
	 * no debe mostrar la suma de los números, sino cuantos han entrado en cada categoría. A esto se llema contadores, a diferencia 
	 * del ejercicio anterior, que reciben el nombre de acumuladores.
	 * @param args
	 */
	public static void main(String[] args) {

		String texto = "Introduce un n�mero: ";
		int contadorBajos = 0; // Acumulador para números entre 0 y 25
		int contadorMedios = 0; // Acumulador para números entre 26 y 250
		int contadorAltos = 0; // Acumulador para números > 250

		// Primer número
		int num = Integer.parseInt(JOptionPane.showInputDialog(texto));
		
		if (num < 0) // números negativos 
			System.exit(0); // Acaba radicalmente con la ejecución
							// del programa
		if (num <= 25) 
			// contadorBajos = contadorBajos + 1;
			// contadorBajos += 1;
			contadorBajos++;
		else 
			if (num <= 250) 
				contadorMedios++;
			else
				contadorAltos++;
		

		// Segundo número
		num = Integer.parseInt(JOptionPane.showInputDialog(texto));
		
		if (num < 0) // números negativos 
			System.exit(0); // Acaba radicalmente con la ejecución
							// del programa
		if (num <= 25) 
			// contadorBajos = contadorBajos + 1;
			// contadorBajos += 1;
			contadorBajos++;
		else 
			if (num <= 250) 
				contadorMedios++;
			else
				contadorAltos++;
		

		// tercer número
		num = Integer.parseInt(JOptionPane.showInputDialog(texto));
		
		if (num < 0) // números negativos 
			System.exit(0); // Acaba radicalmente con la ejecución
							// del programa
		if (num <= 25) 
			// contadorBajos = contadorBajos + 1;
			// contadorBajos += 1;
			contadorBajos++;
		else 
			if (num <= 250) 
				contadorMedios++;
			else
				contadorAltos++;
		

		// cuarto número
		num = Integer.parseInt(JOptionPane.showInputDialog(texto));
		
		if (num < 0) // números negativos 
			System.exit(0); // Acaba radicalmente con la ejecución
							// del programa
		if (num <= 25) 
			// contadorBajos = contadorBajos + 1;
			// contadorBajos += 1;
			contadorBajos++;
		else 
			if (num <= 250) 
				contadorMedios++;
			else
				contadorAltos++;
		

		// Quinto número
		num = Integer.parseInt(JOptionPane.showInputDialog(texto));
		
		if (num < 0) // números negativos 
			System.exit(0); // Acaba radicalmente con la ejecución
							// del programa
		if (num <= 25) 
			// contadorBajos = contadorBajos + 1;
			// contadorBajos += 1;
			contadorBajos++;
		else 
			if (num <= 250) 
				contadorMedios++;
			else
				contadorAltos++;
		

		
		// Resultados de las acumulaciones
		
		System.out.println("Contador bajos " + contadorBajos);
		System.out.println("Contador medios " + contadorMedios);
		System.out.println("Contador altos " + contadorAltos);
	}

}
