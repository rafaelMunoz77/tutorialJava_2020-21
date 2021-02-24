package tutorialJava.modelosBasesDeDatosComunesJPA.bankonter.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import tutorialJava.modelosBasesDeDatosComunesJPA.Controlador;
import tutorialJava.modelosBasesDeDatosComunesJPA.bankonter.TipoContrato;


public class TipoContratoControlador extends Controlador {

	private static TipoContratoControlador controller = null;
	
	//Definici�n de las constantes asociadas
	public static TipoContrato CUENTA_CORRIENTE = getControlador().find(1);
	public static TipoContrato TARJETA_DEBITO = getControlador().find(2);
	public static TipoContrato TARJETA_CREDITO = getControlador().find(3);
	public static TipoContrato PRESTAMOS = getControlador().find(4);
	
	
	
	public TipoContratoControlador() {
		super(TipoContrato.class, "Bankonter");
	}

	/**
	 * 
	 * @return
	 */
	public static TipoContratoControlador getControlador () {
		if (controller == null) {
			controller = new TipoContratoControlador();
		}
		return controller;
	}

	/**
	 * 
	 */
	public TipoContrato find (int id) {
		return (TipoContrato) super.find(id);
	}



	
	/**
	 * 
	 * @return
	 * @throws NoResultException
	 */
	@SuppressWarnings("unchecked")
	public List<TipoContrato> findAllTiposContrato () {
		List<TipoContrato> entities = new ArrayList<TipoContrato>();
		EntityManager em = getEntityManagerFactory().createEntityManager();
		try {			
			Query q = em.createNamedQuery("SELECT * FROM tipocontrato", TipoContrato.class);
			entities = (List<TipoContrato>) q.getResultList();
		}
		catch (NoResultException nrEx) {
		}
		em.close();
		return entities;
	}


	
	
}
