package tutorialJava.capitulo3_bucles.ejercicios.bloque04;

import javax.swing.JOptionPane;

public class Ejercicio03_JuegoLanzamientosMonedaAlAire {

	public static void main(String[] args) {
		// Declaraci�n de variables
	    int i, opcion, contadorHumano, contadorCom, moneda;
	    
	    // Inializaci�n de contadores y de la opci�n, para asegurarnos que entramos
	    // al menos la primera vez en el bucle
	    contadorHumano = 0;
	    contadorCom = 0;
	    
	    // Se juega al mejor de 3 tiradas, por tanto se jugar� hasta que uno de los jugadores
	    // llegue a la puntuaci�n de 2
	    for ( ; !(contadorHumano == 2 || contadorCom == 2) ; ) {
	        // Limpieza de pantalla y presentaci�n de men�
	    	String strBienvenida = "LANZANDO LA MONEDA" + 
	    			"\n\nHumano: " + contadorHumano +  "  -  Ordenador: " + contadorCom +
	    			"\n\n1.- Usted elige CARA." +   
	    			"\n2.- Usted elige CRUZ." + 
	    			"\n\nIntroduzca su opci�n";    
	        
	        // Lectura de la opci�n del usuario
	        opcion = Integer.parseInt(JOptionPane.showInputDialog(null, strBienvenida));
	        
	        // Comprobaci�n si el usuario ha ganado o perdido
	        if (opcion != 0) {
	            // Para simular el lanzamiento de la moneda, partimos de un rango 0-1, y lo pasamos
	            // a un rango 1-2, para que coincida con las opciones que introduce
	            // el usuario en el men�
	            moneda = ((int) (Math.round(Math.random()))) + 1; // 1 es CARA y 2 es CRUZ
	            // Impresi�n del resultado del lanzamiento.
	            String resultado = "";
	            if (moneda == 1) {
	                resultado += "Ha salido CARA.";    
	            }
	            else {
	                resultado += "Ha salido CRUZ.";    
	            }
	            
	            if (opcion == moneda) { // En este caso el usuario ha ganado
	            	resultado += "\n\nUsted HA GANADO";  
	                contadorHumano++;  
	            }
	            else { // En este otro caso, el usuario pierde
	            	resultado += "\n\nUsted HA PERDIDO";  
	                contadorCom++;
	            }
	            
	            JOptionPane.showMessageDialog(null, resultado);
	            
	        }
	    }
	}

}
