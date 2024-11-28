package com.javaweb.converter;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.model.request.BuildingEditRequestDTO;
import com.javaweb.service.BuildingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuildingEditRequestConverter {

    @Autowired
    private ModelMapper modelMapper;
    // Chuyển đổi BuildingEditRequestDTO thành BuildingEntity
    public BuildingEntity toBuildingEntity(BuildingEditRequestDTO buildingEditRequestDTO) {
        // Chuyển đổi từ DTO sang Entity
        BuildingEntity buildingEntity = modelMapper.map(buildingEditRequestDTO, BuildingEntity.class);
        return buildingEntity;
    }
    // Chuyển đổi BuildingEditRequestDTO thành RentAreaEntity
    public List<RentAreaEntity> toRentAreaEntity(BuildingEditRequestDTO buildingEditRequestDTO) {
        List<RentAreaEntity> rentAreaEntities = new ArrayList<>();
        if (buildingEditRequestDTO.getRentArea() != null) {
            for (Integer value : buildingEditRequestDTO.getRentArea()) {
                RentAreaEntity rentAreaEntity = new RentAreaEntity();
                rentAreaEntity.setValue(value);
                rentAreaEntities.add(rentAreaEntity);
            }
        }
        return rentAreaEntities;
    }



}
