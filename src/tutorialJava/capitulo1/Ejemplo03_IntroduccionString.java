package tutorialJava.capitulo1;

public class Ejemplo03_IntroduccionString {

	public static void main (String args[]) {
		
		String cadenaCarac = "Tutorial de Lenguaje de Programaci�n Java 8.";
		 
		System.out.println("Valor de cadenaCarac: " + cadenaCarac);
		System.out.println("Longitud de cadenaCarac: " + cadenaCarac.length());
		System.out.println("Localizaci�n por caracteres: " + cadenaCarac.indexOf("Lenguaje"));
		System.out.println("Localizaci�n por �ndices: " + cadenaCarac.charAt(12));
		System.out.println("Uso de subcadenas: " + cadenaCarac.substring(12, 20));
		System.out.println("Uso de toLower: " + cadenaCarac.toLowerCase());
		System.out.println("Uso de toUpper: " + cadenaCarac.toUpperCase());
	}
}
