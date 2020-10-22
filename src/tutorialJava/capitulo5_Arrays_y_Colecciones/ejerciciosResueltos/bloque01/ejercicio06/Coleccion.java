package tutorialJava.capitulo5_Arrays_y_Colecciones.ejerciciosResueltos.bloque01.ejercicio06;

import java.util.Arrays;

public class Coleccion {
	
	private Cromo cromos[];
	
	public Coleccion (Cromo cromo) {
		cromos = new Cromo[0];
		agregar (cromo);
	}
	

	public void agregar (Cromo nuevosCromos[]) {
		insertarEnPosicion(nuevosCromos, this.cromos.length);
	}
	

	public void insertarEnPosicion (Cromo nuevosCromos[], int pos) {
		for (int i = nuevosCromos.length-1; i > -1; i--) {
			this.insertarEnPosicion(nuevosCromos[i], pos);
		}
	}
	
	

	public void agregar (Cromo nuevoCromo) {
		this.insertarEnPosicion(nuevoCromo, this.cromos.length);
	}
	
	
	public void insertarEnPosicion (Cromo nuevoCromo, int posicion) {
		if (posicion > this.cromos.length) {
			posicion = this.cromos.length;
		}
		
		Cromo nuevoArrayCromos[] = new Cromo[this.cromos.length+1];
		for (int i = 0; i < nuevoArrayCromos.length; i++) {
			if (i < posicion) {
				nuevoArrayCromos[i] = this.cromos[i];
			}
			else {
				if (i > posicion) {
					nuevoArrayCromos[i] = this.cromos[i-1];
				}
				else {
					nuevoArrayCromos[i] = nuevoCromo;
				}
			}
		}
		
		this.cromos = nuevoArrayCromos;
	}
	
	
	
	
	private void copiaArrayCromos (Cromo origen[], Cromo destino[]) {
		for (int i = 0; i < origen.length; i++) {
			destino[i] = origen[i];
		}
	}



	@Override
	public String toString() {
		String resultado = "Coleccion [cromos= "; 
		for (Cromo cromo : this.cromos) {
			resultado += "\n" + cromo.toString();
		}
		resultado += "]";
		return resultado;
	}
	
	
	
	
	public static void main (String args[]) {
		Coleccion coleccion = new Coleccion (
				new Cromo(1, "Lentejas a la parmesana"));
				
		Cromo nuevosCromos [] = new Cromo[] {
				new Cromo(2, "Macarrones en su jugo"),
				new Cromo(3, "Macarrones con tomate"),
				new Cromo(4, "Macarrones carbonara")
		};
		
		coleccion.insertarEnPosicion(nuevosCromos, 5);
		
				
/*		coleccion.insertarCromoEnPosicion(
				new Cromo(2, "Macarrones en su jugo"), 0);
		coleccion.insertarCromoEnPosicion(
				new Cromo(2, "Ensalada"), 1);
		coleccion.insertarCromoEnPosicion(
				new Cromo(3, "Pizza"), 1);
		coleccion.insertarCromoEnPosicion(
				new Cromo(4, "Filete"), 1);
		coleccion.insertarCromoEnPosicion(
				new Cromo(5, "Solomillo a la pimienta"), coleccion.cromos.length);
				*/
		System.out.println(coleccion.toString());
	}
}
