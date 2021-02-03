package tutorialJava.capitulo6b_Videojuegos.Arkanoid.version03;

import java.util.ArrayList;
import java.util.List;

/**
 * Todas las fases deberán extender esta clase abstracta y personalizar la apariencia y el comportamiento
 * @author R
 *
 */
public abstract class Fase {
	
	// Lista de actores a colocar en cualquier fase
	protected List<Actor> actores = new ArrayList<Actor>();
	
	// Método que debe implementar cada Fase
	public abstract void inicializaFase ();

	// Getter de la lista de actores
	public List<Actor> getActores() { return actores; }
}
