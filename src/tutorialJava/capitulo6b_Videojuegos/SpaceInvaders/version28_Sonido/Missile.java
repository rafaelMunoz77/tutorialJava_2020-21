package tutorialJava.capitulo6b_Videojuegos.SpaceInvaders.version28_Sonido;

/**
 * 
 * @author Rafael Muñoz Ruiz
 *
 */

public class Missile extends Actor {
	// Propiedades específicas del Misil, la velocidad en el eje Y.
	private static int SPEED = -10; // El misil se moverá 10 píxeles hacia arriba en cada iteración del bucle principal

	/**
	 * El constructor simplemente establece la imagen de este actor, no tiene varios sprites, sólo tiene uno
	 */
	public Missile() {
		super("misil.gif");
	}

	/**
	 * La actuación de este actor es sencilla, simplemente se desplaza hacia arriba, con la velocidad "SPEED" marcada.
	 * Cuando el actor llega al límite superior de la pantalla, el mismo se marca para su eliminación. El método
	 * "updateWorld" de la clase "Invaders" eliminará este actor de la lista de actores
	 */
	@Override
	public void act() {
		super.act(); // Necesario para controlar diferentes aspectos de los actores
		
		this.y += SPEED; // Movimiento vertical del actor
		
		// Si el actor llega a tocar el límite superior de la escena, desaparecerá
		if (this.y < 0) {
			this.setMarkedForRemoval(true);
		}
	}

}
