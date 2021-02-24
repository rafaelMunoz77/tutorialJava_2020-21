package tutorialJava.capitulo6_Recursos.ejercicios.excepciones.numeroImpar;

import java.util.Scanner;

public class IntroduceNumeroPar {

	
	/**
	 * 
	 * @return
	 * @throws NumeroImparException
	 */
	public static int introduceNumeroPar () throws NumeroImparException {
		System.out.println("\nIntroduce número par: ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if (num % 2 == 0) { // Si es par lanzo una excepción
			throw new NumeroImparException("El número " + num + " es par y no lo permito");
			
		}
		return num;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			introduceNumeroPar();
		} catch (NumeroImparException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
