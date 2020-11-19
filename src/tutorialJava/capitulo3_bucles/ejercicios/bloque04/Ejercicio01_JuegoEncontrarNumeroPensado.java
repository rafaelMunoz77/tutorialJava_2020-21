package tutorialJava.capitulo3_bucles.ejercicios.bloque04;

import javax.swing.JOptionPane;

public class Ejercicio01_JuegoEncontrarNumeroPensado {

	public static void main(String[] args) {
		int numeroPensado = (int) Math.round(Math.random() * 100);
		int tirada;
		
		// Si quitas el comentario a la siguiente l�nea podr�s saber el n�mero pensado por el ordenador
		//System.out.println("n�mero " + numeroPensado);
		
		do {
			// Pedimos su tirada al usuario
			tirada = Integer.parseInt(JOptionPane.showInputDialog(
					"Busca el n�mero pensado (0-100): "));
			
			// Interactuamos con el usuario
			if (tirada > numeroPensado) {
				JOptionPane.showMessageDialog(null, 
						"Mi n�mero pensado es inferior a " + tirada);
			}
			else {
				if (tirada < numeroPensado) {
					JOptionPane.showMessageDialog(null, 
							"Mi n�mero pensado es superior a " + tirada);
				}
				else { // El n�mero pensado coincide con la tirada
					JOptionPane.showMessageDialog(null, 
							"����ENHORABUENA, LO HAS CONSEGUIDO!!!!");
				}
			}
			
		} while (tirada != numeroPensado);
	}

}
