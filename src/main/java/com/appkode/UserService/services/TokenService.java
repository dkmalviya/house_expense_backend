package com.appkode.UserService.services;

import com.appkode.UserService.model.entity.User;
import com.appkode.UserService.model.request.user.PasswordForgotValidateRequest;


public interface TokenService {

    void createEmailConfirmToken(User user);

    void createPasswordResetToken(String email);

    void validateEmail(String token);

    void validateForgotPasswordConfirm(String token);

    void validateForgotPassword(PasswordForgotValidateRequest passwordForgotValidateRequest);
}
