package tutorialJava.capitulo6b_Videojuegos.Arkanoid.version01;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Clase que representa a cada ladrillo de los que pondremos sobre la pantalla
 * @author R
 *
 */
public class Ladrillo extends Actor {
	// Damos un ancho y un alto espec�fico al ladrillo. Suponemos que todos los ladrillos ser�n iguales
	public static final int ANCHO = 30;
	public static final int ALTO = 20;
	
	// Propiedades espec�ficas de cada ladrillo
	private Color color = null;
	
	/**
	 * 
	 */
	public Ladrillo() {
		super();
		spriteActual = null; // El ladrillo se pinta vectorialmente, as� que no utilizo ning�n sprite
		this.x = 10;
		this.y = 10;
		this.color = Color.WHITE; // Por defecto pongo el ladrillo en color blanco
	}

	
	/**
	 * Pintado del ladrillo en pantalla
	 */
	public void paint(Graphics2D g){
		g.setColor(this.color);
		// Pinto el ladrillo como un rect�ngulo con v�rtices redondeados
		g.fillRoundRect(this.x, this.y, ANCHO, ALTO, 3, 3);
	}


	// M�todos getter y setter
	public Color getColor() { return color; }
	public void setColor(Color color) { this.color = color; }
}
