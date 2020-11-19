package tutorialJava.capitulo6b_Videojuegos.SpaceInvaders.version16_El_jugador;

public class Player extends Actor {
	// Propiedades espec�ficas del jugador
	protected int vx; // Cantidad de p�xeles que aumentar� la posici�n del jugador en cada iteraci�n del bucle principal del juego
	protected int vy; // igual a la anterior en el eje vertical
	
	/**
	 * Constructor por defecto, que inicializa la imagen del jugador
	 */
	public Player() {
		super(new String[] {"nave.gif"});
	}
	
	/**
	 * M�todo necesario para extender de Actor, incorpora el movimiento que el actor realizar� en cada iteraci�n del programa
	 */
	public void act() {
		super.act(); // Necesario para habilitar cambios de sprites en el actor

		// Movimiento en el eje horizontal
		this.x += this.vx; // En cada iteraci�n del bucle principal, el monstruo cambiar� su posici�n en el eje X, sum�ndole a esta el valor de vx
		// �Qu� ocurre si la imagen del personaje sale de la pantalla en el eje horizontal?
		if (this.x < 0 || this.x > (Invaders.getInstance().getWidth() - this.getWidth())) {
			  vx = -vx; // En caso de salir fuera de la ventana, el actor cambiar el signo de su velocidad, tanto cuando choque
			  // con el l�mite derecho como cuando lo haga con el izquierdo
		}
		
		// Movimiento en el eje vertical
		this.y += this.vy; // En cada iteraci�n del bucle principal, el monstruo cambiar� su posici�n en el eje y, sum�ndole a esta el valor de vy
		// �Qu� ocurre si la imagen del personaje sale de la pantalla en el eje vertical?
		if (this.y < 0 || this.y > (Invaders.getInstance().getHeight() - this.getHeight())) {
			  vy = -vy; // En caso de salir fuera de la ventana, el actor cambiar el signo de su velocidad, tanto cuando choque
			  // con el l�mite superior como cuando lo haga con el inferior
		}
	}
	
	// M�todos Getters y Setters
	public int getVx() { return vx; }
	public void setVx(int vx) { this.vx = vx; }

	public int getVy() { return vy; }
	public void setVy(int vy) { this.vy = vy; }
}
