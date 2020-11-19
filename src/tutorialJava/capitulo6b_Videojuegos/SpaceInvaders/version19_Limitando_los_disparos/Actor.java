package tutorialJava.capitulo6b_Videojuegos.SpaceInvaders.version19_Limitando_los_disparos;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Rafael Carlos Mu�oz
 *
 */
public class Actor {
	protected int x,y; // Coordenadas en las que se encuentra el actor
	protected int width, height; // Ancho y alto que ocupa, imprescindible para detectar colisiones
	protected List<BufferedImage> sprites = new ArrayList<BufferedImage>(); // Lista de archivos de imagen utilizado para representarse en pantalla
	protected BufferedImage spriteActual = null; // Sprite que representa actualmente a este actor
	private int unidadDeTiempo = 0; // La unidad de tiempo aumenta cada vez que se llama al m�todo "act()" del Actor
	protected int velocidadDeCambioDeSprite = 0;  // Esta propiedad indica cada cu�ntas "unidades de tiempo" debemos mostrar
												  // el siguiente sprite del actor
	protected boolean markedForRemoval = false;  // Pondremos a true esta bandera cuando el actor deba ser eliminado de la siguiente iteraci�n
												  // del juego
	
	
	/**
	 * Constructor por defecto
	 */
	public Actor() {
	}
	
	/**
	 * Constructor usado cuando el actor s�lo tiene un �nico sprite
	 * @param spriteName
	 */
	public Actor (String spriteName) {
		this.velocidadDeCambioDeSprite = 1;
		cargarImagenesDesdeSpriteNames(new String[] {spriteName});
	}
	
	/**
	 * Constructor ampl�amente utilizado, indicando los nombres de los sprites a utilizar para mostrar este actor
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
	 * A partir de un array de String, cargamos en memoria la lista de im�genes que constituyen los sprites del actor
	 * @param spriteNames
	 */
	private void cargarImagenesDesdeSpriteNames (String spriteNames[]) {
		// Obtengo las im�genes de este actor, a partir del patr�n de dise�o Singleton con el que se encuentra
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
	 * Actualiza los valores de width y height del Actor, a partir una BufferedImage que lo representar�
	 * en pantalla
	 */
	private void adjustHeightAndWidth () {
		// Una vez que tengo las im�genes que representa a este actor, obtengo el ancho y el alto m�ximos de las mismas y se
		// los traspaso a objeto actual.
		if (this.sprites.size() > 0) {
			this.height = this.sprites.get(0).getHeight();
			this.width = this.sprites.get(0).getWidth();
		}
		for (BufferedImage sprite : this.sprites) {
			// Ajusto el m�ximo width como el width del actor
			if (sprite.getWidth() > this.width) {
				this.width = sprite.getWidth();
			}
			// Lo mismo que el anterior, pero con el m�ximo height
			if (sprite.getHeight() > this.height) {
				this.height = sprite.getHeight();
			}
		}
	}
	
	/**
	 * M�todo para representar este actor en pantalla
	 * @param g
	 */
	public void paint(Graphics2D g){
		g.drawImage( this.spriteActual, this.x, this.y, null);
	}
	
	/**
	 * M�todo que lleva el control de las unidades de tiempo y el sprite que representa en cada momento al actor. Los subtipos
	 * deber�n incorporar este m�todo y realizar la llamada "super.act()".
	 */
	public void act() {
		// En el caso de que exista un array de sprites el actor actual se tratar� de una animaci�n, para eso llevaremos a cabo los siguientes pasos
		if (this.sprites != null && this.sprites.size() > 1) {
			// cada vez que llaman a "act()" se incrementar� esta unidad, siempre que existan sprites
			unidadDeTiempo++;
			// Si la unidad de tiemplo coincide o es m�ltiplo de la velocidad de cambio de sprite, entramos al if
			if (unidadDeTiempo % velocidadDeCambioDeSprite == 0){
				// Reiniciamos la unidad de tiempo
				unidadDeTiempo = 0;
				// Obtengo el �ndice del spriteActual, dentro de la lista de �ndices
				int indiceSpriteActual = sprites.indexOf(this.spriteActual);
				// Obtengo el siguiente �ndice de sprite, teniendo en cuenta que los sprites cambian de uno a otro en ciclo
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
