package tutorialJava.capitulo4_OO.animales;

public class Raton extends Animal  {

	public Raton(String nombre) {
		super(nombre);
	}

	public Raton(String nombreVar, float alturaCmVar, float longitudCmVar, int edadVar, String colorVar, int tipoVar) {
		super(nombreVar, alturaCmVar, longitudCmVar, edadVar, colorVar, tipoVar);
	}

	public Raton(String nombreVar, float alturaCmVar, float longitudCmVar, int edadVar, String colorVar) {
		super(nombreVar, alturaCmVar, longitudCmVar, edadVar, colorVar, TIPO_RATON);
	}

	
	
	public String sonido () {
		return "chiiiiiiii";
	}

}
