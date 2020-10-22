package tutorialJava.capitulo4_OO.animales;


public class PrincipalAnimales {

	public static void main(String[] args) {		
		
		Animal animales[] = new Animal[2];
		
		animales[0] = new Perro("Toby");
		animales[1] = new Gato("Micifuz");
		
		AnimalQueCome animalesQueComen[] = new AnimalQueCome[2];

		animalesQueComen[0] = new Gato("Toby");
		animalesQueComen[1] = new Gato("Micifuz");
		
		Gato gato = new Gato("Tom");
		
	}

}
