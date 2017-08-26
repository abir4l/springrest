package com.app.hostel.dto;

/**
 * Created by abiral on 7/15/17.
 */
public class CustomerProductDTO {

    private int quantity;
    private double price;
    private String description;


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
