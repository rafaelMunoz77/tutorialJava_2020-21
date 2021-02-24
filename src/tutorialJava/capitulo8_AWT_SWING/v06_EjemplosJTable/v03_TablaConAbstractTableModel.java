package tutorialJava.capitulo8_AWT_SWING.v06_EjemplosJTable;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.AbstractTableModel;

public class v03_TablaConAbstractTableModel extends JPanel {

	MiTableModel tableModel = null;
	
	public v03_TablaConAbstractTableModel () {
		// Construyo el tableModel y la tabla
		tableModel = new MiTableModel();
		JTable jTable = new JTable(tableModel);
		
		//Creamos un JscrollPane y le agregamos la JTable
		JScrollPane scrollPane = new JScrollPane(jTable);
		//Agregamos el JScrollPane al contenedor
		this.setLayout(new BorderLayout());
//		this.add(getBarraHerramientas(), BorderLayout.NORTH);
		this.add(scrollPane, BorderLayout.CENTER);
		this.add(new JTextArea("JTable construida con AbstractTableModel. Ganamos en dificultad y en potencia.\n"
				+ "Tenemos acceso a todas las opciones posibles con JTable"), BorderLayout.SOUTH);
	}
	
	
	
	/**
	 * Modelo de tabla abstracto, que nos permite un control mayor sobre la apariencia, eventos y renderizadores de la tabla
	 * @author R
	 *
	 */
	private class MiTableModel extends AbstractTableModel {

		Object datos[][] = null;
		String titulos[] = null;

		/**
		 * 
		 */
		public MiTableModel() {
			// Datos a presentar en la tabla
			datos = DatosDeTabla.getDatosDeTabla();
			titulos = DatosDeTabla.getTitulosColumnas();
		}
		
		// Los tres siguientes métodos son los mínimos necesarios para representar la tabla
		/**
		 * Permite que la tabla sepa cuántas columnas debe mostrar
		 */
		@Override
		public int getColumnCount() {
			return titulos.length;
		}

		/**
		 * Permite que la tabla sepa cuántas filas debe mostrar
		 */
		@Override
		public int getRowCount() {
			return datos.length;
		}

		/**
		 * Se conocerá el dato en cada celda, es uno de los métodos fundamentales del abstractTableModel
		 */
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return datos[rowIndex][columnIndex];
		}

		/**
		 * Podemos indicar si la tabla será o no editable en cada una de sus celdas, incluso por separado
		 */
		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return true;
		}

		/**
		 * Este método da nombre a las columnas de la tabla
		 */
		@Override
		public String getColumnName(int column) {
			return this.titulos[column];
		}

		/**
		 * Permite que la tabla sepa que tipo de dato está mostrando en cada columna
		 */
		@Override
		public Class<?> getColumnClass(int columnIndex) {
			if (this.datos.length > 0) {
				return this.datos[0][columnIndex].getClass();
			}
			return String.class;
		}

		/**
		 * Este método sólo debe implementarse si la tabla es editable y los datos pueden cambiar
		 */
		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			this.datos[rowIndex][columnIndex] = aValue;
			fireTableCellUpdated(rowIndex, columnIndex);
		}
		
		
		
		
	}
}
