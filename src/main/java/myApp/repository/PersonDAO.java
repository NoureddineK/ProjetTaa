package myApp.repository;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import myApp.domaine.Person;

@Transactional
public interface PersonDAO extends JpaRepository<Person, Long> {
	static final Logger LOGGER = LoggerFactory.getLogger(PersonDAO.class);

	String _findByName = "SELECT p FROM Person p WHERE p.name = :name";
	String _findByMail = "SELECT p FROM Person p WHERE p.mail = :mail";

	@Query(_findByName)
	public Person findByName(@Param("name") String name);

	@Query(_findByMail)
	public Person findByMail(@Param("mail") String mail);

}
