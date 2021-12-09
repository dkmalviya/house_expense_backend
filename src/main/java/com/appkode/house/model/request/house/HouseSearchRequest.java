package com.appkode.house.model.request.house;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseSearchRequest {

    @Pattern(regexp = "^[a-zA-Z0-9-\\s]+$")
    private String houseNumber;

    @Pattern(regexp = "^[a-zA-Z0-9-\\s]+$")
    private String societyName;

    @Pattern(regexp = "^[0-9-\\s]+$")
    @Size(min = 6, max = 6)
    private String pinCode;


}
