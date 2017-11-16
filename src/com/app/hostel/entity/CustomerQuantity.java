package com.app.hostel.entity;

import javax.persistence.Column;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by abiral on 11/16/17.
 */
public class CustomerQuantity {

    private Integer customerId;
    private Integer productId;
    private Integer quantity;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
