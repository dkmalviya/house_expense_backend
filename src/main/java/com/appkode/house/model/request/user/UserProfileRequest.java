package com.appkode.house.model.request.user;

import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserProfileRequest {

    @Pattern(regexp = "^[a-zA-Z\\s]+$")
    @Size(min = 3, max = 26)
    private String firstName;

    @Pattern(regexp = "^[a-zA-Z\\s]+$")
    @Size(min = 3, max = 26)
    private String middleName;

    @Pattern(regexp = "^[a-zA-Z\\s]+$")
    @Size(min = 3, max = 26)
    private String lastName;

    @Pattern(regexp = "[0-9]+")
    @Size(min = 10, max = 12)
    private String mobile;

    @Pattern(regexp = "^[a-zA-Z\\s]+$")
    @Size(min = 4, max = 12)
    private String gender;

    private String dateOfBirth;

    @Pattern(regexp = "^[a-zA-Z\\s]+$")
    @Size(min = 5, max = 12)
    private String maritalStatus;

    @Size(min = 3, max = 50)
    private String imageUrl;


}
