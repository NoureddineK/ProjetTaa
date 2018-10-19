package myApp.service;

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
	@GetMapping("/{id}")
	public CurrentWeather getObject(@PathVariable("id") String id) throws InterruptedException {
		Optional<Place> place = placeDao.findById(Long.parseLong(id));
		MainWeather mainFrame = new MainWeather(place.get().getName());	
		return mainFrame.getWeather();
	}
}
