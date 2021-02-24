package tutorialJava.capitulo8_AWT_SWING.v06_EjemplosJTable.v04_TablaConAbstractTableModelYCellRenderer;

import java.awt.Component;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;

import tutorialJava.modelosBasesDeDatosComunesJPA.poblacionPorProvincias.Provincia;
import tutorialJava.modelosBasesDeDatosComunesJPA.poblacionPorProvincias.controladores.ProvinciaControlador;

public class MiProvinciaTableCellEditor extends DefaultCellEditor {

	// Utilizaremos este puntero para hacer referencia al control mostrado en la tabla
	private JComboBox<Provincia> jcbProvincias = null;
	
	/**
	 * 
	 */
	public MiProvinciaTableCellEditor() {
		super(new JComboBox<Provincia>());
		
		// La celda se comenzará a editar tras 2 clics
		setClickCountToStart(2);
		// Inicialización del componente
		jcbProvincias = (JComboBox<Provincia>) getComponent();
	}

	/**
	 * En este método construimos el componente que el usuario verá cuando haga clic sobre la celda en concreto
	 */
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		JComboBox<Provincia> jcbProvincias = (JComboBox<Provincia>) super.getTableCellEditorComponent(table, value, isSelected, row, column);

		// Si los hubiera, elimino los items actuales.
		jcbProvincias.removeAllItems();
		
		// Inicializo los elementos del combobox a todas las provincias disponibles y selecciono la correcta
		List<Provincia> provincias = ProvinciaControlador.getControlador().findAllProvincias();
		for (Provincia provincia : provincias) {
			jcbProvincias.addItem(provincia);
			if (value != null && value instanceof Provincia) {
				Provincia provinciaValue = (Provincia) value;
				if (provinciaValue.getId() == provincia.getId()) {
					jcbProvincias.setSelectedItem(provincia);
				}
			}
		}
		
		return jcbProvincias;
	}

	/**
	 * Devuelvo el objeto de tipo Provincia seleccionado por el usuario
	 */
	public Object getCellEditorValue() {
		return (Provincia) jcbProvincias.getSelectedItem();
	}

}
