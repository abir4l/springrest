package com.app.hostel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.hostel.entity.Itinerary;
import com.app.hostel.service.ItineraryService;

@RestController
@RequestMapping("/itinerary")
public class ItineraryController {

	@Autowired
	private ItineraryService itineraryService;

	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> addItinerary(@RequestBody Itinerary itinerary) {
		
		itineraryService.createItinerary(itinerary);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping("/{id}")
	public Itinerary getItinerary(@PathVariable("id") Integer id) {
		
		return itineraryService.getItinerary(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Itinerary>> getAllItinerarys() {
		return new ResponseEntity<>(itineraryService.getItinerarys(), HttpStatus.OK);
		
	}

	@RequestMapping(method = RequestMethod.PUT)
		public ResponseEntity<Itinerary> updateItinerary( @RequestBody Itinerary itinerary) {
		
		itineraryService.updateItinerary(itinerary);
		return new ResponseEntity<>(itinerary,HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE,value="/{id}")
	public ResponseEntity<String> deleteItinerary(@PathVariable("id") Integer id) {
		
		itineraryService.deleteItinerary(id);
		return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
	}
}
