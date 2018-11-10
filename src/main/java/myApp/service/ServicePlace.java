package myApp.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
@RequestMapping("/place")
public class ServicePlace implements Services<Place> {

	@Autowired
	PersonDAO personDao;

	@Autowired
	PlaceDAO placeDao;

	@Autowired
	SportDAO sportDao;

	@Override
	public Place getObject(@PathVariable("id") String id) {
		Optional<Place> place = placeDao.findById(Long.parseLong(id));
		return place.get();
	}

	@Override
	public List<Place> getAllObjects() {
		return placeDao.findAll();
	}

	@Override
	public void CreateObject(@RequestBody Place p) {
		placeDao.save(p);
	}

	@Override
	public void CreateObjects(@RequestBody List<Place> listPlace) {
		for (Place p : listPlace) {
			placeDao.save(p);
		}
	}

	@Override
	public void deleteObject(@PathVariable("id") long id) {
		placeDao.deleteById(id);
	}

	@Override
	public void deleteAllObjects() {
		placeDao.deleteAll();
	}

	@Override
	public Place FindByName(@PathVariable("name") String name) {
		return placeDao.findByName(name);
	}

	// TODO a Tester
	@PostMapping("/addSportToPlace/{place}/{sport}")
	public void getPlaceForPerson(@PathVariable String place, @PathVariable String sport) {
		Place p = placeDao.findByName(place);
		p.addSport(sportDao.findByName(sport));
	}

	@GetMapping("/getSportsFromPlace/{name}")
	public List<Sport> getSportsFromPlace(@PathVariable ("name") String name) {
		return placeDao.findByName(name).getSports();
	}

}