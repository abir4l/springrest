package com.app.hostel.dao;

import java.util.List;

import com.app.hostel.entity.Itinerary;


public interface ItineraryDao {

	public void createItinerary(Itinerary itinerary);

	public Itinerary getItinerary(Integer id);
	
	public List<Itinerary> getItinerarys();
	
	public void updateItinerary(Itinerary itinerary);
	
	public void deleteItinerary(Integer id);
}
