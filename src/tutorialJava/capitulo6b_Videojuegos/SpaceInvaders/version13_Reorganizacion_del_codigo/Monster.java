package tutorialJava.capitulo6b_Videojuegos.SpaceInvaders.version13_Reorganizacion_del_codigo;

/**
 * 
 * @author Rafael Carlos Muñoz Ruiz
 *
 */
public class Monster extends Actor {
	// Propiedades específicas del Monstruo
	protected int vx; // Cantidad de píxeles que aumentará la posición del mostruo en cada iteración del bucle principal del juego
	
	/**
	 * Constructor por defecto, que inicializa la imagen del monstruo
	 */
	public Monster() {
		super("bicho.gif");
	}
	
	/**
	 * Método necesario para extender de Actor, incorpora el movimiento que el actor realizará en cada iteración del programa
	 */
	public void act() {
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
