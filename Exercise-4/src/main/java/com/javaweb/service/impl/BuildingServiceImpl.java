package com.javaweb.service.impl;

import com.javaweb.converter.BuildingEditRequestConverter;
import com.javaweb.converter.BuildingRequestConverter;
import com.javaweb.converter.BuildingResponseConverter;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.model.request.BuildingEditRequestDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private BuildingResponseConverter buildingResponseConverter;

    @Autowired
    private BuildingRequestConverter buildingRequestConverter;

    @Autowired
    private BuildingEditRequestConverter buildingEditRequestConverter;
    @Autowired
    private RentAreaRepository rentAreaRepository;

    @Override
    public List<BuildingSearchResponse> FindAllBuildings(Map<String, Object> params, List<String> type) {

        BuildingSearchRequest buildingSearchRequest = buildingRequestConverter.toBuildingSearchRequest(params, type);
        List<BuildingEntity> buildingEntities = buildingRepository.findAll(buildingSearchRequest);

        List<BuildingSearchResponse> buildingSearchResponseList = new ArrayList<>();
        BuildingSearchResponse buildingSearchResponse;
        for (BuildingEntity buildingEntity : buildingEntities) {
            buildingSearchResponse = buildingResponseConverter.toBuildingSearchResponse(buildingEntity);
            buildingSearchResponseList.add(buildingSearchResponse);
        }
        return buildingSearchResponseList ;
    }

    @Override
    @Transactional
    public void addBuilding(BuildingEditRequestDTO buildingEditRequestDTO) {
        // Chuyển đổi từ DTO sang BuildingEntity
        BuildingEntity buildingEntity = buildingEditRequestConverter.toBuildingEntity(buildingEditRequestDTO);

        // Lưu BuildingEntity trước để nhận ID tự động
        buildingRepository.save(buildingEntity);

        // Sau khi lưu BuildingEntity, lấy ID của nó để gán cho RentAreaEntity
        List<RentAreaEntity> rentAreaEntities = buildingEditRequestConverter.toRentAreaEntity(buildingEditRequestDTO);

        // Gán ID của BuildingEntity cho mỗi RentAreaEntity
        for (RentAreaEntity rentAreaEntity : rentAreaEntities) {
            rentAreaEntity.setBuildingEntity(buildingEntity); // Gán BuildingEntity cho RentAreaEntity
        }
        // Lưu tất cả RentAreaEntity đã gán BuildingEntity
        rentAreaRepository.saveAll(rentAreaEntities);
    }
}