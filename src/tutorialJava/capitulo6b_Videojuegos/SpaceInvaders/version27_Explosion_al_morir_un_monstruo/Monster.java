package tutorialJava.capitulo6b_Videojuegos.SpaceInvaders.version27_Explosion_al_morir_un_monstruo;

/**
 * 
 * @author Rafael Mu�oz Ruiz
 *
 */
public class Monster extends Actor {
	// Propiedades espec�ficas del Monstruo
	protected int vx; // Cantidad de p�xeles que aumentar� la posici�n del mostruo en cada iteraci�n del bucle principal del juego
	public static int SCORE_FOR_KILL_THIS_ACTOR = 20;
	public static float FIRING_FREQUENCY = 0.01f; // Frecuencia con la que este actor disparar� (1% de las veces que act�e) 
	
	// Array con los nombres de los sprites que forman este actor
	private static String[] SPRITES = new String[] {"bicho0.gif", "bicho1.gif"};	
	
	/**
	 * Constructor por defecto, que inicializa la imagen del monstruo y la velocidad de cambio de sprites
	 */
	public Monster() {
		super(SPRITES, 20);
	}
	
	/**
	 * M�todo necesario para extender de Actor, incorpora el movimiento que el actor realizar� en cada iteraci�n del programa
	 */
	public void act() {
		super.act(); // Necesario para habilitar cambios de sprites en el actor
		this.x += this.vx; // En cada iteraci�n del bucle principal, el monstruo cambiar� su posici�n en el eje X, sum�ndole a esta el valor de vx
		// �Qu� ocurre si la imagen del personaje sale de la pantalla en el eje horizontal?
		if (this.x < 0 || this.x > (Invaders.getInstance().getWidth() - this.getWidth())) {
			  vx = -vx; // En caso de salir fuera de la ventana, el actor cambiar el signo de su velocidad, tanto cuando choque
			  // con el l�mite derecho como cuando lo haga con el izquierdo
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
        laser.setY(this.y + this.getHeight()); // En vertical el l�ser aparece justo debajo del monstruo
        Invaders.getInstance().addNewActorToNextIteration(laser);
 	}
	
	/**
	 * M�todo que determina el comportamiento cuando este actor colisione con otro
	 */
	@Override
	public void collisionWith(Actor actorCollisioned) {
		super.collisionWith(actorCollisioned);
		// Debo comprobar el tipo del actor que colisiona con este
		if (actorCollisioned instanceof Missile || actorCollisioned instanceof Bomb) {
			// Si este actor colisiona con un misil o una bomba, debo eliminar el monstruo
			this.setMarkedForRemoval(true);
			// Creo una explosi�n en el lugar que antes ocupaba el monstruo
			this.createExplosion();
			// Si el monstruo colisiona con un misil o una bomba, tambi�n debo eliminar el mision o la bomba
			actorCollisioned.setMarkedForRemoval(true);
			// Le debo aumentar la puntuaci�n obtenida al jugador, por haber eliminado a este monstruo
			Invaders.getInstance().getPlayer().addScore(SCORE_FOR_KILL_THIS_ACTOR);
		}
	}
	
	/**
	 * Crear un nuevo actor de explosi�n en el lugar que ocupa el monstruo
	 */
	private void createExplosion () {
		Explosion explosion = new Explosion();
		explosion.setX(this.x); 
		explosion.setY(this.y); 
        Invaders.getInstance().addNewActorToNextIteration(explosion);
	}
	

	// M�todos Getters y Setters
	public int getVx() { return vx; }
	public void setVx(int vx) { this.vx = vx; }

}
