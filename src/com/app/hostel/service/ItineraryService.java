package com.app.hostel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hostel.dao.ItineraryDao;
import com.app.hostel.entity.Itinerary;


@Service("itineraryService")
public class ItineraryService{

	@Autowired
	private ItineraryDao itineraryDaoImpl;

	 
	public void createItinerary(Itinerary itinerary) {
		 
		itineraryDaoImpl.createItinerary(itinerary);
	}

	 
	public Itinerary getItinerary(Integer id) {
		 
		return itineraryDaoImpl.getItinerary(id);
	}

	 
	public List<Itinerary> getItinerarys() {
		 
		return itineraryDaoImpl.getItinerarys();
	}

	 
	public void updateItinerary(Itinerary itinerary) {
		 
		itineraryDaoImpl.updateItinerary(itinerary);
	}

	 
	public void deleteItinerary(Integer id) {
		 
		itineraryDaoImpl.deleteItinerary(id);
	}
}
