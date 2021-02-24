package tutorialJava.examenes.examen20210216;

public class Ejercicio_A_Numero_PI {


	public static void main(String[] args) {
		float numeroPICalculado = 3;
		int signo = 1;
		int term1 = 2, term2 = 3, term3= 4;
		
		do {
			numeroPICalculado += signo * 4.0/(term1 * term2 * term3);
			term1 += 2; term2 += 2; term3 += 2;
			signo *= -1;
			System.out.println("Número PI: " + numeroPICalculado);
		} while (Math.abs(Math.PI - numeroPICalculado) > 0.0001);

		
	}

}
