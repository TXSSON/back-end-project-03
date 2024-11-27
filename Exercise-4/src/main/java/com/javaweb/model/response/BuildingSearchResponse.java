package com.javaweb.model.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuildingSearchResponse{
	private String id;
	private String productName;
	private String address;
	private Long numberOfBasements;
	private String nameManager;
	private String phoneNumber;
	private Long floorArea;
	private String rentArea;
    private String emptyArea;
    private Long rentPrice;
    private String serviceFee;
    private Double brokerageFee;
}
