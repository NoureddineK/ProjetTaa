package myApp.DataModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myApp.domaine.Sport;
import myApp.domaine.Weather;
import myApp.repository.SportDAO;
import myApp.repository.WeatherDAO;
import myApp.utils.MathUtils;

@RestController
@RequestMapping("/admin/modelWeather")
public class WeatherModel {
	@Autowired
	SportDAO sportDao;
	@Autowired
	WeatherDAO weatherDao;

	// Add sport to Weather List
	@PostMapping("/populateWeather/{loop}")
	private void populateWeather(@PathVariable("loop") long loop) {
		List<Weather> weatherList = weatherDao.findAll();
		List<Sport> sportsList = sportDao.findAll();
		for (Sport p : sportsList) {
			for (int i = 0; i < loop; i++) {
				Weather w = weatherList.get(MathUtils.generateInt(0, weatherList.size() - 1));
				w.addSport(p);
				weatherDao.flush();
			}
		}

	}

}
