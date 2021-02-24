package tutorialJava.modelosBasesDeDatosComunesJPA.bankonter.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;


import tutorialJava.modelosBasesDeDatosComunesJPA.Controlador;
import tutorialJava.modelosBasesDeDatosComunesJPA.bankonter.Usuario;





public class UsuarioControlador extends Controlador {

	private static UsuarioControlador controller = null;
	
	
	
	public UsuarioControlador() {
		super(tutorialJava.modelosBasesDeDatosComunesJPA.bankonter.Usuario.class, "Bankonter");
	}

	/**
	 * 
	 * @return
	 */
	public static UsuarioControlador getControlador () {
		if (controller == null) {
			controller = new UsuarioControlador();
		}
		return controller;
	}

	/**
	 * 
	 */
	public Usuario find (int id) {
		return (Usuario) super.find(id);
	}


	/**
	 * 
	 * @return
	 */
	public List<Usuario> findAllUsuarios () {
		List<Usuario> entities = new ArrayList<Usuario>();
		EntityManager em = getEntityManagerFactory().createEntityManager();
		try {			
			Query q = em.createNativeQuery("SELECT * FROM usuario", Usuario.class);
			entities = (List<Usuario>) q.getResultList();
		}
		catch (NoResultException nrEx) {
		}
		em.close();
		return entities;
	}
	
	
	/**
	 * 
	 * @param userName
	 * @param mail
	 * @param password
	 * @return
	 */
	public Usuario findByPasswordAndUsernameOrMail (String userName, String mail, String password) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		Usuario u = null;
		try {
			
			Query q = em.createNativeQuery("SELECT * FROM usuario where (nombreUsuario = ? or email = ?) and password = ? limit 1;", Usuario.class);
			q.setParameter(1, userName);
			q.setParameter(2, mail);
			q.setParameter(3, password);
			u = (Usuario) q.getSingleResult();
		}
		catch (NoResultException nrEx) {
		}
		em.close();
		return u;
	}

	
}
