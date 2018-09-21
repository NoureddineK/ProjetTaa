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
import myApp.domaine.Sport;
import myApp.repository.PersonDAO;
import myApp.repository.PlaceDAO;
import myApp.repository.SportDAO;

@RestController
@RequestMapping("/sport")
public class SportService {

	@Autowired
	PersonDAO personDao;

	@Autowired
	PlaceDAO placeDao;

	@Autowired
	SportDAO sportDao;

	@GetMapping("/{id}")
	public Sport getSport(@PathVariable("id") String id) {
		Optional<Sport> sport = sportDao.findById(Long.parseLong(id));
		return sport.get();
	}

	@GetMapping("/allSports")
	public List<Sport> findSport() {
		return sportDao.findAll();
	}

	@PostMapping("/addSport")
	public void CreateSport(@RequestBody Sport p) {
		sportDao.save(p);
	}

	@PostMapping("/addSports")
	public void CreateSports(@RequestBody List<Sport> listSports) {
		for (Sport p : listSports) {
			sportDao.save(p);
		}
	}

	@DeleteMapping("/delete/{id}")
	public void deleteSport(@PathVariable("id") long id) {
		sportDao.deleteById(id);
	}

	@DeleteMapping("/deleteAll")
	public void deleteAllSports() {
		sportDao.deleteAll();
	}

}