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
    void resetPassword(PasswordResetRequest passwordResetRequest);
    Boolean getVerificationStatus();



    boolean createUserProfile(UserProfileRequest userProfileRequest);
    UserProfileResponse updateUserProfile(UserProfileRequest updateUserRequest);
    Boolean updateUserProfileStatus(String status);
    boolean userExists(String email);
    boolean userProfileExists(String mobile);
    UserProfileResponse fetchUser();
    UserProfile getUserProfile();
    UserProfile getUserProfileById(Long id);

    UserProfileResponse getUserDetails();


















}
