package myApp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	PersonDAO personDao;

	@Autowired
	PlaceDAO placeDao;

	@Autowired
	SportDAO sportDao;

	@GetMapping("/{id}")
	public Person getPerson(@PathVariable("id") String id) {
		Optional<Person> personne = personDao.findById(Long.parseLong(id));
		return personne.get();
	}

	@GetMapping("/allPersons")
	public List<Person> findPeople() {
		return personDao.findAll();
	}

	@PostMapping("/addPerson")
	public void CreatePerson(@RequestBody Person p) {
		personDao.save(p);
	}

	@PostMapping("/addPersons")
	public void CreatePersons(@RequestBody List<Person> listPerson) {
		for (Person p : listPerson) {
			personDao.save(p);
		}
	}

	@DeleteMapping("/delete/{id}")
	public void deletePerson(@PathVariable("id") long id) {
		personDao.deleteById(id);
	}

	@DeleteMapping("/deleteAll")
	public void deleteAllPerson() {
		personDao.deleteAll();
	}

}
