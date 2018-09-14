package repository;

import java.util.List;

import javax.persistence.EntityManager;

import domaine.Person;
import domaine.Place;

public class PlaceDAO implements GenericDAO {
	private EntityManager manager;

	public PlaceDAO(EntityManager manager) {
		this.manager = manager;
	}

	public void Create(Object object) {
		manager.persist(object);

	}

	public void Delete(Object object) {
		// Person p = (Person) object;
		manager.remove(object);
		// manager.createQuery("Delete a From Person a where
		// a.id=:id").setParameter("id", p.getId());

	}

	public Object Find(long id) {
		return (Place) manager.createQuery("Select a From Place a where a.id=:id",Place.class).setParameter("id", id)
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
