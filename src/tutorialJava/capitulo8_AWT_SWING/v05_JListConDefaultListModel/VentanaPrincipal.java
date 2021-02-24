package tutorialJava.capitulo8_AWT_SWING.v05_JListConDefaultListModel;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import tutorialJava.capitulo8_AWT_SWING.utils.Apariencia;

public class VentanaPrincipal extends JFrame {

	static {
		Apariencia.setAparienciasOrdenadas(Apariencia.aparienciasOrdenadas);
	}

	/**
	 * 
	 */
	public VentanaPrincipal() {
		super("Ejemplo de uso de JList con DefaultListModel");
		this.setBounds(0, 0, 500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Establezco el panel principal de la aplicación
		this.setLayout(new BorderLayout());
		this.add(new PanelJList(), BorderLayout.CENTER);
	}


	/**
	 * 
	 * @param args
	 */
	public static void main (String args[]) {
		new VentanaPrincipal().setVisible(true);
	}
}
