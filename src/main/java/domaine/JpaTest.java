package domaine;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import repository.PersonDAO;
import repository.PlaceDAO;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createPersons();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		test.listPersons();

		manager.close();
		System.out.println(".. done");
	}

	private void createPersons() {
		int numOfEmployees = manager.createQuery("Select a From Person a", Person.class).getResultList().size();
		if (numOfEmployees == 0) {

			Place lieu = new Place("java");
			Sport foot = new Sport("foot");
			manager.persist(lieu);
			manager.persist(foot);

			Person p1 = new Person("Jakab Gipsz");
			p1.addPlace(lieu);
			p1.addSport(foot);
			 //manager.persist(p1);

			Person p2 = new Person("Captain Nemo");
			p2.addPlace(lieu);
			p2.addSport(foot);
			manager.persist(p2);

			Person p3 = new Person("Captain ");
			p3.addPlace(lieu);
			p3.addSport(foot);
			manager.persist(p3);

			Person p4 = new Person(" Nemo");
			p4.addPlace(lieu);
			p4.addSport(foot);
			manager.persist(p4);
			
			Place beaulieu = new Place("beaulieu");
			PlaceDAO placeDAO = new PlaceDAO(manager);
			placeDAO.Create(beaulieu);
			
			PersonDAO personDao = new PersonDAO(manager);
			personDao.Create(p1);
			Person p = (Person) personDao.Find(3);
			System.out.println("Le nombre de personnes Avant : " + personDao.CountAll());
			personDao.Delete(p2);
			System.out.println("Personne : " + p.getName());
			System.out.println("Le nombre de personnes Apres : " + personDao.CountAll());

		}
	}

	private void listPersons() {
		List<Person> resultList = manager.createQuery("Select a From Person a", Person.class).getResultList();
		System.out.println("num of Personne:" + resultList.size());
		for (Person next : resultList) {
			System.out.println("next Personne: " + next);
		}
	}
}
