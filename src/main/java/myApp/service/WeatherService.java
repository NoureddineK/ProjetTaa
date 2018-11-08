package myApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myApp.domaine.Place;
import myApp.repository.PlaceDAO;
import weather.CurrentWeather;
import weather.MainWeather;

@RestController
@RequestMapping("/weather")
public class WeatherService {

	@Autowired
	PlaceDAO placeDao;

	@GetMapping("/id/{id}")
	public CurrentWeather getWeatherById(@PathVariable("id") String id) throws InterruptedException {
		Optional<Place> place = placeDao.findById(Long.parseLong(id));
		MainWeather mainFrame = new MainWeather(place.get().getName());
		return mainFrame.getWeather();
	}

	@GetMapping("/name/{name}")
	public CurrentWeather getWeatherByName(@PathVariable("name") String name) throws InterruptedException {
		Place place = placeDao.findByName(name);
		if (place == null)
			return null;
		MainWeather mainFrame = new MainWeather(name);
		return mainFrame.getWeather();
	}

	@GetMapping("/cities")
	public List<CurrentWeather> getWeatherOfAllCities() throws InterruptedException {
		List<CurrentWeather> listWeather = new ArrayList<CurrentWeather>();
		List<Place> listPlaces = placeDao.findAll();
		MainWeather mainFrame;

		for (Place p : listPlaces) {
			mainFrame = new MainWeather(p.getName());
			listWeather.add(mainFrame.getWeather());
		}
		return listWeather;
	}

}
