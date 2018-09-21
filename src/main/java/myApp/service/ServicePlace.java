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
import myApp.domaine.Place;
import myApp.repository.PersonDAO;
import myApp.repository.PlaceDAO;
import myApp.repository.SportDAO;

@RestController
@RequestMapping("/place")
public class ServicePlace {

	@Autowired
	PersonDAO personDao;

	@Autowired
	PlaceDAO placeDao;

	@Autowired
	SportDAO sportDao;

	@GetMapping("/{id}")
	public Place getPlace(@PathVariable("id") String id) {
		Optional<Place> place = placeDao.findById(Long.parseLong(id));
		return place.get();
	}

	@GetMapping("/allPlaces")
	public List<Place> findPlaces() {
		return placeDao.findAll();
	}

	@PostMapping("/addPlace")
	public void CreatePlace(@RequestBody Place p) {
		placeDao.save(p);
	}

	@PostMapping("/addPlaces")
	public void CreatePlaces(@RequestBody List<Place> listPlace) {
		for (Place p : listPlace) {
			placeDao.save(p);
		}
	}

	@DeleteMapping("/delete/{id}")
	public void deletePlace(@PathVariable("id") long id) {
		placeDao.deleteById(id);
	}

	@DeleteMapping("/deleteAll")
	public void deleteAllPlaces() {
		placeDao.deleteAll();
	}

}