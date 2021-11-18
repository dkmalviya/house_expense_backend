package com.appkode.house.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class UserProfileDto {

    private Long memberId;
    private String email;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String maritalStatus;
    private boolean isActiveProfile;
    private String mobile;
    private String imageUrl;
    private boolean isAdminOfHouse;
    private boolean isActiveMember;
    private Date startDate;
    private Date endDate;

}
