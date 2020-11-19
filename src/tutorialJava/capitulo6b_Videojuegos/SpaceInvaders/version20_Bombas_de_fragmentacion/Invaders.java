package tutorialJava.capitulo6b_Videojuegos.SpaceInvaders.version20_Bombas_de_fragmentacion;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
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
 * @author Rafael Muñoz Ruiz
 * 
 * Clase principal del juego, contiene la ventana y, al mismo tiempo, es el objeto Canvas sobre el que
 * se redibuja continuamente el juego. Tiene la lista de actores. Para el repintado de escena utiliza
 * la técnica de doble búffer, a través del objeto BufferStrategy
 *
 */
public class Invaders extends Canvas {
	// Ventana principal del juego
	JFrame ventana = new JFrame("Invaders");
	
	// Indicamos alto y ancho del objeto tipo Canvas
	private static final int JFRAME_WIDTH=640;
	private static final int JFRAME_HEIGHT=480;
	
	// Velocidad de los fotogramas, en concreto este indica que el proceso de redibujado dormirá 10 millis
	// tras haber repintado la escena
	public static final int SPEED_FPS=60;
	
	// Lista con todos los actores que intervienen en el videojuego
	private List<Actor> actors = new ArrayList<Actor>(); 
	// Lista con actores que deben incorporarse en la siguiente iteración del juego
	private List<Actor> newActorsForNextIteration = new ArrayList<Actor>();
	
	// BufferStrategy usado para conseguir la técnica de doble búffer
	private BufferStrategy strategy;
	private long usedTime; // Tiempo usado en cada iteración del bucle principal del juego.
	
	// Instancia para patrón Singleton
	private static Invaders instance = null;
	
