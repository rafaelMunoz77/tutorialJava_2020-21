package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque07_EditorFicheroBasadoEnLista;

import java.util.ArrayList;
import java.util.List;

import tutorialJava.Utils;

public class Ejercicio01_EditorFicheroBasadoEnListas {

	/**
	 * Escribe un programa editor de textos. Debes utilizar la consola de Java. El objetivo es que se pueda editar 
	 * el contenido de un archivo ficticio. Para hacer esto utilizarás una lista de elementos de tipo String. Cada 
	 * línea del texto será representada como un String. Debes mostrar un menú en pantalla, que contenga todas las 
	 * opciones siguientes, y que funcionen adecuadamente:
      a) "Agregar una línea al texto". Pediras al usuario un String y lo agregarás al final de la lista que representa 
      	tu fichero ficticio.
      b) "Insertar una línea en cualquier posición del texto". Pedirás al usuario un String y un número. Insertarás el 
      	String en la línea pedida.
      c) "Editar una línea (reescribir su contenido)". Pedirás al usuario un número de línea para sobrescribir, 
      	mostrarás al usuario la línea actual que desea sobrescribir. Pedirás un nuevo String. Eliminarás el String 
      	actual y cambiarás con el nuevo
      d) "Borrar una línea". Pedirás un número de línea y la eliminarás de la lista.
      e) "Cortar un conjunto de líneas", (marcadas por su posición inicial y final). Pedirás un número de línea inicial 
      	y uno final. "Transportarás todas las líneas del intervalo a una nueva lista y las borrarás de la lista original.
      f) "Pegar un conjunto de líneas cortadas en una determinada posición". Pedirás un número de línea en la que insertar 
      	lo que tienes cortado con la opción anterior.
      g) "Imprimir el fichero". Mostrarás cada línea del fichero ficticio, aparecerá numerada en la consola.
	 * @param args
	 */
	public static void main(String[] args) {
		// Declaro variables necesarias
		int opcion;
		List<String> fichero = new ArrayList<String>();
		
		// Inicializo algo de contenido en la lista. Esto debe eliminarse cuando el programa esté finalizado
		fichero.add("Primera línea"); fichero.add("Segunda línea"); fichero.add("Tercera línea");
		
		// Bucle principal de la aplicación
		do {
			// Llamo a mostrar el menú y pedir una opción al usuario.
			opcion = menu();
		
			// Cada caso en función de la opción elegida por el usuario
			switch (opcion) {
			case 0: // Ha elegido abandonar la aplicación
				System.out.println("Adios!");
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5: 
				break;
			case 6:
				break;
			case 7: // Ha elegido visualizar el fichero
				visualizaLista(fichero);
				break;
			default:
				System.out.println("Opción no válida");
			}
			
			
		} while (opcion != 0);

	}

	/**
	 * Muestra un menú en pantalla y pide una opción al usuario
	 * @return
	 */
	public static int menu () {
		String strMenu = "\n\nMenú"
				+ "\n0.- Salir"
				+ "\n1.- Agregar una línea"
				+ "\n2.- Insertar una línea en una posición"
				+ "\n3.- Editar una línea"
				+ "\n4.- Eliminar una línea"
				+ "\n5.- Cortar un conjunto de líneas"
				+ "\n6.- Pegar un conjunto de líneas"
				+ "\n7.- Visualizar el fichero"
				+ "\n\nIntroduzca su opción: ";
		// Muestro el menú
		System.out.println(strMenu);
		// Pido una opción al usuario
		int opcionUsuario = Utils.obtenerEnteroPorScanner();
		// Devuelvo la opción seleccionada
		return opcionUsuario;
	}
	
	/**
	 * Recorre la lista que simboliza el fichero, exponiendo las líneas en pantalla y cada una con su número de línea
	 * @param lista
	 */
	public static void visualizaLista (List<String> lista) {
		System.out.println("\n\nContenido del fichero");
		for (int i = 0; i < lista.size(); i++) {
			System.out.println("\t" + i + " - " + lista.get(i));
		}
	}
}
