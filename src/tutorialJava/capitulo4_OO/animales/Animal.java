package tutorialJava.capitulo4_OO.animales;

public abstract class Animal {

	public static int TIPO_PERRO = 1;
	public static int TIPO_GATO = 2;
	public static int TIPO_RATON = 3;
	
	public String nombre;
	public float alturaCm;
	public float longitudCm;
	public int edad;
	public String color;
	public int tipo;
	public int posicionX = 0;
	
	
	public Animal (String nombre) {
		this.nombre = nombre;
	}

	public Animal (String nombreVar, float alturaCmVar, float longitudCmVar, int edadVar, String colorVar, int tipoVar) {
		nombre = nombreVar;
		alturaCm = alturaCmVar;
		longitudCm = longitudCmVar;
		edad = edadVar;
		color = colorVar;
		tipo = tipoVar;
	}
	
	
	
	public static String getDescripcionAnimal (int tipoAnimal) {
		if (tipoAnimal == TIPO_PERRO) {
			return "Perro";
		}
		else {
			if (tipoAnimal == TIPO_GATO) {
				return "Gato";
			}
			else {
				if (tipoAnimal == TIPO_RATON) {
					return "Ratón";
				}
			}
		}
		return "Animal Desconocido";
	}
	


	
	public abstract String sonido ();
	
	
	public void imprimirCaracteristicas () {
		System.out.println("Mi nombre es " + nombre + ", mi altura es " + alturaCm + ", \nmi longitud es " + longitudCm +
				", mi edad es " + edad + " y mi color es " + color);
	}
	
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	

}
