package tutorialJava.capitulo6b_Videojuegos.SpaceInvaders.version17_Controlando_el_jugador;

/**
 * 
 * @author Rafael Carlos Muñoz Ruiz
 *
 */
public class Monster extends Actor {
	// Propiedades específicas del Monstruo
	protected int vx; // Cantidad de píxeles que aumentará la posición del mostruo en cada iteración del bucle principal del juego
	
	/**
	 * Constructor por defecto, que inicializa la imagen del monstruo y la velocidad de cambio de sprites
	 */
	public Monster() {
		super(new String[] {"bicho0.gif", "bicho1.gif"}, 20);
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
	}
	
	// Métodos Getters y Setters
	public int getVx() { return vx; }
	public void setVx(int vx) { this.vx = vx; }

}
