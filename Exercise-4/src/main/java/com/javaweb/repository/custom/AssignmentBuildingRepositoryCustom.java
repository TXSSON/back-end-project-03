package com.javaweb.repository.custom;

import com.javaweb.entity.AssignmentBuildingEntity;

import java.util.List;

public interface AssignmentBuildingRepositoryCustom {
    void deleteByBuildingId(Long id);
    List<AssignmentBuildingEntity> findByBuildingId(Long id);
}
