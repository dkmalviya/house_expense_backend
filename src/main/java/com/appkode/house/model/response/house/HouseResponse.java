package com.appkode.house.model.response.house;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseResponse {
    private String houseName;
    private Long addressId;
    private String houseNumber;
    private String buildingName;
    private String societyName;
    private String street;
    private String area;
    private String landmark;
    private String city;
    private String pinCode;
}
