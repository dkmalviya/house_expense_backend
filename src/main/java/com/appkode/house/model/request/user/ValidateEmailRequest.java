package com.appkode.house.model.request.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ValidateEmailRequest {
    @NotBlank
    String token;
}
