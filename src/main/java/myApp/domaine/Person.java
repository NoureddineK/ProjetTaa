package myApp.domaine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Sport.class)
	@JoinTable(name = "Person_Sports")
	@JoinColumn(name = "Sport_id", referencedColumnName = "id", updatable = false, nullable = false)
	private Set<Sport> sports;

	public Person() {
		this.places = new ArrayList<Place>();
		this.sports = new HashSet<Sport>();
	}

	public Person(String name) {
		this.name = name;
		this.places = new ArrayList<Place>();
		this.sports = new HashSet<Sport>();
	}

	public Person(String name, ArrayList<Place> places) {
		this.name = name;
		this.places = places;
	}

	public Person(String name, String mail, String password) {
		this.name = name;
		this.mail = mail;
		this.password = password;
		this.places = new ArrayList<Place>();
		this.sports = new HashSet<Sport>();
	}

	public Long getId() {
		LOGGER.debug("getId : ");
		return id;
	}

	public void setId(Long id) {
		LOGGER.debug("setId : " + id);
		this.id = id;
	}

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
		LOGGER.debug("addplace : " + place);
		this.places.add(place);
	}

	public void deletePlace(Place place) {
		LOGGER.debug("deletePlace : " + place);
		this.places.remove(place);
	}

	public void addSport(Sport sport) {
		LOGGER.debug("addSport : " + sport);
		this.sports.add(sport);
	}

	public void deleteSport(Sport sport) {
		LOGGER.debug("deleteSport : " + sport);
		this.sports.remove(sport);
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

	public Set<Sport> getSports() {
		return sports;
	}

	public void setSports(Set<Sport> sports) {
		this.sports = sports;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", password=" + password + ", mail=" + mail + ", places="
				+ places + "]";
	}

}
