package com.appkode.UserService.controller;

import com.appkode.UserService.model.entity.User;
import com.appkode.UserService.model.request.user.PasswordResetRequest;
import com.appkode.UserService.model.request.user.RegisterUserRequest;
import com.appkode.UserService.model.request.user.UpdateUserProfileRequest;
import com.appkode.UserService.model.response.user.UserProfileResponse;
import com.appkode.UserService.services.TokenService;
import com.appkode.UserService.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PublicUserController extends PublicApiController {


    private final UserProfileService userProfileService;

    private final  TokenService tokenService;

    @Autowired
    public PublicUserController(UserProfileService userProfileService, TokenService tokenService) {
        this.userProfileService = userProfileService;
        this.tokenService = tokenService;
    }


    @PostMapping(value = "/account/registration")
    public ResponseEntity<HttpStatus> registerUser(@RequestBody @Valid RegisterUserRequest registerUserRequest) {
        User user = userProfileService.register(registerUserRequest);
        tokenService.createEmailConfirmToken(user);
        System.out.println("Registration Successful");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/account")
    public ResponseEntity<UserProfileResponse> getUser() {
        UserProfileResponse userProfileResponse = userProfileService.fetchUser();
        System.out.println(userProfileResponse.toString());
        return new ResponseEntity<>(userProfileResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/account")
    public ResponseEntity<UserProfileResponse> updateUser(@RequestBody @Valid UpdateUserProfileRequest updateUserProfileRequest) {
        System.out.println(updateUserProfileRequest.toString());
        UserProfileResponse userProfileResponse = userProfileService.updateUserProfile(updateUserProfileRequest);
        System.out.println(userProfileResponse.toString());
        return new ResponseEntity<>(userProfileResponse, HttpStatus.OK);
    }

    @PostMapping(value = "/account/password/reset")
    public ResponseEntity<HttpStatus> passwordReset(@RequestBody @Valid PasswordResetRequest passwordResetRequest) {
        userProfileService.resetPassword(passwordResetRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }






}
