package tutorialJava.capitulo8_AWT_SWING.v06_EjemplosJTable.v04_TablaConAbstractTableModelYCellRenderer;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.JTextField;

public class MiDateTableCellRenderer extends MiDefaultTableCellRenderer {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		JTextField jtf = new JTextField();
		jtf.setBackground(this.getBackgroundColor(table, value, isSelected, hasFocus, row, column));
        jtf.setForeground(getForegroundColor(table, value, isSelected, hasFocus, row, column));
		jtf.setText(sdf.format((Date) value));
		
		
        return jtf;
	}

}
