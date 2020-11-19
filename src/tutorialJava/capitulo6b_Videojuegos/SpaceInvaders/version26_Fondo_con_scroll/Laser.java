package tutorialJava.capitulo6b_Videojuegos.SpaceInvaders.version26_Fondo_con_scroll;

/**
 * 
 * @author Rafael Muñoz Ruiz
 *
 */

public class Laser extends Actor {
	// Propiedades específicas del Láser, la velocidad en el eje Y.
	private static int SPEED = 3; // El láser se moverá 3 píxeles hacia abajo en cada iteración del bucle principal

	/**
	 * El constructor simplemente establece la imagen de este actor, no tiene varios sprites, sólo tiene uno
	 */
	public Laser() {
		super(new String[] {"disparo0.gif", "disparo1.gif", "disparo2.gif"}, 15);
	}

	/**
	 * La actuación de este actor es sencilla, simplemente se desplaza hacia abajo, con la velocidad "SPEED" marcada.
	 * Cuando el actor llega al límite inferior de la pantalla, el mismo se marca para su eliminación. El método
	 * "updateWorld" de la clase "Invaders" eliminará este actor de la lista de actores
	 */
	@Override
	public void act() {
		super.act(); // Necesario para controlar diferentes aspectos de los actores
		
		this.y += SPEED; // Movimiento vertical del actor
		
		// Si el actor llega a tocar el límite inferior de la escena, desaparecerá
		if (this.y > Invaders.getInstance().getHeight()) {
			this.setMarkedForRemoval(true);
		}
	}

}
