package com.appkode.house.model.response.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileResponse {
    private String email;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String DateOfBirth;
    private String maritalStatus;
    private boolean isNotificationEnable;
    private boolean isActiveProfile;
    private String mobile;
    private String imageUrl;

}

