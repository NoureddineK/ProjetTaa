package service;

import domaine.Place;
import domaine.Sport;
import repository.PlaceDAO;

public class ServicePlace {
	private PlaceDAO placeDAO;

	public ServicePlace(PlaceDAO placeDAO) {
		this.setPlaceDAO(placeDAO);
	}

	public void RegisterSportForPlace(Place place, Sport sport) {
		placeDAO.AddSportToPlace(place, sport);

	}

	public PlaceDAO getPlaceDAO() {
		return placeDAO;
	}

	public void setPlaceDAO(PlaceDAO placeDAO) {
		this.placeDAO = placeDAO;
	}

}
