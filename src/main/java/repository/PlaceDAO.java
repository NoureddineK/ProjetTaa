package repository;

import java.util.List;
import javax.persistence.EntityManager;
import domaine.Place;
import domaine.Sport;

public class PlaceDAO implements GenericDAO<Place> {
	private EntityManager manager;

	public PlaceDAO(EntityManager manager) {
		this.manager = manager;
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
	
	
	public void AddSportToPlace(Place place, Sport sport) {
		Place p = manager.createQuery("Select a From Place a where a.id=:id", Place.class)
				.setParameter("id", place.getId()).getSingleResult();
		p.addSport(sport);
	}


	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

}
