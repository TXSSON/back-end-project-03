package com.javaweb.controller.admin;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.enums.BuildingType;
import com.javaweb.enums.DistrictCode;
import com.javaweb.model.request.BuildingEditRequestDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.service.BuildingService;
import com.javaweb.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController(value = "buildingControllerOfAdmin")
@RequestMapping("/admin/")
public class BuildingController {
    @Autowired
    private UserService userService;

    @Autowired
    private BuildingService buildingService;

    @GetMapping("building-search")
    public ModelAndView buildingSearch() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/Building/list");
        // Tạo một đối tượng BuildingSearchResponse
        List<BuildingSearchResponse> buildingSearchResponses = new ArrayList<>();
        BuildingSearchRequest buildingSearchRequest = new BuildingSearchRequest();
        // Thêm đối tượng vào model với tên "buildingSearchRequest"
        mav.addObject("buildingSearchRequest", buildingSearchRequest);
        mav.addObject("buildingSearchResponses", buildingSearchResponses);
        mav.addObject("listStaffs", userService.getStaffs());
        mav.addObject("districtCode", DistrictCode.type());
        mav.addObject("typeCode", BuildingType.type());
        return mav;
    }

    @GetMapping("building-list")
    public ModelAndView buildingList(@RequestParam Map<String,Object> params,
                                     @RequestParam(required = false) ArrayList<String> type,
                                     @ModelAttribute BuildingSearchRequest buildingSearchRequest) {
        List<BuildingSearchResponse> buildingSearchResponses = buildingService.FindAllBuildings(params, type);
        System.out.print("kích thước của buildingSearchResponses: ");
        System.out.println(buildingSearchResponses.size());
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/Building/list");
        mav.addObject("buildingSearchResponses", buildingSearchResponses);
        mav.addObject("buildingSearchRequest", buildingSearchRequest);
        mav.addObject("listStaffs", userService.getStaffs());
        mav.addObject("districtCode", DistrictCode.type());
        mav.addObject("typeCode", BuildingType.type());
        return mav;
    }

    @RequestMapping(value = "building-edit", method = RequestMethod.GET)
    public ModelAndView buildingEdit() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/Building/edit");
        mav.addObject("buildingEditRequestDTO", new BuildingEditRequestDTO());
        mav.addObject("districtCode", DistrictCode.type());
        mav.addObject("typeCode", BuildingType.type());
        return mav;
    }

    @RequestMapping(value = "building-edit/{id}", method = RequestMethod.GET)
    public ModelAndView buildingEdit(@PathVariable Long id) {

        BuildingEditRequestDTO buildingEditRequestDTO = buildingService.FindBuildingById(id);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/Building/edit");
        mav.addObject("buildingEditRequestDTO", buildingEditRequestDTO);
        mav.addObject("districtCode", DistrictCode.type());
        mav.addObject("typeCode", BuildingType.type());
        return mav;
    }
}
