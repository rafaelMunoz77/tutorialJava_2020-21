package tutorialJava.capitulo4_OO.oca;

public class Principal {

	public static void main(String[] args) {
		Jugador jugadores[] = new Jugador[2];
		
		jugadores[0] = new Jugador("Rafa", "Naranja", 0);		
		jugadores[1] = new Jugador("Arturo", "Negro", 0);
		
		// Empieza el juego
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < jugadores.length; j++) {
				jugadores[j].tirarDado();
				jugadores[j].imprimir();
			}
		}	
	}

}
