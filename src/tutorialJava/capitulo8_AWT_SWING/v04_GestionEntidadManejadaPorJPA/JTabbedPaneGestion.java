package tutorialJava.capitulo8_AWT_SWING.v04_GestionEntidadManejadaPorJPA;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import tutorialJava.Utils;
import tutorialJava.capitulo8_AWT_SWING.utils.CacheImagenes;

public class JTabbedPaneGestion extends JTabbedPane {


	/**
	 * 
	 * @return
	 */
	public JTabbedPaneGestion (){
	
		ImageIcon icono = CacheImagenes.getCacheImagenes().getIcono("duke1-32x32.png");
		
		this.addTab("Concesionario", icono, new PanelGestionConcesionario(), "Concesionario");
		this.setSelectedIndex(0);  
	}	
}
