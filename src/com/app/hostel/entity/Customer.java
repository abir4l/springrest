package com.app.hostel.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

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

	@Column(name="from_date")
	private Date from;

	@Column(name="to_date")
	private Date to;

	@Column(name = "passport_number")
	private String passportNumber;

	@Column(name = "nation")
	private String nation;



	@Transient
	private Integer parentId;

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "parent_id")
	@JsonIgnore
	private Customer parent;

	@OneToMany(mappedBy = "parent", fetch = FetchType.EAGER, cascade = CascadeType.MERGE, orphanRemoval = true)
	@JsonIgnore
	private Set<Customer> children;

	public Integer getParentId() {
		return parentId;
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

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
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

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
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

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	public void setParent(Customer parent) {
		this.parent = parent;
	}


}

