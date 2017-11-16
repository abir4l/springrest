package com.app.hostel.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by abiral on 11/17/17.
 */


@Entity
@Table(name = "tbl_customer_products")
public class CustomerTransaction {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "created_on" ,nullable = false,
            columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date createdOn;


    @Column(name="amount")
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
