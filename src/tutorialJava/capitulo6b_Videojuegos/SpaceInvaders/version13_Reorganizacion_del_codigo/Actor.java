package tutorialJava.capitulo6b_Videojuegos.SpaceInvaders.version13_Reorganizacion_del_codigo;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * 
 * @author Rafael Carlos Muñoz
 *
 */
public abstract class Actor {
	protected int x,y; // Coordenadas en las que se encuentra el actor
	protected int width, height; // Ancho y alto que ocupa, imprescindible para detectar colisiones
	protected BufferedImage image; // Archivo de imagen utilizado para representarse en pantalla
	
	/**
	 * Constructor por defecto, inicializa la propiedad "image" a null, indicando que no hay imagen
	 */
	public Actor() {
		this.image = null;
	}
	
	/**
	 * Constructor amplíamente utilizado, indicando el nombre de la imagen a utilizar
	 * @param spriteName
	 */
	public Actor (String spriteName) {
		// Obtengo la imagen de este actor, a partir del patrón de diseño Singleton con el que se encuentra
		// el spritesRepository
		this.image = SpritesRepository.getInstance().getSprite(spriteName);
		adjustHeightAndWidth ();
	}
	
	/**
	 * Actualiza los valores de width y height del Actor, a partir una BufferedImage que lo representará
	 * en pantalla
	 */
	private void adjustHeightAndWidth () {
		// Una vez que tengo la imagen que representa a este actor, obtengo el ancho y el alto de la misma y se
		// los traspaso a objeto actual.
		height = this.image.getHeight();
		width = this.image.getWidth();
	}
	
	/**
	 * Método para representar este actor en pantalla
	 * @param g
	 */
	public void paint(Graphics2D g){
		g.drawImage( this.image, this.x, this.y, null);
	}
	
	/**
	 * Método abstracto que debe implementar cada subtipo de Actor. Lógicamente no será lo mismo la actuación 
	 * que llevará a cabo un Player que un Monster.
	 */
	public abstract void act();

	// Setters y Getters

	public int getX() { return x; }
	public void setX(int x) { this.x = x; }

	public int getY() {	return y; }
	public void setY(int y) { this.y = y; }

	public int getWidth() { return width; }
	public void setWidth(int width) { this.width = width; }

	public int getHeight() { return height; }
	public void setHeight(int height) { this.height = height; }

	public BufferedImage getImage() { return image; }
	public void setImage(BufferedImage image) { 
		this.image = image;	
		this.adjustHeightAndWidth();
	}
	
	
	
}
