package tutorialJava.capitulo6b_Videojuegos.Arkanoid.version02;

import java.awt.Color;

public class Fase01 extends Fase {
	// Propiedades estáticas de la fase
	public static final int ESPACIO_SUPERIOR_SOBRE_LADRILLOS = 60;

	
	@Override
	public void inicializaFase() {

	    // Inicializamos los ladrillos
	    int numLadrillosPosibles = Arkanoid.getInstancia().getWidth() / (Ladrillo.ANCHO + Ladrillo.ESPACIO_ENTRE_LADRILLOS);
	    int margenIzquierdo = (Arkanoid.getInstancia().getWidth() % (Ladrillo.ANCHO + Ladrillo.ESPACIO_ENTRE_LADRILLOS)) / 2;
	    
	    System.out.println("ancho" + Arkanoid.getInstancia().getWidth());
	    // Array con los diferentes colores, uno por cada fila
	    Color colores[] = new Color[] {Color.RED, Color.YELLOW, Color.PINK, Color.CYAN, Color.GREEN, Color.ORANGE};
	    
	    // Creamos las filas
	    for (int i = 0; i < colores.length; i++) {
	    	for (int j = 0; j < numLadrillosPosibles; j++) {
		    	this.actores.add(new Ladrillo(margenIzquierdo + j * (Ladrillo.ANCHO + Ladrillo.ESPACIO_ENTRE_LADRILLOS), 
		    			ESPACIO_SUPERIOR_SOBRE_LADRILLOS + i * (Ladrillo.ALTO + Ladrillo.ESPACIO_ENTRE_LADRILLOS), colores[i]));
		    }
	    }
	}

}
