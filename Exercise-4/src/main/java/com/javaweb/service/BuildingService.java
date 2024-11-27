package com.javaweb.service;

import com.javaweb.model.request.BuildingEditRequestDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface BuildingService {
    List<BuildingSearchResponse> FindAllBuildings(Map<String, Object> params, List<String> type);
    void addBuilding(BuildingEditRequestDTO buildingEditRequestDTO);
}
