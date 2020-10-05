package tutorialJava.capitulo2_condicionales;

import javax.swing.JOptionPane;

import tutorialJava.Utils;

public class Condicionales {

	 
	
	public static void main (String args[]) {
		primerEjemploCondicionalSimple();
		
		
		
		
		
//		ejemploCondicionalCompuesto();
	}
	
	
	public static void primerEjemploCondicionalSimple () {
		int numero = Utils.obtenerNumeroAzar();
		
		System.out.println(numero);
		
		if ((numero > 25 && numero <= 30) || (numero >= 40 && numero < 70)) {
			System.out.println("Bingooooooooo");
			System.out.println("Bingooooooooo");
			System.out.println("Bingooooooooo");
		}
	}
	
	
	
	public static void ejemploCondicionalCompuesto () {
		int numero = Utils.obtenerNumeroAzar();
		
		System.out.println("Var n�mero: " + numero);
		
		if (numero > 50) {
			System.out.println("El n�mero es mayor de 50");
		}
		else {
			System.out.println("El n�mero es 50 o menor de 50");
		}
	}
	
	
	
	public static void ejemploCondicionalAnidado () {
		int numero = Utils.obtenerNumeroAzar();
		
		System.out.println("Var n�mero: " + numero);
		
		if (numero > 50) { // El n�mero es mayor de 50
			System.out.println("El n�mero es mayor de 50");
		}
		else { // No s� si el n�mero es igual o menor a 50
			if (numero == 50) { // El n�mero es igual a 50
				System.out.println("El n�mero es 50");
			}
			else { // El n�mero es menor a 50
				System.out.println("El n�mero es menor de 50");
			}
		}
	}

	
	
	public static void ejemploCondicionalMultiple () {
		int nota = 11;
		
		switch (nota) {
			case 0:
			case 1:
			case 2:
				System.out.println("Muy deficiente");
				break;
			case 3:
			case 4:
				System.out.println("Deficiente");
				break;
			case 5:
				System.out.println("Suficiente");
				break;
			case 6:
				System.out.println("Bien");
				break;
			case 7:
			case 8:
				System.out.println("Notable");
				break;
			case 9:
			case 10:
				System.out.println("Sobresaliente");
				break;
			default:
				System.out.println("Error, el valor no pertenece a ninguna nota");
		}
	}
	
	
	
	
	
	
	
	
	/**
	 * 
	 */
	public static void ejemploOperadorTernario () {
		int valor;
		boolean esValorPositivo;
		
		// Forma habitual de asignar valor a una variable en funci�n de una condici�n
		valor = 1;
		if (valor >= 0) {
			esValorPositivo = true;
		}
		else { // valor < 0
			esValorPositivo = false;
		}
		
		// Otra forma de hacerlo, a trav�s del operador ternario
		esValorPositivo = (valor >= 0)? true : false ;
			
	}
	
}
