package com.appkode.house.converter.user;

import com.appkode.house.entity.User;
import com.appkode.house.model.response.user.UserProfileResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserResponseConverter implements Function<User, UserProfileResponse> {
    @Override
    public UserProfileResponse apply(User user) {
        UserProfileResponse userResponse = new UserProfileResponse();
        userResponse.setEmail(user.getEmail());

        return userResponse;
    }
}
