package tutorialJava.capitulo8_AWT_SWING.v04_GestionEntidadManejadaPorJPA;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tutorialJava.capitulo8_AWT_SWING.utils.CacheImagenes;
import tutorialJava.modelosBasesDeDatosComunesJPA.ventaDeCoches.Concesionario;
import tutorialJava.modelosBasesDeDatosComunesJPA.ventaDeCoches.controladores.ConcesionarioControlador;

public class PanelGestionConcesionario extends JPanel {

	public static int LOAD_FIRST = 0;
	public static int LOAD_PREV = 1;
	public static int LOAD_NEXT = 2;
	public static int LOAD_LAST = 3;
	public static int NEW = 4;
	public static int SAVE = 5;
	public static int REMOVE = 6;
	
	
	JTextField jtfId = new JTextField(5);
	JTextField jtfCif = new JTextField(15);
	JTextField jtfNombre = new JTextField(40);
	JTextField jtfLocalidad = new JTextField(40);
	
	Concesionario actual = null;
	
	
	/**
	 * 
	 */
	public PanelGestionConcesionario () {
		actual = ConcesionarioControlador.getControlador().findFirst();
		construir();
		cargarDatosActual();
	}
	
	
	
	/**
	 * 
	 */
	private void construir () {
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		// Inclusiï¿½n del panel de navegaciï¿½n
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
	    c.gridy = 0;
	    c.gridwidth = 2;
	    c.insets = new Insets(0, 0, 25, 0);
	    this.add(getPanelNavegacion(), c);
		
	    // Inclusiï¿½n del campo "Identificador"
		c.fill = GridBagConstraints.NONE;
		c.gridx = 0;
	    c.gridy = 1;
	    c.gridwidth = 1;
	    c.anchor = GridBagConstraints.EAST;
	    c.insets = new Insets(2, 2, 2, 2);
	    this.add(new JLabel("Identificador: "), c);
	    
		c.gridx = 1;
	    c.gridy = 1;
	    jtfId.setEnabled(false);
	    c.anchor = GridBagConstraints.WEST;
		this.add(jtfId, c);
		
		// Inclusiï¿½n del campo "CIF"
		c.gridx = 0;
	    c.gridy = 2;
	    c.anchor = GridBagConstraints.EAST;
	    this.add(new JLabel("CIF: "), c);
	    
		c.gridx = 1;
	    c.gridy = 2;
	    c.anchor = GridBagConstraints.WEST;
		this.add(jtfCif, c);
		
		// Inclusiï¿½n del campo "Nombre"
		c.gridx = 0;
	    c.gridy = 3;
	    c.anchor = GridBagConstraints.EAST;
	    this.add(new JLabel("Nombre: "), c);
	    
		c.gridx = 1;
	    c.gridy = 3;
	    c.anchor = GridBagConstraints.WEST;
		this.add(jtfNombre, c);
		
		// Inclusiï¿½n del campo "Localidads"
		c.gridx = 0;
	    c.gridy = 4;
	    c.anchor = GridBagConstraints.EAST;
	    this.add(new JLabel("Localidad: "), c);
	    
		c.gridx = 1;
	    c.gridy = 4;
	    c.anchor = GridBagConstraints.WEST;
		this.add(jtfLocalidad, c);
		
		c.gridx = 0;
	    c.gridy = 5;
	    c.gridwidth = 2;
	    c.anchor = GridBagConstraints.CENTER;
	    c.insets = new Insets(25, 0, 0, 0);
		this.add(getPanelAcciones(), c);
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	private JPanel getPanelNavegacion () {
		JPanel pnl = new JPanel();

		pnl.setBackground(Color.RED);
		
		JButton jbtPrimero = new JButton("Primero");
		asignarFuncion(jbtPrimero, LOAD_FIRST);
		
		JButton jbtAnterior = new JButton("Anterior");
		asignarFuncion(jbtAnterior, LOAD_PREV);
		
		JButton jbtSiguiente = new JButton("Siguiente");
		asignarFuncion(jbtSiguiente, LOAD_NEXT);

		JButton jbtUltimo = new JButton("Ultimo");
		asignarFuncion(jbtUltimo, LOAD_LAST);
		
		pnl.setLayout(new FlowLayout());
		pnl.add(jbtPrimero);
		pnl.add(jbtAnterior);
		pnl.add(jbtSiguiente);
		pnl.add(jbtUltimo);
		
		return pnl;
	}

	
	/**
	 * 
	 * @return
	 */
	private JPanel getPanelAcciones () {
		JPanel pnl = new JPanel();
		
		pnl.setBackground(Color.red);

		JButton jbtNuevo = new JButton("Nuevo");
		asignarFuncion(jbtNuevo, NEW);
		
		JButton jbtGuardar = new JButton("Guardar");
		asignarFuncion(jbtGuardar, SAVE);
		
		JButton jbtEliminar = new JButton("Eliminar");
		asignarFuncion(jbtEliminar, REMOVE);
		
		
		pnl.setLayout(new FlowLayout());
		pnl.add(jbtNuevo);
		pnl.add(jbtGuardar);
		pnl.add(jbtEliminar);
		
		return pnl;
	}

	
	/**
	 * 
	 */
	private void nuevo () {
		limpiarPantalla();
		JOptionPane.showMessageDialog(this, "Por favor, introduzca los datos del nuevo registro");
	}
	

	/**
	 * 
	 */
	private void limpiarPantalla() {
		this.jtfId.setText("");
		this.jtfCif.setText("");
		this.jtfNombre.setText("");
		this.jtfLocalidad.setText("");
	}
	
	
	/**
	 * 
	 */
	private void guardar () {
		Concesionario nuevoRegistro = new Concesionario();
		
		if (this.jtfId.getText().trim().equals("")) 
			nuevoRegistro.setId(0);
		else 
			nuevoRegistro.setId(Integer.parseInt(this.jtfId.getText()));
		
		nuevoRegistro.setCif(this.jtfCif.getText());
		nuevoRegistro.setNombre(this.jtfNombre.getText());
		nuevoRegistro.setLocalidad(this.jtfLocalidad.getText());
		
		if (nuevoRegistro.getId() == 0) {
			ConcesionarioControlador.getControlador().persist(nuevoRegistro);
		}
		else {
			ConcesionarioControlador.getControlador().merge(nuevoRegistro);
		}
		
		this.jtfId.setText("" + nuevoRegistro.getId());
		JOptionPane.showMessageDialog(this, "Guardado correctamente");
		
		this.actual = nuevoRegistro;
	}
	
	
	/**
	 * 
	 * @return
	 */
	private Concesionario eliminar () {
		String respuestas[] = new String[] {"Sí", "No"};
		int opcionElegida = JOptionPane.showOptionDialog(null, 
				"¿Realmente desea eliminar el registro?", "Eliminación del registro", 
		        JOptionPane.OK_CANCEL_OPTION, 
		        JOptionPane.OK_CANCEL_OPTION, 
		        CacheImagenes.getCacheImagenes().getIcono("confirm.png"), 
		        respuestas, respuestas[1]);

	    if(opcionElegida == 0) {
	    	Concesionario nuevoAMostrar = ConcesionarioControlador.getControlador().findPrevious(actual);
	    	if (nuevoAMostrar == null) {
	    		nuevoAMostrar = ConcesionarioControlador.getControlador().findNext(actual);
	    	}
	    	ConcesionarioControlador.getControlador().remove(actual);
			JOptionPane.showMessageDialog(this, "Eliminación correcta");

	    	if (nuevoAMostrar != null) {
	    		actual = nuevoAMostrar;
	    	}
	    	else {
	    		limpiarPantalla();
	    	} 
	    }
	    return actual;
	}
	
	
	/**
	 * 
	 * @param jbt
	 * @param funcion
	 */
	private void asignarFuncion (JButton jbt, final int funcion) {
		jbt.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent arg0) {
				
				Concesionario obtenido = null;
				if (funcion == LOAD_FIRST) 
					obtenido = ConcesionarioControlador.getControlador().findFirst();
				if (funcion == LOAD_PREV) 
					obtenido = ConcesionarioControlador.getControlador().findPrevious(actual);
				if (funcion == LOAD_NEXT) 
					obtenido = ConcesionarioControlador.getControlador().findNext(actual);
				if (funcion == LOAD_LAST) 
					obtenido = ConcesionarioControlador.getControlador().findLast();
				if (funcion == NEW) 
					nuevo();
				if (funcion == SAVE) 
					guardar();
				if (funcion == REMOVE) 
					obtenido = eliminar();
				
				if (obtenido != null) {
					actual = obtenido;
					cargarDatosActual();
				}
			}});
	}
	

	/**
	 * 
	 */
	private void cargarDatosActual () {
		if (this.actual != null) {
			this.jtfId.setText("" + this.actual.getId());
			this.jtfCif.setText(this.actual.getCif());
			this.jtfNombre.setText(this.actual.getNombre());
			this.jtfLocalidad.setText(this.actual.getLocalidad());
		}
	}
}
