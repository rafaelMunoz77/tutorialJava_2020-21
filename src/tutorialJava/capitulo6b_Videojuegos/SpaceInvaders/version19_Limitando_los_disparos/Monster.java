package tutorialJava.capitulo6b_Videojuegos.SpaceInvaders.version19_Limitando_los_disparos;

/**
 * 
 * @author Rafael Carlos Mu�oz Ruiz
 *
 */
public class Monster extends Actor {
	// Propiedades espec�ficas del Monstruo
	protected int vx; // Cantidad de p�xeles que aumentar� la posici�n del mostruo en cada iteraci�n del bucle principal del juego
	
	/**
	 * Constructor por defecto, que inicializa la imagen del monstruo y la velocidad de cambio de sprites
	 */
	public Monster() {
		super(new String[] {"bicho0.gif", "bicho1.gif"}, 20);
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
	}
	
	// M�todos Getters y Setters
	public int getVx() { return vx; }
	public void setVx(int vx) { this.vx = vx; }

}
