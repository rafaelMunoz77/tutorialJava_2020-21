/**
 * Curso Básico de desarrollo de Juegos en Java - Invaders
 * 
 * (c) 2004 Planetalia S.L. - Todos los derechos reservados. Prohibida su reproducción
 * 
 * http://www.planetalia.com
 * 
 */
package tutorialJava.capitulo6b_Videojuegos.SpaceInvaders.version30_EventoDestruccionEnemigo;

import java.util.ArrayList;
import java.util.List;

public class Monster {
	protected int vx;
	protected static final double FIRING_FREQUENCY = 0.01;
	
	private static List<MonstruoEliminadoListener> monstruoEliminadoListeners = 
			new ArrayList<MonstruoEliminadoListener>();
	
	
	
	public static void addMonstruoEliminadoListener (MonstruoEliminadoListener listener) {
		monstruoEliminadoListeners.add(listener);
	}
	
	public static void removeMonstruoEliminadoListener (MonstruoEliminadoListener listener) {
		monstruoEliminadoListeners.remove(listener);
	}
	
	public static void fireMonstruoEliminadoListener (MonstruoEliminadoEvent evento) {
		for (MonstruoEliminadoListener listener : monstruoEliminadoListeners) {
			listener.monstruoEliminado(evento);
		}
	}
	
	
	
	
	public void act() {
	}

}
