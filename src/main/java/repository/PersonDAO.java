package repository;

import java.util.List;
import javax.persistence.EntityManager;
import domaine.Person;
import domaine.Place;
import domaine.Sport;

public class PersonDAO implements GenericDAO<Person> {
	private EntityManager manager;

	public PersonDAO(EntityManager manager) {
		this.setManager(manager);
	}

	public void Create(Person object) {
		manager.persist(object);
	}

	public void Delete(Person object) {
		// Person p = (Person) object;
		manager.remove(object);
		// manager.createQuery("Delete a From Person a where
		// a.id=:id").setParameter("id", p.getId());

	}

	public Person Find(long id) {
		return (Person) manager.createQuery("Select a From Person a where a.id=:id", Person.class)
				.setParameter("id", id).getSingleResult();
		// return manager.find(Person.class, id);
	}

	public int CountAll() {
		List<Person> resultList = manager.createQuery("Select a From Person a", Person.class).getResultList();
		return resultList.size();
	}

	// INSERT INTO tbl_name (col1,col2) VALUES(15,col1*2);
	public void AddPlaceToPerson(Person person, Place place) {
		Person p = manager.createQuery("Select a From Person a where a.id=:id", Person.class)
				.setParameter("id", person.getId()).getSingleResult();
		p.addPlace(place);
	}

	public void AddSportToPerson(Person person, Sport sport) {
		Person p = manager.createQuery("Select a From Person a where a.id=:id", Person.class)
				.setParameter("id", person.getId()).getSingleResult();
		p.addSport(sport);
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

}
