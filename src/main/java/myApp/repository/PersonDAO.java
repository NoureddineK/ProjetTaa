package myApp.repository;
import javax.management.Query;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import myApp.domaine.Person;

@Transactional
public interface PersonDAO extends JpaRepository<Person, Long> {

	
	
}
