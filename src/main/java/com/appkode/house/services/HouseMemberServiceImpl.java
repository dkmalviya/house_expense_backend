package com.appkode.house.services;

import com.appkode.house.converter.house.HouseResponseConverter;
import com.appkode.house.converter.user.UserProfileToUserProfileDtoConverter;
import com.appkode.house.error.exception.ResourceNotFoundException;
import com.appkode.house.model.dto.UserProfileDto;
import com.appkode.house.entity.House;
import com.appkode.house.entity.HouseMember;
import com.appkode.house.entity.User;
import com.appkode.house.entity.UserProfile;
import com.appkode.house.model.request.house_member.HouseMemberRequest;
import com.appkode.house.model.response.house.HouseResponse;
import com.appkode.house.model.response.house_member.HouseMemberResponse;
import com.appkode.house.repository.HouseMemberRepository;
import com.appkode.house.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class HouseMemberServiceImpl implements HouseMemberService {

    private final UserProfileService userProfileService;
    private final HouseRepository houseRepository;

    private final HouseMemberRepository houseMemberRepository;
    private final HouseResponseConverter houseResponseConverter;
    private final UserProfileToUserProfileDtoConverter userProfileToUserProfileDtoConverter;


    @Autowired
    public HouseMemberServiceImpl(UserProfileService userProfileService, HouseRepository houseRepository, HouseMemberRepository houseMemberRepository, HouseResponseConverter houseResponseConverter, UserProfileToUserProfileDtoConverter userProfileToUserProfileDtoConverter) {
        this.userProfileService = userProfileService;
        this.houseRepository = houseRepository;
        this.houseMemberRepository = houseMemberRepository;
        this.houseResponseConverter = houseResponseConverter;
        this.userProfileToUserProfileDtoConverter = userProfileToUserProfileDtoConverter;
    }


    @Override
    public boolean addHouseMember(Long houseId) {

        User user = userProfileService.getUser();
        House house = houseRepository.findById(houseId).orElseThrow(() -> new ResourceNotFoundException("Invalid house id"));
        ;
        HouseMember houseMember = new HouseMember();
        houseMember.setHouse(house);
        houseMember.setIsActiveMember(true);
        houseMember.setIsAdminOfHouse(true);
        houseMember.setUserId(user.getId());

        System.out.println(user.toString());
        System.out.println(house.toString());
        HouseMember resultHouseMember = houseMemberRepository.save(houseMember);
        if (Objects.isNull(resultHouseMember)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateHouseMemberEndDate(Long userId,Long houseMemberId) {
        return false;
    }

    @Override
    public boolean updateStatusOfMember(HouseMemberRequest houseMemberRequest) {

        User loginUser=userProfileService.getUser();

        HouseMember houseMember = houseMemberRepository.findById(houseMemberRequest.getMemberId()).orElseThrow(() -> new
                ResourceNotFoundException("Member not found"));

        houseMember.setIsActiveMember(houseMemberRequest.getStatus());
        //houseMember.updatedBy(loginUser.getId());
        HouseMember houseMemberResult = houseMemberRepository.save(houseMember);

        if(Objects.isNull(houseMemberResult)){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateAdminOfHouse(HouseMemberRequest houseMemberRequest) {
        User loginUser=userProfileService.getUser();

        HouseMember houseMember = houseMemberRepository.findById(houseMemberRequest.getMemberId()).orElseThrow(() -> new
                ResourceNotFoundException("Member not found"));

        houseMember.setIsAdminOfHouse(houseMemberRequest.getStatus());
        //houseMember.updatedBy(loginUser.getId());
        HouseMember houseMemberResult = houseMemberRepository.save(houseMember);

        if(Objects.isNull(houseMemberResult)){
            return false;
        }
        return true;
    }

    @Override
    public boolean removeHouseMember(HouseMemberRequest houseMemberRequest) {
        return false;
    }

    @Override
    public HouseMemberResponse getAllHouseMember(Long houseId) {
        List<HouseMember> allHouseMember = houseMemberRepository.findAllHouseMember(houseId);

        if(allHouseMember.isEmpty()){
            throw new ResourceNotFoundException("No house found.");
        }

        HouseMemberResponse houseMemberResponse = new HouseMemberResponse();
        HouseResponse houseResponse = houseResponseConverter.apply(allHouseMember.get(0).getHouse());
        houseMemberResponse.setHouseResponse(houseResponse);

        List<UserProfileDto> userProfiles = new ArrayList<>();
        for (HouseMember houseMember : allHouseMember) {
            UserProfile userProfileTemp = userProfileService.getUserProfileById(houseMember.getUserId());
            UserProfileDto userProfileDtoTemp = userProfileToUserProfileDtoConverter.apply(userProfileTemp);
            userProfileDtoTemp.setMemberId(houseMember.getId());
            userProfileDtoTemp.setActiveMember(houseMember.getIsActiveMember());
            userProfileDtoTemp.setAdminOfHouse(houseMember.getIsAdminOfHouse());
            userProfileDtoTemp.setStartDate(houseMember.getStartDate());
            userProfileDtoTemp.setEndDate(houseMember.getEndDate());
            userProfiles.add(userProfileDtoTemp);
        }
        houseMemberResponse.setUserProfiles(userProfiles);
        return houseMemberResponse;
    }

    @Override
    public HouseMemberResponse getAllActiveHouseMember(Long houseId) {
        List<HouseMember> allHouseMember = houseMemberRepository.findAllActiveHouseMember(houseId);

        if(allHouseMember.isEmpty()){
            throw new ResourceNotFoundException("No house found.");
        }

        HouseMemberResponse houseMemberResponse = new HouseMemberResponse();
        HouseResponse houseResponse = houseResponseConverter.apply(allHouseMember.get(0).getHouse());
        houseMemberResponse.setHouseResponse(houseResponse);

        List<UserProfileDto> userProfiles = new ArrayList<>();
        for (HouseMember houseMember : allHouseMember) {
            UserProfile userProfileTemp = userProfileService.getUserProfileById(houseMember.getUserId());
            UserProfileDto userProfileDtoTemp = userProfileToUserProfileDtoConverter.apply(userProfileTemp);
            userProfileDtoTemp.setMemberId(houseMember.getId());
            userProfileDtoTemp.setActiveMember(houseMember.getIsActiveMember());
            userProfileDtoTemp.setAdminOfHouse(houseMember.getIsAdminOfHouse());
            userProfileDtoTemp.setStartDate(houseMember.getStartDate());
            userProfileDtoTemp.setEndDate(houseMember.getEndDate());
            userProfiles.add(userProfileDtoTemp);
        }
        houseMemberResponse.setUserProfiles(userProfiles);
        return houseMemberResponse;
    }
}
