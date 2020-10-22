package tutorialJava.capitulo5_Arrays_y_Colecciones.ejerciciosResueltos.bloque01.ejercicio04;

public class Carta {
	
	private static int PICAS = 0; 
	private static int DIAMANTES = 1; 
	private static int TREBOLES = 2; 
	private static int CORAZONES = 3; 
	
	
	private int valor;
	private int palo;
	
	public Carta(int valorCarta, int paloCarta) {
		super();
		this.valor = valorCarta;
		this.palo = paloCarta;
	}

	
	
	
	
	@Override
	public String toString() {
		return "Carta [" + this.traducirCarta() + "]";
	}

	
	private String traducirCarta () {
		String cadena = "";
		
		if (this.valor == 11) {
			cadena += "J";
		}
		else {
			if (this.valor == 12) {
				cadena += "Q";
			}
			else {
				if (this.valor == 13) {
					cadena += "K";
				}
				else {
					if (this.valor == 14) {
						cadena += "A";
					}
					else {
						cadena += valor; 
					}
				}
			}
			
		}

		cadena += " de ";

		if (this.palo == PICAS) {
			cadena += "Picas";
		}
		else {
			if (this.palo == DIAMANTES) {
				cadena += "Diamantes";
			}
			else {
				if (this.palo == TREBOLES) {
					cadena += "Tréboles";
				}
				else {
					cadena += "Corazones"; 
				}
			}
			
		}
		
		
		return cadena;
	}





	public int getValor() {
		return valor;
	}





	public void setValor(int valor) {
		this.valor = valor;
	}





	public int getPalo() {
		return palo;
	}





	public void setPalo(int palo) {
		this.palo = palo;
	}



}
