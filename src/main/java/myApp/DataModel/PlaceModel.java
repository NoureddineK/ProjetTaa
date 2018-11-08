package myApp.DataModel;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myApp.domaine.Place;
import myApp.repository.PlaceDAO;

@RestController
@RequestMapping("/modelPlace")
public class PlaceModel {
	@Autowired
	PlaceDAO placeDao;

	@GetMapping("/insert")
	public void insert() {
		JSONParser parser = new JSONParser();
		JSONArray a;
		String placePath = "/home/noureddine/git/ProjetTaa/src/main/java/utils/place.json";
		try {
			a = (JSONArray) parser.parse(new FileReader(placePath));

			for (Object o : a) {
				JSONObject person = (JSONObject) o;
				String name = (String) person.get("Nom_commune");
				long code = (Long) person.get("Code_postal");
				if ((code % 1000) == 0) {
					System.out.println(name.toLowerCase());
					placeDao.save(new Place(name, code));
				}
			}

		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
