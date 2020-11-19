package tutorialJava.capitulo6b_Videojuegos.SpaceInvaders.version27_Explosion_al_morir_un_monstruo;

/**
 * 
 * @author Rafael Muñoz Ruiz
 *
 */

public class Explosion extends Actor {

	// Array con los nombres de los sprites que forman este actor
	private static String[] SPRITES = new String[] {"sprite-explosion1.png", "sprite-explosion2.png", "sprite-explosion3.png",
			"sprite-explosion4.png", "sprite-explosion5.png", "sprite-explosion6.png", 
			"sprite-explosion7.png", "sprite-explosion8.png", "sprite-explosion9.png"};
	
	/**
	 * El constructor establece los sprites para este actor
	 */
	public Explosion() {
		super(SPRITES, 5);
	}

	/**
	 * Este actor tiene el cometido de mostrar todos y cada uno de los sprites que lo componene y, después, 
	 * desaparecer
	 */
	@Override
	public void act() {
		super.act(); // Necesario para controlar diferentes aspectos de los actores
		
		// Si el actor llega a tocar el límite inferior de la escena, desaparecerá
		if (this.getSpriteActual().equals(this.sprites.get(this.sprites.size()-1))) {
			this.setMarkedForRemoval(true);
		}
	}

}
