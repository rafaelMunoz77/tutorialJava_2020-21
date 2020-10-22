package tutorialJava.capitulo4_OO.instanciarInterfaces;

public class Main {

	public static void main(String[] args) {
		
		// Instanciación de un objeto de una clase abstracta
//		instanciarClaseAbstracta();
		
		// Instanciación de una interfaz, poco a poco
		instanciarInterface01();
		
		// Instanciación de una interfaz, directamente
//		instanciarInterface02();
	}
	
	
	/**
	 * 
	 */
	public static void instanciarClaseAbstracta () {
		Redaccion redaccion = new Redaccion("Texto del artículo") {
			@Override
			public String getFormatoHTML() {
				return "<p>" + texto + "</p>";
			}
		};
		System.out.println(redaccion.getFormatoHTML());
	}

	
	/**
	 * 
	 */
	public static void instanciarInterface01 () {
		TraduccionIngles traduccionIngles = new TraduccionIngles() {

			@Override
			public String textoEnIngles() {
				return "Hello World";
			}
		};
		
		RedaccionMultiIdioma redaccion = new RedaccionMultiIdioma ("Hola Mundo", traduccionIngles);
		System.out.println("Texto original: " + redaccion.texto);
		System.out.println("Texto en inglés: " + redaccion.traduccionIngles.textoEnIngles());
	}

	
	/**
	 * 
	 */
	public static void instanciarInterface02 () {
		RedaccionMultiIdioma redaccion = new RedaccionMultiIdioma ("Hola Mundo", new TraduccionIngles() {
			@Override
			public String textoEnIngles() {
				return "Hello World";
			}
		});
		System.out.println("Texto original: " + redaccion.texto);
		System.out.println("Texto en inglés: " + redaccion.traduccionIngles.textoEnIngles());
	}
}
