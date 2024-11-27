package com.javaweb.model.request;

import com.javaweb.entity.RentAreaEntity;

import java.util.List;

public class BuildingEditRequestDTO {
    private Long id;
    private String productName;
    private Long floorArea;
    private String district;
    private String ward;
    private String street;
    private String Structure;
    private Long numberOfBasement;
    private String direction;
    private Long level;
    private Long rentPrice;
    private List<Integer> rentArea;
    private String rentPriceDescription;
    private String  type;
    private String serviceFee;
    private String carFee;
    private String motorBikeFee;
    private String overTimeFee;
    private String electricityFee;
    private String waterFee;
    private String deposit;
    private String payment;
    private String rentTime;
    private String decorationTime;
    private String nameManager;
    private String phoneManager;
    private String brokerageFee;
    private String note;

    public Long getNumberOfBasement() {
        return numberOfBasement;
    }

    public void setNumberOfBasement(Long numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public String getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getCarFee() {
        return carFee;
    }

    public void setCarFee(String carFee) {
        this.carFee = carFee;
    }

    public String getMotorBikeFee() {
        return motorBikeFee;
    }

    public void setMotorBikeFee(String motorBikeFee) {
        this.motorBikeFee = motorBikeFee;
    }

    public String getOverTimeFee() {
        return overTimeFee;
    }

    public void setOverTimeFee(String overTimeFee) {
        this.overTimeFee = overTimeFee;
    }

    public String getElectricityFee() {
        return electricityFee;
    }

    public void setElectricityFee(String electricityFee) {
        this.electricityFee = electricityFee;
    }

    public String getWaterFee() {
        return waterFee;
    }

    public void setWaterFee(String waterFee) {
        this.waterFee = waterFee;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getRentTime() {
        return rentTime;
    }

    public void setRentTime(String rentTime) {
        this.rentTime = rentTime;
    }

    public String getDecorationTime() {
        return decorationTime;
    }

    public void setDecorationTime(String decorationTime) {
        this.decorationTime = decorationTime;
    }

    public String getNameManager() {
        return nameManager;
    }

    public void setNameManager(String nameManager) {
        this.nameManager = nameManager;
    }

    public String getPhoneManager() {
        return phoneManager;
    }

    public void setPhoneManager(String phoneManager) {
        this.phoneManager = phoneManager;
    }

    public String getBrokerageFee() {
        return brokerageFee;
    }

    public void setBrokerageFee(String brokerageFee) {
        this.brokerageFee = brokerageFee;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLevel() {
        return level;
    }

    public String getProductName() {
        return productName;
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



    public String getRentPriceDescription() {
        return rentPriceDescription;
    }

    public String getType() {
        return type;
    }

    public void setName(String productName) {
        this.productName = productName;
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

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<Integer> getRentArea() {
        return rentArea;
    }

    public void setRentArea(List<Integer> rentArea) {
        this.rentArea = rentArea;
    }

    public void setRentPriceDescription(String rentPriceDescription) {
        this.rentPriceDescription = rentPriceDescription;
    }

    public void setType(String type) {
        this.type = type;
    }
}
