package tutorialJava.capitulo2_condicionales.ejercicios.bloque03;

import javax.swing.JOptionPane;

public class Ejercicio03_Calculadora_avanzada {

	/**
	 * Realiza un programa que resuelva lo siguientes puntos:
               a.- Que muestre un menú en pantalla con opciones para:
                           1. Cálculo de la hipotenusa de un triángulo.
                           2. Cálculo de la superficie de una circunferencia.
                           3. Cálculo del perímetro de una circunferencia.
                           4. Cálculo del área de un rectángulo.
                           5. Cálculo del área de un triángulo.
                           0. Salir de la aplicación.
               b.- En la opción "1" debe pedir dos datos, correspondientes a las longitudes de los dos catetos de un triángulo. 
               	Se debe imprimir la longitud de la hipotenusa. Recuerda que Hipotenusa al cuadrado = cateto1 al cuadrado + cateto2 
               	al cuadrado.
               c.- En la opción "2" debe pedir la longitud del radio de una circunferencia e imprimir la superficie de la misma. 
               	Recuerda que el área es igual a PI por el radio al cuadrado. Recuerda también que PI es igual a 3,1416.
               d.- En la opción "3" debe pedir la longitud del radio de una circunferencia e imprimir la longitud del perímetro de 
               	la misma. Recuerda que la longitud de la circunferencia = 2 por PI por el radio.
               e.- En la opción "4" debe pedir las longitudes de la base y la altura de un rectángulo, e imprimir el área de dicho 
               	rectángulo. Recuerda que el área del rectángulo es igual a la base por la altura.
               f.- En la opción "5" debe pedir la base y la altura de un tríangulo e imprimir el área del mismo. Recuerda que el 
               	área del triángulo es la mitad del área del rectángulo de igual base y altura.
               g.- Tras mostrar el resultado de cada opción, el programa debe hacer una pausa (para poder observar el resultado), 
               	y volver a pintar el menú. Esto se repetirá siempre que la opción no sea "0", en cuyo caso el programa acabará.
               h.- Si la opción no fuese "0", "1", "2", "3", "4" o "5", el programa deberá dar el mensaje de "opción incorrecta" 
               	y volverá a mostrar el menú.
	 * @param args
	 */
	public static void main(String[] args) {
		// Muestro el menú y el usuairo elige su opción
		String str = JOptionPane.showInputDialog("1.- Hipotenusa de un triángulo\n"
				+ "2.- Superficie de un círculo\n"
				+ "3.- Perímetro de la circunferencia\n"
				+ "4.- Área del rectándulo\n"
				+ "5.- Área del triángulo\n"
				+ "Introduzca opción: ");
		int opcion = Integer.parseInt(str);
		
		// Comienzo con el tratamiento de la opción elegida, en el switch
		switch (opcion) {
		case 1: // Hipotenusa
			// Lectura del radicando y del índice de la raíz
			str = JOptionPane.showInputDialog("Introduzca el cateto");
			int cateto1 = Integer.parseInt(str);
			str = JOptionPane.showInputDialog("Introduzca el cateto");
			int cateto2 = Integer.parseInt(str);
			// Calculo la raíz
			float hipotenusa = (float) Math.sqrt(cateto1 * cateto1 + cateto2 * cateto2);
			System.out.println("La hipotenusa vale " + hipotenusa);
			break;
			
		case 2: // Área del círculo
			// Lectura de la base y el exponente
			str = JOptionPane.showInputDialog("Introduzca el radio");
			int radio = Integer.parseInt(str);
			// Cálculo de la potencia
			System.out.println("La superficie vale " + Math.PI * Math.pow(radio, 2));
			break;
			
		case 3: // Perímetro de la circunferencia
			str = JOptionPane.showInputDialog("Introduzca el radio");
			radio = Integer.parseInt(str);
			// C�lculo de la potencia
			System.out.println("La superficie vale " + (2 * Math.PI * radio));
			break;
			
		case 4: // área del rectángulo
			str = JOptionPane.showInputDialog("Base");
			int base = Integer.parseInt(str);
			str = JOptionPane.showInputDialog("Altura");
			int altura = Integer.parseInt(str);
			// Calculo
			System.out.println("el Área vale " + (base * altura));
			break;
			
		case 5: // Área del triángulo
			str = JOptionPane.showInputDialog("Base");
			base = Integer.parseInt(str);
			str = JOptionPane.showInputDialog("Altura");
			altura = Integer.parseInt(str);
			// Calculo
			System.out.println("el Área vale " + (base * altura / 2));
			break;
			
		default:
			System.out.println("Opción no permitida");
		}
	}

}
