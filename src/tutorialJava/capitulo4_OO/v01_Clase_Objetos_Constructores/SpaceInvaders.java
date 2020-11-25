package tutorialJava.capitulo4_OO.v01_Clase_Objetos_Constructores;

/**
 * Clase principal, que crea los monstruos
 *
 */
public class SpaceInvaders {

	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		// Voy a crear un monstruo
		Monster m1 = new Monster();
		
		// Asigno propiedades al monstruo creado
		m1.x = 50;
		m1.y = 62;
		m1.img = "monsterImg01.png";
		m1.probabilidadDisparo = 75;
		m1.nombre = "m1";
		
		// Creo un nuevo monstruo
		Monster m2 = new Monster();
		
		// Asigno propiedades al nuevo monstruo
		m2.x = 100;
		m2.y = 120;
		m2.img = "monsterImg02.png";
		m2.probabilidadDisparo = 10;
		m2.nombre = "m2";
		
		// Muestro los monstruos
		System.out.println("m1: x " + m1.x + " y " + m1.y + " img " + m1.img);
		System.out.println("m2: x " + m2.x + " y " + m2.y + " img " + m2.img);

		// Bucle infinito que hace que los monstruos disparen eternamente
		while (true) {
			m1.dispara();
			m2.dispara();
		}
	}

}
