package tutorialJava.capitulo1;

public class IntroduccionString {

	public static void main (String args[]) {
		
		String cadenaCarac = "Tutorial de Lenguaje de Programación Java 8.";
		 
		System.out.println("Valor de cadenaCarac: " + cadenaCarac);
		System.out.println("Longitud de cadenaCarac: " + cadenaCarac.length());
		System.out.println("Localización por caracteres: " + cadenaCarac.indexOf("Lenguaje"));
		System.out.println("Localización por índices: " + cadenaCarac.charAt(12));
		System.out.println("Uso de subcadenas: " + cadenaCarac.substring(12, 20));
		System.out.println("Uso de toLower: " + cadenaCarac.toLowerCase());
		System.out.println("Uso de toUpper: " + cadenaCarac.toUpperCase());
	}
}
