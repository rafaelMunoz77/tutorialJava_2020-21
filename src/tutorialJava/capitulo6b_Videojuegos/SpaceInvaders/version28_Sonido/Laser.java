package tutorialJava.capitulo6b_Videojuegos.SpaceInvaders.version28_Sonido;

/**
 * 
 * @author Rafael Mu�oz Ruiz
 *
 */

public class Laser extends Actor {
	// Propiedades espec�ficas del L�ser, la velocidad en el eje Y.
	private static int SPEED = 3; // El l�ser se mover� 3 p�xeles hacia abajo en cada iteraci�n del bucle principal

	// Array con los nombres de los sprites que forman este actor
	private static String[] SPRITES = new String[] {"disparo0.gif", "disparo1.gif", "disparo2.gif"};
	
	
	/**
	 * El constructor simplemente establece la imagen de este actor, no tiene varios sprites, s�lo tiene uno
	 */
	public Laser() {
		super(SPRITES, 15);
	}

	/**
	 * La actuaci�n de este actor es sencilla, simplemente se desplaza hacia abajo, con la velocidad "SPEED" marcada.
	 * Cuando el actor llega al l�mite inferior de la pantalla, el mismo se marca para su eliminaci�n. El m�todo
	 * "updateWorld" de la clase "Invaders" eliminar� este actor de la lista de actores
	 */
	@Override
	public void act() {
		super.act(); // Necesario para controlar diferentes aspectos de los actores
		
		this.y += SPEED; // Movimiento vertical del actor
		
		// Si el actor llega a tocar el l�mite inferior de la escena, desaparecer�
		if (this.y > Invaders.getInstance().getHeight()) {
			this.setMarkedForRemoval(true);
		}
	}

}
