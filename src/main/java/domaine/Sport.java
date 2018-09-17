package domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sport {
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
