package com.appkode.house.services;

import com.appkode.house.model.entity.User;
import com.appkode.house.model.entity.VerificationToken;
import com.appkode.house.model.request.user.PasswordForgotValidateRequest;


public interface TokenService {

    VerificationToken createEmailConfirmToken(User user);

    void createPasswordResetToken(String email);

    void validateEmail(String token);

    void validateForgotPasswordConfirm(String token);

    void validateForgotPassword(PasswordForgotValidateRequest passwordForgotValidateRequest);
}
