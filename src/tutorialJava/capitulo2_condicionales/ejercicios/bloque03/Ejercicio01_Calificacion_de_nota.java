package tutorialJava.capitulo2_condicionales.ejercicios.bloque03;

import javax.swing.JOptionPane;

public class Ejercicio01_Calificacion_de_nota {

	/**
	 * Realiza un ejercicio que califique la nota obtenida por un alumno/a en un examen. El ejercicio pedirá al 
	 * usuario la nota numérica, y se imprimirá en pantalla su traducción a nota de texto: muy deficiente, 
	 * insuficiente, suficiente, bien, notable y sobresaliente. Debes realizar el ejercicio a través de una sentencia 
	 * switch, no de if anidados.
	 * @param args
	 */
	public static void main(String[] args) {
		// Pido un número
		String str = JOptionPane.showInputDialog("Introduzca una nota (de 0 a 10): ");
		int nota = Integer.parseInt(str);

		// switch decidirá el camino a tomar en función del valor
		// de la variable
		switch (nota) {
			case 0:
			case 1:
			case 2:
				System.out.println("Muy deficiente"); // Se llega en los cases 0, 1 y 2
				break; // Con esta instrucción salimos del switch
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

}
