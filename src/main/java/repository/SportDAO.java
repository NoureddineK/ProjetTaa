package repository;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import domaine.EntityManagerHelper;
import domaine.Person;
import domaine.Sport;
import service.PersonService;

public class SportDAO implements GenericDAO<Sport> {
	private static final Logger logger = Logger.getLogger(SportDAO.class.getName());
	private EntityManager manager;

	public SportDAO() {
		this.manager = EntityManagerHelper.getEntityManager();
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
