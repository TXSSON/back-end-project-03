package com.javaweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "rentarea")
@Setter
@Getter
public class RentAreaEntity extends BaseEntity {
    @Column(name = "value")
    private Integer value;

    @ManyToOne
    @JoinColumn(name = "building_Id", nullable = false)
    private BuildingEntity  buildingEntity;

}
