package com.appkode.UserService.validator;

import com.appkode.UserService.model.request.user.PasswordForgotValidateRequest;
import com.appkode.UserService.model.request.user.PasswordResetRequest;
import com.appkode.UserService.model.request.user.RegisterUserRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        if (obj instanceof RegisterUserRequest) {
            RegisterUserRequest registerUserRequest = (RegisterUserRequest) obj;
            return registerUserRequest.getPassword().equals(registerUserRequest.getPasswordRepeat());
        } else if (obj instanceof PasswordResetRequest) {
            PasswordResetRequest passwordResetRequest = (PasswordResetRequest) obj;
            return passwordResetRequest.getNewPassword().equals(passwordResetRequest.getNewPasswordConfirm());
        } else if (obj instanceof PasswordForgotValidateRequest) {
            PasswordForgotValidateRequest passwordForgotValidateRequest = (PasswordForgotValidateRequest) obj;
            return passwordForgotValidateRequest.getNewPassword().equals(passwordForgotValidateRequest.getNewPasswordConfirm());
        }

        return false;

    }
}