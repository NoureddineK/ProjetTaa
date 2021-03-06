package myApp.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myApp.domaine.Person;
import myApp.domaine.Place;
import myApp.domaine.Sport;
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
	public Person FindByName(@PathVariable("name") String name) {
		return personDao.findByName(name);
	}

	@GetMapping("/findByMail/{mail}")
	public Person FindByMail(@PathVariable("mail") String mail) {
		return personDao.findByMail(mail);
	}

	@PostMapping("/addPlaceToPerson/{person}/{place}")
	public void addPlaceToPerson(@PathVariable String person, @PathVariable String place) {
		Person p = personDao.findByName(person);
		p.addPlace(placeDao.findByName(place));
		personDao.flush();
	}

	@PostMapping("/addSportToPerson/{person}/{sport}")
	public void addSportToPerson(@PathVariable String person, @PathVariable String sport) {
		Person p = personDao.findByName(person);
		p.addSport(sportDao.findByName(sport));
		personDao.flush();
	}

	@GetMapping("/getPlacesFromPerson/{name}")
	public List<Place> getPlacesFromPerson(@PathVariable String name) {
		return personDao.findByName(name).getPlaces();
	}

	@PostMapping("/addPerson/{name}/{mail}/{mdp}")
	public void addPerson(@PathVariable String name, @PathVariable String mail, @PathVariable String mdp) {
		Person p = new Person(name, mail, mdp);
		personDao.save(p);
	}

	@GetMapping("/deletePlaceFromPerson/{person}/{place}")
	public void deletePlaceFromPerson(@PathVariable String person, @PathVariable String place) {
		personDao.findByName(person).deletePlace(placeDao.findByName(place));
		personDao.flush();
	}

	@GetMapping("/deleteSportFromPerson/{person}/{sport}")
	public void deleteSportFromPerson(@PathVariable String person, @PathVariable String sport) {
		personDao.findByName(person).deleteSport(sportDao.findByName(sport));
		personDao.flush();
	}

	@GetMapping("/getSportsFromPerson/{name}")
	public Set<Sport> getSportsFromPerson(@PathVariable String name) {
		return personDao.findByName(name).getSports();
	}

}
