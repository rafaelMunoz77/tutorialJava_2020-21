package tutorialJava.capitulo8_AWT_SWING.v03_JComponentsAvanzados;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import tutorialJava.capitulo8_AWT_SWING.utils.CacheImagenes;

public class PanelPopUpMenu extends JPanel {

	/**
	 * 
	 */
	public PanelPopUpMenu () {
		super ();

		// Creo una etiqueta para indicar al usuario que debe hacer clic en cualquier sitio
		this.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.anchor = GridBagConstraints.CENTER;
		
		this.add(new JLabel ("Haz clic con el bot�n secundario del rat�n en cualquier parte de este panel"), constraints);
		
		// Inicializo el men� de popup
		JPopupMenu popup = getPopUpMenu();
		
		// Evento para mostrar el men� en las coordenadas que correspondan
		this.addMouseListener(new MouseAdapter() {
 
            @Override
            public void mousePressed(MouseEvent e) {
                showPopup(e);
            }
 
            @Override
            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }
 
            /**
             * M�todo llamado cuando se detecta el evento de rat�n, mostrar� el men�
             * @param e
             */
            private void showPopup(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popup.show(e.getComponent(),
                            e.getX(), e.getY());
                }
            }
        });
	}
	
	
	/**
	 * 
	 * @return
	 */
	private JPopupMenu getPopUpMenu () {
		JPopupMenu menu = new JPopupMenu();
		
		menu.add(crearNuevoMenuItem("Primera opci�n", "ruedadentada.png"));
		menu.addSeparator();
		menu.add(crearNuevoMenuItem("Segunda opci�n", "next.png"));
		menu.add(crearNuevoMenuItem("Tercera opci�n", "previous.png"));
		menu.add(crearNuevoMenuItem("Cuarta opci�n", "gotoend.png"));
		
		return menu;
	}
	
	
	
	/**
	 * Men� Item para salir de la aplicaci�n
	 * @return
	 */
	private JMenuItem crearNuevoMenuItem (String titulo, String nombreIcono) {
        JMenuItem item = new JMenuItem(titulo);
        item.setIcon(CacheImagenes.getCacheImagenes().getIcono(nombreIcono));
        item.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Han hecho clic en: " + titulo);
            }
        });
        
        return item;
	}
	
}
