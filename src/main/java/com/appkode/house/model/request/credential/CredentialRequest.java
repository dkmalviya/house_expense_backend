package com.appkode.house.model.request.credential;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CredentialRequest {

    private Long credentialId;

    @NotBlank
    @Size(min = 3, max = 52)
    private String accountName;

    @NotBlank
    @Size(min = 3, max = 52)
    private String accountCategory;

    @NotBlank
    @Size(min = 3, max = 52)
    private String userName;

    @NotBlank
    @Size(min = 3, max = 200)
    private String primaryPassword;

    @NotBlank
    @Size(min = 3, max = 200)
    private String secondaryPassword;

    @NotBlank
    @Size(min = 3, max = 200)
    private String pin;

    @NotBlank
    @Size(min = 3, max = 200)
    private String recoveryEmail;

   }
