package tutorialJava.capitulo4_OO.galletas;

import javax.swing.JOptionPane;

public class Main {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Mayor: " + peticion2NumerosYMayor());
	}

	
	/**
	 * 
	 * @return
	 */
	public static int peticion2NumerosYMayor () {
		int pepe = pideNumeroEntero(0, 10);
		int juan = pideNumeroEntero(0, 10);
		
		int mayor = mayor (pepe, juan);
		return mayor;
	}
	
	
	/**
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int mayor (int num1, int num2) {
		if (num1 > num2) {
			return num1;
		}
		else {
			return num2;
		}
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static int pideNumeroEntero (int limInf, int limSup) {
		
		int num;
		do {
			num = Integer.parseInt(JOptionPane.showInputDialog(
					"Introduzca número: "));
		} while (num < limInf || num > limSup);
		
		return num;
	}
	
	
	
	
	/**
	 * 
	 * @param num1
	 * @param num2
	 * @param num3
	 * @param num4
	 * @return
	 */
	public static float media4Valores (int num1, int num2, 
			int num3, float num4) {
		float media = (num1 + num2 + num3 + num4) / 4;
		return media;
	}
}
