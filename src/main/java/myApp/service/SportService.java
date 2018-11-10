package myApp.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myApp.DataModel.SportWeatherModel;
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
	public Sport FindByName(@PathVariable("name") String name) {
		return sportDao.findByName(name);
	}

	private boolean check(List<Sport> list, String name) {
		for (Sport sport : list) {

			if (sport.getName().toString() == name) {
				return true;
			}
		}
		return false;
	}

	@GetMapping("/getWeatherIdOfSport/{name}")
	public Integer getWeatherIdOfSport(@PathVariable("name") String name) {
		return sportDao.findByName(name).getWeatherID();
	}

	// TODO Afficher la meteo ideale pour un sport
	@GetMapping("/getWeatherActivity/{name}")
	public List<Integer> getWeatherActivity(@PathVariable("name") String name) {
		SportWeatherModel model = new SportWeatherModel();
		List<Integer> idWeatherList = new ArrayList<Integer>();
		Map<Integer, List<Sport>> mapWeather = model.getSportsWeatherMapModel();
		List<Sport> value;
		Integer key;
		for (Map.Entry<Integer, List<Sport>> entry : mapWeather.entrySet()) {
			key = entry.getKey();
			value = entry.getValue();
			if (check(value, name.toString())) {
				idWeatherList.add(key);
				System.out.println("Key " + key);
			}
		}
		return idWeatherList;
	}

}