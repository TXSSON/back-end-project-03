package com.javaweb.service;

import com.javaweb.entity.AssignmentBuildingEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.repository.AssignmentBuildingRepository;

import java.util.List;
import java.util.Map;

public interface AssignBuildingService {
    List<ResponseDTO> findAllStaff (Long id);
    void updateAssignmentBuilding (Map<Long, Long> mp);
}
