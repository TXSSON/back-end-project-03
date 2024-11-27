package com.javaweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "assignmentcustomer")
@Setter
@Getter
public class AssignmentCustomerEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn (name = "staff_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn (name = "customer_id", nullable = false)
    private CustomerEntity customer;

}
