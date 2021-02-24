package tutorialJava.examenes.examen20210216;

public class EjercicioC {

	public static void main(String[] args) {
		String frase = "  Hola qué tal3 EstÁis45";
		
		frase = frase.trim();
		
		String palabras[] = frase.split(" ");
		
		for (String palabra : palabras) {
			int contMinusculas = 0;
			int contMayusculas = 0;
			int contDigitos = 0;
			
			for (int i = 0; i < palabra.length(); i++) {
				if (Character.isLowerCase(palabra.charAt(i))) contMinusculas++;
				if (Character.isUpperCase(palabra.charAt(i))) contMayusculas++;
				if (Character.isDigit(palabra.charAt(i))) contDigitos++;
			}
			
			System.out.println("Palabra: " + palabra + "\n\tLetras: " + (contMayusculas + contMinusculas) + 
					"\n\tMayúsculas: " + contMayusculas + "\n\tMinúsculas: " + contMinusculas + 
					"\n\tDígitos: " + contDigitos);
		}

	}

}
