package tutorialJava.capitulo6b_Videojuegos.SpaceInvaders.version17_Controlando_el_jugador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends Actor implements KeyListener{
	// Propiedades espec�ficas del jugador
	protected int vx; // Cantidad de p�xeles que aumentar� la posici�n del jugador en cada iteraci�n del bucle principal del juego
	protected int vy; // igual a la anterior en el eje vertical
	private boolean up,down,left,right; // Booleanas que determinan si el player se est� moviendo actualmente
	protected static final int PLAYER_SPEED = 4; // velocidad del movimiento de la nave en los dos ejes


	
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
		// si la nave intenta salir por la derecha no se lo permitimos
		if (this.x <  0) {
			this.x = 0;
		}
		// si la nave intenta salir por la izquierda no se lo permitimos
		if (this.x >  (Invaders.getInstance().getWidth() - this.width)) {
			this.x = (Invaders.getInstance().getWidth() - this.width);
		}
		
		// Movimiento en el eje vertical
		this.y += this.vy; // En cada iteraci�n del bucle principal, el monstruo cambiar� su posici�n en el eje y, sum�ndole a esta el valor de vy
		// si la nave intenta salir por arriba no se lo permitimos
		if (this.y <  0) {
			this.y = 0;
		}
		// si la nave intenta salir por abajo no se lo permitimos
		if (this.y >  (Invaders.getInstance().getHeight() - this.height)) {
			this.y = (Invaders.getInstance().getHeight() - this.height);
		}
	}
	

	/**
	 * Cuando pulsen una tecla activamos la bandera booleana concreta que indica que existe un movimiento
	 */
	@Override
	public void keyPressed(KeyEvent e) {
	  	switch (e.getKeyCode()) {
	  		case KeyEvent.VK_UP : up = true; break;
			case KeyEvent.VK_LEFT : left = true; break;
			case KeyEvent.VK_RIGHT : right = true; break;
			case KeyEvent.VK_DOWN : down = true;break;
	  	}
	  	updateSpeed();
	}

	/**
	 * Cuando una tecla se libera se desactiva la bandera booleana que se hab�a activado al pulsarla
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
  			case KeyEvent.VK_DOWN : down = false;break;
  			case KeyEvent.VK_UP : up = false; break;
  			case KeyEvent.VK_LEFT : left = false; break; 
  			case KeyEvent.VK_RIGHT : right = false;break;
		}
		updateSpeed();
	}
	  
	/**
	 * Este m�todo no se utiliza pero es necesario implementarlo por el KeyListener
	 */
	@Override
	public void keyTyped(KeyEvent e) {}
	
	/**
	 * En funci�n de las banderas booleanas de movimiento, actualizamos las velocidades en los dos ejes
	 */
	protected void updateSpeed() {
		vx=0;vy=0;
		if (down) vy = PLAYER_SPEED;
		if (up) vy = -PLAYER_SPEED;
		if (left) vx = -PLAYER_SPEED;
		if (right) vx = PLAYER_SPEED;
	}
		  
	
	// M�todos Getters y Setters
	public int getVx() { return vx; }
	public void setVx(int vx) { this.vx = vx; }

	public int getVy() { return vy; }
	public void setVy(int vy) { this.vy = vy; }

}
