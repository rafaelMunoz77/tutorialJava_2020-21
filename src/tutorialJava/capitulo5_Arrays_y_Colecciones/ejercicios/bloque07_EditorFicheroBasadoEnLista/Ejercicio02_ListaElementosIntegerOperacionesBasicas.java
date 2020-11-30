package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque07_EditorFicheroBasadoEnLista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import tutorialJava.Utils;

/**
 * Realiza un programa que trabaje con una Lista de elementos Integer. Debes mostrar un menú en pantalla y ofrecer 
 * al usuario las siguientes opciones a realizar sobre la lista:
 		a) "Abandonar el programa".
 		b) "Crear aleatoriamente la lista de valores". Pedirás al usuario los siguientes datos: longitud de la lista, 
 		valor mínimo y valor máximo. A continuación limpiarás la lista (por si contenía valores), y agregarás tantos 
 		elementos enteros como se haya indicado, con valores que deben oscilar entre el mínimo y el máximo señalado.
		c) "Calcular suma, media, mayor y menor". Mostrarás en pantalla esos cuatro valores.
		d) "Agregar una cantidad de nuevos valores". Pedirás al usuario los siguientes datos: cuántos datos nuevos 
		quiere agregar, posición a partir de la que se deben introducir, valor mínimo y valor máximo. Incluirás tantos 
		valores como indique el usuario, en la posición indicada, con valores entre mínimo y máximo.
		e) "Eliminar elementos cuyo valor esté en un intervalo". Pedirás dos valores al usuario (mínimo y máximo), que 
		conforman un intervalo. Eliminarás los valores de la lista de elementos que se encuentren dentro de ese intervalo 
		(incluyendo los límites) e informarás de cuantos elementos has eliminado de la lista.
		f) "Imprimir la lista". Mostrarás la lista en pantalla.
 */
public class Ejercicio02_ListaElementosIntegerOperacionesBasicas {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Declaro variables necesarias
		int opcion;
		List<Integer> lista = new ArrayList<Integer>(); // Línea de elementos enteros 
				
