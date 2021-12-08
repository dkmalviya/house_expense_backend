package com.appkode.house.model.request.house_member;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class HouseMemberSearchRequest {

    @NotBlank
    @Pattern(regexp = "^[0-9\\s]+$")
    @Size(min = 10, max = 10)
    String houseMemberMobileNumber;

}
