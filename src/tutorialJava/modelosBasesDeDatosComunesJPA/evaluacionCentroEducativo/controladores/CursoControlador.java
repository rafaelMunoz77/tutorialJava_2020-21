package tutorialJava.modelosBasesDeDatosComunesJPA.evaluacionCentroEducativo.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import tutorialJava.modelosBasesDeDatosComunesJPA.Controlador;
import tutorialJava.modelosBasesDeDatosComunesJPA.Entidad;
import tutorialJava.modelosBasesDeDatosComunesJPA.evaluacionCentroEducativo.Curso;

public class CursoControlador extends Controlador {

	// instancia del singleton
	private static CursoControlador instancia = null;

	/**
	 * 
	 */
	public CursoControlador() {
		super(Curso.class, "EvaluacionCentroEducativo");
	}

	/**
	 * 
	 * @return
	 */
	public static CursoControlador getInstancia() {
		if (instancia == null) {
			instancia = new CursoControlador();
		}
		return instancia;
	}

	@Override
	public Curso findFirst() {
		return (Curso) super.findFirst();
	}

	@Override
	public Curso findLast() {
		return (Curso) super.findLast();
	}

	@Override
	public Curso findNext(Entidad e) {
		return (Curso) super.findNext(e);
	}

	@Override
	public Curso findPrevious(Entidad e) {
		return (Curso) super.findPrevious(e);
	}

	/**
	 * 
	 * @return
	 */
	public List<Curso> findAllCursos () {
		List<Curso> entities = new ArrayList<Curso>();
		EntityManager em = getEntityManagerFactory().createEntityManager();
		try {			
			Query q = em.createNativeQuery("SELECT * FROM curso", Curso.class);
			entities = (List<Curso>) q.getResultList();
		}
		catch (NoResultException nrEx) {
		}
		em.close();
		return entities;
	}
}
