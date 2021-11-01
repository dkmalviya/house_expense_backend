package com.appkode.UserService.converter.user;

import com.appkode.UserService.model.entity.User;
import com.appkode.UserService.model.response.user.UserProfileResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserResponseConverter implements Function<User, UserProfileResponse> {
    @Override
    public UserProfileResponse apply(User user) {
        UserProfileResponse userResponse = new UserProfileResponse();
        userResponse.setEmail(user.getEmail());
        userResponse.setFirstName(user.getEmail().);
        return userResponse;
    }
}
