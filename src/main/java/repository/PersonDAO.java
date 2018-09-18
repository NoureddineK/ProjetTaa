package repository;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import domaine.EntityManagerHelper;
import domaine.Person;
import service.PersonService;

public class PersonDAO implements GenericDAO<Person> {
	 private static final Logger logger = Logger.getLogger(PersonDAO.class.getName());
	private EntityManager manager;

	public PersonDAO() {
		this.manager = EntityManagerHelper.getEntityManager();	
	}

	public void Create(Person object) {
		manager.getTransaction().begin();
		manager.persist(object);
		EntityManagerHelper.commit();
	}

	public void Delete(Person object) {
		//Person p = (Person) object;
		manager.getTransaction().begin();
		manager.remove(object);
		EntityManagerHelper.commit();
		//manager.createQuery("Delete a From Person a where a.id=:id").setParameter("id", p.getId());

	}

	public Person Find(long id) {
		return manager.createQuery("Select a From Person a where a.id=:id",Person.class).setParameter("id", id)
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
