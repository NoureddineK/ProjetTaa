package myApp.domaine;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Place {
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

	@Override
	public String toString() {
		return "Lieu [id=" + id + ", name=" + name + ", sports=" + sports + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getSports()=" + getSports() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}
