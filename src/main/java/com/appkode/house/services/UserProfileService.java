package com.appkode.house.services;

import com.appkode.house.entity.User;
import com.appkode.house.entity.UserProfile;
import com.appkode.house.model.request.user.PasswordResetRequest;
import com.appkode.house.model.request.user.RegisterUserRequest;
import com.appkode.house.model.request.user.UserProfileRequest;
import com.appkode.house.model.response.user.UserProfileResponse;


public interface UserProfileService {
    User register(RegisterUserRequest registerUserRequest);

    User findByEmail(String email);
    User saveUser(User user);
    User getUser();



    boolean createUserProfile(UserProfileRequest userProfileRequest);
    UserProfileResponse updateUserProfile(UserProfileRequest updateUserRequest);

    void inviteUser(String email);

    boolean userExists(String email);
    boolean userProfileExists(String mobile);
    UserProfileResponse fetchUser();
    UserProfileResponse fetchUserProfile();

    UserProfile getUserProfile();
    UserProfile getUserProfileById(Long id);










    void resetPassword(PasswordResetRequest passwordResetRequest);



}
