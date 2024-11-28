package com.javaweb.service.impl;

import com.google.protobuf.MapEntry;
import com.javaweb.entity.AssignmentBuildingEntity;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.AssignmentBuildingRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.AssignBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class AssignBuildingServiceImpl implements AssignBuildingService {

    @Autowired
    private AssignmentBuildingRepository assignmentBuildingRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<ResponseDTO> findAllStaff(Long id) {
        List<UserEntity> userEntityList = userRepository.findAll();
        List<AssignmentBuildingEntity> assignmentBuildingEntityList = assignmentBuildingRepository.findByBuildingId(id);
        List<ResponseDTO> responseDTOList = new ArrayList<>();

        userEntityList.forEach(userEntity -> {
            ResponseDTO responseDTO = new ResponseDTO();
            StaffResponseDTO staffResponseDTO = new StaffResponseDTO();
            staffResponseDTO.setStaffId(userEntity.getId());
            staffResponseDTO.setFullName(userEntity.getFullName());
            staffResponseDTO.setChecked(isChecked(userEntity.getId(), assignmentBuildingEntityList));
            responseDTO.setData(staffResponseDTO);
            responseDTOList.add(responseDTO);
        });
        return responseDTOList;
    }

    @Override
    @Transactional
    public void updateAssignmentBuilding(Map<Long, Long> mp) {
        Set<Map.Entry<Long, Long>> entrySet = mp.entrySet();
        assignmentBuildingRepository.deleteByBuildingId(entrySet.iterator().next().getValue());
        List<AssignmentBuildingEntity> assignmentBuildingEntityList = new ArrayList<>();
        for (Map.Entry<Long, Long> entry : entrySet) {
            AssignmentBuildingEntity assignmentBuildingEntity = new AssignmentBuildingEntity();
            BuildingEntity buildingEntity = new BuildingEntity();
            UserEntity userEntity = new UserEntity();
            buildingEntity.setId(entry.getValue());
            userEntity.setId(entry.getKey());
            assignmentBuildingEntity.setBuildingEntity(buildingEntity);
            assignmentBuildingEntity.setUserEntity(userEntity);
            assignmentBuildingEntityList.add(assignmentBuildingEntity);
        }
        assignmentBuildingRepository.saveAll(assignmentBuildingEntityList);
    }

    public boolean isChecked(Long id, List<AssignmentBuildingEntity> assignmentBuildingEntityList) {
        for (AssignmentBuildingEntity assignmentBuildingEntity : assignmentBuildingEntityList) {
            if (assignmentBuildingEntity.getUserEntity().getId().equals(id)) {
                return true;
            }
        }
        return false;
    }


}
