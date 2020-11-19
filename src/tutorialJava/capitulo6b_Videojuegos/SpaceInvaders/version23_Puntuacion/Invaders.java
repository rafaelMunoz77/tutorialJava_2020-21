package tutorialJava.capitulo6b_Videojuegos.SpaceInvaders.version23_Puntuacion;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 * @author Rafael Mu�oz Ruiz
 * 
 * Clase principal del juego, contiene la ventana y, al mismo tiempo, es el objeto Canvas sobre el que
 * se redibuja continuamente el juego. Tiene la lista de actores. Para el repintado de escena utiliza
 * la t�cnica de doble b�ffer, a trav�s del objeto BufferStrategy
 *
 */
public class Invaders extends Canvas {
	// Ventana principal del juego
	JFrame ventana = new JFrame("Invaders");
	
	// Indicamos alto y ancho del objeto tipo Canvas
	private static final int JFRAME_WIDTH=640;
	private static final int JFRAME_HEIGHT=480;
	
	// Velocidad de los fotogramas, en concreto este indica que el proceso de redibujado dormir� 10 millis
	// tras haber repintado la escena
	public static final int SPEED_FPS=60;
	
	// Lista con todos los actores que intervienen en el videojuego
	private List<Actor> actors = new ArrayList<Actor>(); 
	// Lista con actores que deben incorporarse en la siguiente iteraci�n del juego
	private List<Actor> newActorsForNextIteration = new ArrayList<Actor>();
	
	// BufferStrategy usado para conseguir la t�cnica de doble b�ffer
	private BufferStrategy strategy;
	private long usedTime; // Tiempo usado en cada iteraci�n del bucle principal del juego.
	
	// Instancia para patr�n Singleton
	private static Invaders instance = null;
	
	// Referencia que guardaremos apuntando al objeto de tipo Player
	private Player player = null;
	
