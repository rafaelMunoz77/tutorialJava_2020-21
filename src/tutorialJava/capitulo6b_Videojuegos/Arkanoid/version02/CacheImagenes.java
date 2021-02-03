package tutorialJava.capitulo6b_Videojuegos.Arkanoid.version02;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;

/**
 * Esta clase se utiliza como un almacén de ficheros de imagen. Para almacenar las imágenes utilizamos
 * un HashMap<String, BufferedImage>. Además esta clase incorpora un patrón Singleton
 * @author R
 *
 */
public class CacheImagenes {
	// HashMap que actúa como almacén de imágenes
	private HashMap<String, BufferedImage> sprites = new HashMap<String, BufferedImage>();
	
	// Instancia Singleton
	private static CacheImagenes instancia= null;
	
	
	/**
	 * Getter Singleton
	 * @return
	 */
	public static CacheImagenes getInstancia () {
		if (instancia == null) {
			instancia = new CacheImagenes();
		}
		return instancia;
	}

	
	/**
	 * Este método carga un fichero de imagen del sistema de ficheros y lo devuelve
	 * como un objeto de tipo BufferedImage
	 * @param nombre
	 * @return
	 */
	private BufferedImage cargarImagen (String nombre) {
		URL url=null;
		try {
			url = getClass().getResource(nombre);
			return ImageIO.read(url);
		} catch (Exception e) { // algo ha fallado, se acaba el programa si no podemos cargar alguna imagen
			e.printStackTrace();
			System.exit(0);
		}
		return null;
	}
	
	/**
	 * Método utilizado desde fuera de esta clase para permitir acceder a las imágenes. En primer lugar se 
	 * busca la imagen en el almacén, si no se encuentra se busca en el sistema de ficheros.
	 * @param nombre
	 * @return
	 */
	public BufferedImage getImagen(String nombre) {
		BufferedImage img = sprites.get(nombre);
		if (img == null) {
			img = cargarImagen("../res/"+nombre);
			sprites.put(nombre,img);
		}
		return img;
	}
}
