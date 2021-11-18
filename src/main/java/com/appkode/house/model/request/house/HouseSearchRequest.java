package com.appkode.house.model.request.house;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseSearchRequest {

    @Pattern(regexp = "^[a-zA-Z0-9-\\s]+$")
    private String houseNumber;

    @Pattern(regexp = "^[a-zA-Z0-9-\\s]+$")
    private String buildingName;

    @Pattern(regexp = "^[a-zA-Z0-9-\\s]+$")
    private String area;

    @Pattern(regexp = "^[a-zA-Z0-9-\\s]+$")
    private String city;
}
