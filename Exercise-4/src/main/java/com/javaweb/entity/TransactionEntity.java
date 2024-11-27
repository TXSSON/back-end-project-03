package com.javaweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
@Setter
@Getter
public class TransactionEntity extends BaseEntity {
    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "custormerId", nullable = false)
    private CustomerEntity customer;

}
