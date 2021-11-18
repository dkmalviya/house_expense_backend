package com.appkode.house.model.request.house_member;

import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class HouseMemberRequest {

    private Long memberId;
    private Boolean status;
}
