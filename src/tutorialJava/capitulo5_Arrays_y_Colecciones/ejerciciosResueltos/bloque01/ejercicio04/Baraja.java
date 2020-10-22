package tutorialJava.capitulo5_Arrays_y_Colecciones.ejerciciosResueltos.bloque01.ejercicio04;

import java.util.Arrays;

import tutorialJava.Utils;

public class Baraja {
	
	private Carta cartas[];

	public Baraja() {
		super();
		inicializaBaraja ();
		mezclar();
	}
	
	
	
	private void inicializaBaraja() {
		cartas = new Carta[52];
		
		int indiceArray = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 2; j <= 14; j++) {
				Carta carta = new Carta(j, i);
				cartas[indiceArray] = carta;
				indiceArray++;
			}
		}
	}



	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("Baraja [cartas=\n");
		
		for (Carta cartita : cartas) {
			if (cartita == null) {
				sb.append("null\n");
			}
			else {
				sb.append(cartita.toString() + "\n");
			}
		}
		
		return sb.toString();
	}
	
	
	
	
	private void mezclar () {
		
		for (int i = 0; i < 100; i++) {
			int indiceAzar1 = Utils.obtenerNumeroAzar(0, cartas.length-1);
			int indiceAzar2 = Utils.obtenerNumeroAzar(0, cartas.length-1);
			
			Carta aux = cartas[indiceAzar1];
			cartas[indiceAzar1] = cartas[indiceAzar2];
			cartas[indiceAzar2] = aux;
		}
	}
	
	
	
	public void devuelvaCarta (Carta cartaADevolver) {
		for (int i = 0; i < this.cartas.length; i++) {
			if (this.cartas[i] == null) {
				this.cartas[i] = cartaADevolver;
			}
		}
	}
	
	
	
	
	public Carta[] repartir (int numCartas) {
		Carta mano[] = new Carta[numCartas];
		
		for (int contMano = 0; contMano < numCartas; contMano++) {
			mano[contMano] = this.tomarCartaTop();
		}
				
		return mano;
	}
	
	
	
	
	private Carta tomarCartaTop () {
		Carta cartaATomar = this.cartas[0];
		
		for (int i = 1; i < this.cartas.length; i++) {
			this.cartas[i-1] = this.cartas[i];
		}
		this.cartas[this.cartas.length-1] = null;
		
		return cartaATomar;
	}
	
	
}
