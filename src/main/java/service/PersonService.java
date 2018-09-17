package service;

import domaine.Person;
import domaine.Place;
import domaine.Sport;
import repository.PersonDAO;

public class PersonService {

	private PersonDAO personDAO;

	public PersonService(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	public void RegisterPlaceForPerson(Person person, Place place) {
		personDAO.AddPlaceToPerson(person, place);
	}

	public void RegisterSportForPerson(Person person, Sport sport) {
		personDAO.AddSportToPerson(person, sport);
	}

	public PersonDAO getPersonDAO() {
		return personDAO;
	}

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}
}
