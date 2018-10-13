package myApp.repository;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import myApp.domaine.Person;

@Transactional
public interface PersonDAO extends JpaRepository<Person, Long> {
	static final Logger LOGGER = LoggerFactory.getLogger(PersonDAO.class);
	
	String _findByName = "SELECT p FROM Person p WHERE p.name = :name";
	String _addSport = "UPDATE p SET  ";

	@Query(_findByName)
	public Person finByName(@Param("name") String name);

	// public void addPlaceToPerson(@RequestBody Person person, Place place);
}
