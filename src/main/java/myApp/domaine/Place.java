package myApp.domaine;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
public class Place {
	private static final Logger LOGGER = LoggerFactory.getLogger(Place.class);
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

	@Override
	public String toString() {
		return "Lieu [id=" + id + ", name=" + name + ", sports=" + sports + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getSports()=" + getSports() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}
