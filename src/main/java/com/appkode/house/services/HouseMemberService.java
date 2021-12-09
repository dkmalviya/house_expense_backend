package com.appkode.house.services;

import com.appkode.house.model.request.house_member.AddHouseMemberRequest;
import com.appkode.house.model.request.house_member.HouseMemberRequest;
import com.appkode.house.model.request.house_member.HouseMemberSearchRequest;
import com.appkode.house.model.response.house_member.HouseMemberResponse;

public interface HouseMemberService {

    boolean addHouseMember(AddHouseMemberRequest addHouseMemberRequest);

    boolean updateHouseMemberEndDate(Long userId, Long houseId);

    boolean updateStatusOfMember(HouseMemberRequest houseMemberRequest);

    boolean updateAdminOfHouse(HouseMemberRequest houseMemberRequest);

    boolean removeHouseMember(HouseMemberRequest houseMemberRequest);

    HouseMemberResponse getAllHouseMember(Long houseId);

    HouseMemberResponse getAllActiveHouseMember(Long houseId);

    HouseMemberResponse searchHouseByMembersMobileNumber(HouseMemberSearchRequest houseMemberSearchRequest);

}
