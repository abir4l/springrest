package com.app.hostel.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


import org.codehaus.jackson.annotate.JsonIgnore;

@Entity(name = "tbl_products")
public class Product extends Base {

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "product", cascade = CascadeType.MERGE)
	private Set<CustomerProducts> customerProducts = new HashSet<>(0);

	@Column(name = "description")
	private String description;

	@Column(name = "sold")
	private Integer sold;

	@Column(name = "price", columnDefinition = "decimal(10,2)")
	private Double price;

	@Column(name = "quantity")
	private Integer quantity;

	@Transient
	private String remarks;

	public Integer getSold() {
		return sold;
	}

	public void setSold(Integer sold) {
		this.sold = sold;
	}


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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
