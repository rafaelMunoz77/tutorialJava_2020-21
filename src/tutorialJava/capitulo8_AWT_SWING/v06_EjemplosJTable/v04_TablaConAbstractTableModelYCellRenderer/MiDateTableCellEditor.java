package tutorialJava.capitulo8_AWT_SWING.v06_EjemplosJTable.v04_TablaConAbstractTableModelYCellRenderer;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.DefaultCellEditor;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;

public class MiDateTableCellEditor extends DefaultCellEditor {

	// Puntero al componente que visualizaremos, se utiliza un JFormattedTextField
	private JFormattedTextField ftf;
	
	/**
	 * Constructor
	 * @param format
	 */
	public MiDateTableCellEditor(DateFormat format) {
		super(new JFormattedTextField(format));

		// La edición comenzará con dos clics de ratón
		setClickCountToStart(2);

		// Establezco un "mapa" de acciones, para conseguir que al pulsar la tecla "Intro" se intente validar
		// el valor contenido en el objeto JFormattedTextField.
		ftf = (JFormattedTextField) getComponent();

		ftf.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "check");
		ftf.getActionMap().put("check", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if (!ftf.isEditValid()) { // The text is invalid.
					JOptionPane.showMessageDialog(null, "Formato incorrecto, debe utilizar dd/MM/yyyy"); 
					ftf.setValue(ftf.getValue());
				} else
					try { // The text is valid,
						ftf.commitEdit(); // so use it.
						ftf.postActionEvent(); // stop editing
					} catch (ParseException ex) {
				}
			}
		});
	}

	/**
	 * Fabrico y devuelvo el componente JFormattedTextField con el valor correctamente introducido, para que el usuario
	 * pueda comenzar a editarlo
	 */
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		JFormattedTextField ftf = (JFormattedTextField) super.getTableCellEditorComponent(table, value, isSelected, row, column);
		ftf.setValue(value);
		return ftf;
	}

	/**
	 * Devuelvo el valor introducido por el usuario
	 */
	public Object getCellEditorValue() {
		return (Date) ftf.getValue();
	}

	/**
	 * En caso de que el valor introducido por el usuario no sea válido, se mantendrá el anterior valor introducido válido.
	 */
	public boolean stopCellEditing() {
		if (ftf.isEditValid()) {
			try {
				ftf.commitEdit();
			} catch (ParseException e) {
			}
		} else { // El texto introducido no es válido
			ftf.setValue(ftf.getValue());
		}
		return super.stopCellEditing();
	}

}
