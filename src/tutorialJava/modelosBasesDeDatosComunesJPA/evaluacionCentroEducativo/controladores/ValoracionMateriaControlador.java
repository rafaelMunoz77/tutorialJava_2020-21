package tutorialJava.modelosBasesDeDatosComunesJPA.evaluacionCentroEducativo.controladores;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import tutorialJava.modelosBasesDeDatosComunesJPA.Controlador;
import tutorialJava.modelosBasesDeDatosComunesJPA.Entidad;
import tutorialJava.modelosBasesDeDatosComunesJPA.evaluacionCentroEducativo.Estudiante;
import tutorialJava.modelosBasesDeDatosComunesJPA.evaluacionCentroEducativo.Materia;
import tutorialJava.modelosBasesDeDatosComunesJPA.evaluacionCentroEducativo.Profesor;
import tutorialJava.modelosBasesDeDatosComunesJPA.evaluacionCentroEducativo.ValoracionMateria;

public class ValoracionMateriaControlador extends Controlador {

	// instancia del singleton
	private static ValoracionMateriaControlador instancia = null;

	/**
	 * 
	 */
	public ValoracionMateriaControlador() {
		super(ValoracionMateria.class, "EvaluacionCentroEducativo");
	}

	/**
	 * 
	 * @return
	 */
	public static ValoracionMateriaControlador getInstancia() {
		if (instancia == null) {
			instancia = new ValoracionMateriaControlador();
		}
		return instancia;
	}

	@Override
	public ValoracionMateria findFirst() {
		return (ValoracionMateria) super.findFirst();
	}

	@Override
	public ValoracionMateria findLast() {
		return (ValoracionMateria) super.findLast();
	}

	@Override
	public ValoracionMateria findNext(Entidad e) {
		return (ValoracionMateria) super.findNext(e);
	}

	@Override
	public ValoracionMateria findPrevious(Entidad e) {
		return (ValoracionMateria) super.findPrevious(e);
	}
	
	
	/**
	 * 
	 * @param profesor
	 * @param materia
	 * @param estudiante
	 * @return
	 */
	public ValoracionMateria findByEstudianteAndProfesorAndMateria (Profesor profesor, Materia materia, Estudiante estudiante) {
		ValoracionMateria resultado = null;
		EntityManager em = this.getEntityManagerFactory().createEntityManager();
		try {
			Query q = em.createNativeQuery("Select * from valoracionmateria where idProfesor = ? and "
					+ "idMateria = ? and idEstudiante = ?", ValoracionMateria.class);
			q.setParameter(1, profesor.getId());
			q.setParameter(2, materia.getId());
			q.setParameter(3, estudiante.getId());
			resultado = (ValoracionMateria) q.getSingleResult();
		}
		catch (Exception ex) {
		}
		em.close();
		return resultado;
	}
	
}
