package repository;

import java.util.List;
import javax.persistence.EntityManager;
import domaine.Sport;

public class SportDAO implements GenericDAO<Sport> {
	private EntityManager manager;

	public SportDAO(EntityManager manager) {
		this.manager = manager;
	}

	public void Create(Sport object) {
		manager.persist(object);

	}

	public void Delete(Sport object) {
		// Person p = (Person) object;
		manager.remove(object);
		// manager.createQuery("Delete a From Person a where
		// a.id=:id").setParameter("id", p.getId());

	}

	public Sport Find(long id) {
		return (Sport) manager.createQuery("Select a From Sport a where a.id=:id", Sport.class).setParameter("id", id)
				.getSingleResult();
	}

	public int CountAll() {
		List<Sport> resultList = manager.createQuery("Select a From Sport a", Sport.class).getResultList();
		return resultList.size();
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

}
