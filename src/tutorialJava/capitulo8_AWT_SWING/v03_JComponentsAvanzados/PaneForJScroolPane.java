package tutorialJava.capitulo8_AWT_SWING.v03_JComponentsAvanzados;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PaneForJScroolPane extends JPanel {

	JButton btn = new JButton("Cambiar imagen");
	JScroolPaneConImagen scrollPaneConImagen = new JScroolPaneConImagen();
	
	public PaneForJScroolPane() {
		this.setLayout(new BorderLayout());
		
		this.add(btn, BorderLayout.SOUTH);
		this.add(scrollPaneConImagen, BorderLayout.CENTER);
		
		btn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				scrollPaneConImagen.cambiaImagen();
			}
		});
		
		
	}


}
