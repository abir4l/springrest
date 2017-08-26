package com.app.hostel.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by abiral on 5/14/17.
 */
@Embeddable
public class CustomerProductsId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id",insertable = false,updatable = false)
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "id",insertable = false,updatable = false)
    private Product product;

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerProductsId that = (CustomerProductsId) o;

        if (customer != null ? !customer.equals(that.customer) : that.customer != null) return false;
        if ( product != null ? !product.equals(that.product) : that.product != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }
}
