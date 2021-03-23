package tutorialJava.capitulo8_AWT_SWING.gestionVentaDeCoches;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class VentanaPrincipal extends JFrame {

	public VentanaPrincipal() {
		super("Gestión de venta de coches");
		this.setBounds(0, 0, 600, 400);
		
		this.setLayout(new BorderLayout());
		this.add(getPanelPrincipal(), BorderLayout.CENTER);
	}

	/**
	 * 
	 * @return
	 */
	private JTabbedPane getPanelPrincipal() {
		JTabbedPane pane = new JTabbedPane();
		
		pane.add("Fabricantes", new PanelFabricantes());
		pane.add("Coches", new PanelCoches());
		
		return pane;
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setVisible(true);
	}

}
