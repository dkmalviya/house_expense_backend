package com.appkode.house.model.response.house_member;


import com.appkode.house.model.dto.UserProfileDto;
import com.appkode.house.model.response.house.HouseResponse;
import lombok.Data;

import java.util.List;

@Data
public class HouseMemberResponse {

    private HouseResponse houseResponse;
    private List<UserProfileDto> userProfiles;
}
