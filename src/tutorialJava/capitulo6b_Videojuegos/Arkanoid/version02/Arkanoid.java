package tutorialJava.capitulo6b_Videojuegos.Arkanoid.version02;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Clase principal del programa, actúa como la ventana que verá el usuario. Se utiliza un patrón Singleton
 * @author R
 *
 */
public class Arkanoid extends Canvas {
	// Variables estáticas
	public static final int ANCHO = 400;
	public static final int ALTO = 600;
	public static final int FPS = 101; // Frames por segundo
	// Ventana
	JFrame ventana = null;
	// Lista de actores que se representan en pantalla
	List<Actor> actores = new ArrayList<Actor>();
	// Estrategia de Doble Buffer
	private BufferStrategy strategy;
	// Variable para patrón Singleton
	private static Arkanoid instancia = null;
	
	/**
	 * Getter Singleton
	 * @return
	 */
	public static Arkanoid getInstancia () {
		if (instancia == null) {
			instancia = new Arkanoid();
		}
		return instancia;
	}
	
	
	
	/**
	 * Constructor
	 */
	public Arkanoid() {
		// Creación de la ventana
		ventana = new JFrame("Arkanoid");
		// Obtenemos el panel principal del JFrame
		JPanel panel = (JPanel) ventana.getContentPane();
		// Utilizo un BorderLayout para colocar el Canvas sobre el JPanel
		panel.setLayout(new BorderLayout());
		// Agregamos el Canvas al panel de manera que ocupe todo el espacio disponible
		panel.add(this, BorderLayout.CENTER);
		// Dimensionamos el JFrame
		ventana.setBounds( 0, 0, ANCHO, ALTO);
		// Hacemos el JFrame visible
		ventana.setVisible(true);
		// Con el siguiente código preguntamos al usuario si realmente desea cerrar la aplicación, cuando
		// pulse sobre el aspa de la ventana
		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ventana.addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				cerrarAplicacion();
			}
		});
		// Creación de la estrategia de doble búffer
		this.createBufferStrategy(2);
		strategy = this.getBufferStrategy();
		// Con ignoreRepaint le decimos al JFrame que no debe repintarse cuando el Sistema Operativo se lo indique,
		// nosotros nos ocupamos totalmente del refresco de la pantalla
		ventana.setIgnoreRepaint(true);
		// La ventana no podrá redimensionarse
		ventana.setResizable(false);
		// Hacemos que el Canvas obtenga automáticamente el foco del programa para que, si se pulsa una tecla, la pulsación
		// se transmita directamente al Canvas.
		this.requestFocus();
		// Para resolver un problema de sincronización con la memoria de vídeo de Linux, utilizamos esta línea
		Toolkit.getDefaultToolkit().sync();
	}
	
	

	/**
	 * Al cerrar la aplicación preguntaremos al usuario si está seguro de que desea salir.
	 */
	private void cerrarAplicacion() {
		String [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(ventana,"¿Desea cerrar la aplicación?","Salir de la aplicación",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	
	
	/**
	 * Al principio del juego, lo primero que se debe hacer es inicializar todo lo necesario para que se pueda mostrar
	 * la primera fase.
	 */
	public void initWorld() {
		// Preparación de la primera fase
		Fase fase = new Fase01();
		fase.inicializaFase();
		// Agregamos los actores de la primera fase a nuestro juego
		this.actores.clear();
		this.actores.addAll(fase.getActores());
		
		// Creación de los actores Nave y Bola
	    this.actores.add(new Nave());
	    this.actores.add(new Bola());
	}
		

	/**
	 * Cada vez que actualicemos el juego se llamará a este método	
	 */
	public void updateWorld() {
		// Actualización de todos los actores
		for (Actor actor : this.actores) {
			actor.act();
		}
	}
		
	
	/**
	 * Método responsable de repintar cada frame del juego
	 */
	public void paintWorld() {
		// Obtenemos el objeto Graphics (la brocha) desde la estrategia de doble búffer
		Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
		// Lo primero que hace cada frame es pintar un rectángulo tan grande como la escena,
		// para superponer la escena anterior.
		g.setColor(Color.black);
		g.fillRect( 0, 0, getWidth(), getHeight());

		// Ejecutamos el método paint de cada uno de los actores
		for (Actor actor : this.actores) {
			actor.paint(g);
		}
		// Una vez construida la escena nueva, la mostramos.
		strategy.show();
	}
	
	
	/**
	 * Método principal del juego. Contiene el bucle principal
	 */
	public void game() {
		// Inicialización del juego
		initWorld();
		// Este bucle se ejecutará mientras el objeto Canvas sea visible.
		while (this.isVisible()) {
			// Tomamos el tiempo en milisegundos antes de repintar el frame
			long millisAntesDeConstruirEscena = System.currentTimeMillis();
			// Actualizamos y pintamos el nuevo frame
			updateWorld();
			paintWorld();
			// Calculamos la cantidad de milisegundos que se ha tardado en realizar un nuevo frame del juego
			int millisUsados = (int) (System.currentTimeMillis() - millisAntesDeConstruirEscena);
			// Hago que el programa duerma lo suficiente para que realmente se ejecuten la cantidad de FPS
			// que tenemos programados
			try { 
				int millisADetenerElJuego = 1000 / FPS - millisUsados;
				if (millisADetenerElJuego >= 0) {
					 Thread.sleep(millisADetenerElJuego);
				}
			} catch (InterruptedException e) {}
		}
	}
	
	
	/**
	 * Método main()
	 * @param args
	 */
	public static void main(String[] args) {
		Arkanoid.getInstancia().game();
	}
}
