package com.javaweb.converter;

import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.utils.MapUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class BuildingRequestConverter {

    public BuildingSearchRequest toBuildingSearchRequest(Map<String, Object> params, List<String> type) {

        BuildingSearchRequest buildingSearchRequest = BuildingSearchRequest.builder()
                .product_name(MapUtils.getObject(params, "product_name", String.class))
                .level(MapUtils.getObject(params, "level", Long.class))
                .area_from(MapUtils.getObject(params, "area_from", Long.class))
                .area_to(MapUtils.getObject(params, "area_to", Long.class))
                .direction(MapUtils.getObject(params, "direction", String.class))
                .district(MapUtils.getObject(params, "district", String.class))
                .floor_area(MapUtils.getObject(params, "floor_area", Long.class))
                .manager_name(MapUtils.getObject(params, "manager_name", String.class))
                .manager_phone(MapUtils.getObject(params, "manager_phone", String.class))
                .ward(MapUtils.getObject(params, "ward", String.class))
                .number_of_basement(MapUtils.getObject(params, "number_of_basement", Long.class))
                .rent_price_from(MapUtils.getObject(params, "rent_price_from", Long.class))
                .rent_price_to(MapUtils.getObject(params, "rent_price_to", Long.class))
                .staff_id(MapUtils.getObject(params, "staff_id", Long.class))
                .street(MapUtils.getObject(params, "street", String.class))
                .type(type)
                .build();
        return buildingSearchRequest;
    }


}
