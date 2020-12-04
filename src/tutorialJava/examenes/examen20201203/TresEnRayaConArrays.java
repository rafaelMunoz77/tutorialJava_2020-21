package tutorialJava.examenes.examen20201203;

import javax.swing.JOptionPane;

/**
 * Esta clase corresponde a la resolución del examen de programación dispuesto con fecha 03/12/2020. Se trata
 * de realizar un programa que permita jugar al "Tres en raya". En este caso utilizamos tres arrays para montar el tablero
 */
public class TresEnRayaConArrays {

	/**
	 * Método principal del juego
	 * @param args
	 */
	public static void main(String[] args) {
		// Primero inicializo los tres arrays que conforman el tablero
		int filaSup[] = creaFilaDeTablero();
		int filaMed[] = creaFilaDeTablero();
		int filaInf[] = creaFilaDeTablero();
		int opcionUsuario;
		
		System.out.println("Bienvenido al Tres en raya");
		muestraTablero(filaSup, filaMed, filaInf);
		
		do {
			opcionUsuario = menu();
			
			switch (opcionUsuario) {
			case 0:
				System.out.println("Adios!!!");
				break;
			case 1:
				juegaUnJugador(1, filaSup, filaMed, filaInf);
				break;
			case 2:
				juegaUnJugador(2, filaSup, filaMed, filaInf);
				break;
			}
			
		} while (opcionUsuario != 0);

	}

	/**
	 * Crea un array con tres posiciones y lo devuelve, con valores iguales a 0 en su interior
	 * @return
	 */
	private static int[] creaFilaDeTablero () {
		int fila[] = new int[] {0, 0, 0};
		return fila;
	}
	
	/**
	 * Obtiene el valor que existe en una casilla del tablero
	 * @param fila
	 * @param col
	 * @param filaSup
	 * @param filaMed
	 * @param filaInf
	 * @return
	 */
	private static int getValorDeCasillaDeTablero (int fila, int col, int[] filaSup, int[] filaMed, int[] filaInf) {
		// Compruebo si me están pidiendo la fila superior, media o inferior
		if (fila == 0) {
			return filaSup[col];
		}
		else {
			if (fila == 1) {
				return filaMed[col];
			}
			else {
				return filaInf[col];
			}
		}
	}
	
	/**
	 * Establece un valor en una casilla del tablero
	 * @param fila
	 * @param col
	 * @param valorDeElemento
	 * @param filaSup
	 * @param filaMed
	 * @param filaInf
	 */
	private static void setValorDeCasillaDeTablero (int fila, int col, int valorDeElemento, int[] filaSup, int[] filaMed, int[] filaInf) {
		// Determino a qué fila se le está intentando establecer un valor.
		if (fila == 0) {
			filaSup[col] = valorDeElemento;
		}
		else {
			if (fila == 1) {
				filaMed[col] = valorDeElemento;
			}
			else {
				filaInf[col] = valorDeElemento;
			}
		}
	}
	
	/**
	 * Muestro un JOptionPane, con un mensaje y obtengo el valor entero que escribe el usuario
	 * @param mensaje
	 * @return
	 */
	private static int getValorEnteroDeJOptionPane (String mensaje) {
		int valor = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
		return valor;
	}
	
	/**
	 * Muestra un menú en pantalla y pide una opción al usuario
	 * @return
	 */
	private static int menu () {
		String strMenu = "\n\nMenú"
				+ "\n0.- Abandonar el programa"
				+ "\n1.- Jugador 1 introduce su jugada"
				+ "\n2.- Jugador 2 introduce su jugada"
				+ "\n\nIntroduzca su opción: ";
		// Muestro el menú y pido una opción al usuario
		int opcionUsuario = getValorEnteroDeJOptionPane(strMenu);
		// Devuelvo la opción seleccionada
		return opcionUsuario;
	}

	/**
	 * Determina el juego que lleva a cabo un jugador
	 * @param jugador Su valor será "1" ó "2", indicando que está jugando un jugador determinado
	 * @param filaSup
	 * @param filaMed
	 * @param filaInf
	 */
	private static void juegaUnJugador (int jugador, int filaSup[], int filaMed[], int filaInf[]) {
		int filaElegida, colElegida; // Las coordenadas que elegirá el jugador
		boolean casillaOcupada; // Es una bandera para saber si una casilla elegida por el jugador está ocupada
		
		// Bucle que se repite tantas veces como sea necesario para que el jugador introduzca las coordenadas de una casilla vacía
		do {
			// El jugador elige sus coordenadas de juego
			filaElegida = getValorEnteroDeJOptionPane("Jugador " + jugador + ". Introduzca su fila: ");
			colElegida = getValorEnteroDeJOptionPane("Jugador " + jugador + ". Introduzca su columna: ");
			
			casillaOcupada = false; // Supongo que la casilla NO está ocupada e intento demostrar lo contrario
			if (getValorDeCasillaDeTablero(filaElegida, colElegida, filaSup, filaMed, filaInf) != 0) {
				// La casilla está ocupada por algún valor
				casillaOcupada = true;
				JOptionPane.showMessageDialog(null, "No puede elegir esa casilla, está ocupada. Elija otra a continuación");
			}
			else {
				// La casilla está libre, se establece el valor del "jugador". Si el jugador vale "1", se introducirá un valor "1".
				setValorDeCasillaDeTablero(filaElegida, colElegida, jugador, filaSup, filaMed, filaInf);
			}
		} while (casillaOcupada); // Repetimos el bucle si la casilla está ocupada
		
		// Mostramos el tablero, después de que el usuario haya introducido su jugada.
		muestraTablero(filaSup, filaMed, filaInf);
	}
	
	/**
	 * Muestra el tablero completo, en la consola
	 * @param filaSup
	 * @param filaMed
	 * @param filaInf
	 */
	private static void muestraTablero (int filaSup[], int filaMed[], int filaInf[]) {
		System.out.println("\nTablero de juego");
		muestraUnaFila(filaSup);
		muestraUnaFila(filaMed);
		muestraUnaFila(filaInf);
	}

	/**
	 * Muestra una única fila del tablero.
	 * @param fila
	 */
	private static void muestraUnaFila (int fila[]) {
		for (int i = 0; i < fila.length; i++) {
			System.out.print(fila[i] + " ");
		}
		System.out.println();
	}
}
