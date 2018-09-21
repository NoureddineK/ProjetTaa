package myApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myApp.domaine.Person;
import myApp.repository.PersonDAO;
import myApp.repository.PlaceDAO;
import myApp.repository.SportDAO;

@RestController
@RequestMapping("/person")
public class PersonService {

	@Autowired
	PersonDAO personDAO;

	@Autowired
	PlaceDAO PlaceDao;

	@Autowired
	SportDAO SportDao;

	@GetMapping(value = "/{id}")
	public Person getPerson(@PathVariable("id") String id) {
		Optional<Person> personne = personDAO.findById(Long.parseLong(id));
		return personne.get();
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deletePerson(@PathVariable("id") long id) {
		personDAO.deleteById(id);
	}

	@GetMapping("/allPersons")
	public List<Person> findPeople() {
		return personDAO.findAll();
	}

	
	@PostMapping("/addPerson")
	public void CreatePerson(Person p) {
		personDAO.save(p);
	}

	// public void addPerson(Person p) {
//		personneDao.save(p);
//	}

//	public void deletePerson(long id) {
//		personneDao.deleteById(id);
//
//	}
}
