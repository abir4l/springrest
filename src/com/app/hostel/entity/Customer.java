package com.app.hostel.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity(name = "tbl_customers")
public class Customer extends Base {

	@Column(name = "name")
	private String name;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customer", cascade = CascadeType.MERGE)
	private Set<CustomerProducts> products;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customer", cascade = CascadeType.MERGE)
	private Set<CustomerItinerary> itineraries;

	@Column(name = "email")
	private String email;


	@Column(name = "passport_number")
	private String passport_number;

	@Column(name = "nation")
	private String nation;

	@Transient
	@JsonIgnore
	private Integer parent_id;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "parent_id")
	private Customer parent;

	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.MERGE, orphanRemoval = true)
	@JsonIgnore
	private Set<Customer> children;

	public Integer getParent_id() {
		return parent_id;
	}

	public Customer getParent() {
		return parent;
	}

	public Set<Customer> getChildren() {
		return children;
	}

	public void setChildren(Set<Customer> children) {
		this.children = children;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassport_number() {
		return passport_number;
	}

	public void setPassport_number(String passport_number) {
		this.passport_number = passport_number;
	}

	public String getNation() {
		return nation;
	}

	public Set<CustomerItinerary> getItineraries() {
		return itineraries;
	}

	public void setItineraries(Set<CustomerItinerary> itineraries) {
		this.itineraries = itineraries;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public Set<CustomerProducts> getProducts() {
		return products;
	}

	public void setProducts(Set<CustomerProducts> products) {
		this.products = products;
	}



}

