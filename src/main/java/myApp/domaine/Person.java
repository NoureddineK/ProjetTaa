package myApp.domaine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Person {
	private static final Logger LOGGER = LoggerFactory.getLogger(Person.class);

	@Id
	@GeneratedValue
	@Column(nullable = false)
	private Long id;
	@Column(nullable = false, unique = true)
	private String name;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String mail;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Place.class)
	@JoinTable(name = "Person_Places")
	@JoinColumn(name = "Person_id", referencedColumnName = "id", updatable = false, nullable = false)
	private List<Place> places;

	public Person() {
		this.places = new ArrayList<Place>();
	}

	public Person(String name) {
		this.name = name;
		this.places = new ArrayList<Place>();
	}

	public Person(String name, ArrayList<Place> places) {
		this.name = name;
		this.places = places;
	}

	public Long getId() {
		LOGGER.debug("getId : ");
		return id;
	}

	public void setId(Long id) {
		LOGGER.debug("setId : " + id);
		this.id = id;
	}

	@Column(nullable = false, unique = true)
	public String getName() {
		LOGGER.debug("getName : ");
		return name;
	}

	public void setName(String name) {
		LOGGER.debug("setName : " + name);
		this.name = name;
	}

	public List<Place> getPlaces() {
		LOGGER.debug("getPlaces : ");
		return places;
	}

	public void setPlaces(List<Place> places) {
		LOGGER.debug("setPlaces : " + places);
		this.places = places;
	}

	public void addPlace(Place place) {
		LOGGER.debug("addLieu : " + place);
		this.places.add(place);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", name=" + name + ", lieux=" + places + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getLieux()=" + getPlaces() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
