package tutorialJava.capitulo1;

import javax.swing.JOptionPane;

public class LecturaDeDatosDelUsuario {

	public static void main (String args[]) {
//		lecturaCadenaDeCaracteres();
		lecturaDatosEnteros();
	}
	
	
	public static void lecturaCadenaDeCaracteres () {
		int numero = 1;
		String palabra = "Rafa2234142";
		String str = JOptionPane.showInputDialog("Introduzca una palabra o frase, ya!");
		System.out.println("Palabra o frase introducida: " + str);
		JOptionPane.showMessageDialog(null, "Palabra o frase introducida: " + str);
	}
	
	
	public static void lecturaDatosEnteros () {
		String str = JOptionPane.showInputDialog("Introduzca un número entero: ");
		int var1 = Integer.parseInt(str);
		System.out.println("Número introducido: " + var1);
		str = JOptionPane.showInputDialog("Introduzca otro número entero: ");
		int var2 = Integer.parseInt(str);
		System.out.println("Número introducido: " + var2);
		
		int suma = var1 + var2;
		System.out.println("Suma de los dos valores introducidos: " + suma);
  }
	
	
	public static void lecturaDatosEnterosConError () {
		String str = JOptionPane.showInputDialog("Introduzca un número entero: ");
		try {
			int var1 = Integer.parseInt(str);
			System.out.println("Número introducido: " + var1);
		}
		catch (Exception ex) {
			System.out.println("Error, no has introducido un número entero");
		}
	}

	
	public static void lecturaDatosFlotantes () {
		String str = JOptionPane.showInputDialog("Introduzca un número flotante: ");
		float var1 = Float.parseFloat(str);
		System.out.println("Número introducido: " + var1);
		
		str = JOptionPane.showInputDialog("Introduzca otro número flotante: ");
		float var2 = Float.parseFloat(str);
		System.out.println("Número introducido: " + var2);
		
		float suma = var1 + var2;
		System.out.println("Suma de los dos valores introducidos: " + suma);
	}

}
