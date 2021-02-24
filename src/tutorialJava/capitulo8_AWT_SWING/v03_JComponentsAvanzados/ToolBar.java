package tutorialJava.capitulo8_AWT_SWING.v03_JComponentsAvanzados;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import tutorialJava.capitulo8_AWT_SWING.utils.CacheImagenes;



public class ToolBar extends JToolBar {

	private static final long serialVersionUID = 1L;
	
	public ToolBar () {
        this.add(creaBoton("", "exit.png", "Salir del programa"));
        this.add(creaBoton("", "conectado.png", "Conectado con el servidor"));
        this.add(creaBoton("", "desconectado.png", "Desconectado del servidor"));
        this.addSeparator();
        this.add(creaComboBox(new String[] {"Opci�n 1", "Opci�n 2", "Opci�n 3", "Opci�n 4", "Opci�n 5"}));
        this.add(creaBoton("", "gotostart.png", "Primero"));
        this.add(creaBoton("", "previous.png", "Anterior"));
        this.add(creaBoton("", "next.png", "Siguiente"));
        this.add(creaBoton("", "gotoend.png", "�ltimo"));
        this.addSeparator();
        this.add(creaToggleBoton("", "ruedadentada.png", "Ver opciones"));
	}

	
	/**
	 * 
	 * @param titulo
	 * @param icono
	 * @return
	 */
	private JButton creaBoton(String titulo, String icono, String toolTip) {
        JButton jbt = new JButton();
        
        jbt.setText(titulo);
        jbt.setToolTipText(toolTip);
        
        jbt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("Has hecho clic en el bot�n: \"" + toolTip + "\"");
            }
        });
        
        try {
        	jbt.setIcon(CacheImagenes.getCacheImagenes().getIcono(icono));  
          } catch (Exception ex) {
        	  ex.printStackTrace();
          }
        return jbt;
	}
	
	
	/**
	 * 
	 * @param titulo
	 * @param icono
	 * @return
	 */
	private JToggleButton creaToggleBoton(String titulo, String icono, String toolTip) {
        JToggleButton jbt = new JToggleButton();
        
        jbt.setText(titulo);
        jbt.setToolTipText(toolTip);
        
        jbt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("Has hecho clic en el toggle bot�n: \"" + toolTip + "\" - Ahora est� seleccionado: " + jbt.isSelected());
            }
        });
        
        try {
        	jbt.setIcon(CacheImagenes.getCacheImagenes().getIcono(icono));  
          } catch (Exception ex) {
        	  ex.printStackTrace();
          }
        return jbt;
	}
	
	
	/**
	 * 
	 * @param opciones
	 * @return
	 */
	private JComboBox creaComboBox (String opciones[]) {
		JComboBox<String> jcb = new JComboBox<String>(opciones);
		jcb.setMaximumSize(new Dimension(100, 75));
		return jcb;
	}
}
