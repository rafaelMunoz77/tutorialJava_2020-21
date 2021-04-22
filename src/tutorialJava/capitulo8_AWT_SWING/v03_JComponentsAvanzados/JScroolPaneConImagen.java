package tutorialJava.capitulo8_AWT_SWING.v03_JComponentsAvanzados;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import tutorialJava.capitulo8_AWT_SWING.utils.CacheImagenes;

public class JScroolPaneConImagen extends JScrollPane {

	String imagenDuke = "dukeGrande.png";
	String imagenBobEsponja = "bob_esponja.png";
	String imagenAMostrar = imagenDuke;

	/**
	 * @param imagen
	 */
	public JScroolPaneConImagen() {
		cambiaImagen();
	}
	
	
	/**
	 * 
	 * @param imagen
	 */
	public void cambiaImagen() {
		JLabel lbl = new JLabel(CacheImagenes.getCacheImagenes().getIcono(this.imagenAMostrar));
		this.setViewportView(lbl);
		this.revalidate();
		this.repaint();
		
		// Alterno a otra imagen
		this.imagenAMostrar = (this.imagenAMostrar.equals(imagenDuke))? imagenBobEsponja : imagenDuke;
	}
}
