package tutorialJava.examenes.examen20201203;

import javax.swing.JOptionPane;

/**
 * Esta clase corresponde a la resolución del examen de programación dispuesto con fecha 03/12/2020. Se trata
 * de realizar un programa que permita jugar al "Tres en raya". En este caso utilizamos una matriz para montar el tablero
 */
public class TresEnRayaConMatrices {

	/**
	 * Método principal del juego
	 * @param args
	 */
	public static void main(String[] args) {
		// Primero inicializo la matriz que conforma el tablero
		int tablero[][] = new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
		int opcionUsuario; // Opción elegida por el usuario
		int ganadorDelTablero; // Determina si existe un ganador del tablero
		
		System.out.println("Bienvenido al Tres en raya");
		muestraTablero(tablero);
		
		// Bucle principal del juego, se repite hasta que el jugador decida salir o se acabe el juego
		do {
			opcionUsuario = menu(); // Muestro menú y recibo opción del usuario
			
			// En función de la opción del usuario, realizo una acción u otra.
			switch (opcionUsuario) {
			case 0: // Salir
				System.out.println("Adios!!!");
				break;
			case 1: // Juega el primer jugador
				juegaUnJugador(1, tablero);
				break;
			case 2: // Juega el segundo jugador
				juegaUnJugador(2, tablero);
				break;
			}
			// Repito todo si el usuario no ha elegido salir, y no hay ganador y quedan casillas vacías
			ganadorDelTablero = getGanadorDelTablero(tablero);
		} while (opcionUsuario != 0 && ganadorDelTablero == 0);
		
		// Muestro el ganador
		if (ganadorDelTablero == -1) { // Hay empate y no quedan casillas vacías
			System.out.println("Fin del juego, no quedan casillas vacías");
		}
		else { // Existe un ganador, puede ser el jugador 1 o el 2.
			System.out.println("Ganador del juego: " + ganadorDelTablero);
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
	private static void juegaUnJugador (int jugador, int tablero[][]) {
		int filaElegida, colElegida; // Las coordenadas que elegirá el jugador
		boolean casillaOcupada; // Bandera para determinar si una casilla está ocupada o no
		
		// Bucle que se repite tantas veces como sea necesario para que el jugador introduzca las coordenadas de una casilla vacía
		do {
			// El jugador elige sus coordenadas de juego
			filaElegida = getValorEnteroDeJOptionPane("Jugador " + jugador + ". Introduzca su fila: ");
			colElegida = getValorEnteroDeJOptionPane("Jugador " + jugador + ". Introduzca su columna: ");
			
			casillaOcupada = false; // Supongo que la casilla está libre, e intento demostrar lo contrario
			if (tablero[filaElegida][colElegida] != 0) {
				// La casilla está ocupada por algún valor
				casillaOcupada = true;
				JOptionPane.showMessageDialog(null, "No puede elegir esa casilla, está ocupada. Elija otra a continuación");
			}
			else {
				// La casilla está libre, se establece el valor del "jugador". Si el jugador vale "1", se introducirá un valor "1".
				tablero[filaElegida][colElegida] = jugador;
			}
		} while (casillaOcupada == true); // Repetimos el bucle si la casilla está ocupada
		
		// Mostramos el tablero, después de que el usuario haya introducido su jugada.
		muestraTablero(tablero);
	}
	
	/**
	 * Muestra el tablero completo, en la consola
	 * @param filaSup
	 * @param filaMed
	 * @param filaInf
	 */
	private static void muestraTablero (int tablero[][]) {
		System.out.println("\nTablero de juego");
		muestraUnaFila(tablero[0]);
		muestraUnaFila(tablero[1]);
		muestraUnaFila(tablero[2]);
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

	/**
	 * Determina si existe un ganador en el juego.
	 * @param tablero
	 * @return Devuelve: 1 si ha ganado el jugador 1; 2 si ha ganado el jugador 2; 0 si no hay ganador y quedan casillas libres; -1 si no hay ganador y no quedan casillas libres
	 */
	private static int getGanadorDelTablero (int tablero[][]) {
		// Busco si existe un ganador mirando las filas
		for (int i = 0; i < tablero.length; i++) {
			if (tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2]) { 
				return tablero[i][0]; // Si todos los valores de una fila son iguales, devuelvo cualquiera de los elementos de esa fila
			}
		}
		// Busco si existe un ganador en las columnas
		for (int i = 0; i < tablero[0].length; i++) {
			if (tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i]) { 
				return tablero[0][i]; // Si todos los valores de una columna son iguales, devuelvo cualquiera de los elementos de esa columna
			}
		}
		// Busco un ganador en la diagonal principal
		if (tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]) { 
			return tablero[0][0]; // Devuelvo cualquier elemento de la diagonal principal
		}
		// Busco un ganador en la diagonal secundaria
		if (tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]) {
			return tablero[0][2]; // Devuelvo cualquier elemento de la diagonal secundaria
		}
		
		// Si llegó hasta aquí no hay ganador, pero aún quedan dos posibilidades: puede que queden casillas vacías o puede que no
		// Voy a suponer que no hay casillas vacías y voy a recorrer el tablero buscando alguna casilla vacía
		boolean hayCasillasVacias = false;
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				if (tablero[i][j] == 0) {
					hayCasillasVacias = true;
				}
			}
		}

		// Devuelvo valores diferentes dependiendo de si existen casillas vacías o no
		if (hayCasillasVacias == true) {
			return 0; // Indica que el juego continúa.
		}
		else {
			return -1; // Indica que no quedan casillas vacías, hay empate
		}
	}
}
