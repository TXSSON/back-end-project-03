package com.javaweb.api.admin;


import com.javaweb.model.request.BuildingEditRequestDTO;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RestController(value = "")
@RequestMapping("/api/building/")
public class BuildingAPI {

    @Autowired
    private BuildingService buildingService;


    @PostMapping()
    public void addAndUpdateBuilding(@RequestBody BuildingEditRequestDTO dto) {
        buildingService.addBuilding(dto);

    }
    @DeleteMapping("{ids}")
    public void deleteBuilding(@PathVariable List<Long> ids) {
        System.out.println("Success deleteBuilding");
    }
    @GetMapping("{id}")
    public List<ResponseDTO> findStaff(@PathVariable Long id){
        StaffResponseDTO staffResponseDTO = new StaffResponseDTO();
        staffResponseDTO.setStaffId(3L);
        staffResponseDTO.setFullName("Nguyễn Văn Tài");
        staffResponseDTO.setChecked(true);
        StaffResponseDTO staffResponseDTO1 = new StaffResponseDTO();
        staffResponseDTO1.setStaffId(4L);
        staffResponseDTO1.setFullName("Trần Văn Nam");
        staffResponseDTO1.setChecked(false);
        List<ResponseDTO> responseDTO = new ArrayList<>();
        ResponseDTO responseDTO1 = new ResponseDTO();
        responseDTO1.setData(staffResponseDTO);
        responseDTO.add(responseDTO1);
        ResponseDTO responseDTO2 = new ResponseDTO();
        responseDTO2.setData(staffResponseDTO1);
        responseDTO.add(responseDTO2);
        return responseDTO;
    }
}

