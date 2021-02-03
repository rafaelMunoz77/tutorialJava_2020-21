package tutorialJava.capitulo6b_Videojuegos.Arkanoid.version03;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Clase que representa a la nave de nuestro juego
 * @author R
 *
 */
public class Nave extends Actor {
	// propiedades de la nave
	private boolean moviendoAIzquierda = false;
	private boolean moviendoADerecha = false;
	private int velocidad = 5;
	private int ancho = 0;
	
	
	/**
	 * Constructor
	 */
	public Nave() {
		super();
		// Carga del sprite de la nave
		this.spriteActual = CacheImagenes.getInstancia().getImagen("nave-50x15.png");
		// Ajusto el ancho virtual de este objeto al mismo ancho que tiene la imagen del sprite
		this.ancho = this.spriteActual.getWidth();
		// Colocación de la nave en el centro horizontalmente y en la parte baja de la pantalla
		this.x = Arkanoid.getInstancia().getWidth() / 2;
		this.y = Arkanoid.getInstancia().getHeight() - 50;
	}
	

	/**
	 * Método que se llamará para cada actor, en cada refresco de pantalla del juego
	 */
	@Override
	public void act() {
		// Controlo que el movimiento a derecha no haga que la nave se pierda por la derecha
		if (this.moviendoADerecha && (this.x + this.velocidad + this.ancho <= Arkanoid.getInstancia().getWidth())) {
			this.x += this.velocidad;
		}
		// Control que el movimiento a izquierda no haga que la nave se pierda por la izquierda
		if (this.moviendoAIzquierda && (this.x - this.velocidad >= 0)) {
			this.x -= this.velocidad;
		}
	}
	
	
	
	/**
	 * Método llamado desde el controlador del ratón, para delegar el evento hasta este objeto
	 * @param event
	 */
	public void mouseMoved(MouseEvent event) {
		// Cuando el ratón se mueva sobre el canvas, la nave debe situarse a su mismo valor del eje X
		// Si el ratón hace que la nave se pierda por la derecha o la izquierda debo contemplar el hecho de que la nave
		// no se pierda por ese margen
		if (event.getX() >= (this.ancho / 2) // La nave no se perderá por la izquierda
				&&
			event.getX() <= (Arkanoid.getInstancia().getWidth() - this.ancho / 2)) {
			this.x = event.getX() - this.ancho / 2;
		}
	}

	/**
	 * Métodos llamados desde el controlador del teclado, para delegar el evento del teclado
	 * @param event
	 */
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			  case KeyEvent.VK_LEFT : moviendoAIzquierda = true; break;
			  case KeyEvent.VK_RIGHT : moviendoADerecha = true; break;
	  	}
	}
	
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT : moviendoAIzquierda = false; break; 
			case KeyEvent.VK_RIGHT : moviendoADerecha = false; break;
		}
	}
	    
}
