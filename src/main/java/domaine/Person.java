package domaine;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import service.RestServer;

@Entity
public class Person {
	private static final Logger logger = Logger.getLogger(Person.class.getName());
	private Long id;

	private String name;
	private List<Place> lieux;
	private List<Sport> sports;

	public Person() {
		this.lieux = new ArrayList<Place>();
		this.sports = new ArrayList<Sport>();
	}

	public Person(String name) {
		this.name = name;
		this.lieux = new ArrayList<Place>();
		this.sports = new ArrayList<Sport>();
	}

	public Person(String name, ArrayList<Place> lieux, ArrayList<Sport> sports) {
		this.name = name;
		this.lieux = lieux;
		this.sports = sports;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany
	@JoinColumn(name = "Personne_ID")
	public List<Place> getLieux() {
		return lieux;
	}

	public void setLieux(List<Place> lieux) {
		this.lieux = lieux;
	}

	@ManyToMany
	public List<Sport> getSports() {
		return sports;
	}

	public void setSports(List<Sport> sports) {
		this.sports = sports;
	}

	public void addSport(Sport sport) {
		this.sports.add(sport);
	}

	public void addLieu(Place lieu) {
		this.lieux.add(lieu);
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", name=" + name + ", lieux=" + lieux + ", sports=" + sports + ", getId()="
				+ getId() + ", getName()=" + getName() + ", getLieux()=" + getLieux() + ", getSports()=" + getSports()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
