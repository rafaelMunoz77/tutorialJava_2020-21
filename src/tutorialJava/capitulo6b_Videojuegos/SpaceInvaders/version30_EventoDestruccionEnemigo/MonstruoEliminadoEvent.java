package tutorialJava.capitulo6b_Videojuegos.SpaceInvaders.version30_EventoDestruccionEnemigo;

public class MonstruoEliminadoEvent {
	Monster monstruo;

	/**
	 * @param monstruo
	 */
	public MonstruoEliminadoEvent(Monster monstruo) {
		super();
		this.monstruo = monstruo;
	}

	public Monster getMonstruo() {
		return monstruo;
	}

	public void setMonstruo(Monster monstruo) {
		this.monstruo = monstruo;
	}
	
	
}