	// Referencia que guardaremos apuntando al objeto de tipo Player
	Player player = null;
	
	
	/**
	 * Constructor: crea la ventana, obtiene una referencia al panel principal, introduce el Canvas en su interior
	 * y habilita y deshabilita varios comportamientos de la ventana
	 */
	public Invaders() {
		// Obtengo referencia al panel principal de la ventana
		JPanel panel = (JPanel) ventana.getContentPane();
		// Establezco una plantilla en el panel, para poder incorporar el Canvas
		panel.setLayout(new BorderLayout());
		// Agrego el Canvas al panel
		panel.add(this, BorderLayout.CENTER);
		// Dimensiono la ventana
		ventana.setBounds(0,0, JFRAME_WIDTH, JFRAME_HEIGHT);
		// Muestro la ventana en pantalla
		ventana.setVisible(true);
		// Desactivo el comportamiento por defecto al pulsar el botón de cierre de la ventana
		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// Agrego un escuchador a la ventana, para detectar el evento de cierre de la misma
		ventana.addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				cerrarAplicacion();
			}
		});
		// Con ignoreRepaint le decimos al JFrame que no debe repintarse cuando el Sistema Operativo se lo indique,
		// nosotros nos ocupamos totalmente del refresco de la pantalla
		ventana.setIgnoreRepaint(true);
		// El Canvas se dibujará en pantalla con una estrategia de doble búffer
		this.createBufferStrategy(2);
		// Obtengo una referencia a la estrategia de doble búffer.
		strategy = getBufferStrategy();
		// El foco de Windows irá al Canvas, para que directamente podamos controlar este juego a través del teclado
		this.requestFocus();		
	}
	
	/**
	 * Método de obtención de patrón Singleton
	 * @return
	 */
	public static Invaders getInstance () {
		if (instance == null) {
			instance = new Invaders();
		}
		return instance;
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
	 * Método con el que iniciamos la cantidad de actores que aparecen en el videojuego
	 */
	public void initWorld() {
		// Creo una oleada de 10 Monstruos
		for (int i = 0; i < 10; i++){
			Monster m = new Monster();
			m.setX((int)(Math.random() * (this.getWidth() - m.getWidth())) ); // Inicializo al azar la posición del eje horizontal del monstruo
			m.setY(i * 20); // Inicializo la posición en el eje vertical, escalonando los monstruos hacia abajo
			m.setVx((int)(Math.random() * (20 - 2) + 2)); // Inicio al azar la velocidad de cada monstruo en el eje horizontal, entre 2 y 20
			actors.add(m); // agrego el nuevo actor a la lista de actores del juego
		}
		
		// Agrego a la lista de jugadores al actor de tipo Player
		Player player = new Player();
		player.setX(100);
		player.setY(100);
		this.actors.add(player);
		// Mantengo una referencia al Player
		this.player = player;
		// Agrego un listener para eventos de teclado y, cuando se produzcan, los derivo al objeto de tipo Player
		this.addKeyListener(player);

	}
	
	/**
	 * Este método actualiza la posición y valores de los diferentes actores del juego, se ejecuta en cada iteración.
	 */
	public void updateWorld() {
		// Puede ocurrir que existan actores que se deben eliminar para el siguiente pintado de escena.
		// Cuando estoy recorriendo una lista no puedo eliminar elementos sin arriesgarme a provocar un problema de
		// concurrencia de acceso. Por ello lo que hago es crear una nueva lista con los elementos a eliminar. Después
		// se recorre esa lista eliminando los elementos de la lista principal y, por último, limpio la lista
		List<Actor> actorsForRemoval = new ArrayList<Actor>();
		for (Actor actor : this.actors) {
			if (actor.isMarkedForRemoval()) {
				actorsForRemoval.add(actor);
			}
		}
		// Elimino los actores marcados para su eliminación
		for (Actor actor : actorsForRemoval) {
			this.actors.remove(actor);
		}
		// Limpio la lista de actores para eliminar
		actorsForRemoval.clear();
		
		// Además de eliminar actores, también puede haber actores nuevos que se deban insertar en la siguiente iteración.
		// Se insertan y después se limpia la lista de nuevos actores a insertar
		this.actors.addAll(newActorsForNextIteration);
		this.newActorsForNextIteration.clear();

		// Finalmente, se llama al método "act" de cada actor, para que cada uno recalcule por si mismo sus valores.
		for (Actor actor : this.actors) {
			actor.act();
		}
	}
	
	/**
	 * Método responsable del pintado de toda la escena, se ejecuta una vez por cada ciclo del programa
	 */
	public void paintWorld() {
		// Resuelve un problema de sincronización de memoria de vídeo en Linux
		Toolkit.getDefaultToolkit().sync();
		// Obtengo el objeto gráfico que me permita pintar en el doble búffer
		Graphics2D g = (Graphics2D)strategy.getDrawGraphics();
		// Pinto un rectángulo negro que ocupe toda la escena
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		// Para cada actor del juego, le pido que se pinte a sí mismo
		for (Actor actor : this.actors) {
			actor.paint(g);
		}
		strategy.show();
	}
	
	/**
	 * Método principal del juego, con el bucle contínuo que refresca el mismo en cada FPS
	 */
	public void game() {
		// Inicialización del juego
		initWorld();
		
		// El bucle se ejecutará mientras el objeto Canvas sea visible
		while (isVisible()) {
			long startTime = System.currentTimeMillis(); // Tomo el tiempo, en millis, antes de crear el siguiente Frame del juego
			// actualizo y pinto la escena
			updateWorld(); 
			paintWorld();
			// Calculo el tiempo que se ha tardado en la ejecución
			usedTime = System.currentTimeMillis()-startTime;
			// Hago que el bucle pare una serie de millis, antes de generar el siguiente FPS
			// El cálculo hecho "duerme" el proceso para no generar más de los SPEED_FPS que se haya específicado
			try { 
				int millisToSleep = (int) (1000/SPEED_FPS - usedTime);
				if (millisToSleep < 0) {
					millisToSleep = 0;
				}
				Thread.sleep(millisToSleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * @param newActor
	 */
	public void addNewActorToNextIteration (Actor newActor) {
		this.newActorsForNextIteration.add(newActor);
	}
	
	// Getters y Setters
	public Player getPlayer() { return player; }
	public void setPlayer(Player player) { this.player = player; }

	
	
	/**
	 * Método principal del juego
	 * @param args
	 */
	public static void main(String[] args) {
		Invaders.getInstance().game();
	}

}
