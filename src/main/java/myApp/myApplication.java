package myApp;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
// Scheduler commente pour des tests
//@EnableScheduling
public class myApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(myApplication.class, args);
	}

}
