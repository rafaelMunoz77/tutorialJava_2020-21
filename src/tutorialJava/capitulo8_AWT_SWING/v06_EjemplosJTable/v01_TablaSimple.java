package tutorialJava.capitulo8_AWT_SWING.v06_EjemplosJTable;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class v01_TablaSimple extends JPanel {

	/**
	 * 
	 */
	public v01_TablaSimple () {
		//Creo un objeto JTable con el constructor más sencillo del que dispone
		JTable table = new JTable(DatosDeTabla.getDatosDeTabla(), 
				DatosDeTabla.getTitulosColumnas());
		//Creamos un JscrollPane y le agregamos la JTable
		JScrollPane scrollPane = new JScrollPane(table);
		
		// Accedo a los clics realizados sobre la tabla
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int indiceFilaSel = table.getSelectedRow();
				System.out.println("Clic en JTAble: " + DatosDeTabla.getDatosDeTabla()[indiceFilaSel][2]);
			}
		});
		
		//Agregamos el JScrollPane al contenedor
		this.setLayout(new BorderLayout());
		this.add(new JTextArea("JTable construida sin TableModel. Muy fácil de crear pero con limitaciones. Siempre editable.\n"
				+ "No podemos realizar cambios como incorporar, eliminar o modificar líneas.\n"
				+ "Prácticamente no podemos configurar casi nada, ni crear renderizadores específicos para celdas concretas"), BorderLayout.NORTH);
		this.add(scrollPane, BorderLayout.CENTER);
	}
	
}
