package tutorialJava.capitulo4_OO.animales;

public class Gato extends Animal implements AnimalQueCome, AnimalQueAnda {

	private String raza;
	
	public Gato(String nombre) {
		super(nombre);
	}

	public Gato(String nombreVar, float alturaCmVar, float longitudCmVar, int edadVar, String colorVar, int tipoVar) {
		super(nombreVar, alturaCmVar, longitudCmVar, edadVar, colorVar, tipoVar);
	}

	public Gato(String nombreVar, float alturaCmVar, float longitudCmVar, int edadVar, String colorVar) {
		super(nombreVar, alturaCmVar, longitudCmVar, edadVar, colorVar, TIPO_GATO);
	}

	
	@Override
	public String sonido () {
		return "Miau miau";
	}

	@Override
	public void comer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void andar() {
		// TODO Auto-generated method stub
		
	}
	
	

}
