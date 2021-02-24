package tutorialJava.capitulo8_AWT_SWING.v06_EjemplosJTable.v04_TablaConAbstractTableModelYCellRenderer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MiDefaultTableCellRenderer extends DefaultTableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setBackground(getBackgroundColor(table, value, isSelected, hasFocus, row, column));
        c.setForeground(getForegroundColor(table, value, isSelected, hasFocus, row, column));
        return c;
	}
	
	/**
	 * 
	 * @param table
	 * @param value
	 * @param isSelected
	 * @param hasFocus
	 * @param row
	 * @param column
	 * @return
	 */
	protected Color getBackgroundColor (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		Color color = null;
		if (isSelected) {
			return Color.BLUE;
		}
		else {
			color = row % 2 == 0 ? Color.LIGHT_GRAY : Color.WHITE;
		}
		return color;
	}

	/**
	 * 
	 * @param table
	 * @param value
	 * @param isSelected
	 * @param hasFocus
	 * @param row
	 * @param column
	 * @return
	 */
	protected Color getForegroundColor (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		Color color = null;
		if (isSelected) {
			return Color.WHITE;
		}
		else {
			return Color.BLACK;
		}
	}

}
