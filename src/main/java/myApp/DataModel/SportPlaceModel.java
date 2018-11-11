package myApp.DataModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myApp.domaine.Place;
import myApp.domaine.Sport;
import myApp.repository.PersonDAO;
import myApp.repository.PlaceDAO;
import myApp.repository.SportDAO;
import utils.MathUtils;

@RestController
@RequestMapping("/admin/modelSport")
public class SportPlaceModel {

	@Autowired
	PersonDAO personDao;

	@Autowired
	PlaceDAO placeDao;

	@Autowired
	SportDAO sportDao;

	@GetMapping("/a")
	private String get() {
		return "Noureddine";
	}

	@PostMapping("/populatePlacesBySports/{loop}")
	private void populatePlacesBySports(@PathVariable("loop") long loop) {
		List<Place> placesList = placeDao.findAll();
		List<Sport> sportsList = sportDao.findAll();
		for (Place p : placesList) {
			for (int i = 0; i < loop; i++) {
				p.addSport(sportsList.get(MathUtils.generateInt(0, sportsList.size() - 1)));
			}
		}
		placeDao.flush();
	}

	@PostMapping("/populatePlaceBySports/{name}/{loop}")
	private void populatePlaceBySports(@PathVariable("name") String name, @PathVariable("loop") long loop) {
		Place place = placeDao.findByName(name);
		List<Sport> sportsList = sportDao.findAll();
		for (int i = 0; i < loop; i++) {
			place.addSport(sportsList.get(MathUtils.generateInt(0, sportsList.size() - 1)));
		}
		placeDao.flush();
	}

}
