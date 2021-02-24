package tutorialJava.capitulo8_AWT_SWING.v05_JListConDefaultListModel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import tutorialJava.modelosBasesDeDatosComunesJPA.poblacionPorProvincias.Provincia;
import tutorialJava.modelosBasesDeDatosComunesJPA.poblacionPorProvincias.controladores.ProvinciaControlador;

import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelJList extends JPanel {

	// Elemento JList a utilizar en el ejemplo
	private JList jlistProvincias;
	// Modelo del elemento JList, necesario para que podamos cómodamente agregar y eliminar elementos
	private DefaultListModel<Provincia> listModelProvincias = null;
	// Lista de todas las provincias de la BBDD, para incluir en el elemento JList
	private List<Provincia> provincias = ProvinciaControlador.getControlador().findAllProvincias();
	// Índice de la última provincia agregada, para saber cuál debe ser la siguiente provincia a agregar
	private int indiceProximaProvinciaParaAgregar = 0;
	
	/**
	 * Create the panel.
	 */
	public PanelJList() {
		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.columnWidths = new int[]{0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0, 0};
//		gridBagLayout.columnWeights = new double[]{1.0, 1.0};
//		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0};
		setLayout(gridBagLayout);
		
		JLabel lblEjemploDeUso = new JLabel("Ejemplo de uso de un elemento JList con DefaultListModel");
		GridBagConstraints gbc_lblEjemploDeUso = new GridBagConstraints();
		gbc_lblEjemploDeUso.gridwidth = 2;
		gbc_lblEjemploDeUso.insets = new Insets(5, 5, 5, 5);
		gbc_lblEjemploDeUso.gridx = 0;
		gbc_lblEjemploDeUso.gridy = 0;
		add(lblEjemploDeUso, gbc_lblEjemploDeUso);
		
		// La JList debe ir dentro de un ScrollPane, y se construye con el modelo de JList sobre el que después
		// se agregarán o eliminarán provincias.
		jlistProvincias = new JList(this.getDefaultListModel());
		// Tipos de selección disponibles en JList
		//this.jlistProvincias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//this.jlistProvincias.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		this.jlistProvincias.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Valor por defecto
		
		JScrollPane scrollJList = new JScrollPane(jlistProvincias);
		GridBagConstraints gbc_jlistProvincias = new GridBagConstraints();
		gbc_jlistProvincias.gridwidth = 2;
		gbc_jlistProvincias.insets = new Insets(5, 5, 5, 5);
		gbc_jlistProvincias.fill = GridBagConstraints.BOTH;
		gbc_jlistProvincias.gridx = 0;
		gbc_jlistProvincias.gridy = 1;
		gbc_jlistProvincias.weighty = 1;
		add(scrollJList, gbc_jlistProvincias);
		
		JButton jbtAgregarProvincia = new JButton("Agregar provincia");
		jbtAgregarProvincia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarProvincia();
			}
		});
		GridBagConstraints gbc_jbtAgregarProvincia = new GridBagConstraints();
		gbc_jbtAgregarProvincia.insets = new Insets(5, 5, 5, 5);
		gbc_jbtAgregarProvincia.gridx = 0;
		gbc_jbtAgregarProvincia.gridy = 2;
		add(jbtAgregarProvincia, gbc_jbtAgregarProvincia);
		
		JButton jbtEliminarSeleccionados = new JButton("Eliminar seleccionados");
		jbtEliminarSeleccionados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminarProvinciasSeleccionadas();
			}
		});
		GridBagConstraints gbc_jbtEliminarSeleccionados = new GridBagConstraints();
		gbc_jbtEliminarSeleccionados.insets = new Insets(5, 5, 5, 5);
		gbc_jbtEliminarSeleccionados.gridx = 1;
		gbc_jbtEliminarSeleccionados.gridy = 2;
		add(jbtEliminarSeleccionados, gbc_jbtEliminarSeleccionados);

	}
	
	
	/**
	 * Método que construye el modelo de JList, a utilizar para agregar y eliminar provincias
	 */
	private DefaultListModel getDefaultListModel () {
		this.listModelProvincias = new DefaultListModel<Provincia>();
		return this.listModelProvincias;
	}

	/**
	 * Para agregar provincias se hace un recorrido circular de la lista de provincias
	 */
	private void agregarProvincia () {
		this.listModelProvincias.addElement(this.provincias.get(this.indiceProximaProvinciaParaAgregar));
		// Aumento el índice de la próxima provincia a agregar
		this.indiceProximaProvinciaParaAgregar++;
		// Si sobrepasa el límite de las provincias posibles, reiniciamos a valor 0 (cero) el índice de la próxima provincia a agregar
		if (this.indiceProximaProvinciaParaAgregar == this.provincias.size()) {
			this.indiceProximaProvinciaParaAgregar = 0;
		}
	}
	
	/**
	 * Para eliminar todas las provincias seleccionadas, deberíamos comenzar desde la última e ir haciendo el barrido hasta la primera.
	 */
	private void eliminarProvinciasSeleccionadas () {
		for (int i = this.jlistProvincias.getSelectedIndices().length - 1; i >= 0; i--) {
			this.listModelProvincias.removeElementAt(this.jlistProvincias.getSelectedIndices()[i]);
		}
	}
}
