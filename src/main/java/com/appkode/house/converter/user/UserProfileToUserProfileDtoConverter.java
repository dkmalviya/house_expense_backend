package com.appkode.house.converter.user;

import com.appkode.house.entity.UserProfile;
import com.appkode.house.model.dto.UserProfileDto;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserProfileToUserProfileDtoConverter implements Function<UserProfile,UserProfileDto > {
    @Override
    public UserProfileDto apply(UserProfile userProfile) {

        UserProfileDto userProfileDto=new UserProfileDto();
        userProfileDto.setEmail(userProfile.getEmail());
        userProfileDto.setFirstName(userProfile.getFirstName());
        userProfileDto.setMiddleName(userProfile.getMiddleName());
        userProfileDto.setLastName(userProfile.getLastName());
        userProfileDto.setGender(userProfile.getGender());
        userProfileDto.setMaritalStatus(userProfile.getMaritalStatus());
        userProfileDto.setActiveProfile(userProfile.isActiveProfile());
        userProfileDto.setMobile(userProfile.getMobile());
        userProfileDto.setImageUrl(userProfile.getImageUrl());
        userProfileDto.setProfileStatus(userProfile.getProfileStatus());

        return userProfileDto;
    }
}
