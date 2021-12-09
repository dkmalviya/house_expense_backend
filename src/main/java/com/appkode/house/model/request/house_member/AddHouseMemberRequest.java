package com.appkode.house.model.request.house_member;

import lombok.Data;


@Data
public class AddHouseMemberRequest {

    private Long addressId;
    private String startDate;
    private String endDate;


}
