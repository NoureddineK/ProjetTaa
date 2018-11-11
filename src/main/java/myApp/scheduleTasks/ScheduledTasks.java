package myApp.scheduleTasks;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import myApp.domaine.Person;
import myApp.domaine.Place;
import myApp.domaine.Sport;
import myApp.domaine.Weather;
import myApp.mailSender.SmtpMailSender;
import myApp.repository.PersonDAO;
import myApp.repository.PlaceDAO;
import myApp.repository.SportDAO;
import myApp.repository.WeatherDAO;
import myApp.utils.Api;
import myApp.weather.MainWeather;

@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	@Autowired
	private SmtpMailSender smtpMailSender;

	@Autowired
	PersonDAO personDao;

	@Autowired
	PlaceDAO placeDao;

	@Autowired
	SportDAO sportDao;

	@Autowired
	WeatherDAO weatherDao;

	private String mailObject = "Weather App";
	private List<Person> persons;
	private List<Place> places;
	private List<Sport> sports;
	MainWeather mainWeather;

	@Scheduled(cron = "0 0 8 * * WED")
	public void sendMailWeatherToUsers() throws MessagingException, InterruptedException {
		log.debug("sendMailWeatherToUsers : ");
		persons = personDao.findAll();
		StringBuilder mail = new StringBuilder("");
		if (!persons.isEmpty()) {
			for (Person person : persons) {
				mail.append("\t\t Bonjour ").append(person.getName() + "; ").append("\n\n");
				places = person.getPlaces();
				if (!places.isEmpty() && places != null) {
					mail.append("\t Ci-dessous, les activités que le temps vous permet de pratiquer ce Week-end.")
							.append("\n\n");
					for (Place l : places) {
						mainWeather = new MainWeather(l.getName());

						sports = getSportsWeatherForPlace(mainWeather.getWeather().getId(), l);
						if ((!sports.isEmpty()) && (sports != null) && (mainWeather.getWeather() != null)) {
							String w = Api.getFormattedDate(mainWeather.getWeather().getTime()) + ", "
									+ mainWeather.getWeather().getDescription() + ", "
									+ mainWeather.getWeather().getTemperature() + "°";
							mail.append(l.getName() + ": ").append(w + " : ").append("\n");
							for (Sport s : sports) {
								mail.append(s.getName()).append("\n");
							}
						}

					}
				} else {
					sports = getSportsWeatherForPerson(mainWeather.getWeather().getId(), person);
					if ((!sports.isEmpty()) && (sports != null) && (mainWeather.getWeather() != null)) {
						String w = Api.getFormattedDate(mainWeather.getWeather().getTime()) + ", "
								+ mainWeather.getWeather().getDescription() + ", "
								+ mainWeather.getWeather().getTemperature() + "°";
						mail.append("Vos activités possibles : ").append(w + " : ").append("\n");
						for (Sport s : sports) {
							mail.append(s.getName()).append("\n");
						}
					}
				}
				mail.append("Bon Week End...").append("\n");
				smtpMailSender.send(person.getMail(), this.mailObject, mail);
				mail = new StringBuilder("");
			}
		}
	}

	public List<Sport> getSportsWeatherForPerson(long weather, Person person) {
		log.debug("getSportsWeatherForPerson : " + weather + " " + person);
		List<Sport> list = new ArrayList<Sport>();
		long id = (weather / 100) * 100;
		Weather w = weatherDao.findByWeatherID(id);
		for (Sport s : w.getSports()) {
			if (person.getSports().contains(s)) {
				list.add(s);
			}
		}
		return list;
	}

	public List<Sport> getSportsWeatherForPlace(long weather, Place place) {
		log.debug("sendMailWeatherToUsers : " + weather + " " + place);
		List<Sport> list = new ArrayList<Sport>();
		long id = (weather / 100) * 100;
		Weather w = weatherDao.findByWeatherID(id);
		for (Sport s : w.getSports()) {
			if (place.getSports().contains(s)) {
				list.add(s);
			}
		}
		return list;
	}

}