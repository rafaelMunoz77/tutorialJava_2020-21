package tutorialJava.capitulo2_condicionales.ejercicios.bloque03;

public class Ejercicio04_Cambio_devuelto_por_expendedora {

	/**
	 * Escribe un programa que lea el importe de una compra y la cantidad recibida y calcule el cambio a devolver, teniendo en 
	 * cuenta que el número de monedas que se devuelven debe ser mínimo. Suponer que el sistema monetario utilizado consta de 
	 * monedas de 100, 50, 25, 5, y 1 unidad. El precio viene dado en unidades monetarias enteras.
		Ejemplo: Pagamos con 2000 unidades monetarias un articulo que nos cuesta 375 unidades monetarias, la vuelta (1625 u) 
		debería de ser de la siguiente forma:
			- 16 monedas de 100 = 1600
			- 1 moneda de 25 = 25
	 * @param args
	 */
	public static void main(String[] args) {
		int precio = 6742; // 67,42 €
		int pago = 10000; // 100,00 €
		
		int cambioADevolver = pago - precio;
		
		// Calculo la cantidad de billetes de 100,00 �
		System.out.println("Devuelvo " + (cambioADevolver / 10000)  + " billetes de 100.00 �");
		cambioADevolver %= 10000;

		// Calculo la cantidad de billetes de 50,00 �
		System.out.println("Devuelvo " + (cambioADevolver / 5000)  + " billetes de 50.00 �");
		cambioADevolver %= 5000;

		// Calculo la cantidad de billetes de 20,00 �
		System.out.println("Devuelvo " + (cambioADevolver / 2000)  + " billetes de 20.00 �");
		cambioADevolver %= 2000;

		// Calculo la cantidad de billetes de 10,00 �
		System.out.println("Devuelvo " + (cambioADevolver / 1000)  + " billetes de 10.00 �");
		cambioADevolver = cambioADevolver % 1000;

		// Calculo la cantidad de billetes de 5,00 �
		System.out.println("Devuelvo " + (cambioADevolver / 500)  + " billetes de 5.00 �");
		cambioADevolver = cambioADevolver % 500;

		// Calculo la cantidad de monedas de 2,00 �
		System.out.println("Devuelvo " + (cambioADevolver / 200)  + " monedas de 2.00 �");
		cambioADevolver = cambioADevolver % 200;

		// Calculo la cantidad de monedas de 1,00 �
		System.out.println("Devuelvo " + (cambioADevolver / 100)  + " monedas de 1.00 �");
		cambioADevolver = cambioADevolver % 100;

		// Calculo la cantidad de monedas de 0,50 �
		System.out.println("Devuelvo " + (cambioADevolver / 50)  + " monedas de 0.50 �");
		cambioADevolver = cambioADevolver % 50;

		// Calculo la cantidad de monedas de 0,20 �
		System.out.println("Devuelvo " + (cambioADevolver / 20)  + " monedas de 0.20 �");
		cambioADevolver = cambioADevolver % 20;

		// Calculo la cantidad de monedas de 0,10 �
		System.out.println("Devuelvo " + (cambioADevolver / 10)  + " monedas de 0.10 �");
		cambioADevolver = cambioADevolver % 10;

		// Calculo la cantidad de monedas de 0,05 �
		System.out.println("Devuelvo " + (cambioADevolver / 5)  + " monedas de 0.05 �");
		cambioADevolver = cambioADevolver % 5;

		// Calculo la cantidad de monedas de 0,02 �
		System.out.println("Devuelvo " + (cambioADevolver / 2)  + " monedas de 0.02 �");
		cambioADevolver = cambioADevolver % 2;

		// Calculo la cantidad de monedas de 0,01 �
		System.out.println("Devuelvo " + (cambioADevolver / 1)  + " monedas de 0.01 �");
		cambioADevolver = cambioADevolver % 1;
	}

}
