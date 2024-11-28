package com.javaweb.api.admin;

import com.javaweb.model.request.BuildingEditRequestDTO;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.service.AssignBuildingService;
import com.javaweb.service.BuildingService;
import com.javaweb.service.impl.AssignBuildingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController(value = "")
@RequestMapping("/api")
public class BuildingAPI {

    @Autowired
    private BuildingService buildingService;
    @Autowired
    private AssignBuildingService assignBuildingService;
    @Autowired
    private AssignBuildingServiceImpl assignBuildingServiceImpl;

    @PostMapping("/building/")
    public void addAndUpdateBuilding(@RequestBody BuildingEditRequestDTO dto) {
        buildingService.addBuilding(dto);
    }

    @PostMapping("/assignment/")
    public void updateAssignmentBuilding(@RequestBody Map<Long, Long> mp) {
        assignBuildingService.updateAssignmentBuilding(mp);
    }

    @DeleteMapping("/building/{ids}")
    public void deleteBuilding(@PathVariable List<Long> ids) {
       buildingService.deleteBuilding(ids);
    }
    @GetMapping("/building/{id}")
    public List<ResponseDTO> findStaff(@PathVariable Long id){
        List<ResponseDTO> responseDTOs =assignBuildingServiceImpl.findAllStaff(id);
        return responseDTOs;
    }
}

