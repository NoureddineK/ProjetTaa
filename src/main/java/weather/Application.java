package weather;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

import myApp.domaine.Place;
import myApp.repository.PersonDAO;
import myApp.repository.PlaceDAO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Application {


	
	public static void main(String[] args) throws ParseException, FileNotFoundException, IOException {
		PlaceDAO placeDao;
		
		Place p ;
		JSONParser parser = new JSONParser();
		// MainWeather mainFrame = new MainWeather("Rennes");
		JSONArray a = (JSONArray) parser
				.parse(new FileReader("/home/noureddine/git/ProjetTaa/src/main/java/weather/france.json"));
		for (Object o : a) {
			JSONObject person = (JSONObject) o;

			String name = (String) person.get("Nom_commune");
			long code = (Long) person.get("Code_postal");
			if ((code >= 35000) && (code < 36000)) {
				System.out.println(name.toLowerCase());
				p=new Place(name, code);
			}
			
			//placeDao.save(p);

		}

//		Object obj = parser.parse(new FileReader("/home/noureddine/git/ProjetTaa/src/main/java/weather/france.json"));
//	
//		
//		JSONObject json_object = (JSONObject) obj;
//		// JSONObject json_object = (JSONObject)
//		// JSONValue.parseWithException("france.json");
//		JSONArray commune = (JSONArray) JSONValue.parseWithException(json_object.get("Nom_commune").toString());
//		System.out.println("Commune" + commune);
	}
}
