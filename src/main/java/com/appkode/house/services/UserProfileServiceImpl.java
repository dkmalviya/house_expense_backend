package com.appkode.house.services;

import com.appkode.house.converter.user.UserProfileResponseConverter;
import com.appkode.house.converter.user.UserResponseConverter;
import com.appkode.house.error.exception.InvalidArgumentException;
import com.appkode.house.error.exception.ResourceNotFoundException;
import com.appkode.house.model.entity.User;
import com.appkode.house.model.entity.UserProfile;
import com.appkode.house.model.request.user.PasswordResetRequest;
import com.appkode.house.model.request.user.RegisterUserRequest;
import com.appkode.house.model.request.user.UserProfileRequest;
import com.appkode.house.model.response.user.UserProfileResponse;
import com.appkode.house.repository.UserProfileRepository;
import com.appkode.house.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserProfileServiceImpl implements UserProfileService {


    private final UserProfileRepository userProfileRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserResponseConverter userResponseConverter;
    private final UserProfileResponseConverter userProfileResponseConverter;

    @Autowired
    public UserProfileServiceImpl(UserRepository userRepository,
                                  PasswordEncoder passwordEncoder,
                                  UserProfileRepository userProfileRepository, UserResponseConverter userResponseConverter, UserProfileResponseConverter userProfileResponseConverter) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userProfileRepository = userProfileRepository;
        this.userResponseConverter = userResponseConverter;
        this.userProfileResponseConverter = userProfileResponseConverter;
    }

    @Override
    public boolean userExists(String email) {
        return userRepository.existsByEmail(email);
    }


    @Override
    public User findByEmail(String email) {
        if (Objects.isNull(email)) {
            throw new InvalidArgumentException("Null email");
        }
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public User saveUser(User user) {
        if (Objects.isNull(user)) {
            throw new InvalidArgumentException("Null user");
        }
        return userRepository.save(user);
    }

    @Override
    public User getUser() {
        return null;
    }


    @Override
    public User register(RegisterUserRequest registerUserRequest) {
        if (userExists(registerUserRequest.getEmail())) {
            throw new InvalidArgumentException("An account already exists with this email");
        }

        User user = new User();
        user.setEmail(registerUserRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerUserRequest.getPassword()));
        user.setEmailVerified(false);
        user.setEnable(false);

        return userRepository.save(user);
    }


    @Override
    public UserProfile getUserProfile() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        if (Objects.isNull(userName)) {
            throw new AccessDeniedException("Invalid access");
        }

        UserProfile userProfile = userProfileRepository.findByEmail(userName);
        if (userProfile == null) {
            throw new ResourceNotFoundException("User not found");
        }
        return userProfile;
    }

    /*@Override
    public Long getUserId() {

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User user=findByEmail(userName);
        return user.getId();
    }*/



    @Override
    public void resetPassword(PasswordResetRequest passwordResetRequest) {

    }



    @Override
    public UserProfileResponse fetchUser() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        System.out.println("sample" + userName);
        if (Objects.isNull(userName)) {
            throw new AccessDeniedException("Invalid access");
        }

        Optional<User> user = userRepository.findByEmail(userName);
        System.out.println("sample" + user.toString());
        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        }
        return userResponseConverter.apply(user.get());
    }

    @Override
    public UserProfileResponse fetchUserProfile() {
        return null;
    }

    @Override
    public boolean userProfileExists(String mobile) {
        return userProfileRepository.existsByMobile(mobile);
    }


    @Override
    public boolean createUserProfile(UserProfileRequest userProfileRequest) {

        if (userProfileExists(userProfileRequest.getMobile())) {
            throw new InvalidArgumentException("User mobile is already registered in our records. please try with different mobile number.");
        }


        UserProfile userProfile = getUserProfile();
        userProfile.setFirstName(userProfileRequest.getFirstName());
        userProfile.setLastName(userProfileRequest.getLastName());
        userProfile.setMiddleName(userProfileRequest.getMiddleName());
        userProfile.setGender(userProfileRequest.getGender());


        userProfile.setMaritalStatus(userProfileRequest.getMaritalStatus());
        userProfile.setMobile(userProfileRequest.getMobile());
        //userProfile.setImageUrl("NA");
        userProfile.setNotificationEnable(true);
        userProfile.setActiveProfile(true);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dateObj = sdf.parse(userProfileRequest.getDateOfBirth());
            userProfile.setDateOfBirth(dateObj);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        UserProfile userProfile1 = userProfileRepository.save(userProfile);

        if (Objects.isNull(userProfile1)) {
            return false;
        }
        return true;

    }

    @Override
    public UserProfileResponse updateUserProfile(UserProfileRequest userProfileRequest) {

        UserProfile userProfile = getUserProfile();
        userProfile.setFirstName(userProfileRequest.getFirstName());
        userProfile.setLastName(userProfileRequest.getLastName());
        userProfile.setMiddleName(userProfileRequest.getMiddleName());
        userProfile.setGender(userProfileRequest.getGender());
        userProfile.setMaritalStatus(userProfileRequest.getMaritalStatus());
        userProfile.setMobile(userProfileRequest.getMobile());
        //userProfile.setImageUrl("NA");
        userProfile.setNotificationEnable(true);
        userProfile.setActiveProfile(true);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dateObj = sdf.parse(userProfileRequest.getDateOfBirth());
            userProfile.setDateOfBirth(dateObj);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        UserProfile userProfile1 = userProfileRepository.save(userProfile);

        if (Objects.isNull(userProfile1)) {
            throw new ResourceNotFoundException("Unable to update user. Please try after some time.");
        }
        return userProfileResponseConverter.apply(userProfile);

    }







    @Override
    public void inviteUser(String email) {


    }


}
