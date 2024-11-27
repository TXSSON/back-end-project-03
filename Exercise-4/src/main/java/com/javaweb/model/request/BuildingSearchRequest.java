package com.javaweb.model.request;

import com.javaweb.model.dto.AbstractDTO;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BuildingSearchRequest extends AbstractDTO {
    private String product_name;
    private Long floor_area;
    private String ward;
    private String street;
    private String district;
    private Long number_of_basement;
    private String direction;
    private Long level;
    private Long area_from;
    private Long area_to;
    private Long rent_price_to;
    private Long rent_price_from;
    private String manager_name;
    private String manager_phone;
    private Long staff_id;
    private List<String> type;
}
