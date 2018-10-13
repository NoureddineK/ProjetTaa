package myApp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import myApp.domaine.Sport;
import myApp.repository.PersonDAO;
import myApp.repository.PlaceDAO;
import myApp.repository.SportDAO;

@RestController
@RequestMapping("/sport")
public class SportService implements Services<Sport> {

	@Autowired
	PersonDAO personDao;

	@Autowired
	PlaceDAO placeDao;

	@Autowired
	SportDAO sportDao;

	@Override
	public Sport getObject(@PathVariable("id") String id) {
		Optional<Sport> sport = sportDao.findById(Long.parseLong(id));
		return sport.get();
	}

	@Override
	public List<Sport> getAllObjects() {
		return sportDao.findAll();
	}

	@Override
	public void CreateObject(@RequestBody Sport p) {
		sportDao.save(p);
	}

	@Override
	public void CreateObjects(@RequestBody List<Sport> listSports) {
		for (Sport p : listSports) {
			sportDao.save(p);
		}
	}

	@Override
	public void deleteObject(@PathVariable("id") long id) {
		sportDao.deleteById(id);
	}

	@Override
	public void deleteAllObjects() {
		sportDao.deleteAll();
	}

	@Override
	public Sport FinByName(@PathVariable("name") String name) {
		return sportDao.finByName(name);
	}

}