package tutorialJava.capitulo4_OO.galletas.kk;

public class Galleta {
	// Propiedades de la clase
	public String color;
	public String sabor;
	public boolean tienePepitasChocolate;
	
	public Galleta() {	
	}

	public Galleta (String color, String sabor, boolean tienePepitasChocolate) {
		this.color = color;
		this.sabor = sabor;
		this.tienePepitasChocolate = tienePepitasChocolate;
	}
	
	
	/**
	 * 
	 */
	public void imprimeEnConsola () {
		System.out.println("Galleta: color " + color + " - sabor: " + 
				sabor + " pepitas de chocolate: " + tienePepitasChocolate);
	}
	
	/**
	 * 
	 * @param nuevoSabor
	 */
	public void cambiaSabor (String nuevoSabor) {
		sabor = nuevoSabor;
	}
	
	
	
	public static void main(String[] args) {
		
		
		Galleta galleta01 = new Galleta();
		
		galleta01.color = "Amarillo";
		galleta01.sabor = "Vainilla";
		galleta01.tienePepitasChocolate = false;
		
		galleta01.imprimeEnConsola();
		
		Galleta galleta02 = new Galleta("Marrón", "Chocolate", true);
		
		galleta02.imprimeEnConsola();
		
		galleta01.cambiaSabor("Anís");
		System.out.println("vuelvo a imprimir");
		galleta01.imprimeEnConsola();
		galleta02.imprimeEnConsola();
	}

	
}
