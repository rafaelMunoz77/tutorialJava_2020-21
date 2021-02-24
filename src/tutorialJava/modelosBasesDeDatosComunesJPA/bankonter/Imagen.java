package tutorialJava.modelosBasesDeDatosComunesJPA.bankonter;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the imagen database table.
 * 
 */
@Entity
@NamedQuery(name="Imagen.findAll", query="SELECT i FROM Imagen i")
public class Imagen extends tutorialJava.modelosBasesDeDatosComunesJPA.Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Lob
	private byte[] contenido;

	@Lob
	private byte[] miniatura;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="imagen")
	private List<Usuario> usuarios;

	public Imagen() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getContenido() {
		return this.contenido;
	}

	public void setContenido(byte[] contenido) {
		this.contenido = contenido;
	}

	public byte[] getMiniatura() {
		return this.miniatura;
	}

	public void setMiniatura(byte[] miniatura) {
		this.miniatura = miniatura;
	}

	
	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setImagen(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setImagen(null);

		return usuario;
	}

}