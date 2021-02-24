package tutorialJava.modelosBasesDeDatosComunesJPA.evaluacionCentroEducativo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the valoracionmateria database table.
 * 
 */
@Entity
@NamedQuery(name="ValoracionMateria.findAll", query="SELECT v FROM ValoracionMateria v")
public class ValoracionMateria extends tutorialJava.modelosBasesDeDatosComunesJPA.Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private float valoracion;

	//bi-directional many-to-one association to Estudiante
	@ManyToOne
	@JoinColumn(name="idEstudiante")
	private Estudiante estudiante;

	//bi-directional many-to-one association to Materia
	@ManyToOne
	@JoinColumn(name="idMateria")
	private Materia materia;

	//bi-directional many-to-one association to Profesor
	@ManyToOne
	@JoinColumn(name="idProfesor")
	private Profesor profesor;

	public ValoracionMateria() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getValoracion() {
		return this.valoracion;
	}

	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}

	public Estudiante getEstudiante() {
		return this.estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Materia getMateria() {
		return this.materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

}