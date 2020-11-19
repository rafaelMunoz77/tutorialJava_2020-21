package tutorialJava.capitulo6b_Videojuegos.SpaceInvaders.version28_Sonido;

/**
 * 
 * @author Rafael Mu�oz Ruiz
 *
 */

public class Missile extends Actor {
	// Propiedades espec�ficas del Misil, la velocidad en el eje Y.
	private static int SPEED = -10; // El misil se mover� 10 p�xeles hacia arriba en cada iteraci�n del bucle principal

	/**
	 * El constructor simplemente establece la imagen de este actor, no tiene varios sprites, s�lo tiene uno
	 */
	public Missile() {
		super("misil.gif");
	}

	/**
	 * La actuaci�n de este actor es sencilla, simplemente se desplaza hacia arriba, con la velocidad "SPEED" marcada.
	 * Cuando el actor llega al l�mite superior de la pantalla, el mismo se marca para su eliminaci�n. El m�todo
	 * "updateWorld" de la clase "Invaders" eliminar� este actor de la lista de actores
	 */
	@Override
	public void act() {
		super.act(); // Necesario para controlar diferentes aspectos de los actores
		
		this.y += SPEED; // Movimiento vertical del actor
		
		// Si el actor llega a tocar el l�mite superior de la escena, desaparecer�
		if (this.y < 0) {
			this.setMarkedForRemoval(true);
		}
	}

}
