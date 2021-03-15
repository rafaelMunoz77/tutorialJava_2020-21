package tutorialJava.capitulo8_AWT_SWING.v02_LayoutsYPrimerosJComponents.vistoEnClase;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.sun.codemodel.fmt.JTextFile;

public class EjemploGridBagLayoutSupers extends JFrame {

	public EjemploGridBagLayoutSupers() {
		this.setBounds(0, 0, 800, 600);
		
		this.setContentPane(getPanelPrincipal());
	}

	
	/**
	 * 
	 * @return
	 */
	private JPanel getPanelPrincipal () {
		JPanel p = new JPanel();
		
		p.setLayout(new GridBagLayout());
		
		// Nombre real
		JLabel lblNombreReal = new JLabel("Nombre real: ");
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0; c.gridy = 0;
		c.anchor = GridBagConstraints.EAST;
		c.insets = new Insets(20, 30, 0, 20);
		p.add(lblNombreReal, c);
		
		JTextField jtfNombreReal = new JTextField();
		c.gridx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.insets = new Insets(20, 0, 0, 30);
		p.add(jtfNombreReal, c);
		
		// Alias
		JLabel lblAlias = new JLabel("Alias: ");
		c.gridx = 0; c.gridy = 1;
		c.weightx = 0;
		c.anchor = GridBagConstraints.EAST;
		c.insets = new Insets(20, 0, 0, 20);
		c.fill = GridBagConstraints.NONE;
		p.add(lblAlias, c);
		
		JTextField jtfAlias = new JTextField();
		c.gridx = 1;
		c.weightx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 0, 0, 30);
		p.add(jtfAlias, c);
		
		// Fila para procedencia
		JLabel lblProcedencia = new JLabel("Procedencia: ");
		c.gridx = 0; c.gridy = 2;
		c.weightx = 0;
		c.anchor = GridBagConstraints.EAST;
		c.insets = new Insets(20, 0, 0, 20);
		c.fill = GridBagConstraints.NONE;
		p.add(lblProcedencia, c);
		
		JPanel pnlProcedencia = new JPanel();
		pnlProcedencia.setLayout(new FlowLayout());
		JRadioButton jrbTerrestre = new JRadioButton("Terrestre");
		JRadioButton jrbExtraterrestre = new JRadioButton("Estraterrestre");
		pnlProcedencia.add(jrbTerrestre);
		pnlProcedencia.add(jrbExtraterrestre);
		c.gridx = 1;
		c.weightx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(20, 0, 0, 30);
		p.add(pnlProcedencia, c);

		// Botón de acción
		JButton jbtGuardar = new JButton("Guardar");
		JButton jbtNuevo = new JButton("Nuevo");
		JButton jbtEliminar = new JButton("Eliminar");
		JPanel pnlBotones = new JPanel();
		pnlBotones.setLayout(new FlowLayout());
		pnlBotones.add(jbtGuardar);
		pnlBotones.add(jbtNuevo);
		pnlBotones.add(jbtEliminar);

		c.gridx = 0; c.gridy = 3;
		c.weightx = 0;
		c.gridwidth = 2;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(20, 0, 0, 20);
		c.fill = GridBagConstraints.NONE;
		p.add(pnlBotones, c);
		
		// Fila para empujar hacia arriba al resto de elementos
		JPanel panelRellenoInf = new JPanel();
		c.weighty = 1;
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 10;
		c.gridwidth = 2;
		p.add(panelRellenoInf, c);
		
		return p;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new EjemploGridBagLayoutSupers().setVisible(true);
	}

}
