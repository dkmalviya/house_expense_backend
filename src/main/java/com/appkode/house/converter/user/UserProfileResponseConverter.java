package com.appkode.house.converter.user;

import com.appkode.house.entity.UserProfile;
import com.appkode.house.model.response.user.UserProfileResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserProfileResponseConverter implements Function<UserProfile, UserProfileResponse> {
    @Override
    public UserProfileResponse apply(UserProfile userProfile) {
        UserProfileResponse userResponse = new UserProfileResponse();
        userResponse.setEmail(userProfile.getEmail());
        userResponse.setFirstName(userProfile.getFirstName());
        userResponse.setMiddleName(userProfile.getMiddleName());
        userResponse.setLastName(userProfile.getLastName());
        userResponse.setGender(userProfile.getGender());
        userResponse.setDateOfBirth(userProfile.getDateOfBirth().toString());
        userResponse.setMaritalStatus(userProfile.getMaritalStatus());
        userResponse.setMobile(userProfile.getMobile());
        userResponse.setActiveProfile(userProfile.isActiveProfile());
        userResponse.setNotificationEnable(userProfile.isNotificationEnable());
        userResponse.setImageUrl(userProfile.getImageUrl());
        return userResponse;
    }

      /*  @Override
        public UserResponse apply(User user) {
            UserResponse userResponse = new UserResponse();
            userResponse.setEmail(user.getEmail());
            userResponse.setFirstName(user.getFirstName());
            userResponse.setLastName(user.getLastName());
            userResponse.setAddress(user.getAddress());
            userResponse.setCity(user.getCity());
            userResponse.setState(user.getState());
            userResponse.setZip(user.getZip());
            userResponse.setPhone(user.getPhone());
            userResponse.setCountry(user.getCountry());
            userResponse.setEmailVerified(user.getEmailVerified());
            return userResponse;
        }*/

}
