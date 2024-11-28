package com.javaweb.converter;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.model.request.BuildingEditRequestDTO;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BuildingEntityConverter {


    // Phương thức ánh xạ từ BuildingEntity sang BuildingEditRequestDTO
    public BuildingEditRequestDTO toBuildingEditRequestDTO(BuildingEntity buildingEntity) {
        BuildingEditRequestDTO dto = new BuildingEditRequestDTO();

        // Ánh xạ các trường đơn giản
        dto.setId(buildingEntity.getId());
        dto.setProductName(buildingEntity.getProductName());
        dto.setFloorArea(buildingEntity.getFloorArea() != null ? Long.valueOf(buildingEntity.getFloorArea()) : null); // chuyển đổi kiểu dữ liệu nếu cần
        dto.setDistrict(buildingEntity.getDistrict());
        dto.setWard(buildingEntity.getWard());
        dto.setStreet(buildingEntity.getStreet());
        dto.setStructure(buildingEntity.getStructure());
        dto.setNumberOfBasement(buildingEntity.getNumberOfBasements() != null ? Long.valueOf(buildingEntity.getNumberOfBasements()) : null);
        dto.setDirection(buildingEntity.getDirection());
        dto.setLevel(buildingEntity.getLevel() != null ? Long.valueOf(buildingEntity.getLevel()) : null);
        dto.setRentPrice(buildingEntity.getRentPrice().longValue());
        dto.setRentPriceDescription(buildingEntity.getRentPriceDescription());
        dto.setType(buildingEntity.getType());
        dto.setServiceFee(buildingEntity.getServiceFee());
        dto.setCarFee(buildingEntity.getCarFee());
        dto.setMotorBikeFee(buildingEntity.getMotorBikeFee());
        dto.setOverTimeFee(buildingEntity.getOverTimeFee());
        dto.setElectricityFee(buildingEntity.getElectricityFee());
        dto.setWaterFee(buildingEntity.getWaterFee());
        dto.setDeposit(buildingEntity.getDeposit());
        dto.setPayment(buildingEntity.getPayment());
        dto.setRentTime(buildingEntity.getRentTime());
        dto.setDecorationTime(buildingEntity.getDecorationTime());
        dto.setNameManager(buildingEntity.getNameManager());
        dto.setPhoneManager(buildingEntity.getPhoneNumber());
        dto.setBrokerageFee(buildingEntity.getBrokerageFee());
        dto.setNote(buildingEntity.getNote());

        // Ánh xạ danh sách RentAreaEntity -> List<Integer> (giả sử bạn chỉ lấy id)
        List<Integer> rentAreaValues = buildingEntity.getRentArea().stream()
                .map(RentAreaEntity::getValue) // Lấy value của mỗi RentAreaEntity
                .collect(Collectors.toList());
        dto.setRentArea(rentAreaValues);

        return dto;
    }
}
