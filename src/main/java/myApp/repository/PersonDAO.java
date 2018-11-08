package myApp.repository;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import myApp.domaine.Person;
import myApp.domaine.Place;

@Transactional
public interface PersonDAO extends JpaRepository<Person, Long> {
	static final Logger LOGGER = LoggerFactory.getLogger(PersonDAO.class);

	String _findByName = "SELECT p FROM Person p WHERE p.name = :name";
	
	@Query(_findByName)
	public Person findByName(@Param("name") String name);

}
