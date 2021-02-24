package tutorialJava.modelosBasesDeDatosComunesJPA.ventaDeCoches;

import java.io.Serializable;
import javax.persistence.*;

import tutorialJava.modelosBasesDeDatosComunesJPA.Entidad;

import java.util.List;


/**
 * The persistent class for the fabricante database table.
 * 
 */
@Entity
@NamedQuery(name="Fabricante.findAll", query="SELECT f FROM Fabricante f")
public class Fabricante extends Entidad implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String cif;

	private String nombre;

	//bi-directional many-to-one association to Coche
	@OneToMany(mappedBy="fabricante")
	private List<Coche> coches;

	public Fabricante() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCif() {
		return this.cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Coche> getCoches() {
		return this.coches;
	}

	public void setCoches(List<Coche> coches) {
		this.coches = coches;
	}

	public Coche addCoch(Coche coch) {
		getCoches().add(coch);
		coch.setFabricante(this);

		return coch;
	}

	public Coche removeCoch(Coche coch) {
		getCoches().remove(coch);
		coch.setFabricante(null);

		return coch;
	}

	@Override
	public String toString() {
		return nombre;
	}

	@Override
	public boolean equals(Object obj) {
		Fabricante f = (Fabricante) obj;
		if (this.id == f.id) {
			return true;
		}
		return false;
	}


}