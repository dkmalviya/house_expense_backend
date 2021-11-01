package com.appkode.UserService.services;

import com.appkode.UserService.converter.user.UserResponseConverter;
import com.appkode.UserService.error.exception.InvalidArgumentException;
import com.appkode.UserService.error.exception.ResourceNotFoundException;
import com.appkode.UserService.model.entity.User;
import com.appkode.UserService.model.request.user.PasswordResetRequest;
import com.appkode.UserService.model.request.user.RegisterUserRequest;
import com.appkode.UserService.model.request.user.UpdateUserProfileRequest;
import com.appkode.UserService.model.response.user.UserProfileResponse;
import com.appkode.UserService.repository.UserProfileRepository;
import com.appkode.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserProfileServiceImpl implements UserProfileService{


    private final UserProfileRepository userProfileRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserResponseConverter userResponseConverter;

    @Autowired
    public UserProfileServiceImpl(UserRepository userRepository,
                                  PasswordEncoder passwordEncoder,
                                  UserProfileRepository userProfileRepository, UserResponseConverter userResponseConverter) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userProfileRepository = userProfileRepository;
        this.userResponseConverter = userResponseConverter;
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
    public UserProfileResponse updateUserProfile(UpdateUserProfileRequest updateUserRequest) {
        return null;
    }

    @Override
    public void resetPassword(PasswordResetRequest passwordResetRequest) {

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

        return userRepository.save(user);
    }

    @Override
    public UserProfileResponse fetchUser() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        System.out.println("sample"+userName);
        if (Objects.isNull(userName)) {
            throw new AccessDeniedException("Invalid access");
        }

        Optional<User> user = userRepository.findByEmail(userName);
        System.out.println("sample"+user.toString());
        if (user==null) {
            throw new ResourceNotFoundException("User not found");
        }
        return userResponseConverter.apply(user.get());
    }

    @Override
    public UserProfileResponse fetchUserProfile() {
        return null;
    }

    @Override
    public Boolean getVerificationStatus() {
        return null;
    }
}
