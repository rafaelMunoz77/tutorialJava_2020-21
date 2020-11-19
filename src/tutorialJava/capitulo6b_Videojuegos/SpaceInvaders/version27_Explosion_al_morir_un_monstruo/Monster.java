package tutorialJava.capitulo6b_Videojuegos.SpaceInvaders.version27_Explosion_al_morir_un_monstruo;

/**
 * 
 * @author Rafael Muñoz Ruiz
 *
 */
public class Monster extends Actor {
	// Propiedades específicas del Monstruo
	protected int vx; // Cantidad de píxeles que aumentará la posición del mostruo en cada iteración del bucle principal del juego
	public static int SCORE_FOR_KILL_THIS_ACTOR = 20;
	public static float FIRING_FREQUENCY = 0.01f; // Frecuencia con la que este actor disparará (1% de las veces que actúe) 
	
	// Array con los nombres de los sprites que forman este actor
	private static String[] SPRITES = new String[] {"bicho0.gif", "bicho1.gif"};	
	
	/**
	 * Constructor por defecto, que inicializa la imagen del monstruo y la velocidad de cambio de sprites
	 */
	public Monster() {
		super(SPRITES, 20);
	}
	
	/**
	 * Método necesario para extender de Actor, incorpora el movimiento que el actor realizará en cada iteración del programa
	 */
	public void act() {
		super.act(); // Necesario para habilitar cambios de sprites en el actor
		this.x += this.vx; // En cada iteración del bucle principal, el monstruo cambiará su posición en el eje X, sumándole a esta el valor de vx
		// ¿Qué ocurre si la imagen del personaje sale de la pantalla en el eje horizontal?
		if (this.x < 0 || this.x > (Invaders.getInstance().getWidth() - this.getWidth())) {
			  vx = -vx; // En caso de salir fuera de la ventana, el actor cambiar el signo de su velocidad, tanto cuando choque
			  // con el límite derecho como cuando lo haga con el izquierdo
		}
		
		// Este actor debe disparar con una probabilidad determinada
		if (Math.random() < FIRING_FREQUENCY) {
			fire();
		}
	}
	
	/**
	 * 
	 */
	public void fire() {
        Laser laser = new Laser(); 
        laser.setX(this.x + this.getWidth() / 2 + laser.getWidth() / 2); // Centro horizontalmente el laser
        laser.setY(this.y + this.getHeight()); // En vertical el láser aparece justo debajo del monstruo
        Invaders.getInstance().addNewActorToNextIteration(laser);
 	}
	
	/**
	 * Método que determina el comportamiento cuando este actor colisione con otro
	 */
	@Override
	public void collisionWith(Actor actorCollisioned) {
		super.collisionWith(actorCollisioned);
		// Debo comprobar el tipo del actor que colisiona con este
		if (actorCollisioned instanceof Missile || actorCollisioned instanceof Bomb) {
			// Si este actor colisiona con un misil o una bomba, debo eliminar el monstruo
			this.setMarkedForRemoval(true);
			// Creo una explosión en el lugar que antes ocupaba el monstruo
			this.createExplosion();
			// Si el monstruo colisiona con un misil o una bomba, también debo eliminar el mision o la bomba
			actorCollisioned.setMarkedForRemoval(true);
			// Le debo aumentar la puntuación obtenida al jugador, por haber eliminado a este monstruo
			Invaders.getInstance().getPlayer().addScore(SCORE_FOR_KILL_THIS_ACTOR);
		}
	}
	
	/**
	 * Crear un nuevo actor de explosión en el lugar que ocupa el monstruo
	 */
	private void createExplosion () {
		Explosion explosion = new Explosion();
		explosion.setX(this.x); 
		explosion.setY(this.y); 
        Invaders.getInstance().addNewActorToNextIteration(explosion);
	}
	

	// Métodos Getters y Setters
	public int getVx() { return vx; }
	public void setVx(int vx) { this.vx = vx; }

}
