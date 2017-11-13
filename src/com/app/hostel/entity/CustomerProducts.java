package com.app.hostel.entity;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;

/**
 * Created by abiral on 5/13/17.
 */
@Entity
@Table(name = "tbl_customer_products")
public class CustomerProducts{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;

    @Transient
    private Integer customerId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;


    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
