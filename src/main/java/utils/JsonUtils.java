package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import myApp.domaine.Sport;

public class JsonUtils {

	public static List<Sport> createSports() throws FileNotFoundException, IOException, ParseException {
		List<Sport> sportsList = new ArrayList<Sport>();
		String sportPath = "/home/noureddine/git/ProjetTaa/src/main/java/utils/sport.json";
		String placePath = "/home/noureddine/git/ProjetTaa/src/main/java/utils/place.json";
		JSONParser parser = new JSONParser();
		JSONArray a = (JSONArray) parser.parse(new FileReader(sportPath));
		for (Object o : a) {
			JSONObject sport = (JSONObject) o;
			String name = (String) sport.get("name");
			sportsList.add(new Sport(name));
		}
		return sportsList;
	}

	public static void main(String[] args) throws ParseException, FileNotFoundException, IOException {
		createSports();
	}
}
