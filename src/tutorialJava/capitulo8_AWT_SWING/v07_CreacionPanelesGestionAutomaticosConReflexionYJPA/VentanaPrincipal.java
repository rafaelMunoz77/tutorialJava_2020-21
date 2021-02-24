package tutorialJava.capitulo8_AWT_SWING.v07_CreacionPanelesGestionAutomaticosConReflexionYJPA;

import javax.swing.JFrame;

import tutorialJava.capitulo8_AWT_SWING.utils.Apariencia;

/**
 * 
 * @author R
 *
 */
public class VentanaPrincipal extends JFrame {

	static {
		Apariencia.setAparienciasOrdenadas(Apariencia.aparienciasOrdenadas);
	}

	/**
	 * 
	 */
	public VentanaPrincipal() {
		super("Centro educativo");
		this.setBounds(0, 0, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Menú de la aplicación
		this.setJMenuBar(new Menu());
	}

	
	/**
	 * 
	 * @param args
	 */
	public static void main (String args[]) {
		new VentanaPrincipal().setVisible(true);
	}
}
