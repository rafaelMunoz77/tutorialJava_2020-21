package tutorialJava.capitulo6_Recursos.annotation;

public class ClaseAnotada {

	public void metodoSinAnotacion () {
		System.out.println("M�todo no anotado");
	}
	
	@EjemploAnotacionMetodo (ejemploValorEntero = 3)
	public void metodoConAnotacion () {
		System.out.println("M�todo anotado");
	}
}
