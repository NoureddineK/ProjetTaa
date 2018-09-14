package repository;

import java.util.List;

import javax.persistence.EntityManager;

import domaine.Person;

public class PersonDAO implements GenericDAO {
	private EntityManager manager;

	public PersonDAO(EntityManager manager) {
		this.setManager(manager);
	}

	public void Create(Object object) {
		manager.persist(object);
	}

	public void Delete(Object object) {
		//Person p = (Person) object;
		manager.remove(object);
		//manager.createQuery("Delete a From Person a where a.id=:id").setParameter("id", p.getId());

	}

	public Object Find(long id) {
		return (Person) manager.createQuery("Select a From Person a where a.id=:id",Person.class).setParameter("id", id)
				.getSingleResult();
	}

	public int CountAll ()  {
		List<Person> resultList = manager.createQuery("Select a From Person a", Person.class).getResultList();
		return resultList.size();	
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

}
