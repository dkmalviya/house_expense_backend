package com.appkode.UserService.services;

import com.appkode.UserService.model.entity.User;
import com.appkode.UserService.model.request.user.PasswordResetRequest;
import com.appkode.UserService.model.request.user.RegisterUserRequest;
import com.appkode.UserService.model.request.user.UpdateUserProfileRequest;
import com.appkode.UserService.model.response.user.UserProfileResponse;
import org.springframework.stereotype.Service;


public interface UserProfileService {
    User register(RegisterUserRequest registerUserRequest);

    UserProfileResponse fetchUser();
    UserProfileResponse fetchUserProfile();
    boolean userExists(String email);
    User findByEmail(String email);
    User saveUser(User user);
    User getUser();



    UserProfileResponse updateUserProfile(UpdateUserProfileRequest updateUserRequest);


    void resetPassword(PasswordResetRequest passwordResetRequest);

    Boolean getVerificationStatus();

}
