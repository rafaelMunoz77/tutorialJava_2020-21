package tutorialJava.capitulo6b_Videojuegos.SpaceInvaders.version18_Disparos;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Rafael Carlos Muñoz
 *
 */
public class Actor {
	protected int x,y; // Coordenadas en las que se encuentra el actor
	protected int width, height; // Ancho y alto que ocupa, imprescindible para detectar colisiones
	protected List<BufferedImage> sprites = new ArrayList<BufferedImage>(); // Lista de archivos de imagen utilizado para representarse en pantalla
	protected BufferedImage spriteActual = null; // Sprite que representa actualmente a este actor
	private int unidadDeTiempo = 0; // La unidad de tiempo aumenta cada vez que se llama al método "act()" del Actor
	protected int velocidadDeCambioDeSprite = 0;  // Esta propiedad indica cada cuántas "unidades de tiempo" debemos mostrar
												  // el siguiente sprite del actor
	protected boolean markedForRemoval = false;  // Pondremos a true esta bandera cuando el actor deba ser eliminado de la siguiente iteración
												  // del juego
	
	
	/**
	 * Constructor por defecto
	 */
	public Actor() {
	}
	
	/**
	 * Constructor usado cuando el actor sólo tiene un único sprite
	 * @param spriteName
	 */
	public Actor (String spriteName) {
		this.velocidadDeCambioDeSprite = 1;
		cargarImagenesDesdeSpriteNames(new String[] {spriteName});
	}
	
	/**
	 * Constructor amplíamente utilizado, indicando los nombres de los sprites a utilizar para mostrar este actor
	 * @param spriteName
	 */
	public Actor (String spriteNames[]) {
		this.velocidadDeCambioDeSprite = 1;
		cargarImagenesDesdeSpriteNames(spriteNames);
	}
	
	/**
	 * 
	 * @param spriteNames
	 * @param velocidadDeCambioDeSprite
	 */
	public Actor (String spriteNames[], int velocidadDeCambioDeSprite) {
		this.velocidadDeCambioDeSprite = velocidadDeCambioDeSprite;
		cargarImagenesDesdeSpriteNames(spriteNames);
	}
	
	
	/**
	 * A partir de un array de String, cargamos en memoria la lista de imágenes que constituyen los sprites del actor
	 * @param spriteNames
	 */
	private void cargarImagenesDesdeSpriteNames (String spriteNames[]) {
		// Obtengo las imágenes de este actor, a partir del patrón de diseño Singleton con el que se encuentra
		// el spritesRepository
		for (String sprite : spriteNames) {
			this.sprites.add(SpritesRepository.getInstance().getSprite(sprite));
		}
		// ajusto el primer sprite del actor
		if (this.sprites.size() > 0) {
			this.spriteActual = this.sprites.get(0);
		}
		adjustHeightAndWidth ();
	}
	
	
	/**
	 * Actualiza los valores de width y height del Actor, a partir una BufferedImage que lo representará
	 * en pantalla
	 */
	private void adjustHeightAndWidth () {
		// Una vez que tengo las imágenes que representa a este actor, obtengo el ancho y el alto máximos de las mismas y se
		// los traspaso a objeto actual.
		if (this.sprites.size() > 0) {
			this.height = this.sprites.get(0).getHeight();
			this.width = this.sprites.get(0).getWidth();
		}
		for (BufferedImage sprite : this.sprites) {
			// Ajusto el máximo width como el width del actor
			if (sprite.getWidth() > this.width) {
				this.width = sprite.getWidth();
			}
			// Lo mismo que el anterior, pero con el máximo height
			if (sprite.getHeight() > this.height) {
				this.height = sprite.getHeight();
			}
		}
	}
	
	/**
	 * Método para representar este actor en pantalla
	 * @param g
	 */
	public void paint(Graphics2D g){
		g.drawImage( this.spriteActual, this.x, this.y, null);
	}
	
	/**
	 * Método que lleva el control de las unidades de tiempo y el sprite que representa en cada momento al actor. Los subtipos
	 * deberán incorporar este método y realizar la llamada "super.act()".
	 */
	public void act() {
		// En el caso de que exista un array de sprites el actor actual se tratará de una animación, para eso llevaremos a cabo los siguientes pasos
		if (this.sprites != null && this.sprites.size() > 1) {
			// cada vez que llaman a "act()" se incrementará esta unidad, siempre que existan sprites
			unidadDeTiempo++;
			// Si la unidad de tiemplo coincide o es múltiplo de la velocidad de cambio de sprite, entramos al if
			if (unidadDeTiempo % velocidadDeCambioDeSprite == 0){
				// Reiniciamos la unidad de tiempo
				unidadDeTiempo = 0;
				// Obtengo el índice del spriteActual, dentro de la lista de índices
				int indiceSpriteActual = sprites.indexOf(this.spriteActual);
				// Obtengo el siguiente índice de sprite, teniendo en cuenta que los sprites cambian de uno a otro en ciclo
				int indiceSiguienteSprite = (indiceSpriteActual + 1) % sprites.size();
				// Se selecciona el nuevo spriteActual
				this.spriteActual = sprites.get(indiceSiguienteSprite);
			}
		}
		
	}

	// Setters y Getters

	public int getX() { return x; }
	public void setX(int x) { this.x = x; }

	public int getY() {	return y; }
	public void setY(int y) { this.y = y; }

	public int getWidth() { return width; }
	public void setWidth(int width) { this.width = width; }

	public int getHeight() { return height; }
	public void setHeight(int height) { this.height = height; }

	public BufferedImage getSpriteActual() { return spriteActual; }
	public void setSpriteActual(BufferedImage spriteActual) { this.spriteActual = spriteActual; }

	public int getVelocidadDeCambioDeSprite() { return velocidadDeCambioDeSprite; }
	public void setVelocidadDeCambioDeSprite(int velocidadDeCambioDeSprite) { this.velocidadDeCambioDeSprite = velocidadDeCambioDeSprite; }

	public boolean isMarkedForRemoval() { return markedForRemoval; }
	public void setMarkedForRemoval(boolean markedForRemoval) { this.markedForRemoval = markedForRemoval; }

	
	
	
}
