package myApp.DataModel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myApp.domaine.Sport;
import myApp.repository.PersonDAO;
import myApp.repository.PlaceDAO;
import myApp.repository.SportDAO;
import utils.JsonUtils;

@RestController
@RequestMapping("/modelWeather")
public class SportWeatherModel {
	@Autowired
	SportDAO sportDao;
	// Listes des sports definies en se basant sur l'etat de la meteo
	// La liste globale des sports est definie dans un fichier JSON
	private Map<Integer, List<Sport>> sportsWeatherMap = new HashMap<Integer, List<Sport>>();
	private List<Sport> clearSkySports = new ArrayList<Sport>();
	private List<Sport> rainSports = new ArrayList<Sport>();
	private List<Sport> thunderstormSports = new ArrayList<Sport>();
	private List<Sport> snowSports = new ArrayList<Sport>();
	private List<Sport> jsonSports = new ArrayList<Sport>();

	public SportWeatherModel() {
		init();
	}

	private void populateClearSkySports() {
		int i = 0;
		while (i < (jsonSports.size() - 3)) {
			clearSkySports.add(jsonSports.get(i));
			i++;
		}
	}


	private void populateRainSports() {
		int i = 12;
		while (i < (jsonSports.size() - 3)) {
			rainSports.add(jsonSports.get(i));
			i++;
		}

	}

	private void populateThunderstormSports() {
		int i = 18;
		while (i < (jsonSports.size() - 3)) {
			thunderstormSports.add(jsonSports.get(i));
			i++;
		}
	}

	private void populateSnowSports() {
		int i = 34;
		while (i < jsonSports.size()) {
			snowSports.add(jsonSports.get(i));
			i++;
		}
	}

	private void populateMap() throws FileNotFoundException, IOException, ParseException {
		jsonSports = JsonUtils.createSports();
		populateClearSkySports();
		populateRainSports();
		populateThunderstormSports();
		populateSnowSports();
		sportsWeatherMap.put(800, clearSkySports);
		sportsWeatherMap.put(500, rainSports);
		sportsWeatherMap.put(200, thunderstormSports);//300 700
		sportsWeatherMap.put(600, snowSports);
	}

	private void init() {
		try {
			populateMap();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}

	public Map<Integer, List<Sport>> getSportsWeatherMapModel() {
		return this.sportsWeatherMap;
	}

	// Gestion des sports selon la meteo
	@GetMapping("/populateModelWeather")
	public Map<Integer, List<Sport>> getSportsWeatherMap() throws FileNotFoundException, IOException, ParseException {
		populateMap();
		return sportsWeatherMap;
	}
}
