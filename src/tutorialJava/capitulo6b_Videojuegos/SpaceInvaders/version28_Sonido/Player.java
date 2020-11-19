package tutorialJava.capitulo6b_Videojuegos.SpaceInvaders.version28_Sonido;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 
 * @author Rafael Muñoz Ruiz
 *
 */

public class Player extends Actor implements KeyListener{
	// Propiedades específicas del jugador
	protected int vx; // Cantidad de píxeles que aumentará la posición del jugador en cada iteración del bucle principal del juego
	protected int vy; // igual a la anterior en el eje vertical
	private boolean up,down,left,right; // Booleanas que determinan si el player se está moviendo actualmente
	protected static final int PLAYER_SPEED = 4; // velocidad del movimiento de la nave en los dos ejes
	private int actsFromLastMissileFired = 0; // Iteraciones del juego desde que se disparo el último misil. Esto servirá para
													// limitar la cantidad de misiles que se pueden disparar. Si no se hiciera esto
													// El jugador podría disparar misiles de forma ilimitada, sin freno
	private static int MIN_ACTS_BETWEEN_MISSILES_FIRED = 10; // Número mínimo de actuaciones de este actor entre dos misiles disparados
	private int remainingBombs = 5; // El jugador dispone de un número limitado de bombas
	public static final int MAX_SHIELDS = 200; // Vida inicial máxima para el jugador
	private int score; // Puntuación del jugador
	private int shields; // Vida del jugador en cada momento del juego
	public static int SHIELDS_RETRIEVED_FOR_COLLISION_WITH_ENEMY = 40; // Puntos que se perderán por colisionar con un enemigo
	public static int SHIELDS_RETRIEVED_FOR_COLLISION_WITH_ENEMY_FIRE = 20; // Puntos que se perderán por colisionar con el disparo de un enemigo


	
	/**
	 * Constructor por defecto, que inicializa la imagen del jugador
	 */
	public Player() {
		super("nave.gif");
		// Inicializo los puntos de vida y la puntuación del player
		this.shields = MAX_SHIELDS;
		this.score = 0;
	}
	
	/**
	 * Método necesario para extender de Actor, incorpora el movimiento que el actor realizará en cada iteración del programa
	 */
	public void act() {
		super.act(); // Necesario para habilitar cambios de sprites en el actor

		// Movimiento en el eje horizontal
		this.x += this.vx; // En cada iteración del bucle principal, el monstruo cambiará su posición en el eje X, sumándole a esta el valor de vx
		// si la nave intenta salir por la derecha no se lo permitimos
		if (this.x <  0) {
			this.x = 0;
		}
		// si la nave intenta salir por la izquierda no se lo permitimos
		if (this.x >  (Invaders.getInstance().getWidth() - this.width)) {
			this.x = (Invaders.getInstance().getWidth() - this.width);
		}
		
		// Movimiento en el eje vertical
		this.y += this.vy; // En cada iteración del bucle principal, el monstruo cambiará su posición en el eje y, sumándole a esta el valor de vy
		// si la nave intenta salir por arriba no se lo permitimos
		if (this.y <  0) {
			this.y = 0;
		}
		// si la nave intenta salir por abajo no se lo permitimos
		if (this.y >  (Invaders.getInstance().getHeight() - this.height)) {
			this.y = (Invaders.getInstance().getHeight() - this.height);
		}
		
		// La cantidad de actuaciones desde el último disparo de la nave debe aumentarse cada vez que este actor actúa
		this.actsFromLastMissileFired++;
	}
	

	/**
	 * Cuando pulsen una tecla activamos la bandera booleana concreta que indica que existe un movimiento
	 */
	@Override
	public void keyPressed(KeyEvent e) {
	  	switch (e.getKeyCode()) {
	  		case KeyEvent.VK_UP : up = true; break;
			case KeyEvent.VK_LEFT : left = true; break;
			case KeyEvent.VK_RIGHT : right = true; break;
			case KeyEvent.VK_DOWN : down = true;break;
			case KeyEvent.VK_SPACE : fireMissile(); break; // Disparo de un nuevo misil
			case KeyEvent.VK_B : fireBomb(); break; // Disparo de una bomba
	  	}
	  	updateSpeed();
	}

	/**
	 * Cuando una tecla se libera se desactiva la bandera booleana que se había activado al pulsarla
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
  			case KeyEvent.VK_DOWN : down = false;break;
  			case KeyEvent.VK_UP : up = false; break;
  			case KeyEvent.VK_LEFT : left = false; break; 
  			case KeyEvent.VK_RIGHT : right = false;break;
		}
		updateSpeed();
	}
	  
	/**
	 * Este método no se utiliza pero es necesario implementarlo por el KeyListener
	 */
	@Override
	public void keyTyped(KeyEvent e) {}
	
