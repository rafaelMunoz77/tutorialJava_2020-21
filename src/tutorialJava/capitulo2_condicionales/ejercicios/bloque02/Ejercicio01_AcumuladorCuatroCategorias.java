package tutorialJava.capitulo2_condicionales.ejercicios.bloque02;

import javax.swing.JOptionPane;

public class Ejercicio01_AcumuladorCuatroCategorias {

	/**
	 * Realiza un ejercicio que acumule cinco números introducidos por el usuario, es decir, que sume las cantidades introducidas, 
	 * pero realizando cuatro categorías: números negativos, números bajos (entre 0 y 25, ambos inclusive), números medios (entre 
	 * 26 y 250, ambos inclusie) y números grandes (mayores de 250). Al finalizar el programa, se debe mostrar el total de las sumas 
	 * de los números introducidos en cada una de las categorías.
	 * @param args
	 */
	public static void main(String[] args) {

		String texto = "Introduce un n�mero: ";
		int acumuladorNegativos = 0; // Acumulador para números negativos
		int acumuladorBajos = 0; // Acumulador para números entre 0 y 25
		int acumuladorMedios = 0; // Acumulador para números entre 26 y 250
		int acumuladorAltos = 0; // Acumulador para números > 250

		// Primer número
		int num = Integer.parseInt(JOptionPane.showInputDialog(texto));
		
		if (num < 0) {
			acumuladorNegativos = acumuladorNegativos + num;
		}
		else {
			if (num <= 25) {
				acumuladorBajos = acumuladorBajos + num;
			}
			else {
				if (num <= 250) {
					acumuladorMedios = acumuladorMedios + num;
				}
				else {
					acumuladorAltos = acumuladorAltos + num;
				}
			}
		}
		
		// segundo número
		num = Integer.parseInt(JOptionPane.showInputDialog(texto));
		
		if (num < 0) 
			acumuladorNegativos = acumuladorNegativos + num;
		else 
			if (num <= 25)
				acumuladorBajos = acumuladorBajos + num;
			else 
				if (num <= 250)
					acumuladorMedios = acumuladorMedios + num;
				else
					acumuladorAltos = acumuladorAltos + num;
			
		// tercer número
		num = Integer.parseInt(JOptionPane.showInputDialog(texto));
		
		if (num < 0) 
			acumuladorNegativos += num;
		else 
			if (num <= 25)
				acumuladorBajos += num;
			else 
				if (num <= 250)
					acumuladorMedios += num;
				else
					acumuladorAltos += num;
			
		// cuarto número
		num = Integer.parseInt(JOptionPane.showInputDialog(texto));
		
		if (num < 0) 
			acumuladorNegativos += num;
		else 
			if (num <= 25)
				acumuladorBajos += num;
			else 
				if (num <= 250)
					acumuladorMedios += num;
				else
					acumuladorAltos += num;
			
		// quinto número
		num = Integer.parseInt(JOptionPane.showInputDialog(texto));
		
		if (num < 0) 
			acumuladorNegativos += num;
		else 
			if (num <= 25)
				acumuladorBajos += num;
			else 
				if (num <= 250)
					acumuladorMedios += num;
				else
					acumuladorAltos += num;

		
		// Resultados de las acumulaciones
		
		System.out.println("Acumulador negativos " + acumuladorNegativos);
		System.out.println("Acumulador bajos " + acumuladorBajos);
		System.out.println("Acumulador medios " + acumuladorMedios);
		System.out.println("Acumulador altos " + acumuladorAltos);
	}

}
