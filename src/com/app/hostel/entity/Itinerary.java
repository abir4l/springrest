package com.app.hostel.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity(name = "tbl_itenaries")
public class Itinerary extends Base {


	@OneToMany(fetch = FetchType.EAGER, mappedBy = "itinerary")
	private Set<CustomerItinerary> customerItineraries= new HashSet<>(0);

	@Column(name = "description")
	private String description;

	@Column(name = "price",columnDefinition = "decimal(10,2)")
	private Double price;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
