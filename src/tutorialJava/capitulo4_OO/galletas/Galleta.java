package tutorialJava.capitulo4_OO.galletas;



public class Galleta {

	public int identificador;
	public boolean chocolate;
	public boolean coco;
	public boolean vainilla;
	public static int numero;
	public static String forma = "Cuadrada";
	

	public Galleta () {
	}
	

	public Galleta (int identificador) {
		this.identificador = identificador;
	}
	
	public Galleta (int identificador, boolean chocolate) {
		this.identificador = identificador;
		this.chocolate = chocolate;
	}
	

	public void imprimeEnPantalla () { 
		System.out.println("Galleta-> id: " + 
				this.identificador + " chocolate: " + 
				this.chocolate + " coco: " + this.coco + 
				" vainilla: " + this.vainilla + 
				" forma: " + this.forma);
	}
	
	
	/**
	 * 
	 * @param numero1
	 * @param numero2
	 */
	private void sumaEImprimeEnPantalla (int numero1, int numero2) {
		System.out.println("la suma vale: " + (numero1 + numero2));
	}



	public int suma (int numero1, int numero2) {
		return numero1 + numero2;
	}
	
	
	
	
	
	
	
	public static int factorial (int numero) {
//		if (numero > 1) {
			return numero * factorial(numero-1);
//		}
//		return 1;
	}
	
	
	
	
	
	
	
	
	public static Galleta creaGalleta (int id) {
		Galleta galleta = new Galleta();
		galleta.identificador = id;
		return galleta;
	}
	
	
	public static Galleta creaGalleta (int id, boolean choco) {
		Galleta galleta = new Galleta();
		galleta.identificador = id;
		galleta.chocolate = choco;
		return galleta;
	}
	
	
	

}
