package com.appkode.house.controller.unsecure;

import com.appkode.house.entity.User;
import com.appkode.house.entity.VerificationToken;
import com.appkode.house.model.request.user.*;
import com.appkode.house.model.response.generic.GenericResponse;
import com.appkode.house.model.response.user.UserProfileResponse;
import com.appkode.house.services.TokenService;
import com.appkode.house.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PublicUserController extends PublicApiController {


    private final UserProfileService userProfileService;

    private final TokenService tokenService;

    @Autowired
    public PublicUserController(UserProfileService userProfileService, TokenService tokenService) {
        this.userProfileService = userProfileService;
        this.tokenService = tokenService;
    }


    @PostMapping(value = "/account/registration")
    public ResponseEntity<GenericResponse> registerUser(@RequestBody @Valid RegisterUserRequest registerUserRequest) {
        User user = userProfileService.register(registerUserRequest);
        VerificationToken emailConfirmToken = tokenService.createEmailConfirmToken(user);
        System.out.println(emailConfirmToken.toString());

        return new ResponseEntity<>(new GenericResponse(0, "Success", "User successfully registered."), HttpStatus.OK);
    }

    @PostMapping(value = "/account/registration/validate")
    public ResponseEntity<GenericResponse> validateEmail(@RequestBody @Valid ValidateEmailRequest validateEmailRequest) {
        tokenService.validateEmail(validateEmailRequest.getToken());
        return new ResponseEntity<>(new GenericResponse(0, "Success", "Token successfully validated."), HttpStatus.OK);

    }

    @PostMapping(value = "/account/password/forgot")
    public ResponseEntity<GenericResponse> forgotPasswordRequest(@RequestBody @Valid PasswordForgotRequest passwordForgotRequest) {
        tokenService.createPasswordResetToken(passwordForgotRequest.getEmail());
        return new ResponseEntity<>(new GenericResponse(0, "Success", "Token sent successfully."), HttpStatus.OK);
    }

    @PostMapping(value = "/account/password/forgot/validate")
    public ResponseEntity<GenericResponse> validateForgotPassword(@RequestBody @Valid PasswordForgotValidateRequest passwordForgotValidateRequest) {
        tokenService.validateForgotPassword(passwordForgotValidateRequest);
        return new ResponseEntity<>(new GenericResponse(0, "Success", "Password changed successfully."), HttpStatus.OK);
    }

    @PostMapping(value = "/account/password/forgot/confirm")
    public ResponseEntity<GenericResponse> confirmForgotPassword(@RequestBody @Valid PasswordForgotConfirmRequest passwordForgotConfirmRequest) {
        tokenService.validateForgotPasswordConfirm(passwordForgotConfirmRequest.getToken());
        return new ResponseEntity<>(new GenericResponse(0, "Success", "Password changed successfully."), HttpStatus.OK);

    }

//this method should be use for get all the details of user in initial screen
    /*@PostMapping(value = "/account/validateAuthToken")
    public ResponseEntity<GenericResponse> validateAuthToken(@RequestBody @Valid ValidateEmailRequest validateEmailRequest) {
        userProfileService.getUserId();
        return new ResponseEntity<>(new GenericResponse(0,"Success","Valid Token"),HttpStatus.OK);
    }*/

    @GetMapping(value = "/account")
    public ResponseEntity<UserProfileResponse> getUser() {
        UserProfileResponse userProfileResponse = userProfileService.fetchUser();
        System.out.println(userProfileResponse.toString());
        return new ResponseEntity<>(userProfileResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/account")
    public ResponseEntity<UserProfileResponse> updateUser(@RequestBody @Valid UserProfileRequest userProfileRequest) {
        System.out.println(userProfileRequest.toString());
        UserProfileResponse userProfileResponse = userProfileService.updateUserProfile(userProfileRequest);
        System.out.println(userProfileResponse.toString());
        return new ResponseEntity<>(userProfileResponse, HttpStatus.OK);
    }

    @PostMapping(value = "/account/password/reset")
    public ResponseEntity<HttpStatus> passwordReset(@RequestBody @Valid PasswordResetRequest passwordResetRequest) {
        userProfileService.resetPassword(passwordResetRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
