package tutorialJava.capitulo4_OO.animales;

public class Perro extends Animal {

	private String raza;
	
	public Perro(String nombre) {
		super(nombre);
	}

	public Perro(String nombreVar, float alturaCmVar, float longitudCmVar, int edadVar, String colorVar, int tipoVar) {
		super(nombreVar, alturaCmVar, longitudCmVar, edadVar, colorVar, tipoVar);
	}

	public Perro(String nombreVar, float alturaCmVar, float longitudCmVar, int edadVar, String colorVar) {
		super(nombreVar, alturaCmVar, longitudCmVar, edadVar, colorVar, TIPO_PERRO);
	}

	
	
	public String sonido () {
		return "Guau guau";
	}
	
	
	
	
	public boolean equals(Object obj) {
		if (obj instanceof Perro) {
			if ( ((Perro) obj).alturaCm == this.alturaCm) {
				return true;
			}
		}
		return false;
	}
	
	
	
	public String toString () {
		return "Mi nombre es " + nombre + ", mi altura es " + alturaCm + ", \nmi longitud es " + longitudCm +
				", mi edad es " + edad + " y mi color es " + color;
	}
	
	
	
	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

}
