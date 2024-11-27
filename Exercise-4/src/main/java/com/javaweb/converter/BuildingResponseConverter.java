package com.javaweb.converter;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.model.response.BuildingSearchResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class BuildingResponseConverter {

    @Autowired
    private ModelMapper modelMapper;

    public BuildingSearchResponse toBuildingSearchResponse(BuildingEntity buildingEntity) {
        BuildingSearchResponse buildingSearchResponse = modelMapper.map(buildingEntity, BuildingSearchResponse.class);
        buildingSearchResponse.setAddress(buildingEntity.getStreet() + ", " + buildingEntity.getWard() + ", " + buildingEntity.getDistrict());
        List <RentAreaEntity> rentAreaEntities = buildingEntity.getRentArea();
        if (rentAreaEntities != null && !rentAreaEntities.isEmpty()) {
            String rentAreaValue = rentAreaEntities.stream().map(areaEntity -> String.valueOf(areaEntity.getValue())).collect(Collectors.joining(", "));
            buildingSearchResponse.setRentArea(rentAreaValue);
        } else {
            buildingSearchResponse.setRentArea("");
        }
        return buildingSearchResponse;
    }

}
