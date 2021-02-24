package tutorialJava.capitulo8_AWT_SWING.v06_EjemplosJTable;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import tutorialJava.capitulo8_AWT_SWING.utils.CacheImagenes;


public class v02_TablaConDefaultTableModel extends JPanel {

	private DefaultTableModel dtm = null;
	private Object datosEnTabla[][] = DatosDeTabla.getDatosDeTabla();
	private String titulosEnTabla[] = DatosDeTabla.getTitulosColumnas();
	
	/**
	 * 
	 */
	public v02_TablaConDefaultTableModel () {
		// Inicializo el DefaultTableModel
		this.dtm = getDefaultTableModelNoEditable();
		// Creo la tabla con el DefaultTableModel del método más abajo
		JTable jTable = new JTable(dtm);
		
		// Demostración de como acceder al clic del ratón sobre la tabla y sobrescribir un valor en la misma
		jTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int indiceFilaSel = jTable.getSelectedRow();
				dtm.setValueAt("Rafa", indiceFilaSel, 1);
			}
		});
		
	
		
		//Creamos un JscrollPane y le agregamos la JTable
		JScrollPane scrollPane = new JScrollPane(jTable);
		//Agregamos el JScrollPane al contenedor
		this.setLayout(new BorderLayout());
		this.add(getBarraHerramientas(), BorderLayout.NORTH);
		this.add(scrollPane, BorderLayout.CENTER);
		this.add(new JTextArea("JTable construida con DefaultTableModel. Un poco más difícil de crear.\n"
				+ "Podemos realizar cambios como incorporar, eliminar o modificar líneas o columnas.\n"
				+ "También podemos controlar que las celdas sean editables o no lo sean."), BorderLayout.SOUTH);
	}
	
	/**
	 * 
	 * @return
	 */
	private DefaultTableModel getDefaultTableModelNoEditable () {
		DefaultTableModel dtm = new DefaultTableModel(datosEnTabla, titulosEnTabla) {
			/**
			 * La sobreescritura de este método nos permite controlar qué celdas queremos que sean editables
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
				if (column != 1) {
					return false;
				}
				return true;
			}
		};
		return dtm;
	}
	
	
	/**
	 * 
	 * @return
	 */
	private JToolBar getBarraHerramientas() {
		JToolBar toolBar = new JToolBar();
		
		// Botón para insertar una línea
		JButton jbtNuevo = new JButton();
		jbtNuevo.setIcon(CacheImagenes.getCacheImagenes().getIcono("nuevo.png"));
		jbtNuevo.setToolTipText("Inserta una línea al final de la tabla");
		jbtNuevo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dtm.addRow(new String[] {"100000", "Rafa", "Muñoz", "Ruiz", "19/03/1977", "42", "true", "Córdoba"});
			}
		});
		toolBar.add(jbtNuevo);

		// Botón para modificar la primera línea en su primera columna
		JButton jbtModificar = new JButton();
		jbtModificar.setIcon(CacheImagenes.getCacheImagenes().getIcono("guardar.png"));
		jbtModificar.setToolTipText("Modificar el valor de la primera columna de la primera fila");
		jbtModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dtm.setValueAt("Rafa estuvo aquí", 0, 0);
			}
		});
		toolBar.add(jbtModificar);

		// Botón para eliminar la última fila
		JButton jbtEliminar = new JButton();
		jbtEliminar.setIcon(CacheImagenes.getCacheImagenes().getIcono("eliminar.png"));
		jbtEliminar.setToolTipText("Eliminar la primera fila de la tabla");
		jbtEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dtm.removeRow(0);
			}
		});
		toolBar.add(jbtEliminar);

		return toolBar;
	}

}
