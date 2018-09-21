package myApp.domaine;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Person {

	private Long id;

	private String name;
	private List<Place> places;
	private List<Sport> sports;

	public Person() {
		this.places = new ArrayList<Place>();
		this.sports = new ArrayList<Sport>();
	}

	public Person(String name) {
		this.name = name;
		this.places = new ArrayList<Place>();
		this.sports = new ArrayList<Sport>();
	}

	public Person(String name, ArrayList<Place> places, ArrayList<Sport> sports) {
		this.name = name;
		this.places = places;
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
	public List<Place> getPlaces() {
		return places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
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

	public void addLieu(Place place) {
		this.places.add(place);
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", name=" + name + ", lieux=" + places + ", sports=" + sports + ", getId()="
				+ getId() + ", getName()=" + getName() + ", getLieux()=" + getPlaces() + ", getSports()=" + getSports()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
