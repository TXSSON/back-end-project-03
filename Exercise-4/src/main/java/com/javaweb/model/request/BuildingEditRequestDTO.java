package com.javaweb.model.request;

import java.util.List;

public class BuildingEditRequestDTO {
    private Long id;
    private String name;
    private Long floorArea;
    private String district;
    private String ward;
    private String street;
    private String Structure;
    private String direction;
    private Long level;
    private Long rentPrice;
    private String rentArea;
    private String rentPriceDescription;
    private List<String> typeCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public Long getFloorArea() {
        return floorArea;
    }

    public String getDistrict() {
        return district;
    }

    public String getWard() {
        return ward;
    }

    public String getStreet() {
        return street;
    }

    public String getStructure() {
        return Structure;
    }

    public String getDirection() {
        return direction;
    }

    public Long getRentPrice() {
        return rentPrice;
    }

    public String getRentArea() {
        return rentArea;
    }

    public String getRentPriceDescription() {
        return rentPriceDescription;
    }

    public List<String> getTypeCode() {
        return typeCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFloorArea(Long floorArea) {
        this.floorArea = floorArea;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setStructure(String structure) {
        Structure = structure;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public void setRentPrice(Long rentPrice) {
        this.rentPrice = rentPrice;
    }

    public void setRentArea(String rentArea) {
        this.rentArea = rentArea;
    }

    public void setRentPriceDescription(String rentPriceDescription) {
        this.rentPriceDescription = rentPriceDescription;
    }

    public void setTypeCode(List<String> typeCode) {
        this.typeCode = typeCode;
    }
}
