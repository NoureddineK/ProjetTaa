package myApp.domaine;

import java.util.ArrayList;
import java.util.List;

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
public class Place {
	private static final Logger LOGGER = LoggerFactory.getLogger(Place.class);

	@Id
	@GeneratedValue
	@Column(nullable = false)
	private Long id;
	@Column(nullable = false, unique = true)
	private String name;
	private long posteCode;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Sport.class)
	@JoinTable(name = "Place_Sports")
	@JoinColumn(name = "Place_id", referencedColumnName = "id", updatable = false, nullable = false)
	private List<Sport> sports;

	public Place() {
		super();
		sports = new ArrayList<Sport>();
	}

	public Place(String name) {
		this.name = name;
		sports = new ArrayList<Sport>();
	}

	public Place(String name, long posteCode) {
		this.name = name;
		this.posteCode = posteCode;
		sports = new ArrayList<Sport>();
	}

	public Place(String name, List<Sport> sports) {
		this.name = name;
		this.sports = sports;
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
	public void deleteSport(Sport sport) {
		LOGGER.debug("deleteSport : " + sport);
		this.sports.remove(sport);
	}

	public long getPosteCode() {
		return posteCode;
	}

	public void setPosteCode(long posteCode) {
		this.posteCode = posteCode;
	}

	@Override
	public String toString() {
		return "Lieu [id=" + id + ", name=" + name + ", sports=" + sports +  "]";
	}
}
