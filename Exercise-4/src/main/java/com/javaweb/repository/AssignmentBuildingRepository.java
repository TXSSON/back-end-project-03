package com.javaweb.repository;

import com.javaweb.entity.AssignmentBuildingEntity;
import com.javaweb.repository.custom.AssignmentBuildingRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentBuildingRepository extends JpaRepository<AssignmentBuildingEntity, Long>, AssignmentBuildingRepositoryCustom {
}
