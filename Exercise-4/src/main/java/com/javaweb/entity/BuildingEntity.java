package com.javaweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "building")
public class BuildingEntity extends BaseEntity{

    @Column(nullable = false, name = "productName")
    private String productName;
    @Column (nullable = false, name = "street")
    private String street;
    @Column (nullable = false, name = "ward")
    private String ward;
    @Column(nullable = false, name = "district")
    private String district;

    @OneToMany (mappedBy = "buildingEntity")
    private List<RentAreaEntity> rentArea;

    @OneToMany(mappedBy = "buildingEntity")
    private List<AssignmentBuildingEntity> userEntities;

    @Column(name = "structure")
    private String structure;
    @Column(name = "numberOfBasement")
    private Integer numberOfBasements;
    @Column(name = "floorArea")
    private Integer floorArea;
    @Column(name = "direction")
    private String direction;
    @Column(name = "level")
    private String level;
    @Column (name = "rentPrice", nullable = false)
    private Integer rentPrice;
    @Column(name = "rentPriceDescription")
    private String rentPriceDescription;
    @Column(name =  "serviceFee")
    private String serviceFee;
    @Column(name = "carFee")
    private String carFee;
    @Column(name = "motorBikeFee")
    private String motorBikeFee;
    @Column(name = "overTimeFee")
    private String overTimeFee;
    @Column(name = "waterFee")
    private String waterFee;
    @Column(name = "electricityFee")
    private String electricityFee;
    @Column (name = "deposit")
    private String deposit;
    @Column (name = "payment")
    private String payment;
    @Column (name = "rentTime")
    private String rentTime;
    @Column(name = "decorationTime")
    private String decorationTime;
    @Column(name = "brokerageFee")
    private String brokerageFee;
    @Column(name = "note")
    private String note;
    @Column(name = "linkOfBuilding")
    private String linkOfBuilding;
    @Column(name = "map")
    private String map;
    @Column(name = "image")
    private String image;
    @Column(name = "managerName")
    private String nameManager;
    @Column(name = "managerPhone")
    private String phoneNumber;
    @Column(name = "type")
    private String type;
}
