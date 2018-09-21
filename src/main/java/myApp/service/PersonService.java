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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.util.JSONPObject;

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

	@GetMapping("/allPersons")
	public List<Person> findPeople() {
		return personDAO.findAll();
	}

	@PostMapping(value = "/addPerson")
	public void CreatePerson(@RequestBody Person p) {
		personDAO.save(p);
	}

	@PostMapping(value = "/addPersons")
	public void CreatePersons(@RequestBody List<Person> listPerson) {
		for (Person p : listPerson) {
			personDAO.save(p);
		}
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deletePerson(@PathVariable("id") long id) {
		personDAO.deleteById(id);
	}

	@DeleteMapping("/deleteAll")
	public void deleteAllPerson() {
		personDAO.deleteAll();
	}

}
