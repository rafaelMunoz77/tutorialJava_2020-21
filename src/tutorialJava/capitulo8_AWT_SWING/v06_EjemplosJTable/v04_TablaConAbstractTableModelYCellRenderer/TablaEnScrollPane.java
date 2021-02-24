package tutorialJava.capitulo8_AWT_SWING.v06_EjemplosJTable.v04_TablaConAbstractTableModelYCellRenderer;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import tutorialJava.modelosBasesDeDatosComunesJPA.poblacionPorProvincias.Provincia;

public class TablaEnScrollPane extends JPanel {

	MiTableModel tableModel = null;
	
	public TablaEnScrollPane () {
		// Construyo el tableModel y la tabla
		tableModel = new MiTableModel();
		JTable jTable = new JTable(tableModel);
		// Configuro la tabla para que utilice un renderizador particular en diferentes tipos de objetos
		jTable.setDefaultRenderer(Object.class, new MiDefaultTableCellRenderer());
		jTable.setDefaultRenderer(Integer.class, new MiDefaultTableCellRenderer());
		jTable.setDefaultRenderer(Boolean.class, new MiBooleanTableCellRenderer());
		jTable.setDefaultRenderer(Date.class, new MiDateTableCellRenderer());
		jTable.setDefaultEditor(Date.class, new MiDateTableCellEditor(new SimpleDateFormat("dd/MM/yyyy")));
		jTable.setDefaultEditor(Provincia.class, new MiProvinciaTableCellEditor());
		
		MiTableHeaderCellRenderer tableHeaderCellRenderer = new MiTableHeaderCellRenderer();
		for (int i = 0; i < jTable.getColumnCount(); i++) {
			jTable.getColumnModel().getColumn(i).setHeaderRenderer(tableHeaderCellRenderer);
		}
			
		// Detección del clic sobre una fila
		jTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int idSeleccionado = ((Integer) tableModel.getValueAt(jTable.getSelectedRow(), 0)).intValue();
				System.out.println("Clic en la fila con identificador: " + idSeleccionado);
			}
		});
		
		//Creamos un JscrollPane y le agregamos la JTable
		JScrollPane scrollPane = new JScrollPane(jTable);
		//Agregamos el JScrollPane al contenedor
		this.setLayout(new BorderLayout());
//		this.add(getBarraHerramientas(), BorderLayout.NORTH);
		this.add(scrollPane, BorderLayout.CENTER);
		this.add(new JTextArea("JTable construida con AbstractTableModel y CellRenderer personalizado.\n"
				+ "Gracias a esto podemos controlar la forma en la que los datos se muestran al usuario"), BorderLayout.SOUTH);
	}
}
