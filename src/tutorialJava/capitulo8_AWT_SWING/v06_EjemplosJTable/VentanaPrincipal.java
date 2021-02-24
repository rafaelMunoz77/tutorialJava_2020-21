package tutorialJava.capitulo8_AWT_SWING.v06_EjemplosJTable;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import tutorialJava.capitulo8_AWT_SWING.utils.Apariencia;
import tutorialJava.capitulo8_AWT_SWING.v03_JComponentsAvanzados.splitPaneYJSlider.SplitPanel;
import tutorialJava.capitulo8_AWT_SWING.v06_EjemplosJTable.v04_TablaConAbstractTableModelYCellRenderer.TablaEnScrollPane;

public class VentanaPrincipal extends JFrame {

	static {
		Apariencia.setAparienciasOrdenadas(Apariencia.aparienciasOrdenadas);
	}

	/**
	 * 
	 */
	public VentanaPrincipal() {
		super("Ejemplos de JTable");
		this.setBounds(0, 0, 900, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Establezco el panel principal de la aplicación y la barra de herramientas
		this.setLayout(new BorderLayout());
		this.add(getTabbedPane(), BorderLayout.CENTER);
	}

	/**
	 * 
	 * @return
	 */
	private JTabbedPane getTabbedPane() {
		JTabbedPane tabbedPane = new JTabbedPane();

		tabbedPane.add("JTable simple", new v01_TablaSimple());
		tabbedPane.add("JTable con DefaultTableModel", new v02_TablaConDefaultTableModel());
		tabbedPane.add("JTable con AbstractTableModel", new v03_TablaConAbstractTableModel());
		tabbedPane.add("JTable con AbstractTableModel y CellRenderer", new TablaEnScrollPane());

		return tabbedPane;
	}

}
