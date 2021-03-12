package tutorialJava.capitulo8_AWT_SWING.v02_LayoutsYPrimerosJComponents.vistoEnClase;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Ventana extends JFrame {

	static {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		} // Look and Feel Windows - S�lo en entornos Windows
	}
	
	/**
	 * 
	 */
	public Ventana() {
		this.setBounds(0, 0, 600, 600);
		this.getContentPane().add(getPanelPrincipal());
		this.setVisible(true);
	}
	
	
	/**
	 * 
	 * @return
	 */
	private static JPanel getPanelPrincipal () {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		// Primer línea con jlabel y jtextfield
		JPanel pnlNombre = new JPanel();
		pnlNombre.setLayout(new FlowLayout());
		pnlNombre.add(new JLabel("Nombre y apellidos"));
		
		JTextField jtf = new JTextField();
		jtf.setMinimumSize(new Dimension(200, 20));
		jtf.setPreferredSize(new Dimension(200, 20));
		pnlNombre.add(jtf);
		
		// Agrego el panel del nombre al panel principal
		panel.add(pnlNombre);
		

		// Segunda línea con jlabel y jtextfield de mail
		JPanel pnlEmail = new JPanel();
		pnlEmail.setLayout(new FlowLayout());
		pnlEmail.add(new JLabel("Correo electrónico"));
		
		JTextField jtfEmail = new JTextField();
		jtfEmail.setMinimumSize(new Dimension(200, 20));
		jtfEmail.setPreferredSize(new Dimension(200, 20));
		pnlEmail.add(jtfEmail);
		
		// Agrego el panel del nombre al panel principal
		panel.add(pnlEmail);
		
		
		// Tercera línea con JRadioButton para género
		JPanel pnlGenero = new JPanel();
		pnlGenero.setLayout(new BoxLayout(pnlGenero, BoxLayout.Y_AXIS));
		JRadioButton jrbMujer = new JRadioButton("Mujer");
		JRadioButton jrbHombre = new JRadioButton("Hombre");
		JRadioButton jrbOtros = new JRadioButton("Otros");

		pnlGenero.add(jrbHombre);
		pnlGenero.add(jrbMujer);
		pnlGenero.add(jrbOtros);

		// Hago excluyentes los botones de radio
		ButtonGroup grupoGenero = new ButtonGroup();
		grupoGenero.add(jrbMujer);
		grupoGenero.add(jrbHombre);
		grupoGenero.add(jrbOtros);

		panel.add(pnlGenero);
		
		
		// JComboBox
		JPanel pnlLocalidades = new JPanel();
		pnlLocalidades.setLayout(new FlowLayout());
		pnlLocalidades.add(new JLabel("Localidades"));
		
		String opts[] = new String[] {"Lucena", "Albendín"};
		JComboBox jcbLocalidades = new JComboBox(opts); 
		pnlLocalidades.add(jcbLocalidades);
		
		panel.add(pnlLocalidades);

		// Línea con JPasswordField
		JPanel pnlPassword = new JPanel();
		pnlPassword.setLayout(new FlowLayout());
		pnlPassword.add(new JLabel("Contraseña"));
		
		JPasswordField jpfPass = new JPasswordField();
		jpfPass.setMinimumSize(new Dimension(200, 20));
		jpfPass.setPreferredSize(new Dimension(200, 20));
		pnlPassword.add(jpfPass);
		
		// Agrego el panel del nombre al panel principal
		panel.add(pnlPassword);
		
		
		// JButton
		JButton btn = new JButton("Guardar");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Botón pulsado");
				StringBuffer sb = new StringBuffer();
				sb.append(jtf.getText() + " ");
				sb.append(jtfEmail.getText() + " ");
				sb.append(jrbMujer.isSelected() + " ");
				sb.append(jcbLocalidades.getSelectedItem());
				sb.append(jpfPass.getPassword());
				
				System.out.println(sb);
			}
		});
		panel.add(btn);
		
		return panel;
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main (String args[]) {
		new Ventana();
	}

}