		// Bucle principal de la aplicación
		do {
			// Llamo a mostrar el menú y pedir una opción al usuario.
			opcion = menu();
		
			// Cada caso en función de la opción elegida por el usuario
			switch (opcion) {
			case 0: // Ha elegido abandonar la aplicación
				System.out.println("Adios!");
				break;
			case 1: // Inicializo la lista de elementos, con una longitud, mínimo y máximo pedidos al usuario
				lista.clear(); // Como voy a inicializar, comienzo eliminando cualquier elemento que existiera
				int longitud = Integer.parseInt(JOptionPane.showInputDialog("Introduzca longitud: "));
				int minimo = Integer.parseInt(JOptionPane.showInputDialog("Introduzca mínimo valor a introducir: "));
				int maximo = Integer.parseInt(JOptionPane.showInputDialog("Introduzca máximo valor a introducir: "));
				// Inicializo la lista
				for (int i = 0; i < longitud; i++) {
					lista.add(Utils.obtenerNumeroAzar(minimo, maximo));
				}
				break;
			case 2: // obtengo la suma, media, menor y mayor de la lista
				sumaMediaMinimoMaximoEnLista(lista);
				break;
			case 3: // Agrego nuevos elementos a la lista
				agregarNuevosElementos (lista);
				break;
			case 4: // Elimina elementos cuyos valores estén entre un mínimo y un máximo
				eliminarValoresEnIntervalo(lista);
				break;
			case 5: // Visualiza la lista
				visualizaLista(lista);
				break;
			default:
				System.out.println("Opción no válida");
			}
			
			// El bucle se repetirá mientras no se pulse la opción de salir.
		} while (opcion != 0);

	}

	/**
	 * Muestra un menú en pantalla y pide una opción al usuario
	 * @return
	 */
	public static int menu () {
		String strMenu = "\n\nMenú"
				+ "\n0.- Salir"
				+ "\n1.- Inicializar lista aleatoriamente"
				+ "\n2.- Suma, media, máximo y mínimo"
				+ "\n3.- Agregar nuevos valores aleatorios en una posición"
				+ "\n4.- Eliminar valores dentro de un intervalo"
				+ "\n5.- Visualizar la lista"
				+ "\n\nIntroduzca su opción: ";
		// Muestro el menú y pido una opción al usuario
		int opcionUsuario = Integer.parseInt(JOptionPane.showInputDialog(strMenu));
		// Devuelvo la opción seleccionada
		return opcionUsuario;
	}
	
	/**
	 * Recorre la lista que simboliza el fichero, exponiendo las líneas en pantalla y cada una con su número de línea
	 * @param lista
	 */
	public static void visualizaLista (List<Integer> lista) {
		// Visualizo sólo si la lista tiene elementos
		if (!lista.isEmpty()) {
			System.out.println("\n\nContenido de la lista");
			for (int i = 0; i < lista.size(); i++) {
				System.out.print(lista.get(i) + " ");
			}
		}
		else {
			System.out.println("Lista Vacía");
		}
		System.out.println();
	}
	
	/**
	 * Obtiene los valores de suma, media, minimo y máximo dentro de los elementos enteros de la lista
	 */
	public static void sumaMediaMinimoMaximoEnLista (List<Integer> lista) {
		int suma = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		float media = 0;
		
		// Si existe al menos un elemento, juego con la lista
		if (!lista.isEmpty()) {
			// El primer valor debe tenerse en cuenta para la suma, es el mínimo y es el máximo
			suma += lista.get(0);
			min = lista.get(0);
			max = lista.get(0);

			// Recorro el resto de elementos de la lista
			for (int i = 1; i < lista.size(); i++) {
				suma += lista.get(0); // Calculo la suma
				// Ajusto, si procede, el nuevo mínimo
				if (lista.get(i).intValue() < min) {
					min = lista.get(i);
				}
				// Ajusto, si procede, el nuevo máximo
				if (lista.get(i).intValue() > max) {
					max = lista.get(i);
				}
			}

			// Al terminar el bucle, tengo localizados los datos y los imprimo
			System.out.println("\nSuma: " + suma + " - Mínimo: " + min + " - Máximo: " + max + " - Media: " + (suma/(float) lista.size()));
		}
		// Si no hay elementos en la lista, informo
		else {
			System.out.println("\nLista vacía");
		}
		
	}
	
	/**
	 * Agrega una serie de elementos nuevos a la lista
	 * @param lista
	 */
	public static void agregarNuevosElementos (List<Integer> lista) {
		List<Integer> listaAux = new ArrayList<Integer>(); // Necesito una nueva lista auxiliar
		int longitud = Integer.parseInt(JOptionPane.showInputDialog("Introduzca nº de elementos a agregar: "));
		int minimo = Integer.parseInt(JOptionPane.showInputDialog("Introduzca mínimo valor a introducir: "));
		int maximo = Integer.parseInt(JOptionPane.showInputDialog("Introduzca máximo valor a introducir: "));
		int posicion = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la posición en la que insertar los valores: "));
		// Inicializo la lista auxiliar
		for (int i = 0; i < longitud; i++) {
			listaAux.add(Utils.obtenerNumeroAzar(minimo, maximo));
		}
		// Agrego los elementos de la lista auxiliar en la lista original
		lista.addAll(posicion, listaAux);
	}
	
	/**
	 * Elimina los valores de la lista que se encuentren entre un valor mínimo y uno máximo.
	 * @param lista
	 */
	public static void eliminarValoresEnIntervalo (List<Integer> lista) {
		int minimo = Integer.parseInt(JOptionPane.showInputDialog("Introduzca mínimo valor a tener en cuenta: "));
		int maximo = Integer.parseInt(JOptionPane.showInputDialog("Introduzca máximo valor a tener en cuenta: "));
		// Recorro la lista buscando los elementos que correspondan con el criterio de que su valor esté entre un mínimo y un máximo
		for (int i = lista.size() - 1; i > 0; i--) {
			if (lista.get(i).intValue() >= minimo && lista.get(i).intValue() <= maximo) {
				lista.remove(i);
			}
		}
	}
}
