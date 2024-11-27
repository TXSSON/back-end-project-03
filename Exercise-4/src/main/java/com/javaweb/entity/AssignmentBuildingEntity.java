package com.javaweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "assignmentbuilding")
public class AssignmentBuildingEntity extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "building_id", nullable = false)
    private BuildingEntity buildingEntity;

    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    private UserEntity userEntity;


}
