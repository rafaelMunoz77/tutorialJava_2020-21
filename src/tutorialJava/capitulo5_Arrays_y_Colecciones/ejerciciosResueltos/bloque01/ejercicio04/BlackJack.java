package tutorialJava.capitulo5_Arrays_y_Colecciones.ejerciciosResueltos.bloque01.ejercicio04;

import java.util.Arrays;

public class BlackJack {

	private Jugador jugadores[];
	private Baraja baraja;
	public static int CARTAS_POR_JUGADOR = 2;
	private Jugador Groupier;
	
	
	public BlackJack (Baraja baraja) {
		super();
		this.baraja = baraja;
		
		Groupier = new Jugador ("Groupier", baraja.repartir(CARTAS_POR_JUGADOR));
				
		int array[] = new int[] {1, 2};
		
		jugadores = new Jugador[] {
				new Jugador ("Pepe", baraja.repartir(CARTAS_POR_JUGADOR)),
				new Jugador ("Pepa", baraja.repartir(CARTAS_POR_JUGADOR)), 
				Groupier};
	}
	
	
	
	
	public Jugador determinaGanador () {
		for (Jugador jugador : this.jugadores) {
			System.out.println(jugador + "\n");
		}
		// Si los dos jugadores se pasan, gana la banca
		if (estanJugadoresPasadosDePuntuacion()) {
			return this.Groupier;
		}
		// Recorro el array buscando la mayor puntuación
		Jugador ganador = this.jugadores[0];
		for (Jugador jugador : this.jugadores) {
			if (jugador.puntuacion() > ganador.puntuacion()) {
				ganador = jugador;
			}
		}
		
		return ganador;
	}

	
	
	private boolean estanJugadoresPasadosDePuntuacion () {
		for (Jugador jugador : this.jugadores) {
			if (jugador.puntuacion() <= 21) {
				return false;
			}
		}
		return true;
	}
	
	
	
	
	public static int getPuntuacionCarta (Carta carta) {
		if (carta.getValor() < 11) {
			return carta.getValor();
		}
		else {
			if (carta.getValor() < 14) {
				return 10;
			}
			else {
				return 11;
			}
		}
	}
	
	
	
	
	@Override
	public String toString() {
		return "BlackJack [jugadores=" + Arrays.toString(jugadores) + "\n" 
				+ "Baraja: \n" + this.baraja.toString() + "]";
	}










	public static void main (String args[]) {
		Baraja baraja = new Baraja();
		BlackJack juego = new BlackJack(baraja);
		
		System.out.println("Ganador/a: " + juego.determinaGanador());  
	}

}
