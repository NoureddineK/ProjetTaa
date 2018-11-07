package myApp.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import myApp.domaine.Person;
import myApp.repository.PersonDAO;
import myApp.repository.PlaceDAO;
import myApp.repository.SportDAO;

@RestController
@RequestMapping("/person")
public class PersonService implements Services<Person> {
	static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

	@Autowired
	PersonDAO personDao;

	@Autowired
	PlaceDAO placeDao;

	@Autowired
	SportDAO sportDao;

	@Override
	public Person getObject(@PathVariable("id") String id) {
		Optional<Person> person = personDao.findById(Long.parseLong(id));
		return person.get();
	}

	@Override
	public List<Person> getAllObjects() {
		return personDao.findAll();
	}

	@Override
	public void CreateObject(@RequestBody Person p) {
		personDao.save(p);
	}

	@Override
	public void CreateObjects(@RequestBody List<Person> listPerson) {
		for (Person p : listPerson) {
			personDao.save(p);
		}
	}

	@Override
	public void deleteObject(@PathVariable("id") long id) {
		personDao.deleteById(id);
	}

	@Override
	public void deleteAllObjects() {
		personDao.deleteAll();
	}

	@Override
	public Person FinByName(@PathVariable("name") String name) {
		return personDao.finByName(name);
	}

}
