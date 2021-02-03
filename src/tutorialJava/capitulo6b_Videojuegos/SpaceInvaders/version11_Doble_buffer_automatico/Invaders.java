package tutorialJava.capitulo6b_Videojuegos.SpaceInvaders.version11_Doble_buffer_automatico;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Rafael Carlos Mu�oz Ruiz
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
	
	// Velocidad de los fotogramas, en concreto este indica que el proceso de redibujado dormir� 20 millis
	// tras haber repintado la escena
	public static final int TIME_TO_SLEEP=20;
	
	// BufferStrategy usado para conseguir la t�cnica de doble b�ffer
	private BufferStrategy strategy;

	private int monsterX = 0, monsterY = 100; // Coordenadas en las que se encuentra el monstruo
	private int monsterSpeed = 2; // Velocidad a la que se mueve el monstruo sobre la pantalla
	
	// El almacen de im�genes se mapear� con un objeto de tipo HashMap<String, BufferedImage>
	// En este tipo de HashMap todas las claves (keys) ser�n de tipo String y todas los objetos
	// almacenados ser�n de tipo BufferedImage
	private HashMap<String, BufferedImage> sprites = new HashMap<String, BufferedImage>();
	
	// Carpeta en la que se encuentran los recursos: im�genes, sonidos, etc.
	private static String RESOURCES_FOLDER = "../res/";

	// Instancia para patr�n Singleton
	private static Invaders instance = null;
	
	
	
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
	 * Este m�todo actualiza la posici�n y valores de los diferentes actores del juego, se ejecuta en cada iteraci�n.
	 */
	public void updateWorld() {
		this.monsterX += this.monsterSpeed; // Actualizo la posici�n del monstruo
		// Si el monstruo sale del canvas, cambio de signo la velocidad que sigue, para provocar un cambio de sentido
		if (this.monsterX < 0 || this.monsterX > this.getWidth()) {
			this.monsterSpeed = -this.monsterSpeed;
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
		// Pinto el monstruo en la posici�n que le corresponde
		g.drawImage(getSprite("bicho.gif"), monsterX, monsterY,this);
		// Muestro en pantalla el buffer con el nuevo frame creado para el juego
		strategy.show();
	}
	
	/**
	 * M�todo principal del juego, con el bucle cont�nuo que refresca el mismo en cada FPS
	 */
	public void game() {
		// El bucle se ejecutar� mientras el objeto Canvas sea visible
		while (this.isVisible()) {
			// actualizo y pinto la escena
			updateWorld(); 
			paintWorld();
			// Hago que el bucle pare una serie de millis, antes de generar el siguiente FPS
			try { 
				int millisToSleep = (int) (TIME_TO_SLEEP);
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
	 * Realiza la carga de un recurso del disco duro, dentro de un objeto de tipo BufferedImgae
	 * @param nombre
	 * @return
	 */
	private BufferedImage loadImage(String resourceName) {
		// Para localizar el archivo se utiliza un objeto de tipo URL
		URL url=null;
		
		// Se intenta cargar el recurso del disco duro, si no se pudiera se capturar� la excepci�n y se
		// mostrar� un mensaje en pantalla
		try {
			url = getClass().getResource(resourceName);
			return ImageIO.read(url);
		} catch (Exception e) {
			// Aqu� dentro capturamos y tratamos el error que pueda haberse ocasionado
			System.out.println("No se pudo cargar la imagen " + resourceName +" de "+url);
			System.out.println("El error fue : "+e.getClass().getName()+" "+e.getMessage());
			System.exit(0); // Fin del programa
		}
		return null; // S�lo se llegar� a esta l�nea si no se ha podido cargar el recurso correctamente
	}
	
	/**
	 * M�todo para obtener una imagen.
	 * @param nombre
	 * @return
	 */
	public BufferedImage getSprite(String resourceName) {
		// En primera instancia intentamos obtener el objeto BufferedImage a partir del HashMap.
		BufferedImage img = sprites.get(resourceName);
		
		// En caso de que el objeto BufferedImage no exista dentro del HashMap, se carga desde el disco duro
		if (img == null) {
			img = loadImage(RESOURCES_FOLDER + resourceName);
			// Una vez que cargo el recurso en la memoria, lo agrego al HashMap, as� no habr� que volver a 
			// buscarlo en el disco duro. Como "clave" del objeto en el HashMap utilizo el nombre del fichero
			sprites.put(resourceName, img);
		}
		return img;
	}	
	
	/**
	 * M�todo principal del juego
	 * @param args
	 */
	public static void main(String[] args) {
		Invaders.getInstance().game();
	}
}
