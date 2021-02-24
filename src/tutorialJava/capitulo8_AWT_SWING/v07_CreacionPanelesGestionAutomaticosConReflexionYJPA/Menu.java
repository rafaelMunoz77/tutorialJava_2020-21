package tutorialJava.capitulo8_AWT_SWING.v07_CreacionPanelesGestionAutomaticosConReflexionYJPA;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import tutorialJava.modelosBasesDeDatosComunesJPA.evaluacionCentroEducativo.Curso;
import tutorialJava.modelosBasesDeDatosComunesJPA.evaluacionCentroEducativo.Estudiante;
import tutorialJava.modelosBasesDeDatosComunesJPA.evaluacionCentroEducativo.Materia;
import tutorialJava.modelosBasesDeDatosComunesJPA.evaluacionCentroEducativo.Profesor;
import tutorialJava.modelosBasesDeDatosComunesJPA.evaluacionCentroEducativo.TipologiaSexo;
import tutorialJava.modelosBasesDeDatosComunesJPA.evaluacionCentroEducativo.ValoracionMateria;
import tutorialJava.modelosBasesDeDatosComunesJPA.evaluacionCentroEducativo.controladores.CursoControlador;
import tutorialJava.modelosBasesDeDatosComunesJPA.evaluacionCentroEducativo.controladores.EstudianteControlador;
import tutorialJava.modelosBasesDeDatosComunesJPA.evaluacionCentroEducativo.controladores.MateriaControlador;
import tutorialJava.modelosBasesDeDatosComunesJPA.evaluacionCentroEducativo.controladores.ProfesorControlador;
import tutorialJava.modelosBasesDeDatosComunesJPA.evaluacionCentroEducativo.controladores.TipologiaSexoControlador;
import tutorialJava.modelosBasesDeDatosComunesJPA.evaluacionCentroEducativo.controladores.ValoracionMateriaControlador;

public class Menu extends JMenuBar {

	/**
	 * 
	 */
	public Menu() {
		// Menú Archivo de la aplicación
		JMenu menuArchivo = new JMenu("Entidades");

		menuArchivo.add(crearMenuItemLanzamientoPanelGestionComoJDialog("Gestion Profesores con PanelGestionEntidadJPA", new PanelGestionProfesor()));
		menuArchivo.addSeparator();
		menuArchivo.add(crearMenuItemLanzamientoPanelGestionComoJDialog("Gestión \"Tipologías de sexo\" con reflexión", 
				new PanelGestionEntidadJPAConReflexion(TipologiaSexo.class, TipologiaSexoControlador.getInstancia())));
		menuArchivo.add(crearMenuItemLanzamientoPanelGestionComoJDialog("Gestión \"Cursos\" con reflexión", 
				new PanelGestionEntidadJPAConReflexion(Curso.class, CursoControlador.getInstancia())));
		menuArchivo.add(crearMenuItemLanzamientoPanelGestionComoJDialog("Gestión \"Materias\" con reflexión", 
				new PanelGestionEntidadJPAConReflexion(Materia.class, MateriaControlador.getInstancia())));
		menuArchivo.add(crearMenuItemLanzamientoPanelGestionComoJDialog("Gestión \"Estudiantes\" con reflexión", 
				new PanelGestionEntidadJPAConReflexion(Estudiante.class, EstudianteControlador.getInstancia())));
		menuArchivo.add(crearMenuItemLanzamientoPanelGestionComoJDialog("Gestión \"Profesores\" con reflexión", 
				new PanelGestionEntidadJPAConReflexion(Profesor.class, ProfesorControlador.getInstancia())));
		menuArchivo.add(crearMenuItemLanzamientoPanelGestionComoJDialog("Gestión \"Valoraciones - Calificaciones\" con reflexión", 
				new PanelGestionEntidadJPAConReflexion(ValoracionMateria.class, ValoracionMateriaControlador.getInstancia())));
		
		this.add(menuArchivo);
	}
	
	
	/**
	 * 
	 * @param titulo
	 * @param bounds
	 * @param panel
	 * @return
	 */
	private JMenuItem crearMenuItemLanzamientoPanelGestionComoJDialog (String titulo, JPanel panel) {
		JMenuItem mi = new JMenuItem(titulo);
		mi.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialogo = new JDialog();
				// El usuario no puede redimensionar el diálogo
				dialogo.setResizable(true);
				// título del díalogo
				dialogo.setTitle(titulo);
				// Introducimos el panel creado sobre el diálogo
				dialogo.setContentPane(panel);
				// Empaquetar el diálogo hace que todos los componentes ocupen el espacio que deben y el lugar adecuado
				dialogo.pack();
				// El usuario no puede hacer clic sobre la ventana padre, si el Diálogo es modal
				dialogo.setModal(true);
				// Centro el diálogo en pantalla
				dialogo.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - dialogo.getWidth()/2, 
						(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - dialogo.getHeight()/2);
				// Muestro el diálogo en pantalla
				dialogo.setVisible(true);
			}
		});
		return mi;
	}

}
