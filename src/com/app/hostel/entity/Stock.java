package com.app.hostel.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "tbl_stock")
public class Stock extends Base {

	@ManyToOne(cascade=CascadeType.MERGE)
	private Product product;

	@Column(name = "final_stock")
	private Integer finalStock;

	@Column(name = "initial_stock")
	private Integer initialStock;

	@Column(name = "spent_quantity")
	private Integer spent_quantity;

	@Column(name="remarks")
	private String remarks;
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public Integer getFinalStock() {
		return finalStock;
	}

	public void setFinalStock(Integer finalStock) {
		this.finalStock = finalStock;
	}

	public Integer getInitialStock() {
		return initialStock;
	}

	public void setInitialStock(Integer initialStock) {
		this.initialStock = initialStock;
	}

	public Integer getSpent_quantity() {
		return spent_quantity;
	}

	public void setSpent_quantity(Integer spent_quantity) {
		this.spent_quantity = spent_quantity;
	}
	





}