package tutorialJava.capitulo8_AWT_SWING.v07_CreacionPanelesGestionAutomaticosConReflexionYJPA;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import tutorialJava.capitulo8_AWT_SWING.utils.CacheImagenes;
import tutorialJava.modelosBasesDeDatosComunesJPA.Controlador;
import tutorialJava.modelosBasesDeDatosComunesJPA.Entidad;
import tutorialJava.modelosBasesDeDatosComunesJPA.evaluacionCentroEducativo.controladores.CursoControlador;

/**
 * En esta clase se hace un esfuerzo por generalizar una cierta forma de hacer paneles de gestión de entidades JPA.
 * En concreto se ha tomado como punto de partida los paneles creados en el ejemplo v03 de este capítulo. A continuación,
 * tras ese punto de partida, se han realizado un par de paneles de gestión con un nuevo formato en este ejemplo: se trata
 * del panel de gestión de los cursos y las materias, que se pueden encontrar en este mismo paquete.
 * Tras pensar en dichos paneles, se ha hecho un trabajo de generalización, intentando encontrar aquellos aspectos que se
 * repetirán una y otra vez y harán el trabajo pesado. Los aspectos comunes se han realizado en este panel de gestión general
 * y los aspectos concretos deben ser implementados por los subtipos de este panel. Podemos encontrar un ejemplo de utilización
 * de este panel en la clase PanelGestionProfesor, de este mismo paquete
 * 
 * Los aspectos generales que se llevan a cabo en esta clase son:
 *   - Navegación, alta, modificación y eliminación de la entidad gestionada
 *   - Maquetación del panel, a partir de unos componentes visuales que permiten mostrar y recoger datos relacionados con la entidad
 *   - Creación de la barra de herramientas y asignación de funciones a los botones
 * 
 * Los aspectos generales, que deben ser implementados por los subtipos de esta clase son:
 *   - Obtener y establecer una entidad que será gestionada en este panel
 *   - Establecer un controlador de entidad JPA, que controlará las acciones de BBDD relacionadas con la entidad
 *   - Establecer un conjunto de componentes visuales (JTextFields, JComboBox....) específicos para cada campo
 *   	de la entidad JPA gestionada en este panel
 *   - Establecer un array de Strings que servirá para crear etiquetas asociadas a los componentes visuales.
 *   - Establecer sobre los componentes visuales el valor de los diferentes campos de la entidad JPA gestionada
 *   - Leer la información de los componentes visuales y establecerla dentro de la entidad JPA gestionada.
 * 
 * @author R
 *
 */

public abstract class PanelGestionEntidadJPA extends JPanel {

	// Constantes que nos ayudan a asignar funciones a los botones de la barra de herramientas
	public static int LOAD_FIRST = 0;
	public static int LOAD_PREV = 1;
	public static int LOAD_NEXT = 2;
	public static int LOAD_LAST = 3;
	public static int NEW = 4;
	public static int SAVE = 5;
	public static int REMOVE = 6;

	// Métodos que debe implementar cualquier subtipo de esta clase
	
