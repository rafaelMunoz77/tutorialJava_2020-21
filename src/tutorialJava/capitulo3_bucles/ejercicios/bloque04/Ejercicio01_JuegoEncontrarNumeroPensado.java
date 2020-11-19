package tutorialJava.capitulo3_bucles.ejercicios.bloque04;

import javax.swing.JOptionPane;

public class Ejercicio01_JuegoEncontrarNumeroPensado {

	public static void main(String[] args) {
		int numeroPensado = (int) Math.round(Math.random() * 100);
		int tirada;
		
		// Si quitas el comentario a la siguiente línea podrás saber el número pensado por el ordenador
		//System.out.println("número " + numeroPensado);
		
		do {
			// Pedimos su tirada al usuario
			tirada = Integer.parseInt(JOptionPane.showInputDialog(
					"Busca el número pensado (0-100): "));
			
			// Interactuamos con el usuario
			if (tirada > numeroPensado) {
				JOptionPane.showMessageDialog(null, 
						"Mi número pensado es inferior a " + tirada);
			}
			else {
				if (tirada < numeroPensado) {
					JOptionPane.showMessageDialog(null, 
							"Mi número pensado es superior a " + tirada);
				}
				else { // El número pensado coincide con la tirada
					JOptionPane.showMessageDialog(null, 
							"¡¡¡¡ENHORABUENA, LO HAS CONSEGUIDO!!!!");
				}
			}
			
		} while (tirada != numeroPensado);
	}

}
