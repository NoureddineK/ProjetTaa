package myApp.domaine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
public class Sport {
	private static final Logger LOGGER = LoggerFactory.getLogger(Sport.class);
	@Id
	@GeneratedValue
	@Column(nullable = false)
	private Long id;

	private String name;

	private Integer weatherID;

	public Sport(String name) {
		this.name = name;
	}

	public Sport() {
	}

	public Sport(String name, Integer weatherID) {
		this.name = name;
		this.weatherID = weatherID;
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

	public Integer getWeatherID() {
		return weatherID;
	}

	public void setWeatherID(Integer weatherID) {
		this.weatherID = weatherID;
	}

	@Override
	public String toString() {
		return "Sport [id=" + id + ", name=" + name + "]";
	}
}
