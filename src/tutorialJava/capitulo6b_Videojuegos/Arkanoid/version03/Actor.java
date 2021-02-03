package tutorialJava.capitulo6b_Videojuegos.Arkanoid.version03;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Esta clase representará a cualquier elemento que queramos pintar sobre la pantalla
 * @author R
 *
 */
public class Actor {
	// Propiedades que contienen las coordenadas del actor y la imagen que corresponda con el mismo
	protected int x, y;
	protected BufferedImage spriteActual;
	
	
	/**
	 * 
	 */
	public Actor() {
		// En principio coloco una imagen genérica al actor
		spriteActual = CacheImagenes.getInstancia().getImagen("sin-imagen.png");
	}
	
	
	/**
	 * Método para pintar el actor en la pantalla
	 * @param g
	 */
	public void paint(Graphics2D g){
		// Cuidado, el sprite del actor puede ser nulo, de manera que el actor se pinte por gráficos vectoriales
		if (this.spriteActual != null) {
			g.drawImage(this.spriteActual, this.x, this.y, null);
		}
	}
	
	
	/**
	 * Método que se llamará para cada actor, en cada refresco de pantalla del juego
	 */
	public void act() {
	}


	// Métodos setters y getters
	public int getX() {	return x; }
	public void setX(int x) { this.x = x; }
	public int getY() { return y; }
	public void setY(int y) { this.y = y; }
	public BufferedImage getSpriteActual() { return spriteActual; }
	public void setSpriteActual(BufferedImage spriteActual) { this.spriteActual = spriteActual; }
}
