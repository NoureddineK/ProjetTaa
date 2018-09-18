package repository;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import domaine.EntityManagerHelper;
import domaine.Person;
import domaine.Place;
import service.PersonService;

public class PlaceDAO implements GenericDAO<Place> {
	private static final Logger logger = Logger.getLogger(PlaceDAO.class.getName());
	private EntityManager manager;

	public PlaceDAO() {
		this.manager = EntityManagerHelper.getEntityManager();
	}

	public void Create(Place object) {
		manager.persist(object);

	}

	public void Delete(Place object) {
		// Person p = (Person) object;
		manager.remove(object);
		// manager.createQuery("Delete a From Person a where
		// a.id=:id").setParameter("id", p.getId());

	}

	public Place Find(long id) {
		return (Place) manager.createQuery("Select a From Place a where a.id=:id", Place.class).setParameter("id", id)
				.getSingleResult();
	}

	public int CountAll() {
		List<Place> resultList = manager.createQuery("Select a From Place a", Place.class).getResultList();
		return resultList.size();
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

}
