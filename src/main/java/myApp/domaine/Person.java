package myApp.domaine;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Person {
	private static final Logger LOGGER = LoggerFactory.getLogger(Person.class);
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
	@Column(nullable = false)
	public Long getId() {
		LOGGER.debug("getId : ");
		return id;
	}

	public void setId(Long id) {
		LOGGER.debug("setId : " + id);
		this.id = id;
	}

	@Column(nullable = false)
	public String getName() {
		LOGGER.debug("getName : ");
		return name;
	}

	public void setName(String name) {
		LOGGER.debug("setName : " + name);
		this.name = name;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	public List<Place> getPlaces() {
		LOGGER.debug("getPlaces : ");
		return places;
	}

	public void setPlaces(List<Place> places) {
		LOGGER.debug("setPlaces : " + places);
		this.places = places;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	public List<Sport> getSports() {
		LOGGER.debug("getSports : ");
		return sports;
	}

	public void setSports(List<Sport> sports) {
		LOGGER.debug("setSports : " + sports);
		this.sports = sports;
	}

	public void addSport(Sport sport) {
		LOGGER.debug("addSport : " + sport);
		this.sports.add(sport);
	}

	public void addPlace(Place place) {
		LOGGER.debug("addLieu : " + place);
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
