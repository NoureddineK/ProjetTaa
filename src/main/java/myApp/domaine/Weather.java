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
public class Weather {
	private static final Logger LOGGER = LoggerFactory.getLogger(Weather.class);
	@Id
	@GeneratedValue
	@Column(nullable = false)
	private Long id;
	@Column(unique = true)
	private long weatherID;

	private String Description;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Sport.class)
	@JoinTable(name = "Weather_Sports")
	@JoinColumn(name = "Sport_id", referencedColumnName = "id", updatable = false, nullable = false)
	private List<Sport> sports;

	public Weather() {
		this.sports = new ArrayList<Sport>();
	}

	public Weather(long weatherID) {
		this.weatherID = weatherID;
		this.sports = new ArrayList<Sport>();
	}

	public Weather(long weatherID, ArrayList<Sport> sports) {
		this.weatherID = weatherID;
		this.sports = sports;
	}

	public Weather(long weatherID, String Description) {
		this.weatherID = weatherID;
		this.Description = Description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getWeatherID() {
		return weatherID;
	}

	public void setWeatherID(long weatherID) {
		this.weatherID = weatherID;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public List<Sport> getSports() {
		return sports;
	}

	public void setSports(List<Sport> sports) {
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

	@Override
	public String toString() {
		return "Weather [id=" + id + ", weatherID=" + weatherID + ", Description=" + Description + ", sports=" + sports
				+ "]";
	}

}
