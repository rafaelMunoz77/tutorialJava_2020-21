
package tutorialJava.capitulo6b_Videojuegos.SpaceInvaders.version24_Muriendo;

/**
 * @author Rafael Muñoz Ruiz
 *
 * Representa a un actor, un fragmento de bomba. La bomba completa se forma con 8 actores de este tipo. Los
 * 8 fragmentos salen en 8 direcciones diferentes, las cuatro direcciones normales (arriba, abajo, izquierda
 * y derecha) y las 4 diagonales.
 */

public class Bomb extends Actor {
	
	// Velocidad fija de todos los fragmentos de bomba
	protected static final int BOMB_SPEED = 5; 
	// Velocidades en los ejes, que llevará cada fragmento de bomba
	protected int vX;
	protected int vY;
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param vX
	 * @param vY
	 * @param spriteName
	 */
	public Bomb(int x, int y, int vX, int vY, String spriteName) {
		super(spriteName);
		// Posicionamiento del fragmento
		this.x = x;
		this.y = y;
		// Velocidades en los ejes
		this.vX = vX;
		this.vY = vY;
	}
	
	/**
	 * Actuación del actor en cada iteración del bucle principal del juego
	 */
	@Override
	public void act() {
		super.act(); // Necesario para controlar aspectos comunes de todos los actores
		
		// En cada actuación, el fragmento de bomba se desplazará en los ejes, con la velocidad especificada
		this.y += this.vY;
		this.x += this.vX;
		
		// Si el actor sale de los límites del Canvas, debe marcarse para ser eliminado
		if (this.y < 0 || this.y > Invaders.getInstance().getHeight() 
				|| 
				x < 0 || x > Invaders.getInstance().getWidth()) {
		  
			this.setMarkedForRemoval(true);
		}
	}

	/**
	 * Método estático que permite crear los ocho fragmentos de la bomba. El método también los agrega
	 * a la lista de actores.
	 */
	public static void createWholeBomb (int x, int y) {
		// Creo los 8 fragmentos, uno a uno
		// hacia arriba e izquierda
		Bomb bomb = new Bomb(x, y, -BOMB_SPEED, -BOMB_SPEED, "bombUL.gif");
		bomb.setX(x - bomb.getWidth()); bomb.setY(y - bomb.getHeight());
		Invaders.getInstance().addNewActorToNextIteration(bomb); 
		
		// hacia arriba
		bomb = new Bomb(x, y, 0, -BOMB_SPEED, "bombU.gif");
		bomb.setX(x - bomb.getWidth() / 2); bomb.setY(y - bomb.getHeight());
		Invaders.getInstance().addNewActorToNextIteration(bomb);
		
		// hacia arriba y derecha
		bomb = new Bomb(x, y, BOMB_SPEED, -BOMB_SPEED, "bombUR.gif");
		bomb.setX(x); bomb.setY(y - bomb.getHeight());
		Invaders.getInstance().addNewActorToNextIteration(bomb);
		
		// hacia la derecha
		bomb = new Bomb(x, y, BOMB_SPEED, 0, "bombR.gif");
		bomb.setX(x); bomb.setY(y - bomb.getHeight() / 2);
		Invaders.getInstance().addNewActorToNextIteration(bomb);
		
		// hacia abajo y derecha
		bomb = new Bomb(x, y, BOMB_SPEED, BOMB_SPEED, "bombDR.gif");
		Invaders.getInstance().addNewActorToNextIteration(bomb);

		// hacia abajo
		bomb = new Bomb(x, y, 0, BOMB_SPEED, "bombD.gif");
		bomb.setX(x - bomb.getWidth() / 2);
		Invaders.getInstance().addNewActorToNextIteration(bomb);

		// hacia abajo e izquierda
		bomb = new Bomb(x, y, -BOMB_SPEED, BOMB_SPEED, "bombDL.gif");
		bomb.setX(x - bomb.getWidth());
		Invaders.getInstance().addNewActorToNextIteration(bomb);

		// hacia la izquierda
		bomb = new Bomb(x, y, -BOMB_SPEED, 0, "bombL.gif");
		bomb.setX(x - bomb.getWidth()); bomb.setY(y - bomb.getHeight() / 2);
		Invaders.getInstance().addNewActorToNextIteration(bomb);
	}
}   