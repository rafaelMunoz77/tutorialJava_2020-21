package tutorialJava.capitulo5_Arrays_y_Colecciones.ejerciciosResueltos.bloque01.ejercicio04;

import java.util.Arrays;

public class Jugador {
	
	private Carta mano[];
	private String nombre;
	
	
	public Jugador(String nombre, Carta[] mano) {
		super();
		this.mano = mano;
		this.nombre = nombre;
	}

	
	public int puntuacion() {
		int puntos = 0; 
		
		for (int i = 0; i < mano.length; i++) {
			puntos += BlackJack.getPuntuacionCarta(this.mano[i]);
		}
		
		return puntos;
	}
	

	@Override
	public String toString() {
		return "Jugador [mano=" + Arrays.toString(mano) + 
				", nombre=" + nombre + 
				", puntuacion= " + puntuacion() + "]";
	}


	public Carta[] getMano() {
		return mano;
	}


	public void setMano(Carta[] mano) {
		this.mano = mano;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
