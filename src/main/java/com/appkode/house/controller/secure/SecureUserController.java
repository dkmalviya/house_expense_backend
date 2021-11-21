package com.appkode.house.controller.secure;

import com.appkode.house.model.request.user.UserProfileRequest;
import com.appkode.house.model.response.generic.GenericResponse;
import com.appkode.house.model.response.user.UserProfileResponse;
import com.appkode.house.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public  class SecureUserController {

    private final UserProfileService userProfileService;
    @Autowired
    public SecureUserController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping(value = "/createProfile")
    public ResponseEntity<GenericResponse> createProfile(@RequestBody @Valid UserProfileRequest userProfileRequest) {
        boolean createProfileStatus=userProfileService.createUserProfile(userProfileRequest);
        if(createProfileStatus){

            return new ResponseEntity<>(new GenericResponse(0,"Success","User profile created successfully"), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(new GenericResponse(99,"Failed","Unable to create User profile."), HttpStatus.OK);
        }
    }

    @PostMapping(value = "/updateProfile")
    public ResponseEntity<UserProfileResponse> updateProfile(@RequestBody @Valid UserProfileRequest userProfileRequest) {
        UserProfileResponse userProfileResponse=userProfileService.updateUserProfile(userProfileRequest);
        return new ResponseEntity<>(userProfileResponse,HttpStatus.OK);
    }

    @GetMapping(value = "/getUserProfile")
    public ResponseEntity<UserProfileResponse> getUserProfile() {
        UserProfileResponse userProfileResponse=userProfileService.getUserDetails();
        return new ResponseEntity<>(userProfileResponse,HttpStatus.OK);
    }


}
