package tutorialJava.capitulo4_OO.oca;

import tutorialJava.Utils;

public class Jugador {
	String nombre = "Ninguno";
	String color = "Ninguno";
	int casillaActual = 0;
	
	
	public Jugador () {
	}
	
	public Jugador (String nuevoNombre, String nuevoColor, int nuevaCasilla) {
		nombre = nuevoNombre;
		color = nuevoColor;
		casillaActual = nuevaCasilla;
	}
	
	
	public void tirarDado () {
		casillaActual += Utils.obtenerNumeroAzar(1, 6);
	}
	
	public void tirarDado (int minimoDado, int maximoDado) {
		casillaActual += Utils.obtenerNumeroAzar(minimoDado, maximoDado);
	}
	
	public void imprimir() {
		System.out.println("Jugador: " + nombre + " - color: " +
				color + " - casilla: " + casillaActual);
	}
}
