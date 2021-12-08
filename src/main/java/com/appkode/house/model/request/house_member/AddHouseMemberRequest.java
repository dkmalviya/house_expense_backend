package com.appkode.house.model.request.house_member;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
public class AddHouseMemberRequest {

    private Long addressId;
    private String startDate;
    private String endDate;



}
