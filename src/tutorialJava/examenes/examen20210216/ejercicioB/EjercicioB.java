package tutorialJava.examenes.examen20210216.ejercicioB;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class EjercicioB {

	private static HashMap<Integer, CromoBaloncesto> cromos = new HashMap<Integer, CromoBaloncesto>();

	/*
	 * 
	 */
	public static void main(String[] args) {

		datosIniciales();

		int opcionMenu = 0;
		do {
			opcionMenu = menu();
			
			switch (opcionMenu) {
			case 0:
				System.exit(0);
			case 1:
				mostrarTodos();
				break;
			case 4:
				mayor();
				break;
			}	
			
		} while (opcionMenu != 0);
		
	}

	
	/**
	 * 
	 * @return
	 */
	private static int menu () {
		String str = "\n\n0 - Abandonar.\n1.- Mostrar todos\n2.- Agregar\n3.- Eliminar\n4.- Máximo puntos\n\n\tIntroduzca opción: ";
		System.out.println(str);
		Scanner sc = new Scanner (System.in);
		int opcion = sc.nextInt();
		return opcion;
	}
	
	/**
	 * 
	 */
	private static void mostrarTodos() {
		Iterator<CromoBaloncesto> itCromos = cromos.values().iterator();
		System.out.println("\nTodos los elementos");
		while (itCromos.hasNext()) {
			System.out.println(itCromos.next().toString());
		}
	}
	
	/**
	 * 
	 */
	private static void mayor() {
		CromoBaloncesto mayor = null;
		Iterator<CromoBaloncesto> itCromos = cromos.values().iterator();
		System.out.println("\nTodos los elementos");
		
		if (itCromos.hasNext()) {
			mayor = itCromos.next();
		}
		
		while (itCromos.hasNext()) {
			CromoBaloncesto siguiente = itCromos.next();
			if (siguiente.getPuntos() > mayor.getPuntos()) {
				mayor = siguiente;
			}
		}
		
		System.out.println("Mayor de todos por puntos: " + mayor.toString());
	}
	/**
	 * 
	 */
	private static void datosIniciales () {
		CromoBaloncesto cromo = new CromoBaloncesto(Integer.valueOf(1), "Ana Cruz", 500, 60);
		cromos.put(cromo.getId(), cromo);
		cromo = new CromoBaloncesto(Integer.valueOf(2), "Pau Gasol", 400, 90);
		cromos.put(cromo.getId(), cromo);
		cromo = new CromoBaloncesto(Integer.valueOf(3), "Marc Gasol", 550, 80);
		cromos.put(cromo.getId(), cromo);
	}
}