	// Para establecer el lugar que ocupa la barra de estado, necesitamos tener una referencia de hasta d�nde llega
	// la zona vertical de juego y d�nde empieza la barra de estado
	private int YforStatusBar = 0;
	
	
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
		// Desactivo el comportamiento por defecto al pulsar el bot�n de cierre de la ventana
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
		// El Canvas se dibujar� en pantalla con una estrategia de doble b�ffer
		this.createBufferStrategy(2);
		// Obtengo una referencia a la estrategia de doble b�ffer.
		strategy = getBufferStrategy();
		// El foco de Windows ir� al Canvas, para que directamente podamos controlar este juego a trav�s del teclado
		this.requestFocus();		
	}
	
	/**
	 * M�todo de obtenci�n de patr�n Singleton
	 * @return
	 */
	public static Invaders getInstance () {
		if (instance == null) {
			instance = new Invaders();
		}
		return instance;
	}
	
	/**
	 * Al cerrar la aplicaci�n preguntaremos al usuario si est� seguro de que desea salir.
	 */
	private void cerrarAplicacion() {
		String [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(ventana,"�Desea cerrar la aplicaci�n?","Salir de la aplicaci�n",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	
	/**
	 * M�todo con el que iniciamos la cantidad de actores que aparecen en el videojuego
	 */
	public void initWorld() {
		// Creo una oleada de 10 Monstruos
		for (int i = 0; i < 10; i++){
			Monster m = new Monster();
			m.setX((int)(Math.random() * (this.getWidth() - m.getWidth())) ); // Inicializo al azar la posici�n del eje horizontal del monstruo
			m.setY(i * 20); // Inicializo la posici�n en el eje vertical, escalonando los monstruos hacia abajo
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
	 * Este m�todo actualiza la posici�n y valores de los diferentes actores del juego, se ejecuta en cada iteraci�n.
	 */
	public void updateWorld() {
		// Puede ocurrir que existan actores que se deben eliminar para el siguiente pintado de escena.
		// Cuando estoy recorriendo una lista no puedo eliminar elementos sin arriesgarme a provocar un problema de
		// concurrencia de acceso. Por ello lo que hago es crear una nueva lista con los elementos a eliminar. Despu�s
		// se recorre esa lista eliminando los elementos de la lista principal y, por �ltimo, limpio la lista
		List<Actor> actorsForRemoval = new ArrayList<Actor>();
		for (Actor actor : this.actors) {
			if (actor.isMarkedForRemoval()) {
				actorsForRemoval.add(actor);
			}
		}
		// Elimino los actores marcados para su eliminaci�n
		for (Actor actor : actorsForRemoval) {
			this.actors.remove(actor);
		}
		// Limpio la lista de actores para eliminar
		actorsForRemoval.clear();
		
		// Adem�s de eliminar actores, tambi�n puede haber actores nuevos que se deban insertar en la siguiente iteraci�n.
		// Se insertan y despu�s se limpia la lista de nuevos actores a insertar
		this.actors.addAll(newActorsForNextIteration);
		this.newActorsForNextIteration.clear();

		// Finalmente, se llama al m�todo "act" de cada actor, para que cada uno recalcule por si mismo sus valores.
		for (Actor actor : this.actors) {
			actor.act();
		}
		
		// Una vez que cada actor ha actuado, intento detectar colisiones entre los actores y notificarlas. Para detectar
		// estas colisiones, no nos queda m�s remedio que intentar detectar la colisi�n de cualquier actor con cualquier otro
		// s�lo con la excepci�n de no comparar un actor consigo mismo.
		// La detecci�n de colisiones se va a baser en formar un rect�ngulo con las medidas que ocupa cada actor en pantalla,
		// De esa manera, las colisiones se traducir�n en intersecciones entre rect�ngulos.
		for (Actor actor1 : this.actors) {
			// No comprobar� colisiones con actores que han sido marcados para su eliminaci�n
			if (!actor1.isMarkedForRemoval()) {
				// Creo un rect�ngulo para este actor.
				Rectangle rect1 = new Rectangle(actor1.getX(), actor1.getY(), actor1.getWidth(), actor1.getHeight());
				// Compruebo un actor con cualquier otro actor
				for (Actor actor2 : this.actors) {
					// Evito comparar un actor consigo mismo, ya que eso siempre provocar�a una colisi�n y no tiene sentido
					// Adem�s tambi�n se debe evitar trabajar con actores que han sido marcados para ser eliminados
					if (!actor1.equals(actor2) && !actor2.isMarkedForRemoval()) {
						// Formo el rect�ngulo del actor 2
						Rectangle rect2 = new Rectangle(actor2.getX(), actor2.getY(), actor2.getWidth(), actor2.getHeight());
						// Si los dos rect�ngulos tienen alguna intersecci�n, notifico una colisi�n en los dos actores
						if (rect1.intersects(rect2)) {
							actor1.collisionWith(actor2); // El actor 1 colisiona con el actor 2
							actor2.collisionWith(actor1); // El actor 2 colisiona con el actor 1
						}
					}
				}
			}
		}
	}
	
	/**
	 * M�todo responsable del pintado de toda la escena, se ejecuta una vez por cada ciclo del programa
	 */
	public void paintWorld() {
		// Resuelve un problema de sincronizaci�n de memoria de v�deo en Linux
		Toolkit.getDefaultToolkit().sync();
		// Obtengo el objeto gr�fico que me permita pintar en el doble b�ffer
		Graphics2D g = (Graphics2D)strategy.getDrawGraphics();
		// Pinto un rect�ngulo negro que ocupe toda la escena
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		// Para cada actor del juego, le pido que se pinte a s� mismo
		for (Actor actor : this.actors) {
			actor.paint(g);
		}
		
		// Pinto la barra de estado, para lo que necesito conocer el alto del juego
		YforStatusBar = this.getHeight() - 25;
		this.paintStatus(g);
		
		// Muestro la imagen de b�ffer que acabo de crear
		strategy.show();
	}

	
	/**
	 * Pinta la barra de estado completa del videojuego
	 * @param g
	 */
	public void paintStatus(Graphics2D g) {
	  paintScore(g);
	  paintShields(g);
	  paintAmmo(g);
	}
	

	/**
	 * Pinta una barra de progreso que cambia de color cuando el jugador va perdiendo vida
	 * @param g
	 */
	public void paintShields(Graphics2D g) {
		// Se pinta en rojo un rect�ngulo con toda la vida disponible
		g.setPaint(Color.red);
		g.fillRect(280, YforStatusBar, Player.MAX_SHIELDS, 20);
		// En azul pinta un rect�ngulo con los puntos de vida actuales 
		g.setPaint(Color.blue);
		g.fillRect(280 + Player.MAX_SHIELDS - player.getShields(), YforStatusBar, player.getShields(), 20);
		// En verde se pinta un texto con la cantidad de puntos de vida actuales
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.setPaint(Color.green);
		g.drawString("Shields", 170, YforStatusBar + 20);
    	
	}
    
	/**
	 * Pinta la puntuaci�n del jugador
	 * @param g
	 */
	public void paintScore(Graphics2D g) {
		// En verde pinta el texto "Score:"
		g.setFont(new Font("Arial", Font.BOLD,20));
		g.setPaint(Color.green);
		g.drawString("Score:", 20, YforStatusBar + 20);
		// En rojo pinta una cadena de texto con la puntuaci�n conseguida
		g.setPaint(Color.red);
		g.drawString(player.getScore() + "", 100, YforStatusBar + 20);
	}
	
	/**
	 * Pinta un peque�o icono de bomba para cada bomba que a�n podemos disparar
	 * @param g
	 */
	public void paintAmmo(Graphics2D g) {
		int xBase = 280 + Player.MAX_SHIELDS + 10;
		for (int i = 0; i < player.getRemainingBombs(); i++) {
			BufferedImage bomb = SpritesRepository.getInstance().getSprite("bombUL.gif");
			g.drawImage(bomb, xBase + i * bomb.getWidth() , YforStatusBar, this);
		}
	}
	
	
	
	/**
	 * M�todo principal del juego, con el bucle cont�nuo que refresca el mismo en cada FPS
	 */
	public void game() {
		// Inicializaci�n del juego
		initWorld();
		
		// El bucle se ejecutar� mientras el objeto Canvas sea visible
		while (isVisible()) {
			long startTime = System.currentTimeMillis(); // Tomo el tiempo, en millis, antes de crear el siguiente Frame del juego
			// actualizo y pinto la escena
			updateWorld(); 
			paintWorld();
			// Calculo el tiempo que se ha tardado en la ejecuci�n
			usedTime = System.currentTimeMillis()-startTime;
			// Hago que el bucle pare una serie de millis, antes de generar el siguiente FPS
			// El c�lculo hecho "duerme" el proceso para no generar m�s de los SPEED_FPS que se haya espec�ficado
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
	 * M�todo principal del juego
	 * @param args
	 */
	public static void main(String[] args) {
		Invaders.getInstance().game();
	}

}
