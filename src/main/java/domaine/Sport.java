package domaine;

import java.util.logging.Logger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import service.RestServer;

@Entity
public class Sport {
	private static final Logger logger = Logger.getLogger(Sport.class.getName());
	private Long id;

	private String name;

	public Sport(String name) {
		this.name = name;
	}

	public Sport() {
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

	@Override
	public String toString() {
		return "Sport [id=" + id + ", name=" + name + "]";
	}
}
