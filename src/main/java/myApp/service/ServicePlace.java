package myApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myApp.domaine.Place;
import myApp.repository.PersonDAO;
import myApp.repository.PlaceDAO;
import myApp.repository.SportDAO;

@RestController
@RequestMapping("/place")
public class ServicePlace implements Services<Place>{

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
	public Place FinByName(@PathVariable("name") String name) {
		return placeDao.finByName(name);
	}

}