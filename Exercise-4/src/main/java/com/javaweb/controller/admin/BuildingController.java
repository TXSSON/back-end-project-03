package com.javaweb.controller.admin;

import com.javaweb.enums.BuildingType;
import com.javaweb.enums.DistrictCode;
import com.javaweb.model.request.BuildingEditRequestDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller(value = "buildingControllerOfAdmin")

public class BuildingController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/admin/building-list", method = RequestMethod.GET)
    public ModelAndView buildingList(@ModelAttribute BuildingSearchRequest buildingSearchRequest, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/Building/list");
        List<BuildingSearchResponse> buildingSearchResponses = new ArrayList<>();
        BuildingSearchResponse item1 = new BuildingSearchResponse();
        item1.setId(3L);
        item1.setName("FTP Tower");
        item1.setAddress("Số 2, đường Trường Chinh, Quận Hai Bà Trưng");
        item1.setManagerName("Anh Nam");
        item1.setManagerPhone("0123456789");
        item1.setFloorArea(500L);
        item1.setEmptyArea("700");
        item1.setRentArea("100, 200, 300");
        item1.setBrokerageFee(0D);
        item1.setServiceFee("0");
        item1.setNumberOfBasement(4L);
        buildingSearchResponses.add(item1);
        BuildingSearchResponse item2 = new BuildingSearchResponse();
        item2.setId(4L);
        item2.setName("Sunshine Tower");
        item2.setAddress("Số 12, đường Nguyễn Trãi, Quận Thanh Xuân");
        item2.setManagerName("Chị Lan");
        item2.setManagerPhone("0987654321");
        item2.setFloorArea(800L);
        item2.setEmptyArea("600");
        item2.setRentArea("150, 250, 350");
        item2.setBrokerageFee(5D);
        item2.setServiceFee("500000");
        item2.setNumberOfBasement(3L);
        buildingSearchResponses.add(item2);
        mav.addObject("buildingSearchResponses", buildingSearchResponses);
        mav.addObject("buildingSearchRequest", buildingSearchRequest);
        mav.addObject("listStaffs", userService.getStaffs());
        mav.addObject("districtCode", DistrictCode.type());
        mav.addObject("typeCode", BuildingType.type());
        return mav;
    }

    @RequestMapping(value = "/admin/building-edit", method = RequestMethod.GET)
    public ModelAndView buildingEdit( HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/Building/edit");
        BuildingEditRequestDTO buildingEditRequestDTO = new BuildingEditRequestDTO();
        mav.addObject("buildingEditRequest", buildingEditRequestDTO);
        mav.addObject("districtCode", DistrictCode.type());
        mav.addObject("typeCode", BuildingType.type());
        return mav;
    }
    @RequestMapping(value = "/admin/building-edit/{id}", method = RequestMethod.GET)
    public ModelAndView buildingEdit(@PathVariable Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("admin/Building/edit");
        BuildingEditRequestDTO item1 = new BuildingEditRequestDTO();
        item1.setId(id);
        item1.setName("FTP Tower");
        item1.setStreet("Số 2, đường Trường Chinh");
        item1.setWard("Phường Cầu Dền");
        item1.setDistrict("Quận Hai Bà Trưng");
        item1.setDirection("Tây Nam");
        item1.setLevel(4L);
        item1.setFloorArea(500L);
        item1.setRentArea("100, 200, 300");
        item1.setRentPriceDescription("VND");
        ArrayList<String> types = new ArrayList<>();
        types.add("Nội Thất");
        types.add("Tầng Trệt");
        item1.setTypeCode(types);
        item1.setStructure("Cao Tầng");
        mav.addObject("buildingEditRequest", item1);
        mav.addObject("districtCode", DistrictCode.type());
        mav.addObject("typeCode", BuildingType.type());
        return mav;
    }
}
