package domaine;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import repository.PersonDAO;

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
			test.createEmployees();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		test.listEmployees();

		manager.close();
		System.out.println(".. done");
	}

	private void createEmployees() {
		int numOfEmployees = manager.createQuery("Select a From Person a", Person.class).getResultList().size();
		if (numOfEmployees == 0) {

			Place lieu = new Place("java");
			Sport foot = new Sport("foot");
			manager.persist(lieu);
			manager.persist(foot);

			Person p1 = new Person("Jakab Gipsz");
			p1.addLieu(lieu);
			p1.addSport(foot);
//			manager.persist(p1);
			
			Person p2 = new Person("Captain Nemo");
			p2.addLieu(lieu);
			p2.addSport(foot);
			manager.persist(p2);
			
			Person p3 = new Person("Captain ");
			p3.addLieu(lieu);
			p3.addSport(foot);
			manager.persist(p3);
			
			Person p4 = new Person(" Nemo");
			p4.addLieu(lieu);
			p4.addSport(foot);
			manager.persist(p4);
			
			PersonDAO personDao = new PersonDAO(manager);
			personDao.Create(p1);
			Person p = (Person) personDao.Find(3);
			
			System.out.println("Personne : "+ p.getName());
			
			
		}
	}

	private void listEmployees() {
		List<Person> resultList = manager.createQuery("Select a From Person a", Person.class).getResultList();
		System.out.println("num of Personne:" + resultList.size());
		for (Person next : resultList) {
			System.out.println("next Personne: " + next);
		}
	}
}
