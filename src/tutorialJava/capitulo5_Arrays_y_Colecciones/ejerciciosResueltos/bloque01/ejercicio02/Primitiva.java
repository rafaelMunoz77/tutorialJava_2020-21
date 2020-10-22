package tutorialJava.capitulo5_Arrays_y_Colecciones.ejerciciosResueltos.bloque01.ejercicio02;

import java.util.Arrays;

import tutorialJava.Utils;

public class Primitiva {
	
	private int numeros[];
	private int complementario;
	
	
	public Primitiva() {
		super();		
		inicializaNumeros();
		this.complementario = Utils.obtenerNumeroAzar(1, 49);
	}

	
	public static Primitiva getPrimitiva () {
		return new Primitiva();
	}
	
	
	
	private void inicializaNumeros () {
		numeros = new int[6];
		for (int i = 0; i < numeros.length; i++) {
			int numAzar;
			do {
				numAzar = Utils.obtenerNumeroAzar(1, 5);
			} while (estaNumeroEnArray (numAzar, this.numeros));
			numeros[i] = numAzar;  
		}
	}
	
	
	private boolean estaNumeroEnArray (int numBuscado, int array[]) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == numBuscado) {
				return true;
			}
		}
		return false;
	}
	

	@Override
	public String toString() {
		return "Primitiva [numeros=" + Arrays.toString(numeros) + ", complementario=" + complementario + "]";
	}
	
	
	
	
	
	
}
