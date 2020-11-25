package tutorialJava.capitulo4_OO.v01_Clase_Objetos_Constructores;

/**
 * Esta clase representa las propiedades y acciones de un monstruo del videojuego SpaceInvaders
 */
public class Monster {
	// Propiedades de cada monstruo
	int x; // Coordenadas x e y del monstruo
	int y;
	String img; // Imagen del monstruo
	int probabilidadDisparo; // Probabilidad de que ser realice un disparo
	String nombre; // Nombre que recibe el monstruo
	
	/**
	 * Constructor sin argumentos de entrada
	 */
	public Monster() {
		System.out.println("Han construido un monstruo");
	}
	
	// Acciones de cada monstruo
	
	/**
	 * El monstruo dispara con una determinada probabilidad
	 */
	public void dispara() {
		int numAzar = (int) Math.round(Math.random() * 100);
		if (numAzar < probabilidadDisparo) {
			System.out.println(nombre + " Dispara");
		}
	}
}
