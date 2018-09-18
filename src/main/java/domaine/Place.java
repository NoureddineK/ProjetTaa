package domaine;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import service.RestServer;

@Entity
public class Place {
	private static final Logger logger = Logger.getLogger(Place.class.getName());
	private Long id;

	private String name;

	private List<Sport> sports;

	public Place() {
		super();
		sports = new ArrayList<Sport>();
	}

	public Place(String name) {
		this.name = name;
		sports = new ArrayList<Sport>();
	}

	public Place(String name, List<Sport> sports) {
		this.name = name;
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
	@JoinColumn(name = "Lieu_ID")
	public List<Sport> getSports() {
		return sports;
	}

	public void setSports(List<Sport> sports) {
		this.sports = sports;
	}

	public void addSport(Sport sport) {
		this.sports.add(sport);
	}

	@Override
	public String toString() {
		return "Lieu [id=" + id + ", name=" + name + ", sports=" + sports + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getSports()=" + getSports() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}
