package tutorialJava.capitulo6b_Videojuegos.Arkanoid.version03;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Clase que implementa al MouseAdapter para poder controlar el movimiento del ratón sobre el juego
 * @author R
 *
 */
public class ControladorRaton extends MouseAdapter {

	/**
	 * Override que permite manejar el evento de mover el ratón sobre el Canvas
	 */
	@Override
	public void mouseMoved(MouseEvent event) {
		super.mouseMoved(event);
		// Al recibir un evento se le envía directamente a la nave, para que ella lo maneje
		Arkanoid.getInstancia().getNave().mouseMoved(event);
	}

}
