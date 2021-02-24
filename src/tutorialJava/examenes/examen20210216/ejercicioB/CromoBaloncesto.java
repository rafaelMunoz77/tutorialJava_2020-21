package tutorialJava.examenes.examen20210216.ejercicioB;

public class CromoBaloncesto {

	Integer id;
	String nombre;
	int puntos;
	int rebotes;
	
	public CromoBaloncesto() {
	}

	public CromoBaloncesto(Integer id, String nombre, int puntos, int rebotes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.puntos = puntos;
		this.rebotes = rebotes;
	}

	@Override
	public String toString() {
		return "CromoBaloncesto [id=" + id + ", nombre=" + nombre + ", puntos=" + puntos + ", rebotes=" + rebotes + "]";
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the puntos
	 */
	public int getPuntos() {
		return puntos;
	}

	/**
	 * @param puntos the puntos to set
	 */
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	/**
	 * @return the rebotes
	 */
	public int getRebotes() {
		return rebotes;
	}

	/**
	 * @param rebotes the rebotes to set
	 */
	public void setRebotes(int rebotes) {
		this.rebotes = rebotes;
	}

	
}
