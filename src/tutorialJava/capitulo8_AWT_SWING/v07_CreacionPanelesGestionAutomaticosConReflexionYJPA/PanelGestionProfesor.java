package tutorialJava.capitulo8_AWT_SWING.v07_CreacionPanelesGestionAutomaticosConReflexionYJPA;

import java.awt.Component;

import javax.swing.JTextField;

import tutorialJava.modelosBasesDeDatosComunesJPA.Controlador;
import tutorialJava.modelosBasesDeDatosComunesJPA.Entidad;
import tutorialJava.modelosBasesDeDatosComunesJPA.evaluacionCentroEducativo.Profesor;
import tutorialJava.modelosBasesDeDatosComunesJPA.evaluacionCentroEducativo.controladores.ProfesorControlador;

public class PanelGestionProfesor extends PanelGestionEntidadJPA {

	// Entidad gestionada por este panel
	Profesor profesorActual;
	// Componentes visuales de la gestión de la entidad
	private JTextField jtfId = new JTextField(5);
	private JTextField jtfNombre = new JTextField(20);
	private JTextField jtfPrimerApellido = new JTextField(20);
	private JTextField jtfSegundoApellido = new JTextField(20);
	private JTextField jtfDni = new JTextField(20);
	private JTextField jtfDireccion = new JTextField(20);
	private JTextField jtfEmail = new JTextField(20);
	private JTextField jtfTelefono = new JTextField(20);
	

	public PanelGestionProfesor() {
		super();
		// Configuración sobre los controles del panel actual
		this.jtfId.setEnabled(false);
		// Maquetación del supertipo
		this.maquetarPanel();
	}

	@Override
	public Entidad getEntidadActualReflejadaEnPanel() {
		return this.profesorActual;
	}

	@Override
	protected void setEntidadActualReflejadaEnPanel(Entidad e) {
		this.profesorActual = (Profesor) e;
	}

	@Override
	protected Controlador getControladorJPA() {
		return ProfesorControlador.getInstancia();
	}

	@Override
	protected void cargarEntidadActualEnComponentesVisuales() {
		this.jtfId.setText("" + this.profesorActual.getId());
		this.jtfNombre.setText(this.profesorActual.getNombre());
		this.jtfPrimerApellido.setText(this.profesorActual.getPrimerApellido());
		this.jtfSegundoApellido.setText(this.profesorActual.getSegundoApellido());
		this.jtfDni.setText(this.profesorActual.getDni());
		this.jtfDireccion.setText(this.profesorActual.getDireccion());
		this.jtfEmail.setText(this.profesorActual.getEmail());
		this.jtfTelefono.setText(this.profesorActual.getTelefono());
	}

	@Override
	protected Entidad construirEntidadDesdeComponentesVisuales() {
		Profesor entidadRepresentada = new Profesor();
		
		// Leo el identificador de la entidad
		if (this.jtfId.getText().trim().equals("")) 
			entidadRepresentada.setId(0);
		else 
			entidadRepresentada.setId(Integer.parseInt(this.jtfId.getText()));
		// Leo el resto de los campos de la entidad
		entidadRepresentada.setNombre(this.jtfNombre.getText());
		entidadRepresentada.setPrimerApellido(this.jtfPrimerApellido.getText());
		entidadRepresentada.setSegundoApellido(this.jtfSegundoApellido.getText());
		entidadRepresentada.setDni(this.jtfDni.getText());
		entidadRepresentada.setDireccion(this.jtfDireccion.getText());
		entidadRepresentada.setEmail(this.jtfEmail.getText());
		entidadRepresentada.setTelefono(this.jtfTelefono.getText());

		return entidadRepresentada;
	}

	@Override
	protected String[] getEtiquetasComponentesVisuales() {
		return new String[] {"Identificador:", "Nombre:", "Primer apellido:", "Segundo apellido:", "DNI:", "Dirección:", "Email:", "Teléfono:"};
	}

	@Override
	protected Component[] getComponentesVisuales() {
		return new Component[] {this.jtfId, this.jtfNombre, this.jtfPrimerApellido, this.jtfSegundoApellido, 
				this.jtfDni, this.jtfDireccion, this.jtfEmail, this.jtfTelefono};
	}

}