	// Getter de una entidad JPA gestionada en el panel
	public abstract Entidad getEntidadActualReflejadaEnPanel();
	// Setter de la entidad JPA gestionada en el panel
	protected abstract void setEntidadActualReflejadaEnPanel(Entidad e);
	// Getter del controlador JPA
	protected abstract Controlador getControladorJPA();
	// Obtiene un array con todos los componentes visuales: JTextField, JComboBox, etc. que gestionan campos de la entidad JPA
	protected abstract Component[] getComponentesVisuales();
	// Obtiene un array de etiquetas que acompañan a los componentes visuales anteriores
	protected abstract String[] getEtiquetasComponentesVisuales();
	// Establece los campos de la entidad JPA sobre los componentes visuales que los muestran
	protected abstract void cargarEntidadActualEnComponentesVisuales();
	// Obtiene la información contenida en los componentes visuales y se la establece a los campos de la entidad JPA gestionada
	protected abstract Entidad construirEntidadDesdeComponentesVisuales();
	
	
	// Necesario para que los JTextField no puedan quedar demasiado pequeños
	protected Dimension minimaDimensionJTextField = new Dimension (150, 20);

	
	/**
	 * Dispone todos los elementos sobre la pantalla. El panel principal tiene BorderLayout. El panel de los componentes visuales
	 * se obtiene por el método "getPanelGestion" y utiliza un GridBagLayout.
	 */
	public void maquetarPanel() {
		this.setLayout(new BorderLayout());
		this.add(getBarraHerramientas(), BorderLayout.NORTH);
		this.add(getPanelGestion(), BorderLayout.CENTER);
		
		// Incializo la navegación cargando en pantalla el primer registro de la tabla
		this.setEntidadActualReflejadaEnPanel(this.getControladorJPA().findFirst());
		cargarEntidadActualEnComponentesVisuales();
	}
	
	
	/**
	 * Crea y asigna funciones a los botones de la barra de herramientas
	 * Acaba devolviendo un objeto de tipo JToolBar.
	 * @return
	 */
	private JToolBar getBarraHerramientas() {
		JToolBar toolBar = new JToolBar();
		
		JButton jbtPrimero = new JButton();
		asignarFuncion(jbtPrimero, "gotostart.png", LOAD_FIRST);
		toolBar.add(jbtPrimero);

		JButton jbtPrevio = new JButton();
		asignarFuncion(jbtPrevio, "previous.png", LOAD_PREV);
		toolBar.add(jbtPrevio);

		JButton jbtSiguiente = new JButton();
		asignarFuncion(jbtSiguiente, "next.png", LOAD_NEXT);
		toolBar.add(jbtSiguiente);

		JButton jbtUltimo = new JButton();
		asignarFuncion(jbtUltimo, "gotoend.png", LOAD_LAST);
		toolBar.add(jbtUltimo);

		JButton jbtNuevo = new JButton();
		asignarFuncion(jbtNuevo, "nuevo.png", NEW);
		toolBar.add(jbtNuevo);

		JButton jbtGuardar = new JButton();
		asignarFuncion(jbtGuardar, "guardar.png", SAVE);
		toolBar.add(jbtGuardar);

		JButton jbtEliminar = new JButton();
		asignarFuncion(jbtEliminar, "eliminar.png", REMOVE);
		toolBar.add(jbtEliminar);

		return toolBar;
	}
	
	
	/**
	 * Asigna funciones a los diferentes botones, asociándolos con un método de esta clase
	 * @param jbt
	 * @param funcion
	 */
	private void asignarFuncion (JButton jbt, String icono, final int funcion) {
		jbt.setIcon(CacheImagenes.getCacheImagenes().getIcono(icono));
		jbt.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent arg0) {
				// De este proceso es posible que aparezca una nueva entidad JPA mantenida, que deberá 
				// mostrarse en los componentes visuales del panel
				Entidad obtenido = null;
				if (funcion == LOAD_FIRST) 
					obtenido = getControladorJPA().findFirst();
				if (funcion == LOAD_PREV) 
					obtenido = getControladorJPA().findPrevious(getEntidadActualReflejadaEnPanel());
				if (funcion == LOAD_NEXT) 
					obtenido = getControladorJPA().findNext(getEntidadActualReflejadaEnPanel());
				if (funcion == LOAD_LAST) 
					obtenido = getControladorJPA().findLast();
				if (funcion == NEW) 
					nuevo();
				if (funcion == SAVE) 
					guardar();
				if (funcion == REMOVE) 
					obtenido = eliminar();
				
				// Si, como resultado de un método, la entidad JPA gestionada debe actualizarse, se hace ahora
				if (obtenido != null) {
					// Sobrescribo la entidad JPA gestionada
					setEntidadActualReflejadaEnPanel(obtenido);
					// Muestro la entidad JPA gestionada en los componentes visuales
					cargarEntidadActualEnComponentesVisuales();
				}
			}});
	}

	
	/**
	 * Maqueta y devuelve un panel, con GridBagLayout, que contiene todos los componentes visuales que deben
	 * mostrar los campos de la entidad JPA gestionada
	 */
	private JPanel getPanelGestion () {
		JPanel panelGestion = new JPanel();
		panelGestion.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
	    c.insets = new Insets(5, 5, 5, 5); // márgenes para cada celda

	    // Incluyo cada uno de los componentes visuales, con sus correspondientes etiquetas
	    String[] etiquetasDeComponentes = getEtiquetasComponentesVisuales();
	    Component[] componentesVisuales = getComponentesVisuales();
	    
	    // Recorro los componentes visuales, poniéndolos en pantalla, en filas, junto con su correspondiente etiqueta
	    for (int i = 0; i < componentesVisuales.length; i++) {
	    	// Incluyo la etiqueta
	    	c.gridx = 0;
		    c.gridy = i;
		    c.anchor = GridBagConstraints.EAST;
		    panelGestion.add(new JLabel(etiquetasDeComponentes[i]), c);

		    // Incluyo el componente visual.
		    // Si es un JTextField, le establezco un tamaño mínimo
		    if (componentesVisuales[i] instanceof JTextField) {
		    	componentesVisuales[i].setMinimumSize(minimaDimensionJTextField);
		    }
			c.gridx = 1;
		    c.anchor = GridBagConstraints.WEST;
		    panelGestion.add(componentesVisuales[i], c);
	    }
	    // Devuelvo el panel ya montado
	    return panelGestion;
	}	
	
	
	/**
	 * Limpia los componentes visuales y avisa al usuario de que debe introducir valores para los mismos.
	 */
	private void nuevo () {
		limpiarComponentesVisuales();
		// Avisamos al usuario para introduzca los nuevos valores
		JOptionPane.showMessageDialog(this, "Por favor, introduzca los datos del nuevo registro");
	}
	

	/**
	 * Limpia los componentes visuales
	 */
	private void limpiarComponentesVisuales() {
		// Limpio los componentes visuales
		for (Component componente : getComponentesVisuales()) {
			// Si es un JTextField, su texto se establece a ""
			if (componente instanceof JTextField) {
				((JTextField) componente).setText("");
			}
			// Si es un JComboBox, se selecciona su primer elemento, si este existe.
			if (componente instanceof JComboBox) {
				JComboBox<Entidad> comboBox = ((JComboBox<Entidad>) componente);
				if (comboBox.getItemCount() > 0) {
					comboBox.setSelectedIndex(0);
				}
			}
		}
	}
	

	/**
	 * Almacena los valores de los componentes visuales dentro de una nueva entidad JPA. Esto lo
	 * debe hacer el método abstracto "construirEntidadDesdeComponentesVisuales" que debe implementar
	 * el subtipo de esta clase.
	 * A continuación, establece si se debe realizar un alta "persist" o una modificación "merge".
	 */
	private void guardar () {
		// Leo los componentes visuales y los introduzco en la nueva entidad JPA
		Entidad nuevaEntidad = construirEntidadDesdeComponentesVisuales();
		
		// Determino si se debe insertar o modificar la nueva entidad
		if (nuevaEntidad.getId() == 0) {
			CursoControlador.getInstancia().persist(nuevaEntidad);
		}
		else {
			CursoControlador.getInstancia().merge(nuevaEntidad);
		}
		
		// Actualizo la entidad JPA gestionada por el panel, sobrescribiédola con la nueva entida 
		// creada en este método.
		this.setEntidadActualReflejadaEnPanel(nuevaEntidad);
		// Muestro la entidad en los componentes visuales
		this.cargarEntidadActualEnComponentesVisuales();
		// Informo al usuario.
		JOptionPane.showMessageDialog(this, "Guardado correctamente");		
	}


	
	/**
	 * Pregunta al usuario si desea eliminar un registro, en caso afirmativo, se elimina, se selecciona
	 * un nuevo registro a mostrar en pantalla y se informa al usuario del resultado.
	 * @return
	 */
	private Entidad eliminar () {
		// Construyo un Diálogo nuevo con las posibles respuestas "Sí" y "No" para que el usuario elija
		// si realmente desea eliminar el registro.
		String respuestas[] = new String[] {"Sí", "No"};
		int opcionElegida = JOptionPane.showOptionDialog(null, 
				"¿Realmente desea eliminar el registro?", "Eliminación del registro", 
		        JOptionPane.OK_CANCEL_OPTION, 
		        JOptionPane.OK_CANCEL_OPTION, 
		        CacheImagenes.getCacheImagenes().getIcono("confirm.png"), 
		        respuestas, respuestas[1]);

		// En caso de que el usuario confirme la eliminación, determino cuál será la nueva entidad que
		// se mostrará en pantalla.
		Entidad nuevoAMostrarEnPanel = null;
		if(opcionElegida == 0) {
	    	// Si existe un registro anterior al actual, es ese el que cargo en el panel
	    	nuevoAMostrarEnPanel = this.getControladorJPA().findPrevious(this.getEntidadActualReflejadaEnPanel());
	    	if (nuevoAMostrarEnPanel == null) {
	    		// Si no existe un anterior, elijo un siguiente registro
	    		nuevoAMostrarEnPanel = this.getControladorJPA().findNext(this.getEntidadActualReflejadaEnPanel());
	    	}
	    	// Elimino el registro actual
	    	getControladorJPA().remove(this.getEntidadActualReflejadaEnPanel());
	    	// Informo al usuario
			JOptionPane.showMessageDialog(this, "Eliminación correcta");

			// Si no existe una entidad a mostrar en los componentes visuales, los limpio todos para poder
    		// introducir un nuevo registro.
			if (nuevoAMostrarEnPanel == null) {
	    		limpiarComponentesVisuales();
	    	}
	    }
	    // Devuelvo la nueva entidad a representar en el panel
	    return nuevoAMostrarEnPanel;
	}
	
	

}
