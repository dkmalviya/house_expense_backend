package com.appkode.house.model.request.house;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseRequest {

    @Pattern(regexp = "^[a-zA-Z\\s]+$")
    @Size(min = 2, max = 20)
    private String houseName;

    private String addressId;

    @Pattern(regexp = "^[a-zA-Z0-9-\\s]+$")
    @Size(min = 1, max = 10)
    private String houseNumber;

    @Pattern(regexp = "^[a-zA-Z\\s]+$")
    @Size(min = 3, max = 30)
    private String buildingName;

    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$")
    @Size(min = 3, max = 30)
    private String street;

    @Pattern(regexp = "^[a-zA-Z\\s]+$")
    @Size(min = 3, max = 30)
    private String area;

    @Pattern(regexp = "^[a-zA-Z\\s]+$")
    @Size(min = 3, max = 30)
    private String landmark;

    @Pattern(regexp = "^[a-zA-Z\\s]+$")
    @Size(min = 3, max = 30)
    private String city;

    @Pattern(regexp = "^[0-9\\s]+$")
    @Size(min = 6, max = 6)
    private String pinCode;


    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$")
    @Size(min = 3, max = 50)
    private String societyName;

}
