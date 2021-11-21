package com.appkode.house.model.response.credential;


import lombok.Data;

@Data
public class CredentialResponse {

    private Long credentialId;
    private String accountName;
    private String accountCategory;
    private String userName;
    private String primaryPassword;
    private String secondaryPassword;
    private String pin;
    private String recoveryEmail;

}
