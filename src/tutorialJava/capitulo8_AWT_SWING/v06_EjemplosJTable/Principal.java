package tutorialJava.capitulo8_AWT_SWING.v06_EjemplosJTable;

import tutorialJava.modelosBasesDeDatosComunesJPA.poblacionPorProvincias.controladores.PersonaControlador;
import tutorialJava.modelosBasesDeDatosComunesJPA.poblacionPorProvincias.controladores.ProvinciaControlador;

public class Principal {

	public static void main(String[] args) {
		// Inicialización de la BBDD, sólo si es necesario
//		ProvinciaControlador.getControlador().inicializaDatosEnTabla();
//		PersonaControlador.getControlador().inicializaDatosEnTabla();
		
		new VentanaPrincipal().setVisible(true);
	}

}
