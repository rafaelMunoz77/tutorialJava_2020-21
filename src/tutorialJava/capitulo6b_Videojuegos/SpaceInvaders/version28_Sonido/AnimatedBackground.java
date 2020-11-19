package tutorialJava.capitulo6b_Videojuegos.SpaceInvaders.version28_Sonido;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;

/**
 * 
 * @author Rafael Muñoz Ruiz
 *
 */
public class AnimatedBackground extends Actor {
	// Utilizo este valor para indicar una ordinada a partir de la que dibujar la imagen de fondo animado.
	private int ordinate = 0;
	
	/**
	 * Constructor simple
	 */
	public AnimatedBackground() {
		super("oceano.gif");
	}

	/**
	 * La única actuación de este actor es aumentar la ordinada a partir de la que pinta el fondo con scroll
	 */
	@Override
	public void act() {
		super.act();
		ordinate++;
	}

	/**
	 * Pintado del fondo animado
	 */
	@Override
	public void paint(Graphics2D g) {
		// Si la ordinada llega a tener el valor del alto de la imagen con scroll, reinicio dicho valor, para que 
		// el valor no llegue al infinito
		if (ordinate == this.getHeight()) {
			ordinate = 0;
		}
		
		// Creo una brocha con la que pintar, basada en la imagen de este actor, pero con la ordinada correcta, que 
		// simula la animación del scroll
		g.setPaint(new TexturePaint(this.getSpriteActual(), 
				new Rectangle(0 , ordinate, this.getWidth(), this.getHeight())));
		
		// Relleno un rectángulo con todo el espacio visible del canvas principal del juego
	    g.fillRect( 0, 0, Invaders.getInstance().getWidth(), Invaders.getInstance().getHeight());
	}


	
}
