package com.appkode.house.model.request.user;

import com.appkode.house.validator.CustomEmail;
import com.appkode.house.validator.PasswordMatches;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@PasswordMatches
public class RegisterUserRequest {

    @NotBlank
    @Size(min = 3, max = 52)
    @CustomEmail
    private String email;

    @NotBlank
    @Size(min = 6, max = 52)
    private String password;

    @NotBlank
    @Size(min = 6, max = 52)
    private String passwordRepeat;
}