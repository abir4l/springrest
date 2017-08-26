package com.app.hostel.dto;

import java.util.List;

/**
 * Created by abiral on 7/15/17.
 */
public class CustomerDTO {


    private Integer id;
    private String name;
    private String email;
    private String nationality;
    private List<CustomerProductDTO> products;
    private List<CustomerItineraryDTO> itineraries;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

       public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<CustomerItineraryDTO> getItineraries() {
        return itineraries;
    }

    public void setItineraries(List<CustomerItineraryDTO> itineraries) {
        this.itineraries = itineraries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CustomerProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<CustomerProductDTO> products) {
        this.products = products;
    }

    public List<CustomerItineraryDTO> getItinerary() {
        return itineraries;
    }

    public void setItinerary(List<CustomerItineraryDTO> itinerary) {
        this.itineraries = itinerary;
    }
}
