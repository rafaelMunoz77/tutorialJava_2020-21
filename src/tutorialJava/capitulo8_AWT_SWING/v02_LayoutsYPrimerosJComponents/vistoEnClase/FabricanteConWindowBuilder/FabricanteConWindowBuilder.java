package tutorialJava.capitulo8_AWT_SWING.v02_LayoutsYPrimerosJComponents.vistoEnClase.FabricanteConWindowBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import java.awt.Insets;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FabricanteConWindowBuilder {

	Fabricante actual = null;
	
	private JFrame frmGestinDeFabricantes;
	private JTextField jtfId;
	private JTextField jtfCIF;
	private JTextField jtfNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FabricanteConWindowBuilder window = new FabricanteConWindowBuilder();
					window.frmGestinDeFabricantes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FabricanteConWindowBuilder() {
		initialize();
		this.actual = ControladorFabricante.getInstance().getPrimero();
		cargarDatosActualEnPantalla();
	}

	private void cargarDatosActualEnPantalla () {
		if (this.actual != null) {
			this.jtfId.setText("" + this.actual.getId());
			this.jtfCIF.setText(this.actual.getCif());
			this.jtfNombre.setText(this.actual.getNombre());
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestinDeFabricantes = new JFrame();
		frmGestinDeFabricantes.setTitle("Gestión de Fabricantes");
		frmGestinDeFabricantes.setBounds(100, 100, 450, 300);
		frmGestinDeFabricantes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		frmGestinDeFabricantes.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(5, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frmGestinDeFabricantes.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.weightx = 1.0;
		gbc_jtfId.insets = new Insets(5, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 0;
		frmGestinDeFabricantes.getContentPane().add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CIF:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		frmGestinDeFabricantes.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfCIF = new JTextField();
		GridBagConstraints gbc_jtfCIF = new GridBagConstraints();
		gbc_jtfCIF.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCIF.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCIF.gridx = 1;
		gbc_jtfCIF.gridy = 1;
		frmGestinDeFabricantes.getContentPane().add(jtfCIF, gbc_jtfCIF);
		jtfCIF.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		frmGestinDeFabricantes.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 2;
		frmGestinDeFabricantes.getContentPane().add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		frmGestinDeFabricantes.getContentPane().add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnPrimero = new JButton("<<");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorFabricante.getInstance().getPrimero();
				cargarDatosActualEnPantalla();
			}
		});
		panel.add(btnPrimero);
		
		JButton btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorFabricante.getInstance().getAnterior(actual.getId());
				cargarDatosActualEnPantalla();
			}
		});
		panel.add(btnAnterior);
		
		JButton btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorFabricante.getInstance().getSiguiente(actual.getId());
				cargarDatosActualEnPantalla();
			}
		});
		panel.add(btnSiguiente);
		
		JButton btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorFabricante.getInstance().getUltimo();
				cargarDatosActualEnPantalla();
			}
		});
		panel.add(btnUltimo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		panel.add(btnGuardar);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		panel.add(btnNuevo);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		panel.add(btnEliminar);
	}
	
	
	private void cargarActualDesdePantalla () {
		this.actual.setId(Integer.parseInt(jtfId.getText()));
		this.actual.setCif(jtfCIF.getText());
		this.actual.setNombre(jtfNombre.getText());
	}
	
	private void guardar() {
		cargarActualDesdePantalla();
		if (this.actual.getId() != 0) {
			int regs = ControladorFabricante.getInstance().guardarExistente(actual);
			if (regs == 1) {
				JOptionPane.showMessageDialog(null, "Registro modificado correctamente");
			}
		}
		else {
			int nuevoId = ControladorFabricante.getInstance().guardarNuevo(actual);
			if (nuevoId > 1) {
				this.actual.setId(nuevoId);
				cargarDatosActualEnPantalla();
				JOptionPane.showMessageDialog(null, "Registro creado correctamente");
			}
		}
	}
	
	private void vaciaDatosActuales () {
		this.actual.setId(0);
		this.actual.setCif("");
		this.actual.setNombre("");
		cargarDatosActualEnPantalla();
	}
	
	private void nuevo() {
		vaciaDatosActuales();
	}

	
	private void eliminar() {
		String posiblesRespuestas[] = {"Sí","No"};
		// En esta opci�n se utiliza un showOptionDialog en el que personalizo el icono mostrado
		int opcionElegida = JOptionPane.showOptionDialog(null, "¿Realmente desea eliminar?", "Eliminar", 
		        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, posiblesRespuestas, posiblesRespuestas[1]);
	    if(opcionElegida == 0) {
	      int regs = ControladorFabricante.getInstance().eliminar(this.actual.getId()); 
	      if (regs > 0) {
	    	  vaciaDatosActuales();
	    	  JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
	      }
	    }

	}
}
