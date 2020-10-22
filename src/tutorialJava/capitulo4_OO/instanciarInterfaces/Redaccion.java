package tutorialJava.capitulo4_OO.instanciarInterfaces;

public abstract class Redaccion {
	
	public String texto;
	
	public Redaccion (String texto) {
		this.texto = texto;
	}
	
	public abstract String getFormatoHTML ();
	
	
}
