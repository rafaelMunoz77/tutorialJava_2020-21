package tutorialJava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Utils {

	
	public static int obtenerNumeroAzar () {
		 return (int) Math.round(Math.random() * 100);
	}
	
	
	
	public static int obtenerEntero () {
		int numero = 0;
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader (isr);
			numero = Integer.parseInt (br.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return numero;
	}

	
	
	public static int obtenerEnteroMet2() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	
	public static int obtenerEnteroMet3() {
		String str = JOptionPane.showInputDialog("Introduce un número");
		return Integer.parseInt(str);
	}
}
