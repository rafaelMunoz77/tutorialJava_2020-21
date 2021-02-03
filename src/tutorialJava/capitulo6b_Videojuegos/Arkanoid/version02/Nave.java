package tutorialJava.capitulo6b_Videojuegos.Arkanoid.version02;

/**
 * Clase que representa a la nave de nuestro juego
 * @author R
 *
 */
public class Nave extends Actor {

	/**
	 * 
	 */
	public Nave() {
		super();
		// Carga del sprite de la nave
		spriteActual = CacheImagenes.getInstancia().getImagen("nave-50x15.png");
		// Colocación de la nave en el centro horizontalmente y en la parte baja de la pantalla
		this.x = Arkanoid.getInstancia().getWidth() / 2;
		this.y = Arkanoid.getInstancia().getHeight() - 50;
	}
		
}