	/**
	 * En función de las banderas booleanas de movimiento, actualizamos las velocidades en los dos ejes
	 */
	protected void updateSpeed() {
		vx=0;vy=0;
		if (down) vy = PLAYER_SPEED;
		if (up) vy = -PLAYER_SPEED;
		if (left) vx = -PLAYER_SPEED;
		if (right) vx = PLAYER_SPEED;
	}
		 
	/**
	 * Método que crea un nuevo misil, justo encima de la posición que ocupa el objeto Player
	 */
	public void fireMissile() {
		// Para poder disparar debo comprobar que han transcurrido la mínima cantidad de actuaciones entre dos 
		// misiles seguidos
		if (this.actsFromLastMissileFired >= MIN_ACTS_BETWEEN_MISSILES_FIRED) {
			// Reseteo el valor de actuaciones desde el último misil lanzado
			this.actsFromLastMissileFired = 0;
			
			// Creo el nuevo objeto de tipo Missile
			Missile missile = new Missile();
			// Como coordenada x del disparo hago un cálculo para que quede centrado respecto a la nave del jugador
			missile.setX(this.x + this.width / 2 - missile.getWidth() / 2);
			// Como coordenada y del misil, tomo la coordenada y de la nave
			missile.setY(this.y);
			// Agrego el actor a la lista de nuevos actores del videojuego
		   	Invaders.getInstance().addNewActorToNextIteration(missile);
		   	
		   	// Lanzo el sonido que corresponde a lanzar el misil
		   	SoundsRepository.getInstance().playSound(SoundsRepository.getInstance().MISSILE);
		}
	  }

	/**
	 * Creo y disparo una nueva bomba. Existe un contador de bombas, son limitadas
	 */
	public void fireBomb() {
		// Compruebo si aún dispongo de bombas 
		if (this.remainingBombs > 0) {
			// Lanzo una nueva bomba
			Bomb.createWholeBomb(this.x + this.getWidth() / 2, this.y + this.getHeight() / 2);
			// Descuento la bomba lanzada respecto a las bombas aún disponibles
			this.remainingBombs--;

			// Lanzo el sonido que corresponde a lanzar una bomba
		   	SoundsRepository.getInstance().playSound(SoundsRepository.getInstance().MISSILE);
		}
	}
	
	/**
	 * Método llamado cuando este actor colisiona con otro en pantalla
	 */
	@Override
	public void collisionWith(Actor actorCollisioned) {
		super.collisionWith(actorCollisioned);
		// Si el player choca contra un monstruo, eliminamos al monstruo, le damos puntuación al player
		// y le quitamos puntos de vida al player.
		if (actorCollisioned instanceof Monster) {
			actorCollisioned.setMarkedForRemoval(true);
			this.addScore(Monster.SCORE_FOR_KILL_THIS_ACTOR);
			this.retrieveShields(SHIELDS_RETRIEVED_FOR_COLLISION_WITH_ENEMY);
		}
		
		// Si el player choca con el disparo de un monstruo, eliminamos el disparo y le quitamos vida al player
		if (actorCollisioned instanceof Laser) {
			actorCollisioned.setMarkedForRemoval(true);
			this.retrieveShields(SHIELDS_RETRIEVED_FOR_COLLISION_WITH_ENEMY_FIRE);
		}
	}

	/**
	 * Método que permite quitar puntos de vida del player
	 * @param shieldsToRetrieve
	 */
	public void retrieveShields (int shieldsToRetrieve) {
		this.shields -= shieldsToRetrieve;
		// Si nos quedamos sin puntos de vida, el juego termina
		if (this.shields <= 0) {
			Invaders.getInstance().setGameEnded(true);
			// Además, el player se elimina del juego, para que no aparezca más
			this.setMarkedForRemoval(true);
		}
	}
	
	
	// Métodos Getters y Setters
	public int getVx() { return vx; }
	public void setVx(int vx) { this.vx = vx; }

	public int getVy() { return vy; }
	public void setVy(int vy) { this.vy = vy; }

	public int getScore() {	return score; }
	public void setScore(int score) { this.score = score; }
	public void addScore(int score) { this.score += score; }

	public int getShields() { return shields; }
	public void setShields(int shields) { this.shields = shields; }

	public int getRemainingBombs() { return remainingBombs; }
	public void setRemainingBombs(int remainingBombs) { this.remainingBombs = remainingBombs; }
	

}
