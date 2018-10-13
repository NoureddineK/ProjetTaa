package myApp.repository;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import myApp.domaine.Sport;

@Transactional
public interface SportDAO extends JpaRepository<Sport, Long> {
	static final Logger LOGGER = LoggerFactory.getLogger(SportDAO.class);
	String _findByName = "SELECT p FROM Sport p WHERE p.name = :name";

	@Query(_findByName)
	public Sport finByName(@Param("name") String name);
}