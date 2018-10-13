package myApp.repository;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import myApp.domaine.Person;
import myApp.domaine.Place;

@Transactional
public interface PlaceDAO extends JpaRepository<Place, Long> {
	static final Logger LOGGER = LoggerFactory.getLogger(PlaceDAO.class);
	String _findByName = "SELECT p FROM Place p WHERE p.name = :name";

	@Query(_findByName)
	public Place finByName(@Param("name") String name);

}