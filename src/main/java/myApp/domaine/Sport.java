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
	private Long id;
	private String name;

	public Sport(String name) {
		this.name = name;
	}

	public Sport() {
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

	@Override
	public String toString() {
		return "Sport [id=" + id + ", name=" + name + "]";
	}
}
